package com.dbapp.mybatis.mapper;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.executor.BatchExecutor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * @desc: 批量处理
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/25
 * @Time： 14:23
 */
@Repository
public class BatchMapper {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private int batchSize = 20;//每次批量5000

    public <T> int updateBatch(String statement, List<T> list) {
        SqlSession batchSqlSession = null;
        int counts = 0;
        try {
            batchSqlSession = this.sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);
            int batchLastIndex = batchSize;// 每批最后一个的下标
            for(int index = 0;index<list.size();){
                if(batchLastIndex >= list.size()){//插入完毕
                    batchLastIndex = list.size();
                    batchSqlSession.insert(statement,list.subList(index, batchLastIndex));
                    String s = null;
                    s.lastIndexOf("e");
                    batchSqlSession.commit();
                    counts = counts + (batchLastIndex - index);
                    break;
                }else{
                    batchSqlSession.insert(statement,list.subList(index, batchLastIndex));
                    batchSqlSession.commit();
                    counts = counts + (batchLastIndex - index);
                    index = batchLastIndex;//设置下一批下标
                    batchLastIndex = index + batchSize;
                }
                batchSqlSession.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            batchSqlSession.rollback();
        } finally {
            if(batchSqlSession!=null){
                batchSqlSession.close();
            }
        }
        return counts;
    }

    public <T> int updateBatch2(String statement, List<T> list) {
        int counts = 0;
        SqlSession session = this.sqlSessionTemplate.getSqlSessionFactory().openSession();
        Transaction transaction = null;
        Environment env = null;
        BatchExecutor be = null;
        try {
            Configuration conf = session.getConfiguration();
            conf.setDefaultExecutorType(ExecutorType.BATCH);
            env = conf.getEnvironment();
            JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();
            transaction = jdbcTransactionFactory.newTransaction(
                    env.getDataSource(),
                    TransactionIsolationLevel.REPEATABLE_READ, false);
            be = new BatchExecutor(conf, transaction);
            MappedStatement ms = conf.getMappedStatement(statement);
            if (CollectionUtils.isEmpty(list)) {
                return 0;
            }
            int x = 1;
            for (Iterator iter = list.iterator(); iter.hasNext();) {
                be.doUpdate(ms, iter.next());
                if (x % batchSize == 0) {
                    be.commit(true);
                    transaction.commit();
                }
                x++;
            }
            be.commit(true);
            transaction.commit();
            List<BatchResult> bl = be.flushStatements();
            if (CollectionUtils.isNotEmpty(bl)) {
                for (BatchResult br : bl) {
                    for (int c : br.getUpdateCounts()) {
                        counts += c;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                be.rollback(true);
                transaction.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            be.close(false);
        }
        return counts;
    }
}

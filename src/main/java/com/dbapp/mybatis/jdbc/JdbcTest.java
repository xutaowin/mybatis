package com.dbapp.mybatis.jdbc;

import java.sql.*;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/11
 * @Time： 23:17
 */
public class JdbcTest {
    public static void main(String[] args) {
        //数据库连接
        Connection connection = null;
        //预编译的statement,预编译的statement可以提高数据库的性能
        PreparedStatement preparedStatement = null;
        //结果集
        ResultSet resultSet = null;
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //通过驱动管理类来获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_db?useUnicode=true&characterEncoding=UTF-8","root","123qwe");
            //定义sql语句 ? 表示占位符
            String sql = "select * from user where username = ?";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为sql的参数序号(从1开始)，第二个参数为值
            preparedStatement.setString(1,"xutao");
            //向数据库发出sql执行，查询是结果集
            resultSet = preparedStatement.executeQuery();
            //遍历查询结果
            while (resultSet.next()){
                System.out.println(resultSet.getString("id")+":"+resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

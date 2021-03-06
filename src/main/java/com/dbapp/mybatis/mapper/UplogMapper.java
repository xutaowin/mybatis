package com.dbapp.mybatis.mapper;

import com.dbapp.mybatis.pojo.Uplog;
import com.dbapp.mybatis.pojo.UplogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper 接口 - 表：t_uplog
 * @since 2017-10-10 10:02:21
 */
public interface UplogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_uplog
     *
     * @mbggenerated Tue Oct 10 10:02:21 CST 2017
     */
    int countByExample(UplogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_uplog
     *
     * @mbggenerated Tue Oct 10 10:02:21 CST 2017
     */
    int deleteByExample(UplogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_uplog
     *
     * @mbggenerated Tue Oct 10 10:02:21 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_uplog
     *
     * @mbggenerated Tue Oct 10 10:02:21 CST 2017
     */
    int insert(Uplog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_uplog
     *
     * @mbggenerated Tue Oct 10 10:02:21 CST 2017
     */
    int insertSelective(Uplog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_uplog
     *
     * @mbggenerated Tue Oct 10 10:02:21 CST 2017
     */
    List<Uplog> selectByExample(UplogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_uplog
     *
     * @mbggenerated Tue Oct 10 10:02:21 CST 2017
     */
    Uplog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_uplog
     *
     * @mbggenerated Tue Oct 10 10:02:21 CST 2017
     */
    int updateByExampleSelective(@Param("record") Uplog record, @Param("example") UplogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_uplog
     *
     * @mbggenerated Tue Oct 10 10:02:21 CST 2017
     */
    int updateByExample(@Param("record") Uplog record, @Param("example") UplogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_uplog
     *
     * @mbggenerated Tue Oct 10 10:02:21 CST 2017
     */
    int updateByPrimaryKeySelective(Uplog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_uplog
     *
     * @mbggenerated Tue Oct 10 10:02:21 CST 2017
     */
    int updateByPrimaryKey(Uplog record);
}
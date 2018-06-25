package com.dbapp.mybatis.mapper;

import com.dbapp.mybatis.pojo.Token;
import com.dbapp.mybatis.pojo.TokenCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper 接口 - 表：t_token
 * @since 2017-10-27 17:14:48
 */
public interface TokenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_token
     *
     * @mbggenerated Fri Oct 27 17:14:48 CST 2017
     */
    int countByExample(TokenCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_token
     *
     * @mbggenerated Fri Oct 27 17:14:48 CST 2017
     */
    int deleteByExample(TokenCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_token
     *
     * @mbggenerated Fri Oct 27 17:14:48 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_token
     *
     * @mbggenerated Fri Oct 27 17:14:48 CST 2017
     */
    int insert(Token record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_token
     *
     * @mbggenerated Fri Oct 27 17:14:48 CST 2017
     */
    int insertSelective(Token record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_token
     *
     * @mbggenerated Fri Oct 27 17:14:48 CST 2017
     */
    List<Token> selectByExample(TokenCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_token
     *
     * @mbggenerated Fri Oct 27 17:14:48 CST 2017
     */
    Token selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_token
     *
     * @mbggenerated Fri Oct 27 17:14:48 CST 2017
     */
    int updateByExampleSelective(@Param("record") Token record, @Param("example") TokenCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_token
     *
     * @mbggenerated Fri Oct 27 17:14:48 CST 2017
     */
    int updateByExample(@Param("record") Token record, @Param("example") TokenCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_token
     *
     * @mbggenerated Fri Oct 27 17:14:48 CST 2017
     */
    int updateByPrimaryKeySelective(Token record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_token
     *
     * @mbggenerated Fri Oct 27 17:14:48 CST 2017
     */
    int updateByPrimaryKey(Token record);
}
package com.dbapp.mybatis.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.StringTypeHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @desc: 特殊字符转义
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/7/10
 * @Time： 11:01
 */
public class EscapeStringTypeHandler extends StringTypeHandler {

    public EscapeStringTypeHandler() {

    }

    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        String afterEscape = parameter.replace("%", "\\%");
        afterEscape = afterEscape.replace("_", "\\_");
        super.setNonNullParameter(ps, i, afterEscape, jdbcType);
    }
}

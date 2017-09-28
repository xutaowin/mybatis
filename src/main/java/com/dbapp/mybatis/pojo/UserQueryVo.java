package com.dbapp.mybatis.pojo;

import java.util.List;

/**
 * @desc:用户包装类型
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/4/20
 * @Time： 23:58
 */
public class UserQueryVo {
    //包装User的扩展类
    private UserCustom userCustom;
    //ids
    private List<Integer> ids;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}

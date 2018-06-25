package com.dbapp.mybatis.service.impl;

import com.dbapp.mybatis.mapper.UplogMapper;
import com.dbapp.mybatis.pojo.Uplog;
import com.dbapp.mybatis.service.UplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @desc:
 * @author: xutao
 */
@Service
//@Transactional
public class UplogServiceImpl implements UplogService{
    @Autowired
    private UplogMapper uplogMapper;
    /*@Override
    public int add(Uplog record){
        return uplogMapper.insert(record);
    }*/

    @Override
    @Transactional(propagation = Propagation.MANDATORY,rollbackFor=Exception.class)
    public int add(Uplog record){
        try {
            //record.setId(1L);
            return uplogMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}

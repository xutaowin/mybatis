package com.dbapp.mybatis.test;

import com.dbapp.mybatis.mapper.ItemsMapper;
import com.dbapp.mybatis.pojo.Items;
import com.dbapp.mybatis.pojo.ItemsExample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by XUTAO on 2016/12/4.
 */
public class ItemsMapperTest {
    private ApplicationContext applicationContext;
    private ItemsMapper itemsMapper;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        itemsMapper = (ItemsMapper)applicationContext.getBean("itemsMapper");
    }
    @Test
    public void test(){
        ItemsExample itemsExample = new ItemsExample();
        //通过criteria构造查询条件
        ItemsExample.Criteria criteria1 = itemsExample.createCriteria();
        criteria1.andNameLike("think6");
        //可能返回多条
        List<Items> itemsList = itemsMapper.selectByExample(itemsExample);
        System.out.println(itemsList);
    }
}

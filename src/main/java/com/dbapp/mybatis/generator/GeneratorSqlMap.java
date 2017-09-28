package com.dbapp.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc: mybatis逆向工程
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/6/4
 * @Time： 11:30
 */
public class GeneratorSqlMap {
    public void generator() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //new File(pathname) pathname:fileSystem相对的是工程目录
        //而classpath相对应的路径就是src目录下
        File configFile = new File("src/main/resources/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) {
        try {
            GeneratorSqlMap generatorSqlMap = new GeneratorSqlMap();
            generatorSqlMap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

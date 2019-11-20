package com.ersc.test;

import com.ersc.domain.User;
import com.ersc.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author yyl
 * @Date 2019/11/18 0018 下午 10:00
 * @Version 1.0
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder ss = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = ss.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = sf.openSession();
        //4.使用SqlSession创建的dao接口的代理对象
        UserMapper us = session.getMapper(UserMapper.class);
        //5.使用代理对象执行方法
        //String name = us.getUsername();
        List<User> users = us.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}

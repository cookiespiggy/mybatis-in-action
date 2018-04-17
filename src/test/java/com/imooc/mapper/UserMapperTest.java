package com.imooc.mapper;

import com.imooc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest {
    private UserMapper userMapper;

    @Before
    public void setUp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);// 自动提交事务
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testQueryUserById() {
        User user = userMapper.queryUserById(1L);
        System.out.println(user);
    }
}

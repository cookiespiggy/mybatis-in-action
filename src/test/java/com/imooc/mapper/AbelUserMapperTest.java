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
import java.util.List;

public class AbelUserMapperTest {
    private AbelUserMapper userMapper;

    @Before
    public void setUp() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);// 自动提交事务
        userMapper = sqlSession.getMapper(AbelUserMapper.class);
    }

    @Test
    public void testSelectByPrimaryKey() {
        User user = userMapper.selectByPrimaryKey(1L);
        System.out.println(user);
    }

    @Test
    public void testSelectOne() {
        User condition = new User();
        condition.setUserName("张三");
        condition.setPassword("123456");
        User user = userMapper.selectOne(condition);
        System.out.println(user);
    }

    @Test
    public void testSelect() {
        List<User> userList = userMapper.select(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectCount() {
        int count = userMapper.selectCount(null);
        System.out.println(count);
    }
}

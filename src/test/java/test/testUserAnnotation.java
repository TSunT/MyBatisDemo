package test;

import cn.edu.nuaa.mybatisdemo.dao.UserDaoAnnotation;
import cn.edu.nuaa.mybatisdemo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class testUserAnnotation {
    @Test
    public void testFindAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("MybatisdemoConnectionConfig.xml");
        SqlSessionFactory factory =new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        UserDaoAnnotation userDaoAnnotation = sqlSession.getMapper(UserDaoAnnotation.class);
        List<User> userList = userDaoAnnotation.findAll();
        for (User u:userList) {
            System.out.println(u);
        }
        sqlSession.close();
        in.close();
    }
    @Test
    public void testInsertUser() throws IOException {
        InputStream in = Resources.getResourceAsStream("MybatisdemoConnectionConfig.xml");
        SqlSessionFactory factory =new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        UserDaoAnnotation userDaoAnnotation = sqlSession.getMapper(UserDaoAnnotation.class);
        User user = new User();
        user.setUsername("xxc");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("zjnb");
        userDaoAnnotation.insertUser(user);
        sqlSession.commit();//提交事务不回滚
        sqlSession.close();
        in.close();
    }
    @Test
    public void testUpdateUser() throws IOException {
        InputStream in = Resources.getResourceAsStream("MybatisdemoConnectionConfig.xml");
        SqlSessionFactory factory =new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        UserDaoAnnotation userDaoAnnotation = sqlSession.getMapper(UserDaoAnnotation.class);
        User user = new User();
        user.setId(55);
        user.setUsername("xx6");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("zjnb");
        userDaoAnnotation.updateUser(user);
        sqlSession.commit();//提交事务不回滚
        sqlSession.close();
        in.close();
    }
    @Test
    public void testUserAccount() throws IOException {
        InputStream in = Resources.getResourceAsStream("MybatisdemoConnectionConfig.xml");
        SqlSessionFactory factory =new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        UserDaoAnnotation userDaoAnnotation = sqlSession.getMapper(UserDaoAnnotation.class);
        User userAccount = userDaoAnnotation.findUserAccount(46);
        System.out.println(userAccount);
        sqlSession.close();
        in.close();
    }
}



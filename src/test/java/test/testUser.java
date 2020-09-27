package test;

import cn.edu.nuaa.mybatisdemo.dao.UserDao;
import cn.edu.nuaa.mybatisdemo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class testUser {
    private InputStream in = null;
    private SqlSessionFactory factory = null;
    private SqlSession sqlSession = null;
    private UserDao userDao = null;
    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("MybatisdemoConnectionConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        userDao = sqlSession.getMapper(UserDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAll(){
        List<User> userList = userDao.findAll();
//        for (User u:userList){
//            System.out.println(u);
//        }
    }
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("xx5");
        user.setBirthday(new Date());
        user.setAddress("jsnj");
        user.setSex("男");

        int i = userDao.insertUser(user);
        System.out.println("this user id is"+i);
    }
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(49);
        user.setUsername("xx6");
        user.setBirthday(new Date());
        user.setAddress("jsnj");
        user.setSex("男");

        userDao.updateUser(user);
    }
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(52);
    }
    @Test
    public void testFindUserByCondition(){
        User user = new User();
        user.setUsername("xx2");

        List<User> userList = userDao.findUserByCondition(user);
        for (User u:userList) {
            System.out.println(u);
        }
    }
    @Test
    public void testFindUserByRangeId(){
        List<Integer> ids = new ArrayList<>();
        ids.add(47);
        ids.add(49);
        ids.add(50);

        List<User> userList = userDao.findUserByRangeId(ids);
        for (User u:userList) {
            System.out.println(u);
        }
    }
    @Test
    public void testFindUserById(){
        User user = userDao.findUserById(48);
        System.out.println(user);
    }
}

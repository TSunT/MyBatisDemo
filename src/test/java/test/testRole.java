package test;

import cn.edu.nuaa.mybatisdemo.dao.RoleDao;
import cn.edu.nuaa.mybatisdemo.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testRole {
    private InputStream in = null;
    private SqlSessionFactory factory = null;
    private SqlSession sqlSession = null;
    private RoleDao roleDao = null;
    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("MybatisdemoConnectionConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);
        roleDao = sqlSession.getMapper(RoleDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.close();
        in.close();
    }
    @Test
    public void testfindAllRole(){
        List<Role> roleList = roleDao.findAllRole();
        for (Role r:roleList) {
            System.out.println(r);
        }
    }
}

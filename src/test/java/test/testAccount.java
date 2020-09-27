package test;

import cn.edu.nuaa.mybatisdemo.dao.AccountDao;
import cn.edu.nuaa.mybatisdemo.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class testAccount {
    private InputStream in = null;
    private SqlSessionFactory factory = null;
    private SqlSession sqlSession = null;
    private AccountDao accountDao = null;
    @Before
    public void init() throws  Exception{
        in = Resources.getResourceAsStream("MybatisdemoConnectionConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession(true);//true：自动提交
        accountDao=sqlSession.getMapper(AccountDao.class);
    }
    @After
    public void destory() throws Exception{
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAllAccount(){
        List<Account> list = accountDao.findAllDelay();
    }
}

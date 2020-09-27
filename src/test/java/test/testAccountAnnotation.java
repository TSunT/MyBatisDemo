package test;

import cn.edu.nuaa.mybatisdemo.dao.AccountDaoAnnotation;
import cn.edu.nuaa.mybatisdemo.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testAccountAnnotation {
    @Test
    public void testAccountAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("MybatisdemoConnectionConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession=factory.openSession();
        AccountDaoAnnotation accountDaoAnnotation = sqlSession.getMapper(AccountDaoAnnotation.class);
        List<Account> accountList = accountDaoAnnotation.findAccountAll();
        for (Account a:accountList) {
            System.out.println(a);
        }
        sqlSession.close();
        in.close();
    }
    @Test
    public void testAccountUserAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("MybatisdemoConnectionConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession=factory.openSession();
        AccountDaoAnnotation accountDaoAnnotation = sqlSession.getMapper(AccountDaoAnnotation.class);
        List<Account> accountList = accountDaoAnnotation.findAccountUserAll();
        for (Account a:accountList) {
            System.out.println(a);
        }
        sqlSession.close();
        in.close();
    }
}

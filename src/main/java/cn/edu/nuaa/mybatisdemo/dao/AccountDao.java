package cn.edu.nuaa.mybatisdemo.dao;

import cn.edu.nuaa.mybatisdemo.domain.Account;
import cn.edu.nuaa.mybatisdemo.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户信息--延迟查询
     * @return
     */
    public List<Account> findAllDelay();

    /**
     * 添加账户信息
     * @param account
     */
    public void inserteAccount(Account account);

    /**
     * 修改用户信息
     * @param accoutn
     */
    public void updateAccount (Account accoutn);

    /**
     * 根据uid来查询账户
     * @param uid
     * @return
     */
    public List<Account> findAccountByUid(int uid);
}

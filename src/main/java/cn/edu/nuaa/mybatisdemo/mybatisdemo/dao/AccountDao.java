package cn.edu.nuaa.mybatisdemo.mybatisdemo.dao;

import cn.edu.nuaa.mybatisdemo.mybatisdemo.domain.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户信息
     * @return
     */
    public List<Account> findAll();

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


}

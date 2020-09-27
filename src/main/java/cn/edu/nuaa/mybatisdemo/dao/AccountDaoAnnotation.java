package cn.edu.nuaa.mybatisdemo.dao;

import cn.edu.nuaa.mybatisdemo.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDaoAnnotation {
    /**
     * 查询所有账户信息
     * @return
     */
    @Select("select * from account")
    public List<Account> findAccountAll();

    /**
     * 查询所有账户的用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id = "AccountUserMap",value = {
            @Result(id = true,property = "id" ,column = "aid"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            @Result(property = "user",column = "uid",
                    one = @One(select = "cn.edu.nuaa.mybatisdemo.dao.UserDaoAnnotation.findUserById",
                            fetchType = FetchType.EAGER))})//fetchType 是可选的，有效值为 lazy延迟加载和eager立即加载
    public List<Account> findAccountUserAll();

    /**
     * 根据id查询账户信息
     * @param uid
     * @return
     */
    @Select("select * from account where uid = #{uid}")
    public List<Account> findAccountById(int uid);

}

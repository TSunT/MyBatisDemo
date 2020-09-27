package cn.edu.nuaa.mybatisdemo.dao;

import cn.edu.nuaa.mybatisdemo.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.ListResourceBundle;

public interface UserDaoAnnotation {
    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    public void insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    @Update("update user set username=#{username} , birthday = #{birthday} , sex = #{sex} where id = #{id}")
    public void updateUser(User user);

    /**
     * 根据id查询用用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    public User findUserById(int id);

    @Select("select * from user where id = #{id}")
    @Results(id = "userAccountMap",value = {
            @Result(id = true, property = "id" ,column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "address",column = "address") ,
            @Result(property = "accountList" , column = "id" ,many = @Many(select = "cn.edu.nuaa.mybatisdemo.dao.AccountDaoAnnotation.findAccountById",
            fetchType = FetchType.EAGER))})//这里的column表示当前本表的列名
    public User findUserAccount(int id);
}

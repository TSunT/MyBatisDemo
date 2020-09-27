package cn.edu.nuaa.mybatisdemo.dao;

import cn.edu.nuaa.mybatisdemo.domain.User;

import java.util.List;
//该类的全类名与映射的资源路径名除了.xml外要求一致
public interface UserDao {
    /**
     * 查询所有用户的方法
     * @return
     */
    public List<User> findAll();

    /**
     * 添加用户返回该用户的id值
     * @return
     */
    public int insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     *
     * @param id
     */
    public void deleteUser(int id);

    /**
     * 根据条件查询用户
     * @param user
     * @return
     */
    public List<User> findUserByCondition(User user);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User findUserById(int id);

    /**
     * 按照id的范围查询用户
     * @param ids
     * @return
     */
    public List<User> findUserByRangeId(List<Integer> ids);
}

package cn.edu.nuaa.mybatisdemo.mybatisdemo.dao;

import cn.edu.nuaa.mybatisdemo.mybatisdemo.domain.Role;

import java.util.List;

public interface RoleDao {

    /**
     * 查询所有职位信息
     * @return
     */
    public List<Role> findAllRole();
}

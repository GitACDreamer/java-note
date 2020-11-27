package com.lelandacm.jdbc;

import java.util.List;

/**
 * @author LelandACM
 */
public interface UserService {

    /**
     * 添加用户
     *
     * @param username  用户名
     * @param password  密码
     * @param name      姓名
     * @param gender    性别
     * @param age       年龄
     * @param email     邮箱
     * @param telephone 手机号
     */
    void add(String username, String password, String name, String gender, int age, String email, String telephone);

    /**
     * 按用户名删除用户
     *
     * @param username 用户名
     */
    void deleteByUsername(String username);

    /**
     * 按id删除指定用户
     *
     * @param id 用户id
     */
    void deleteById(Integer id);

    /**
     * 删除所有用户
     */
    void deleteAllUsers() ;

    /**
     * 获取用户总量
     *
     * @return 用户总量
     */
    Integer count();

    /**
     * 获取所有用户
     *
     * @return 用户列表
     */
    List<UserEntity> all();
}

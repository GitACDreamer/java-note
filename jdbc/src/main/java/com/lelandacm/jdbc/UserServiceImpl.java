package com.lelandacm.jdbc;

import org.apache.catalina.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author LelandACM
 */

@Component
public class UserServiceImpl implements UserService {

    private final JdbcTemplate jdbcTemplate;

    public UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
    @Override
    public void add(String username, String password, String name, String gender, int age, String email,
                    String telephone) {
        jdbcTemplate.update("insert into user(username ,password , name , gender , age , email , telephone) values(?," +
                "?,?,?,?,?,?)", username, password, name, gender, age, email,telephone);
    }

    /**
     * 按用户名删除用户
     *
     * @param username 用户名
     */
    @Override
    public void deleteByUsername(String username) {
        jdbcTemplate.update("delete from user where username = ? ", username);
    }

    /**
     * 按id删除指定用户
     *
     * @param id 用户id
     */
    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("delete from user where id = ? ", id);
    }

    /**
     * 删除所有用户
     */
    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from user");
    }

    /**
     * 获取用户总量
     *
     * @return 用户总量
     */
    @Override
    public Integer count() {
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }

    /**
     * 获取所有用户
     *
     * @return 用户列表
     */
    @Override
    public List<UserEntity> all() {
        return (List<UserEntity>) jdbcTemplate.queryForObject("select * from user", UserEntity.class);
    }
}

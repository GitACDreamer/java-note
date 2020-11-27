package com.lelandacm.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author LelandACM
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * 按username查找用户
     *
     * @param username 用户名
     * @return 用户实体
     */
    UserEntity findByUsername(String username);

    /**
     * 按年龄获取数据
     *
     * @param age 年龄
     * @return 用户实力
     */
    List<UserEntity> findByAgeGreaterThanEqual(int age);

    /**
     * 按用户名删除数据
     *
     * @param username 用户名
     */
    void deleteByUsername(String username);
}

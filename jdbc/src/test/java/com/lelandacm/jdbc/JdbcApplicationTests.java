package com.lelandacm.jdbc;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JdbcApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void test() throws Exception {
        // 插入5个用户
        userService.add("root", "123456", "liliang", "男", 20, "lelandacm@sunet.net.cn", "18588254125");
        userService.add("admin", "123456", "liliang", "男", 20, "lelandacm@sunet.net.cn", "18588254125");
        userService.add("test", "123456", "liliang", "男", 20, "lelandacm@sunet.net.cn", "18588254125");
        userService.add("op", "123456", "liliang", "男", 20, "lelandacm@sunet.net.cn", "18588254125");
        userService.add("mp", "123456", "liliang", "男", 20, "lelandacm@sunet.net.cn", "18588254125");

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userService.count().intValue());

        // 删除两个用户
        userService.deleteByUsername("root");
        userService.deleteByUsername("admin");

        // 查数据库，应该有5个用户
        Assert.assertEquals(3, userService.count().intValue());
    }
}

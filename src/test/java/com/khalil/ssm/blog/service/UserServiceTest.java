package com.khalil.ssm.blog.service;

import com.khalil.ssm.blog.BaseTest;
import com.khalil.ssm.blog.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void getUserById() {
        User user = userService.getUserById(1);
        System.out.println(user);
        Assert.notNull(user, "用户不存在");
    }

    @Test
    public void getUserByName() {
        User user = userService.getUserByName("admin");
        System.out.println(user);
        Assert.notNull(user, "用户名不存在");
    }
}

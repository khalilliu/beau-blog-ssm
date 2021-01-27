package com.khalil.ssm.blog.mapper;


import com.khalil.ssm.blog.BaseTest;
import com.khalil.ssm.blog.entity.User;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class UserMapperTest extends BaseTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void listUser() {
        List<User> userList = userMapper.listUser();
        System.out.println(userList);
        Assert.notEmpty(userList, "用户数量为空");
    }
}

package com.midland.test.service;

import java.util.Date;
import javax.annotation.Resource;

import com.midland.core.util.ApplicationUtils;
import com.midland.core.feature.test.TestSupport;
import com.midland.web.model.User;
import com.midland.web.service.UserService;

public class UserServiceTest extends TestSupport {

    @Resource
    private UserService userService;

//    @Test
    public void test_insert() {
        User model = new User();
        model.setUsername("");
        model.setPassword(ApplicationUtils.sha256Hex("123456"));
        model.setCreateTime(new Date().toString());
        userService.insert(model);
    }

//    @Test
    public void test_10insert() {
        for (int i = 0; i < 10; i++) {
            User model = new User();
            model.setUsername("" + i);
            model.setPassword(ApplicationUtils.sha256Hex("123456"));
            model.setCreateTime(new Date().toString());
            userService.insert(model);
        }
    }

}

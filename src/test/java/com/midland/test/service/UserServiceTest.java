package com.midland.test.service;

import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.midland.core.util.ApplicationUtils;
import com.midland.core.feature.test.TestSupport;
import com.midland.web.model.LinkUrlManager;
import com.midland.web.service.JdbcService;
import com.midland.web.service.LinkUrlManagerService;
import com.midland.web.util.MidlandHelper;
import com.midland.web.model.user.User;
import com.midland.web.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceTest extends TestSupport {
    
    
    @Autowired
    private LinkUrlManagerService linkUrlManagerServiceImpl;

    @Resource
    private UserService userService;

     @Resource
    private JdbcService jdbcService;

    
    @Test
    public void dsfef(){
        System.out.println(jdbcService.shiftDown("id","user",3));
    }
    
   @Test
    public void sdfsf(){
        LinkUrlManager ob=new LinkUrlManager();
        try {
            Page<LinkUrlManager> result = (Page<LinkUrlManager>) linkUrlManagerServiceImpl.findLinkUrlManagerList(ob);
            System.out.println(result.getPageNum());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    @Test
    public void sdfdsfdsfsf(){
        LinkUrlManager ob=new LinkUrlManager();
        try {
            LinkUrlManager result = linkUrlManagerServiceImpl.selectById(1);
            System.out.println(result.getCityId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    @Test
    public void test_insert() {
        User model = new User();
        model.setUsername("");
        model.setPassword(ApplicationUtils.sha256Hex("123456"));
        model.setCreateTime(MidlandHelper.getCurrentTime());
        userService.insert(model);
    }

    @Test
    public void test_10insert() {
        for (int i = 0; i < 10; i++) {
            User model = new User();
            model.setUsername("" + i);
            model.setPassword(ApplicationUtils.sha256Hex("123456"));
            model.setCreateTime(MidlandHelper.getCurrentTime());
            userService.insert(model);
        }
    }

}

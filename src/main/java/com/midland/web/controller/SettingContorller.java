package com.midland.web.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.enums.ContextEnums;
import com.midland.web.model.Popular;
import com.midland.web.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/setting")
public class SettingContorller {
@Autowired
private SettingService settingService;
    // 进入热门关注首页面
    @RequestMapping(value = "showPopularIndex", method = { RequestMethod.GET, RequestMethod.POST })
    public String showPopularIndex(Model model, HttpServletRequest request) {

        return "setting/showPopularIndex";
    }
    // 进入热门关注列表页
    @RequestMapping(value = "showPopularList", method = { RequestMethod.GET, RequestMethod.POST })
    public String showPopularList(Model model, HttpServletRequest request, Popular popular) {
        String pageSize = request.getParameter("pageSize");
        String pageNo = request.getParameter("pageNo");
        if(pageNo==null||pageNo.equals("")){
            pageNo = ContextEnums.PAGENO;
        }
        Map<String,Object> map =new HashMap<>();
        if(pageSize==null||pageSize.equals("")){
            pageSize = ContextEnums.PAGESIZE;
        }
        PageBounds pageBounds = new PageBounds(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
/*      Map<String,String> parem = new HashMap<>();
        parem.put("flag","sheet");
        parem.put("cityId","085");
        parem.put("areaId","R000010042");
        Map result =  settingService.queryAreaByRedis(parem);*/

        PageList<Popular> PopularList = settingService.findPopularList(popular,pageBounds);
        model.addAttribute("PopularList",PopularList);
        model.addAttribute("paginator",PopularList.getPaginator());

        return "setting/popularList";
    }



}

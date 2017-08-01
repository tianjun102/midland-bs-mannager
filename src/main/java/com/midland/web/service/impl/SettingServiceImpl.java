package com.midland.web.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.dao.PopularMapper;
import com.midland.web.model.Popular;
import com.midland.web.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private PopularMapper popularMapper;

    @Override
    public PageList<Popular> findPopularList(Popular popular, PageBounds pageBounds) {
        return popularMapper.selectPropularList(popular,pageBounds);
    }

    @Override
    public Popular findPopular(Popular popular) {
        return popularMapper.selectByPrimaryKey(popular.getId());
    }

    @Override
    public int updatePopular(Popular popular) {
        return popularMapper.updateByPrimaryKeySelective(popular);
    }

    @Override
    public int insertPopular(Popular popular) {
        return popularMapper.insert(popular);
    }
}

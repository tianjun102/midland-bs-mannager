package com.midland.web.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.model.Popular;

public interface SettingService {

    public PageList<Popular> findPopularList(Popular popular , PageBounds pageBounds);

    public Popular findPopular(Popular popular);

    public int updatePopular(Popular popular);

    public int insertPopular(Popular popular);




}

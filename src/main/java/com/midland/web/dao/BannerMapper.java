package com.midland.web.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.model.Banner;

public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKeyWithBLOBs(Banner record);

    int updateByPrimaryKey(Banner record);

    PageList<Banner> selectBannerList(Banner banner, PageBounds pageBounds);
}
package com.midland.web.dao;

import com.midland.web.model.Banner;

public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKeyWithBLOBs(Banner record);

    int updateByPrimaryKey(Banner record);
}
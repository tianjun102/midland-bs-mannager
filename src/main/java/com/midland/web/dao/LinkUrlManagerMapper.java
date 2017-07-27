package com.midland.web.dao;

import com.midland.web.model.LinkUrlManager;

public interface LinkUrlManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LinkUrlManager record);

    int insertSelective(LinkUrlManager record);

    LinkUrlManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LinkUrlManager record);

    int updateByPrimaryKeyWithBLOBs(LinkUrlManager record);

    int updateByPrimaryKey(LinkUrlManager record);
}
package com.midland.web.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.model.LinkUrlManager;

public interface LinkUrlManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LinkUrlManager record);

    int insertSelective(LinkUrlManager record);

    LinkUrlManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LinkUrlManager record);

    int updateByPrimaryKeyWithBLOBs(LinkUrlManager record);

    int updateByPrimaryKey(LinkUrlManager record);

    PageList<LinkUrlManager> selectLinkUrlList(LinkUrlManager linkUrlManager, PageBounds pageBounds);
}
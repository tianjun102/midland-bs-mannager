package com.midland.web.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.model.Popular;
import org.springframework.stereotype.Repository;
@Repository
public interface PopularMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Popular record);

    int insertSelective(Popular record);

    Popular selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Popular record);

    int updateByPrimaryKey(Popular record);

    PageList<Popular> selectPropularList(Popular propular, PageBounds pageBounds);
}
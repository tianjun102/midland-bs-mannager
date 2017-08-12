package com.midland.web.dao;

import com.midland.web.model.Popular;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PopularMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Popular record);

    int insertSelective(Popular record);

    Popular selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Popular record);

    int updateByPrimaryKey(Popular record);

    List<Popular> selectPropularList(Popular propular);
}
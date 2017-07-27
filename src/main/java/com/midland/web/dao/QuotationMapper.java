package com.midland.web.dao;

import com.midland.web.model.Quotation;

public interface QuotationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Quotation record);

    int insertSelective(Quotation record);

    Quotation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Quotation record);

    int updateByPrimaryKey(Quotation record);
}
package com.midland.web.dao;

import com.midland.web.model.TradeFair;

public interface TradeFairMapper {
    int insert(TradeFair record);

    int insertSelective(TradeFair record);
}
package com.midland.web.dao;

import com.midland.web.model.Appointment;

public interface AppointmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Appointment record);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);
}
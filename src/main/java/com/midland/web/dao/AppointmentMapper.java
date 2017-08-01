package com.midland.web.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.midland.web.model.Appointment;

import java.util.List;

public interface AppointmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Appointment record);
    
    List<Appointment> appointmentPage(Appointment record, PageBounds pageBounds);

    Appointment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appointment record);

}
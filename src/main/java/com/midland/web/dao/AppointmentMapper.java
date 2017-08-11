package com.midland.web.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.model.appointment.Appointment;

public interface AppointmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Appointment record);
    
    PageList<Appointment> appointmentPage(Appointment record, PageBounds pageBounds);

    Appointment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appointment record);

}
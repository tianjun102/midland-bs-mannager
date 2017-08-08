package com.midland.web.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.model.appointment.Appointment;

public interface AppointmentService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(Integer id);
    
    PageList<Appointment> appointmentPage(Appointment record, PageBounds pageBounds);
    
    int updateByPrimaryKeySelective(Appointment record);

}
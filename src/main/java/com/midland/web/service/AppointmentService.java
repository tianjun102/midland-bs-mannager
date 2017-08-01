package com.midland.web.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.midland.web.model.Appointment;

import java.util.List;

public interface AppointmentService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(Integer id);
    
    List<Appointment> appointmentPage(Appointment record, PageBounds pageBounds);
    
    int updateByPrimaryKeySelective(Appointment record);

}
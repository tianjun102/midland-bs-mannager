package com.midland.web.service;

import com.midland.web.model.appointment.Appointment;

import java.util.List;

public interface AppointmentService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(Integer id);
    
    List<Appointment> appointmentPage(Appointment record);
    
    int updateByPrimaryKeySelective(Appointment record);

}
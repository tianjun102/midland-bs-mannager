package com.midland.web.dao;

import com.midland.web.model.appointment.Appointment;

import java.util.List;

public interface AppointmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Appointment record);
    
    List<Appointment> appointmentPage(Appointment record);

    Appointment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appointment record);

}
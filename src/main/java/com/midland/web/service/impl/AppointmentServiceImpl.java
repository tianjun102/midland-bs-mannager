package com.midland.web.service.impl;

import com.midland.web.dao.AppointmentMapper;
import com.midland.web.model.appointment.Appointment;
import com.midland.web.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 预约看房Service实现类
 *
 * @author 
 * @since 2016年6月10日 下午12:05:03
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Resource
    private AppointmentMapper appointmentMapper;
    
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return appointmentMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insertSelective(Appointment record) {
        return appointmentMapper.insertSelective(record);
    }
    
    @Override
    public Appointment selectByPrimaryKey(Integer id) {
        return appointmentMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<Appointment> appointmentPage(Appointment record) {
        return appointmentMapper.appointmentPage(record);
    }
    
    @Override
    public int updateByPrimaryKeySelective(Appointment record) {
        return appointmentMapper.updateByPrimaryKeySelective(record);
    }
    
}

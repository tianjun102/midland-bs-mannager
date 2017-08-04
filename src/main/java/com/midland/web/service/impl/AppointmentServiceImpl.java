package com.midland.web.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.dao.AppointmentMapper;
import com.midland.web.model.Appointment;
import com.midland.web.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public PageList<Appointment> appointmentPage(Appointment record, PageBounds pageBounds) {
        return appointmentMapper.appointmentPage(record,pageBounds);
    }
    
    @Override
    public int updateByPrimaryKeySelective(Appointment record) {
        return appointmentMapper.updateByPrimaryKeySelective(record);
    }
    
}

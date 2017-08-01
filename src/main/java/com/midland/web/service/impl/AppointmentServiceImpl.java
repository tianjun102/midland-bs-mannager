package com.midland.web.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.midland.core.generic.GenericDao;
import com.midland.core.generic.GenericServiceImpl;
import com.midland.web.dao.AppointmentMapper;
import com.midland.web.dao.PermissionMapper;
import com.midland.web.model.Appointment;
import com.midland.web.model.Permission;
import com.midland.web.service.AppointmentService;
import com.midland.web.service.PermissionService;
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
    public List<Appointment> appointmentPage(Appointment record, PageBounds pageBounds) {
        return appointmentMapper.appointmentPage(record,pageBounds);
    }
    
    @Override
    public int updateByPrimaryKeySelective(Appointment record) {
        return appointmentMapper.updateByPrimaryKeySelective(record);
    }
    
}

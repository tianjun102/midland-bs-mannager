package com.midland.web.service.impl;

import com.midland.web.dao.AppointLogMapper;
import com.midland.web.model.AppointLog;
import com.midland.web.service.AppointLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 预约看房Service实现类
 *
 * @author 
 * @since 2016年6月10日 下午12:05:03
 */
@Service
public class AppointLogServiceImpl implements AppointLogService {

    @Resource
    private AppointLogMapper appointLogMapper;
    
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return appointLogMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insertSelective(AppointLog record) {
        return appointLogMapper.insertSelective(record);
    }
    
    @Override
    public AppointLog selectByPrimaryKey(Integer id) {
        return appointLogMapper.selectByPrimaryKey(id);
    }
    
    
    @Override
    public int updateByPrimaryKeySelective(AppointLog record) {
        return appointLogMapper.updateByPrimaryKeySelective(record);
    }
}

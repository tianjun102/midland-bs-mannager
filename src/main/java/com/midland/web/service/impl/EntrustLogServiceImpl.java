package com.midland.web.service.impl;

import com.midland.web.dao.EntrustLogMapper;
import com.midland.web.model.EntrustLog;
import com.midland.web.service.EntrustLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 委託看房Service实现类
 *
 * @author 
 * @since 2016年6月10日 下午12:05:03
 */
@Service
public class EntrustLogServiceImpl implements EntrustLogService {

    @Resource
    private EntrustLogMapper entrustLogMapper;
    
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return entrustLogMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insertSelective(EntrustLog record) {
        return entrustLogMapper.insertSelective(record);
    }
    
    @Override
    public EntrustLog selectByPrimaryKey(Integer id) {
        return entrustLogMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<EntrustLog> selectEntrustLogByEntrustId(Integer entrustId) {
        return entrustLogMapper.selectEntrustLogByEntrustId(entrustId);
    }
    
    @Override
    public int updateByPrimaryKeySelective(EntrustLog record) {
        return entrustLogMapper.updateByPrimaryKeySelective(record);
    }
}

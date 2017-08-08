package com.midland.web.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.midland.web.dao.EntrustMapper;
import com.midland.web.model.Entrust;
import com.midland.web.service.EntrustService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 预约看房Service实现类
 *
 * @author 
 * @since 2016年6月10日 下午12:05:03
 */
@Service
public class EntrustServiceImpl implements EntrustService {

    @Resource
    private EntrustMapper entrustMapper;
    
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return entrustMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insertSelective(Entrust record) {
        return entrustMapper.insertSelective(record);
    }
    
    @Override
    public Entrust selectByPrimaryKey(Integer id) {
        return entrustMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public PageList<Entrust> entrustPage(Entrust record, PageBounds pageBounds) {
        return entrustMapper.entrustPage(record,pageBounds);
    }
    
    @Override
    public int updateByPrimaryKeySelective(Entrust record) {
        return entrustMapper.updateByPrimaryKeySelective(record);
    }
}

package com.midland.web.service.impl;

import com.midland.web.model.Quotation;
import com.midland.web.dao.QuotationMapper;
import com.midland.web.service.QuotationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class QuotationServiceImpl implements QuotationService {

	private Logger log = LoggerFactory.getLogger(QuotationServiceImpl.class);
	@Autowired
	private QuotationMapper quotationMapper;

	/**
	 * 插入
	 **/
	@Override
	public void insertQuotation(Quotation quotation) throws Exception {
		try {
			log.info("insert {}",quotation);
			quotationMapper.insertQuotation(quotation);
		} catch(Exception e) {
			log.error("insertQuotation异常 {}",quotation,e);
			throw e;
		}
	}

	/**
	 * 查询
	 **/
	@Override
	public Quotation selectQuotationById(Integer id) {
		log.info("selectQuotationById  {}",id);
		return quotationMapper.selectQuotationById(id);
	}
	@Override
	public List<Map> tooltip(Quotation id) {
		log.info("selectQuotationById  {}",id);
		return quotationMapper.tooltip(id);
	}

	/**
	 * 删除
	 **/
	@Override
	public void deleteQuotationById(Integer id)throws Exception {
		try {
			log.info("deleteQuotationById  {}",id);
			int result = quotationMapper.deleteQuotationById(id);
			if (result < 1) {
				throw new Exception("deleteQuotationById失败");
			}
		} catch(Exception e) {
			log.error("deleteQuotationById  {}",id,e);
			throw e;
		}
	}
	/**
	 * 更新
	 **/
	@Override
	public void updateQuotationById(Quotation quotation) throws Exception {
		try {
			log.info("updateQuotationById  {}",quotation);
			int result = quotationMapper.updateQuotationById(quotation);
			if (result < 1) {
				throw new Exception("updateQuotationById失败");
			}
		} catch(Exception e) {
			log.error("updateQuotationById  {}",quotation,e);
			throw e;
		}
	}

	/**
	 * 分页，这里建议使用插件（com.github.pagehelper.PageHelper）
	 **/
	@Override
	public List<Quotation> findQuotationList(Quotation quotation) throws Exception {
		try {
			log.info("findQuotationList  {}",quotation);
			return quotationMapper.findQuotationList(quotation);
		} catch(Exception e) {
			log.error("findQuotationList  {}",quotation,e);
			throw e;
		}
	}
}

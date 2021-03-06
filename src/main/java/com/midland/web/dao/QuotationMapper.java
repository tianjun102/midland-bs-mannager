package com.midland.web.dao;

import com.midland.web.model.Quotation;
import java.util.List;
import java.util.Map;

public interface QuotationMapper {

	Quotation selectQuotationById(Integer quotation);

	int deleteQuotationById(Integer quotation);

	int updateQuotationById(Quotation quotation);

	int insertQuotation(Quotation quotation);

	List<Quotation> findQuotationList(Quotation quotation);
	List<Map> tooltip(Quotation quotation);

}

package com.midland.web.dao;

import com.midland.web.model.QrCode;
import java.util.List;

public interface QrCodeMapper {

	QrCode selectQrCodeById(Integer qrCode);

	int deleteQrCodeById(Integer qrCode);

	int updateQrCodeById(QrCode qrCode);

	int insertQrCode(QrCode qrCode);

	List<QrCode> findQrCodeList(QrCode qrCode);

}

package com.midland.ueditor.upload;

import com.midland.core.util.AppSetting;
import com.midland.ueditor.PathFormat;

import com.midland.ueditor.define.AppInfo;
import com.midland.ueditor.define.BaseState;
import com.midland.ueditor.define.FileType;
import com.midland.ueditor.define.State;

import java.util.Map;

import com.midland.web.controller.base.BaseController;
import org.apache.commons.codec.binary.Base64;

public final class Base64Uploader extends BaseController{

	public static State save(String content, Map<String, Object> conf) {
		
		byte[] data = decode(content);

		long maxSize = ((Long) conf.get("maxSize")).longValue();

		if (!validSize(data, maxSize)) {
			return new BaseState(false, AppInfo.MAX_SIZE);
		}

		String suffix = FileType.getSuffix("JPG");

		String savePath = PathFormat.parse((String) conf.get("savePath"),
				(String) conf.get("filename"));
		
		savePath = savePath + suffix;
		String physicalPath = (String) conf.get("rootPath") + savePath;

		State storageState = StorageManager.saveBinaryFile(data, physicalPath);

		if (storageState.isSuccess()) {
			storageState.putInfo("url", AppSetting.getAppSetting("imgdomain")+PathFormat.format(savePath.substring(1, savePath.length())));
			storageState.putInfo("type", suffix);
			storageState.putInfo("original", "");
		}

		return storageState;
	}

	private static byte[] decode(String content) {
		return Base64.decodeBase64(content);
	}

	private static boolean validSize(byte[] data, long length) {
		return data.length <= length;
	}
	
}
package com.fire.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fire.para.FinalPara;

@Service
public class UploadService {

	// 路径 FinaPata.FileRoot +type+date+fileName
	// File.separatorChar 与系统有关的默认名称分隔符
	public String uploadPic(MultipartFile file, String type) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = format.format(new Date());
		String date1 = format1.format(new Date());
		// 图片真实路径
		String path = FinalPara.FileRoot + type + File.separatorChar + date;
		// 获取当前时间为图片名
		String fileName = date1 + ".jpg";
		fileMaker(path, fileName, file);
		return FinalPara.FileRootVirtul + type + "/" + date + "/" + fileName;

	}

	// 图片上传文件
	private boolean fileMaker(String path, String fileName, MultipartFile file) {
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			// 转存文件
			file.transferTo(targetFile);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

package com.fire.action.manage;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fire.po.Picture;
import com.fire.service.UploadImgService;
import com.fire.service.UploadService;

@Controller
public class UploadImageAction {
	@Autowired
	UploadService uploadService;
	@Autowired
	UploadImgService uploadImgService;

	// 图片上传接口
	@RequestMapping(value = "UploadImg")
	@ResponseBody
	public JSONObject UploadPic(MultipartFile file, Picture picture) {
		JSONObject jsonObject = new JSONObject();
		// 图片的虚拟路径 
		String picurl = uploadService.uploadPic(file, picture.getPicType());
		// 获取当前时间
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String date = dateFormat.format(new Date());
		// 将图片虚拟路径存入数据库
		picture.setPictureurl(picurl);
		// 存入图片上传时间
		picture.setUploaddate(date);
		int a = uploadImgService.InsertImg(picture);

		if (a > 0) {
			jsonObject.put("result", "success");// 上传成功
		} else {
			jsonObject.put("result", "error");// 长传失败
		}
		return jsonObject;
	}

}
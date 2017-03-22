package com.fire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.PictureMapper;
import com.fire.po.Picture;

@Service
public class UploadImgService {
	@Autowired
	PictureMapper pictureMapper;

	// 图片上传
	public int InsertImg(Picture picture) {
		// TODO Auto-generated method stub
		return pictureMapper.insert(picture);
	}

}

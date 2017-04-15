package com.fire.action.manage;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.fire.service.CountService;
import com.fire.service.TableService;
import com.fire.service.UnitService;
import com.fire.utils.ExcelImportUtil;

@Controller
public class ExcelAction {
	@Autowired
	TableService fireTableService;
	@Autowired
	UnitService unitService;
	@Autowired
	CountService countService;

	// 商铺信息上传
	@RequestMapping("/ExcelUpload")
	@ResponseBody
	public String UploadExcel(MultipartFile file, Model model)
			throws IOException {
		InputStream fis = file.getInputStream();

		List<Map<String, String>> data = ExcelImportUtil.parseExcel(fis);

		Map<String, String> map = new HashMap<String, String>();
		// 循环上传数据
		for (int i = 0; i < data.size(); i++) {
			map.putAll(data.get(i));
			// 上传至数据库
			unitService.insertExcel(map);
		}
		// 上传成功后跳转到成功页面
		return "index";
	}
}

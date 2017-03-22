package com.fire.action.manage;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fire.po.PoliceInfo;
import com.fire.service.PoliceManageService;

@Controller
public class PoliceManageAction {
	@Autowired
	PoliceManageService policeManageService;

	// 客户端用户登录
	@RequestMapping("/login")
	@ResponseBody
	public JSONObject userLogin(String tel, String password) {

		JSONObject Result = new JSONObject();
		JSONObject jsonObject1 = new JSONObject();

		PoliceInfo police = policeManageService.findPoliceByName(tel);

		if (police != null) {
			if (police.getPassword().equals(password)) {
				// 登录成功
				police.setState("success");

				Result.put("result", police);
				return Result;

			} else {
				// 密码错误
				jsonObject1.put("state", "密码错误");
				Result.put("result", jsonObject1);
				return Result;
			}
		} else {
			// 用户名不存在
			jsonObject1.put("state", "用户名不存在");

			Result.put("result", jsonObject1);

			return Result;
		}

	}
}

package com.fire.action.manage;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fire.po.Menu;
import com.fire.po.Role;
import com.fire.po.User;
import com.fire.service.MenuService;
import com.fire.service.RoleService;
import com.fire.service.UserService;
import com.fire.utils.RightsHelper;
import com.fire.utils.Tools;

@Controller
@RequestMapping("user")
public class UserViewAction {
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	MenuService menuService;

	/**
	 * 
	 * 显示用户列表
	 */
	@RequestMapping
	public ModelAndView userlist(User user) {
		List<User> userList = userService.listPageUser(user);
		List<Role> roleList = roleService.listAllRoles();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("manage/users");
		mv.addObject("userList", userList);
		mv.addObject("roleList", roleList);
		return mv;
	}

	/**
	 * 
	 * 请求新增用户页面
	 */
	@RequestMapping("adduser")
	public String adduser(Model model) {
		List<Role> roleList = roleService.listAllRoles();
		model.addAttribute("roleList", roleList);
		return "manage/user_info";
	}

	/**
	 * 
	 * 保存用户信息
	 */
	@RequestMapping("saveuser")
	public ModelAndView saveUer(User user) {
		ModelAndView mv = new ModelAndView();
		if (user.getUserid() == null || user.getUserid().intValue() == 0) {
			if (userService.insertUser(user) == false) {
				mv.addObject("msg", "failed");
			} else {
				mv.addObject("msg", "success");
			}
		} else {
			userService.updateUserBaseInfo(user);
		}
		mv.setViewName("manage/save_result");
		return mv;
	}

	/**
	 * 
	 * 请求编辑用户页面
	 */
	@RequestMapping("edituser")
	public ModelAndView editUser(@RequestParam int userid) {
		ModelAndView mv = new ModelAndView();
		User user = userService.getUserById(userid);
		List<Role> roleList = roleService.listAllRoles();
		mv.addObject("user", user);
		mv.addObject("roleList", roleList);
		mv.setViewName("manage/user_info");
		return mv;
	}

	/**
	 * 
	 * 删除某个用户
	 */
	@RequestMapping("deleteuser")
	public void daleteUser(@RequestParam int userid, PrintWriter out) {
		userService.daleteUser(userid);
		out.write("success");
		out.close();
	}

	/**
	 * 
	 * 请求用户授权页面
	 */
	@RequestMapping("auth")
	public String authUser(@RequestParam int userid, Model model) {
		List<Menu> menuList = menuService.listAllMenu();
		User user = userService.getUserById(userid);
		String userlimit = user.getUserlimit();
		if (Tools.notEmpty(userlimit)) {
			for (Menu menu : menuList) {
				menu.setHasMenu(RightsHelper.testRights(userlimit,
						menu.getMenuid()));
				if (menu.isHasMenu()) {
					List<Menu> subUserlimitList = menu.getSubMenu();
					for (Menu sub : subUserlimitList) {
						sub.setHasMenu(RightsHelper.testRights(userlimit,
								sub.getMenuid()));
					}
				}
			}
		}
		JSONArray arr = JSONArray.fromObject(menuList);
		String json = arr.toString();
		json = json.replace("menuid", "id").replaceAll("menuname", "name")
				.replaceAll("subMenu", "nodes")
				.replaceAll("hasMenu", "checked");
		model.addAttribute("zTreeNodes", json);
		model.addAttribute("userid", userid);
		return "manage/authorization";
	}

	/**
	 * 
	 * 保存用户权限
	 */
	@RequestMapping("auth/save")
	public void saveAuth(@RequestParam int userid,
			@RequestParam String menuids, PrintWriter out) {
		BigInteger userlimit = RightsHelper.sumRights(Tools
				.str2StrArray(menuids));
		User user = userService.getUserById(userid);
		user.setUserlimit(userlimit.toString());
		userService.updateUserlimit(user);
		out.write("success");
		out.close();
	}

}

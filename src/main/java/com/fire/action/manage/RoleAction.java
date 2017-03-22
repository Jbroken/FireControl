package com.fire.action.manage;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fire.po.Menu;
import com.fire.po.Role;
import com.fire.service.MenuService;
import com.fire.service.RoleService;
import com.fire.utils.RightsHelper;
import com.fire.utils.Tools;

@Controller
@RequestMapping("role")
public class RoleAction {
	@Autowired
	RoleService roleService;
	@Autowired
	MenuService menuService;

	/**
	 * 
	 * 显示角色列表
	 * 
	 */
	@RequestMapping
	public String UserList(Map<String, Object> map) {
		List<Role> roleList = roleService.listAllRoles();
		map.put("roleList", roleList);
		return "manage/roles";
	}

	/**
	 * 
	 * 保存角色信息
	 * 
	 */
	@RequestMapping("save")
	public void save(PrintWriter out, Role role) {
		boolean flag = true;
		if (role.getRoleid() != null && role.getRoleid().intValue() > 0) {
			flag = roleService.updateRoleBaseInfo(role);
		} else {
			flag = roleService.insertRole(role);
		}
		if (flag) {
			out.write("success");
		} else {
			out.write("failed");
		}
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 
	 * 请求角色授权页面
	 */
	@RequestMapping("auth")
	public String auth(@RequestParam int roleid, Model model) {
		List<Menu> menuList = menuService.listAllMenu();
		Role role = roleService.getRoleById(roleid);
		String userlimit = role.getUserlimit();
		if (Tools.notEmpty(userlimit)) {
			for (Menu menu : menuList) {
				menu.setHasMenu(RightsHelper.testRights(userlimit,
						menu.getMenuid()));
				if (menu.isHasMenu()) {
					List<Menu> subMenuList = menu.getSubMenu();
					for (Menu sub : subMenuList) {
						sub.setHasMenu(RightsHelper.testRights(userlimit,
								sub.getMenuid()));
					}
				}

			}
		}
		JSONArray arr = JSONArray.fromObject(menuList);
		String json = arr.toString();
		json = json.replaceAll("menuid", "id").replaceAll("menuname", "name")
				.replaceAll("subMenu", "nodes")
				.replaceAll("hasMenu", "checked");
		model.addAttribute("zTreeNodes", json);
		model.addAttribute("roleid", roleid);
		return "manage/authorization";
	}

	/**
	 * 
	 * 保存角色权限
	 * 
	 */
	@RequestMapping("/auth/save")
	public void saveAuth(@RequestParam int roleid,
			@RequestParam String menuids, PrintWriter out) {
		BigInteger userlimit = RightsHelper.sumRights(Tools
				.str2StrArray(menuids));
		Role role = roleService.getRoleById(roleid);
		role.setUserlimit(userlimit.toString());
		roleService.updateRoleUserlimit(role);
		out.write("success");
		out.close();
	}
}

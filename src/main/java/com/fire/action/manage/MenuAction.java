package com.fire.action.manage;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fire.po.Menu;
import com.fire.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuAction {
	@Autowired
	MenuService menuService;

	/*
	 * 
	 * 显示菜单列表
	 */
	@RequestMapping
	public String list(Model model) {
		List<Menu> menuList = menuService.listAllparentMenu();
		model.addAttribute("menuList", menuList);
		return "manage/menus";
	}

	/*
	 * 
	 * 请求新增菜单页面
	 */
	@RequestMapping("addmenu")
	public String addmenu(Model model) {
		List<Menu> menuList = menuService.listAllparentMenu();
		model.addAttribute("menuList", menuList);
		return "manage/menus_info";
	}

	/*
	 * 
	 * 请求编辑菜单页面
	 */
	@RequestMapping("/editmenu")
	public String editmenu(@RequestParam Integer menuid, Model model) {
		Menu menu = menuService.getMenuById(menuid);
		model.addAttribute("menu", menu);
		if (menu.getMenuid() != null /* && menu.getModelid().intValue()>0 */) {
			List<Menu> menuList = menuService.listAllparentMenu();
			model.addAttribute("menuList", menuList);
		}
		return "manage/menus_info";
	}

	/*
	 * 
	 * 保存菜单信息
	 */
	@RequestMapping("savemenu")
	public String Savemenu(Menu menu, Model model) {
		menuService.saveMenu(menu);
		model.addAttribute("msg", "success");
		return "manage/save_result";
	}

	/*
	 * 
	 * 获取当前菜单的所有子菜单
	 */
	@RequestMapping("getSub")
	public void GetSub(@RequestParam Integer menuid,
			HttpServletResponse response) {
		List<Menu> subMenu = menuService.listSubMenuByParentId(menuid);
		JSONArray arr = JSONArray.fromObject(subMenu);
		PrintWriter out;
		try {
			response.setCharacterEncoding("utf-8");
			out = response.getWriter();
			String json = arr.toString();
			out.write(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 删除菜单
	 */
	@RequestMapping("delMenu")
	public void deleteMenu(@RequestParam Integer menuid, PrintWriter out) {
		menuService.deleteMenuById(menuid);
		out.write("success");
		out.flush();
		out.close();
	}
}

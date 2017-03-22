package com.fire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.MenuMapper;
import com.fire.po.Menu;

@Service
public class MenuService {
	@Autowired
	MenuMapper menuMapper;

	public List<Menu> listAllparentMenu() {
		// TODO Auto-generated method stub
		return menuMapper.listallSubMenu();
	}

	public Menu getMenuById(Integer menuid) {
		// TODO Auto-generated method stub
		return menuMapper.getMenuById(menuid);
	}

	public void saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		if (menu.getMenuid() != null && menu.getMenuid().intValue() > 0) {
			menuMapper.updateByPrimaryKey(menu);
		} else {
			menuMapper.insert(menu);
		}
	}

	public List<Menu> listSubMenuByParentId(Integer menuid) {
		// TODO Auto-generated method stub
		return menuMapper.listallSubMenuByParentId(menuid);
	}

	public void deleteMenuById(Integer menuid) {
		// TODO Auto-generated method stub
		menuMapper.deleteMenuById(menuid);

	}

	public List<Menu> listAllMenu() {
		// TODO Auto-generated method stub
		List<Menu> rl = this.listAllparentMenu();
		for (Menu menu : rl) {
			List<Menu> subList = this.listSubMenuByParentId(menu.getMenuid());
			menu.setSubMenu(subList);
		}
		return rl;
	}

}

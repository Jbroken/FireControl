package com.fire.po;

import java.util.List;

public class Menu {
	
    private Integer menuid;

    private String menuname;

    private String menurel;

    private Integer modelid;
    
    
    private Menu parentMenu;
    private List<Menu> SubMenu;
    
    private boolean hasMenu = false;
    

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMenurel() {
        return menurel;
    }

    public void setMenurel(String menurel) {
        this.menurel = menurel;
    }

    public Integer getModelid() {
        return modelid;
    }

    public void setModelid(Integer modelid) {
        this.modelid = modelid;
    }

	public Menu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}

	public List<Menu> getSubMenu() {
		return SubMenu;
	}

	public void setSubMenu(List<Menu> subMenu) {
		SubMenu = subMenu;
	}

	public boolean isHasMenu() {
		return hasMenu;
	}

	public void setHasMenu(boolean hasMenu) {
		this.hasMenu = hasMenu;
	}


}
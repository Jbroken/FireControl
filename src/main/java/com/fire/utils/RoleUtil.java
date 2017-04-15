package com.fire.utils;

import com.fire.po.Menu;

import java.util.List;

/**
 * Created by BZhao on 2017/4/15.
 */
public class RoleUtil {
    /**
     * 用户授权
     * @param userlimit
     * @param menuList
     */
    public static void userAuth(String userlimit,List<Menu> menuList){
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
    }
}

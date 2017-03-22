package com.fire.action.manage;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.fire.service.UserService;
import com.fire.utils.Const;
import com.fire.utils.RightsHelper;
import com.fire.utils.Tools;

@Controller
public class LoginAction {

	@Autowired
	UserService userService;
	@Autowired
	MenuService menuService;

	/**
	 * 请求登录，验证用户
	 * 
	 * @return
	 */
	@RequestMapping("admin")
	public ModelAndView UserLogin(HttpSession session,
			@RequestParam String username, @RequestParam String password,
			@RequestParam String code) {
		String sessionCode = (String) session
				.getAttribute(Const.SESSION_SECURITY_CODE);
		ModelAndView mv = new ModelAndView();
		String errInfo = "";
		if (Tools.notEmpty(sessionCode) && sessionCode.equalsIgnoreCase(code)) {
			User user = userService.getUserByNameAndPwd(username, password);
			if (user != null) {
				user.setLastlogin(new Date());
				userService.updateLastLogin(user);
				session.setAttribute(Const.SESSION_USER, user);
				session.removeAttribute(Const.SESSION_SECURITY_CODE);
			} else {
				errInfo = "用户名或密码有误";
			}
		} else {
			errInfo = "验证码输入有误！";
		}
		if (Tools.isEmpty(errInfo)) {
			mv.setViewName("redirect:index");// 登录成功
		} else {
			mv.addObject("errInfo", errInfo);
			mv.addObject("username", username);
			mv.addObject("password", password);
			mv.setViewName("manage/login");
		}
		return mv;
	}

	/**
	 * 访问系统首页
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpSession session, Model model) {
		User user = (User) session.getAttribute(Const.SESSION_USER);
		user = userService.getUserAndRoleById(user.getUserid());
		Role role = user.getRole();
		String rolelimit = role != null ? role.getUserlimit() : "";
		String userlimit = user.getUserlimit();
		// 避免每次拦截用户操作时查询数据库，以下将用户角色权限、用户权限都存入session
		session.setAttribute(Const.SESSION_ROLE_RIGHTS, rolelimit);// 将角色权限存入session
		session.setAttribute(Const.SESSION_USER_RIGHTS, userlimit);// 将用户权限存入session

		List<Menu> menuList = menuService.listAllMenu();
		if (Tools.notEmpty(userlimit) || Tools.notEmpty(rolelimit)) {
			for (Menu menu : menuList) {
				menu.setHasMenu(RightsHelper.testRights(userlimit,
						menu.getMenuid())
						|| RightsHelper.testRights(rolelimit, menu.getMenuid()));
				if (menu.isHasMenu()) {
					List<Menu> subMenuList = menu.getSubMenu();
					for (Menu sub : subMenuList) {
						sub.setHasMenu(RightsHelper.testRights(userlimit,
								sub.getMenuid())
								|| RightsHelper.testRights(rolelimit,
										sub.getMenuid()));
					}
				}
			}
		}
		model.addAttribute("user", user);
		model.addAttribute("menuList", menuList);
		return "manage/index";
	}

	/**
	 * 
	 * 退出登录
	 * 
	 * @return
	 */
	@RequestMapping("logout")
	public String Logout(HttpServletRequest request) {
		// 去掉session中的数据
		request.getSession().removeAttribute(Const.SESSION_USER);
		return "manage/login";
	}
}

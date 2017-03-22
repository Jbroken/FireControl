package com.fire.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.UserMapper;
import com.fire.po.User;
import com.fire.po.UserExample;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public boolean userLogin(User user,HttpServletRequest request) {

		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		if (userMapper.selectByExample(userExample).size() == 0) {

			return false;
		}
		User user2 = userMapper.selectByExample(userExample).get(0);
		if (user2 == null || user == null) {
			return false;
		}
		if (user2.getPassword().equals(user.getPassword())) {
			request.getSession().setAttribute("user", user);
			user.setUserlimit(user2.getUserlimit());
			return true;
		}
		return false;

	}

	public List<User> listPageUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.listPageUser(user);
	}

	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		int count = userMapper.getCountByName(user.getUsername());
		if (count > 0) {
			return false;
		} else {
			userMapper.insert(user);
			return true;
		}
	}

	public void updateUserBaseInfo(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKey(user);

	}

	public User getUserById(int userid) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(userid);
	}

	public void daleteUser(int userid) {
		// TODO Auto-generated method stub
		userMapper.deleteByPrimaryKey(userid);

	}

	public void updateUserlimit(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKey(user);

	}

	public User getUserByNameAndPwd(String username, String password) {
		// TODO Auto-generated method stub
		// User user = new User();
		// user.setUsername(username);
		// user.setPassword(password);
		return userMapper.getUserInfo(username, password);
	}

	public void updateLastLogin(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKey(user);
	}

	public User getUserAndRoleById(Integer userid) {
		// TODO Auto-generated method stub
		return userMapper.getUserAndRoleById(userid);
	}

}

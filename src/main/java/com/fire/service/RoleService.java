package com.fire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.dao.RoleMapper;
import com.fire.po.Role;

@Service
public class RoleService {
	@Autowired
	RoleMapper roleMapper;

	public List<Role> listAllRoles() {
		// TODO Auto-generated method stub
		return roleMapper.listAllroles();
	}

	public boolean updateRoleBaseInfo(Role role) {
		// TODO Auto-generated method stub
		if (roleMapper.getCountByName(role) > 0) {
			return false;
		} else {
			roleMapper.updateByPrimaryKey(role);
			return true;
		}
	}

	public boolean insertRole(Role role) {
		// TODO Auto-generated method stub
		if (roleMapper.getCountByName(role) > 0) {
			return false;
		} else {
			roleMapper.insert(role);
			return true;
		}

	}

	public Role getRoleById(int roleid) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleById(roleid);
	}

	public void updateRoleUserlimit(Role role) {
		// TODO Auto-generated method stub
		roleMapper.updateRoleUserlimit(role);
	}

}

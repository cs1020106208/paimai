package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.User;

public interface UserDao {
	
//询查全部
	public List<User> selectAllUser();
	
//查询一个
	public User selectOneUser(int id);

//添加用户
	public void insertUser(User user);		
	
//删除用户
	public void deleteUser(int id);
	
//修改用户
	public void updateUser(User user);	
	
//	登陆
	public User login(User user);
	
	
}

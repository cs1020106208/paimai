package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.User;

public interface UserDao {
	
//ѯ��ȫ��
	public List<User> selectAllUser();
	
//��ѯһ��
	public User selectOneUser(int id);

//����û�
	public void insertUser(User user);		
	
//ɾ���û�
	public void deleteUser(int id);
	
//�޸��û�
	public void updateUser(User user);	
	
//	��½
	public User login(User user);
	
	
}

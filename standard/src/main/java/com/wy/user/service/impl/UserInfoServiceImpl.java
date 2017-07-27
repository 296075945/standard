package com.wy.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wy.common.datasource.DataSource;
import com.wy.common.datasource.TargetDataSource;
import com.wy.user.dao.UserInfoDao;
import com.wy.user.model.UserInfo;
import com.wy.user.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	UserInfoDao userInfoDao;
	@Override
	@TargetDataSource(name=DataSource.TEST2)
	public UserInfo getUserinfo(int id) {
		return userInfoDao.selectByPrimaryKey(id); 
	}

}

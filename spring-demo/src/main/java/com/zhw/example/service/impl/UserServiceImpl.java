package com.zhw.example.service.impl;

import org.springframework.stereotype.Service;

import com.zhw.example.service.IUserService;

@Service
public class UserServiceImpl implements IUserService
{

	public UserServiceImpl()
	{
		System.out.println(this.getClass().getSimpleName() + " 构造函数执行...");
	}
}

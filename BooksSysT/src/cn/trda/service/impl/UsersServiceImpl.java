package cn.trda.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.trda.dao.UsersMapper;
import cn.trda.entity.Users;
import cn.trda.service.UsersService;
@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Resource
	private UsersMapper usersMapper;
	

	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	@Override
	public Users login(Users users) {
		// TODO Auto-generated method stub
		return usersMapper.login(users);
	}

	@Override
	public void register(Users users) {
		// TODO Auto-generated method stub
		usersMapper.register(users);
	}

	@Override
	public void loginTime(Users users) {
		// TODO Auto-generated method stub
		usersMapper.loginTime(users);
	}
	
}

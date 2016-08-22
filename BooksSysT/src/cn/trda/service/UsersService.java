package cn.trda.service;

import cn.trda.entity.Users;

public interface UsersService {

	Users login(Users users);

	void register(Users users);

	void loginTime(Users users);

}

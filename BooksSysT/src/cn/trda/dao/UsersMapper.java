package cn.trda.dao;

import cn.trda.entity.Users;

public interface UsersMapper {

	Users login(Users users);

	void register(Users users);

	void loginTime(Users users);

}

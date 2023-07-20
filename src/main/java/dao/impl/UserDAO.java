package dao.impl;

import java.util.List;
import java.util.Map;

import constant.NamedStored;
import dao.AbstractDAO;
import dao.IUserDAO;
import entity.User;

public class UserDAO extends AbstractDAO<User> implements IUserDAO {

	@Override
	public User findById(int id) {
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		String jpql = "SELECT o FROM User o WHERE email = ?0";
		return super.findOne(User.class, jpql, email);
	}

	@Override
	public User findByUsername(String username) {
		String jpql = "SELECT o FROM User o WHERE username = ?0";
		return super.findOne(User.class, jpql, username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		String jpql = "SELECT o FROM User o WHERE username = ?0 AND password = ?1";
		return super.findOne(User.class, jpql, username, password);
	}

	@Override
	public List<User> findAll() {
		return super.findAll(User.class, true);
	}
	
	@Override
	public List<User> findPage(int pageNumber, int pageSize) {
		return super.findPage(User.class, true, pageNumber, pageSize);
	}

	@Override
	public List<User> findUserLikedByVideoHref(Map<String, Object> params) {
		
		return super.callStored(NamedStored.FIND_USERS_LIKED_VIDEO_BY_HREF, params);
	}

	@Override
	public List<User> findUsersLikeByVideoHref(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.callStored(NamedStored.FIND_USERS_LIKED_VIDEO_BY_HREF, params);
	}	
}

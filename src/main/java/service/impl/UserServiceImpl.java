package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.IUserDAO;
import dao.impl.UserDAO;
import entity.User;
import entity.Video;
import service.UserService;

public class UserServiceImpl implements UserService {
	private IUserDAO dao;

	public UserServiceImpl() {
		dao = new UserDAO();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findByUsername(username);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findByUsernameAndPassword(username, password);
	}

	@Override
	public User resetPassword(String email) {
		// TODO Auto-generated method stub
		User exitUser = findByEmail(email);
		if (exitUser != null) {
			String newPass = String.valueOf((int) (Math.random() * ((9999 - 1000) + 1)) + 1000);
			exitUser.setPassword(newPass);
			return dao.update(exitUser);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<User> findPage(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return dao.findPage(pageNumber, pageSize);
	}

	@Override
	public List<User> findUserLikedByVideoHref(String href) {
		// TODO Auto-generated method stub
		Map<String,Object> params = new HashMap<>();
		params.put("videoHref",href);
		return dao.findUserLikedByVideoHref(params);
	}

	@Override
	public User create(String username, String password, String email) {
		// TODO Auto-generated method stub
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setIsAdmin(Boolean.FALSE);
		newUser.setIsActive(Boolean.TRUE);
		return dao.create(newUser);
	}

	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public User delete(String username) {
		// TODO Auto-generated method stub
		User user = dao.findByUsername(username);
		user.setIsActive(Boolean.FALSE);
		return dao.update(user);
	}

}

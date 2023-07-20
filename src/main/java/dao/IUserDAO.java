package dao;

import java.util.List;
import java.util.Map;

import entity.User;

public interface IUserDAO {
	User findById(int id);
	User findByEmail(String email);
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
	List<User> findAll();
	List<User> findPage(int pageNumber, int pageSize);
	List<User> findUserLikedByVideoHref(Map<String, Object> params);
	User create (User entity);
	User update (User entity);
	User delete (User entity);
	List<User> findUsersLikeByVideoHref(Map<String,Object> params);
}

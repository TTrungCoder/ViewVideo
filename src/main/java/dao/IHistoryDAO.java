package dao;

import java.util.List;

import entity.History;

public interface IHistoryDAO {
	List<History> findByUser(String username);
	List<History> findByUserAndIsliked(String username);
	History findByUserIdAndVideoId(int userId, int videoId);
	History create(History entity);
	History update(History entity);
}

package dao.impl;

import java.util.List;

import dao.AbstractDAO;
import dao.IHistoryDAO;
import entity.History;

public class HistoryDAO extends AbstractDAO<History> implements IHistoryDAO {

	@Override
	public List<History> findByUser(String username) {
		String jpql = "SELECT o FROM History o WHERE o.user.username = ?0 AND o.video.isActive = 1"
				+ " ORDER BY o.viewedDate DESC";
		return super.findMany(History.class, jpql, username);
	}

	@Override
	public List<History> findByUserAndIsliked(String username) {
		String jpql = "SELECT o FROM History o WHERE o.user.username = ?0 AND o.video.isActive = 1 AND o.isLiked = 1"
				+ " ORDER BY o.viewedDate DESC";
		return super.findMany(History.class, jpql, username);
	}

	@Override
	public History findByUserIdAndVideoId(int userId, int videoId) {
		String jpql = "SELECT o FROM History o WHERE o.user.id = ?0 AND o.video.id = ?1"
				+ " AND o.video.isActive = 1";
		return super.findOne(History.class, jpql, userId, videoId);
	}
}

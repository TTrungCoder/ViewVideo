package service.impl;

import java.sql.Timestamp;
import java.util.List;

import dao.IHistoryDAO;
import dao.impl.HistoryDAO;
import entity.History;
import entity.User;
import entity.Video;
import service.HistorySevice;
import service.VideoService;

public class HistoryServiceImpl implements HistorySevice {
	private IHistoryDAO dao;
	private VideoService videoService = new VideoServiceImpl();

	public HistoryServiceImpl() {
		dao = new HistoryDAO();
	}

	@Override
	public List<History> findByUser(String username) {
		// TODO Auto-generated method stub
		return dao.findByUser(username);
	}

	@Override
	public List<History> findByUserAndIsliked(String username) {
		// TODO Auto-generated method stub
		return dao.findByUserAndIsliked(username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		// TODO Auto-generated method stub
		return dao.findByUserIdAndVideoId(userId, videoId);
	}

	@Override
	public History create(User user, Video video) {
		// TODO Auto-generated method stub
		History exithistory = findByUserIdAndVideoId(user.getId(), video.getId());
		if (exithistory == null) {
			exithistory = new History();
			exithistory.setUser(user);
			exithistory.setVideo(video);
			exithistory.setLikedDate(new Timestamp(System.currentTimeMillis()));
			exithistory.setIsLiked(Boolean.FALSE);
			return dao.create(exithistory);
		}
		return exithistory;
	}

	@Override
	public boolean updateLikeOrUnLike(User user, String videohref) {
		// TODO Auto-generated method stub
		Video video = videoService.findByHref(videohref);
		History existHistory = findByUserIdAndVideoId(user.getId(), video.getId());
		
		if (existHistory.getIsLiked() == Boolean.FALSE) {
			existHistory.setIsLiked(Boolean.TRUE);
			existHistory.setLikedDate(new Timestamp(System.currentTimeMillis()));
		}else {
			existHistory.setIsLiked(Boolean.FALSE);
			existHistory.setLikedDate(null);
		}
		History updateHistory = dao.update(existHistory);
		return updateHistory != null ? true : false;
	}

}

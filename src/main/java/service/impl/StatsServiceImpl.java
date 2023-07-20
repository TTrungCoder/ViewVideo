package service.impl;

import java.util.List;

import dao.impl.StatsDAO;
import dto.VideoLikedInfo;
import service.StatsService;

public class StatsServiceImpl implements StatsService{
	private StatsDAO statsDao;
	public StatsServiceImpl() {
		statsDao = new StatsDAO();
	}
	@Override
	public List<VideoLikedInfo> finLikedInfos() {
		
		return statsDao.findVideoLikedInfo();
	}

}

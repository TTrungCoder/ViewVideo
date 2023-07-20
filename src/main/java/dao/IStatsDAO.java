package dao;

import java.util.List;

import dto.VideoLikedInfo;
import entity.User;

public interface IStatsDAO {
	List<VideoLikedInfo> findVideoLikedInfo();
}

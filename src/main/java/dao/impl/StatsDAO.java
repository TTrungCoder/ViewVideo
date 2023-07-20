package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.AbstractDAO;
import dao.IStatsDAO;
import dto.VideoLikedInfo;
import entity.User;

public class StatsDAO extends AbstractDAO<Object[]> implements IStatsDAO {

	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		String sql = "select v.id, v.title, v.href, sum(cast(h.isLiked as int)) as totalLike"
				+ "	from Videos v left join Historys h on v.id = h.videoId"
				+ "	where v.isActive = 1"
				+ "	group by"
				+ "	v.id, v.title, v.href"
				+ "	order by"
				+ "	sum(cast(h.isLiked as int)) desc";
		List<Object[]> objects =  super.findManyByNativeQuery(sql);
		System.out.println("Objects=: " + objects);
		List<VideoLikedInfo> result = new ArrayList<>();
		objects.forEach(object -> {
			VideoLikedInfo likedInfo = setDataVideoLikedInfo(object);
			result.add(likedInfo);
		});
		System.out.println("Result: " + result);
		return result;
		
	}
	
	private VideoLikedInfo setDataVideoLikedInfo(Object[] object) {
		VideoLikedInfo likedInfo = new VideoLikedInfo();
		likedInfo.setVideoId((int)object[0]);
		likedInfo.setTitle((String)object[1]);
		likedInfo.setHref((String)object[2]);
		likedInfo.setTotalLike(object[3] == null ? 0 : (int) object[3]);
		return likedInfo;
	}

}

package dao.impl;

import java.util.List;

import dao.AbstractDAO;
import dao.IVideoDAO;
import entity.Video;

public class VideoDAO extends AbstractDAO<Video> implements IVideoDAO {

	@Override
	public Video findById(int id) {
		return super.findById(Video.class, id);
	}

	@Override
	public Video findByHref(String href) {
		String jpql = "SELECT o FROM Video o WHERE o.href = ?0";
		return super.findOne(Video.class, jpql, href);
	}

	@Override
	public List<Video> findAll() {
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findPage(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findPage(Video.class, true, pageNumber, pageSize);
	}

}

package service.impl;

import java.util.List;

import dao.IVideoDAO;
import dao.impl.VideoDAO;
import entity.Video;
import service.VideoService;

public class VideoServiceImpl implements VideoService {
	private IVideoDAO dao;

	public VideoServiceImpl() {
		dao = new VideoDAO();
	}

	@Override
	public Video findById(int id) {
		
		return dao.findById(id);
	}

	@Override
	public Video findByHref(String href) {
		// TODO Auto-generated method stub
		return dao.findByHref(href);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<Video> findPage(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return dao.findPage(pageNumber, pageSize);
	}

	@Override
	public Video create(Video entity) {
		// TODO Auto-generated method stub
		entity.setIsActive(Boolean.TRUE);
		entity.setViews(0);
		entity.setShares(0);
		return dao.create(entity);
	}

	@Override
	public Video update(Video entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public Video delete(String href) {
		// TODO Auto-generated method stub
		Video entity = dao.findByHref(href);
		entity.setIsActive(Boolean.FALSE);
		return dao.update(entity);
	}

}
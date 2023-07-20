package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.SessionAttr;
import entity.History;
import entity.User;
import entity.Video;
import service.HistorySevice;
import service.VideoService;
import service.impl.HistoryServiceImpl;
import service.impl.VideoServiceImpl;

/**
 * Servlet implementation class VideoController
 */
@WebServlet({ "/admin/video", "/admin/views","/admin/add","/admin/edit"})
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoService videoService = new VideoServiceImpl();
	private HistorySevice historyService = new HistoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
			String action = req.getParameter("action");
			switch (action) {
			case "view": 
				doGetOverViews(req, res);
				break;
			case "delete": 
				doGetDelete(req, res);
				break;
			case "add": 
				req.setAttribute("isEdit", false);
				doGetAdd(req, res);
				break;
			case "edit": 
				req.setAttribute("isEdit", true);
				doGetEdit(req, res);
				break;
			}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
			String action = req.getParameter("action");
			switch (action) {
			case "add": 
				doPostAdd(req, res);
				break;
			case "edit": 
				doPostEdit(req, res);
				break;
			}
	}
	private void doPostAdd(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("application/json");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String href = req.getParameter("href");
		String poster = req.getParameter("poster");
		
		Video video = new Video();
		video.setTitle(title);
		video.setHref(href);
		video.setDescription(description);
		video.setPoster(poster);
		
		Video videoReturn = videoService.create(video);
		if (videoReturn != null) {
			res.setStatus(204);
		}else {
			res.setStatus(400);
		}
	}
	private void doPostEdit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("application/json");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String href = req.getParameter("newhref");
		String poster = req.getParameter("poster");
		String hrefOrigin = req.getParameter("hrefOrigin");
		Video video = videoService.findByHref(hrefOrigin);
		video.setTitle(title);
		video.setHref(href);
		video.setDescription(description);
		video.setPoster(poster);
		
		Video videoReturn = videoService.update(video);
		if (videoReturn != null) {
			res.setStatus(204);
		}else {
			res.setStatus(400);
		}
	}
	private void doGetOverViews(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Video> videos = videoService.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/overviews.jsp").forward(req, res);
	}
	private void doGetDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		String href = req.getParameter("href");
		Video videoDelete = videoService.delete(href);
		if (videoDelete != null) {
			res.setStatus(204);
		}else {
			res.setStatus(400);
		}
	}
	private void doGetAdd(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Video> videos = videoService.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, res);
	}
	private void doGetEdit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String href = req.getParameter("href");
		Video video = videoService.findByHref(href);
		req.setAttribute("video", video);
		req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, res);
	}

}

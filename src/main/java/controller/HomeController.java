package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class HomeController
 */
@WebServlet({ "/index", "/favorites", "/history" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoService videoService = new VideoServiceImpl();
	private HistorySevice historyService = new HistoryServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		HttpSession session = req.getSession();
		switch (path) {
		case "/index":
			doIndex(req, res);
			break;
		case "/favorites":
			doFavorites(session, req, res);
			break;
		case "/history":
			doHistory(session, req, res);
			break;
		}
	}

	protected void doIndex(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Video> videos = videoService.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("views/index.jsp").forward(req, res);
	}
	protected void doFavorites(HttpSession session, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<History> history = historyService.findByUserAndIsliked(user.getUsername());
		List<Video> videos = new ArrayList<>();
		history.forEach(item -> videos.add(item.getVideo()));
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("views/favorites.jsp").forward(req, res);
	}
	protected void doHistory(HttpSession session, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<History> history = historyService.findByUser(user.getUsername());
		List<Video> videos = new ArrayList<>();
		history.forEach(item -> videos.add(item.getVideo()));
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("views/history.jsp").forward(req, res);
	}


}

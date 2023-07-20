package controller;

import java.io.IOException;
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
@WebServlet({ "/video" })
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoService videoService = new VideoServiceImpl();
	private HistorySevice historyService = new HistoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionParam = req.getParameter("action");
		String href = req.getParameter("id");
		HttpSession session = req.getSession();
		switch (actionParam) {
		case "watch":
			doWatch(session, href, req, res);
			break;
		case "like":
			doLike(session, href, req, res);
			break;
		}

	}

	private void doWatch(HttpSession session, String href, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Video video = videoService.findByHref(href);
		req.setAttribute("video", video);
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if (currentUser != null) {
			History history = historyService.create(currentUser, video);
			req.setAttribute("flagLikeBtn", history.getIsLiked());
		}
		req.getRequestDispatcher("views/single.jsp").forward(req, res);
	}

	private void doLike(HttpSession session, String href, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("application/json"); 															
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		boolean result = historyService.updateLikeOrUnLike(currentUser, href);
		if (result == true) {
			res.setStatus(204);
		} else {
			res.setStatus(400);
		}
		req.getRequestDispatcher("views/single.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}

package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import constant.SessionAttr;
import dto.VideoLikedInfo;
import entity.History;
import entity.User;
import entity.Video;
import service.HistorySevice;
import service.StatsService;
import service.UserService;

import service.impl.StatsServiceImpl;
import service.impl.UserServiceImpl;
/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/admin", "/admin/favourites" }, name = "HomeControllerAdmin")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StatsService statsService = new StatsServiceImpl();
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if (currentUser != null && currentUser.getIsAdmin() == Boolean.TRUE) {
			String path = req.getServletPath();
			switch (path) {
			case "/admin":
				doGetHome(req, res);
				break;
			case "/admin/favourites":
				doGetfavourites(req, res);
				break;
			}
		} else {
			res.sendRedirect("index");
		}

	}

	protected void doGetHome(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<VideoLikedInfo> videos = statsService.finLikedInfos();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/home.jsp").forward(req, res);
	}

	protected void doGetfavourites(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setCharacterEncoding("utf-8");
		res.setContentType("application/json");
		String videoHref = req.getParameter("href");
		List<User> users = userService.findUserLikedByVideoHref(videoHref);
		if (users.isEmpty()) {
			res.setStatus(400);
		} else {
			ObjectMapper mapper = new ObjectMapper();
			String dataResponse = mapper.writeValueAsString(users);
			res.setStatus(200);
			out.print(dataResponse);
			out.flush();
		}

	}

}

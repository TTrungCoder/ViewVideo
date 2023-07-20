package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.SessionAttr;
import entity.User;
import service.EmailService;
import service.UserService;
import service.impl.EmailServiceImpl;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet({ "/login", "/logout", "/register", "/forgotpassword", "/changePass" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	private EmailService emailService = new EmailServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doLogin(req, res);
			break;
		case "/register":
			doRegister(req, res);
			break;
		case "/logout":
			doLogout(session, req, res);
			break;
		case "/forgotpassword":
			doForgot(req, res);
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/login":
			doPostLogin(session, req, res);
			break;
		case "/register":
			doPostRegister(session, req, res);
			break;
		case "/forgotpassword":
			doPostForgot(req, res);
			break;
		case "/changePass":
			doPostChangePass(session, req, res);
			break;
		}

	}

	protected void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = userService.login(username, password);
		if (user != null) {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			res.sendRedirect("index");
		} else {
			res.sendRedirect("login");
		}

	}

	protected void doPostRegister(HttpSession session, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			User user = userService.create(username, password, email);
			if (user != null) {
				emailService.senEmail(getServletContext(), user, "welcome");
				session.setAttribute(SessionAttr.CURRENT_USER, user);
				res.sendRedirect("index");
			} else {
				res.sendRedirect("register");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPostForgot(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			res.setContentType("application/json");
			String email = req.getParameter("email");
			User userWithNewPass = userService.resetPassword(email);
			if (userWithNewPass != null) {
				emailService.senEmail(getServletContext(), userWithNewPass, "forgot");
				res.setStatus(204);
			} else {
				res.setStatus(400);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doLogout(HttpSession session, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		session.removeAttribute(SessionAttr.CURRENT_USER);
		res.sendRedirect("index");
	}

	protected void doLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/login.jsp").forward(req, res);
	}

	protected void doRegister(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/register.jsp").forward(req, res);
	}

	protected void doForgot(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/forgotpw.jsp").forward(req, res);
	}

	private void doPostChangePass(HttpSession session, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json");
		String currentPass = req.getParameter("currentPass");
		String newPass = req.getParameter("newPass");

		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);

		if (currentUser.getPassword().equals(currentPass)) {
			currentUser.setPassword(newPass);
			User updatedUser = userService.update(currentUser);
			if (updatedUser != null) {
				session.setAttribute(SessionAttr.CURRENT_USER, updatedUser);
				resp.setStatus(204);
			} else {
				resp.setStatus(400);
			}
		} else {
			resp.setStatus(400);
		}
	}

}

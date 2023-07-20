package service;

import javax.servlet.ServletContext;

import entity.User;

public interface EmailService {
	void senEmail(ServletContext context, User recipient, String type);
}

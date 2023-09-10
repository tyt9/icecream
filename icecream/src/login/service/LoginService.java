package login.service;

import org.springframework.beans.factory.annotation.Autowired;

import login.dao.AdminDao;
import login.model.Admin;

public class LoginService {

	@Autowired
	private AdminDao adminDao;

	public User login(String id, String password) {

		Admin admin = adminDao.selectById(id);
		if (admin == null) {
			System.out.println("admin == null");
			throw new LoginFailException();
		}
		if (!admin.matchPassword(password)) {
			System.out.println("!admin.matchPassword(password)");
			throw new LoginFailException();
		}
		return new User(admin.getAdminId(), admin.getName()); //session 저장

	}
}

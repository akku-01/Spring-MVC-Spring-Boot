package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.ComplexDao;
import springmvc.dao.UserDao;
import springmvc.model.User;
import springmvc.model.UserComplex;

@Service
public class ComplexService {

	@Autowired
	private ComplexDao userDao;
	public int createUser(UserComplex user) {
		return this.userDao.saveUser(user);
	}
}


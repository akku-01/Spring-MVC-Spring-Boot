package springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Product;
import springmvc.model.UserComplex;

@Repository
public class ComplexDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveUser(UserComplex user) {
		int id = (Integer) this.hibernateTemplate.save(user);
		return id;
	}
	
	public void createProduct(Product product) {
		
	}
}


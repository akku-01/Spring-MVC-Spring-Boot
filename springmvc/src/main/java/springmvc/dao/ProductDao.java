package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import springmvc.model.Product;

@Component
public class ProductDao {
	@Autowired 
	private HibernateTemplate hibernateTemplate;
	
	//create product
	@Transactional
	public void createProd(Product product) {
		System.out.println("inside create"+product);
		this.hibernateTemplate.save(product);
	}
	
	//get all products
	public List<Product> getProducts(){
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//Delete the single product
	@Transactional
	public void deleteProd(int pid) {
		Product p = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);
	}
	
	//get single product
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class, pid);
	}
}

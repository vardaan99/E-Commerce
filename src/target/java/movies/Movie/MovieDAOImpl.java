package movies.Product;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void insert(Product p) {
		sessionFactory.getCurrentSession().save(p);
		
	}

	public void update(Product p) {
		sessionFactory.getCurrentSession().update(p);
		
	}

	public void delete(int pid) {
		sessionFactory.getCurrentSession().createQuery("delete from Product where pid = :somevalue").setInteger("somevalue", pid).executeUpdate();		}

	public Product getProduct(int pid) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, pid);
		
	}

	public List<Product> getProduct() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
		}

}


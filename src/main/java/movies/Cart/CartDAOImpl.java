package movies.Cart;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void insert(Cart c) {
		sessionFactory.getCurrentSession().save(c);
	}

	public void update(Cart c) {
		sessionFactory.getCurrentSession().update(c);
		
	}

	public void delete(int id) {
		sessionFactory.getCurrentSession().createQuery("delete from Cart where id = :somevalue").setInteger("somevalue", id).executeUpdate();		
		}

	public Cart getCart(int id) {
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class, id);
		
	}

	public List<Cart> getCart() {
		return sessionFactory.getCurrentSession().createQuery("from Cart").list();
		}

	

}

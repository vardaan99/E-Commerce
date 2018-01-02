package movies.Movie;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class MovieDAOImpl implements MovieDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void insert(Movie m) {
		sessionFactory.getCurrentSession().save(m);
	}

	public void update(Movie m) {
		sessionFactory.getCurrentSession().update(m);
		
	}

	public void delete(int mid) {
		sessionFactory.getCurrentSession().createQuery("delete from Genre where mid = :somevalue").setInteger("somevalue", mid).executeUpdate();		
		}

	public Movie getMovie(int mid) {
		return (Movie) sessionFactory.getCurrentSession().get(Movie.class, mid);
		
	}

	public List<Movie> getMovie() {
		return sessionFactory.getCurrentSession().createQuery("from Movie").list();
		}


}

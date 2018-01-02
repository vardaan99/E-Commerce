package movies.Genre;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class GenreDAOImpl implements GenreDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void insert(Genre g) {
		sessionFactory.getCurrentSession().save(g);
		
	}

	public void update(Genre g) {
		sessionFactory.getCurrentSession().update(g);
		
	}

	public void delete(int id) {
		sessionFactory.getCurrentSession().createQuery("delete from Genre where id = :somevalue").setInteger("somevalue", id).executeUpdate();		}

	public Genre getGenre(int id) {
		return (Genre) sessionFactory.getCurrentSession().get(Genre.class, id);
		
	}

	public List<Genre> getGenre() {
		return sessionFactory.getCurrentSession().createQuery("from Genre").list();
		}

}

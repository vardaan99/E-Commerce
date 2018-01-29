package movies.Profiles;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class ProfilesDAOImpl implements ProfilesDAO {

		@Autowired
	SessionFactory sessionFactory;
	
		
	public void insert(Profiles p) {
		sessionFactory.getCurrentSession().save(p);
	}

	public void update(Profiles p) {
		sessionFactory.getCurrentSession().update(p);
		
	}

	public void delete(int id) {
		sessionFactory.getCurrentSession().createQuery("delete from Profiles where id = :somevalue").setInteger("somevalue", id).executeUpdate();		
		}

	public Profiles getSignup(int id) {
		return (Profiles) sessionFactory.getCurrentSession().get(Profiles.class, id);
		
	}

	public List<Profiles> getProfiles() {
		return sessionFactory.getCurrentSession().createQuery("from Profiles").list();
		}

	public List<Profiles> getAll() {
		return (List<Profiles>)this.sessionFactory.getCurrentSession().createQuery("from Profiles").list();
	}


}

package movies.Profiles;

import java.util.List;

public interface ProfilesDAO {
	
	void insert( Profiles p );
	void update( Profiles p );
	void delete( int id );

	Profiles getSignup(int id);
	List<Profiles> getProfiles();

}
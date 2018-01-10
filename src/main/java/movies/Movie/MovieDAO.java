package movies.Movie;

import java.util.List;

public interface MovieDAO {
	
	void insert( Movie m );
	void update( Movie m );
	void delete( int id );

	Movie getMovie(int id);
	List<Movie> getMovie();

}

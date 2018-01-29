package movies.Movie;

import java.util.List;

public interface MovieDAO {
	
	void insert( Movie m );
	void update( Movie m );
	void delete( int mid );

	Movie getMovie(int mid);
	public Movie getProductsbyId(int mid);
	List<Movie> getMovie();

}

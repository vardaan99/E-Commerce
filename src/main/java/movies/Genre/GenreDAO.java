package movies.Genre;

import java.util.List;

public interface GenreDAO {
	
	void insert( Genre g );
	void update( Genre g );
	void delete( int id );

	Genre getGenre(int id);
	List<Genre> getGenre();

}

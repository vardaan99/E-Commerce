package movies.Product;

import java.util.List;

public interface ProductDAO {
	
	void insert( Product p );
	void update( Product p );
	void delete( int pid );

	Product getProduct(int pid);
	List<Product> getProduct();

}

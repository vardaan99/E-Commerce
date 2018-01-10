package movies.Cart;

import java.util.List;

public interface CartDAO {
	
	void insert( Cart c );
	void update( Cart c );
	void delete( int id );

	Cart getCart(int id);
	List<Cart> getCart();

}

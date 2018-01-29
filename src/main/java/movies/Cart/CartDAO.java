package movies.Cart;

import java.util.List;

public interface CartDAO {
	
	public void insert( Cart c );
	public void update( Cart c );
	public void update(String Email,String ship,String bill);
	public void delete( int id );

	public Cart getCart(int id);
	public List<Cart> getCart();
}

package movies.Cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import movies.Movie.Movie;

@Entity
public class Cart {

	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	
	private int id;
	private int pid;
	private String Billing_Address;
	private String Shipping_Address;
	private int quantity;
	private String Email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getBilling_Address() {
		return Billing_Address;
	}
	public void setBilling_Address(String billing_Address) {
		Billing_Address = billing_Address;
	}
	public String getShipping_Address() {
		return Shipping_Address;
	}
	public void setShipping_Address(String shipping_Address) {
		Shipping_Address = shipping_Address;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getEmail() {
		return Email;
	}
	public void setUsername(String Email) {
		this.Email = Email;
	} 
}
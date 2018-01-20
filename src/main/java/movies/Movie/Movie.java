package movies.Movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Movie {

	@Id @GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	private String name;
	private String Description;
	private int Rating;
	private String ImagePath;
	private int Quantity;
	
	@Transient
	private MultipartFile f;
	
	
	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		this.ImagePath = imagePath;
	}

	public MultipartFile getF() {
		return f;
	}

	public void setF(MultipartFile f) {
		this.f = f;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String Description) {
		this.Description = Description;
	}
	
	public int getRating() {
		return Rating;
	}
	
	public void setRating(int Rating) {
		this.Rating= Rating;
	}
	
	
}
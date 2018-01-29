package movies;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import com.cloudinary.utils.ObjectUtils;
import com.cloudinary.Cloudinary;

import movies.Cart.Cart;
import movies.Cart.CartDAO;
import movies.Movie.*;

@Controller
public class MovieController {
	
	@Autowired
	MovieDAO mdao;
	
	@Autowired
	CartDAO cdao;

	@RequestMapping("/AddMovie")
	public ModelAndView AddMovie() {
		ModelAndView mv = new ModelAndView("AddMovie");

		Movie m = new Movie();

		mv.addObject("Movie", m);

		return mv;
	}

	@RequestMapping(value = "/AddMovieToDB", method = RequestMethod.POST)
	public ModelAndView AddMovieToDB(@ModelAttribute("Movie") Movie m , HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("redirect:/AddMovie");

		try
		{
			System.out.println(m.getF());
			
			byte b[] = m.getF().getBytes();
			
			System.out.println( req.getRealPath("/") );
			
			File f1 = new File( req.getRealPath("/") +  "/image.jpg");
			
			 BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(f1));
	            stream.write(b);
	            stream.close();
	            
	            Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
	            		  "cloud_name", "dcggaci79",
	            		  "api_key", "661329623955634",
	            		  "api_secret", "UQzGfBCt1oL_YnvPOWTfzEi9qTM"));
	            
	            Map uploadResult = cloudinary.uploader().upload(f1, ObjectUtils.emptyMap());
	            System.out.println( uploadResult);
	            System.out.println(uploadResult.get("secure_url").toString());
	            m.setImagePath(uploadResult.get("secure_url").toString());
	            
		}
		
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		
		
		mdao.insert(m);

		return mv;
	}

	@RequestMapping("/UpdateMovie/{mid}")
	public ModelAndView UpdateMovie(@PathVariable("mid") int mid) {
		ModelAndView mv = new ModelAndView("UpdateMovie");

		mv.addObject("Movie", mdao.getMovie(mid));

		return mv;
	}

	private String getCurrentUser(){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    {    
	    	System.out.println(auth.getName());
	    	System.out.println("User present");
	    	return auth.getName();
	    }
	    
		return "";
	}
	
	@RequestMapping(value = "/AddCartToDB", method = RequestMethod.POST)
	public ModelAndView AddCartToDB( @RequestParam("Id") int id , @RequestParam("quantity") int qty ) {
		ModelAndView mv = new ModelAndView("redirect:/cart");

		String user = this.getCurrentUser();
		
		Cart c = new Cart();
		
		c.setPid(id);
		c.setQuantity(qty);
		c.setUsername(user);
		
		cdao.insert(c);

		return mv;
	}
	
	@RequestMapping("/ViewMovie")
	public ModelAndView ViewMovie() {
		ModelAndView mv = new ModelAndView("ViewMovie");

		mv.addObject("AllMovie", mdao.getMovie());

		return mv;
	}

	@RequestMapping(value="/UpdateMovie/UpdateMovieToDB",method=RequestMethod.POST)
	public ModelAndView UpdateMovieToDB( @ModelAttribute("Movie") Movie m )
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewMovie");
		
		mdao.update(m);
		
		return mv;
	}

	@RequestMapping("/DeleteMovieFromDB/{mid}")
	public ModelAndView DeleteMovieFromDB(@PathVariable("mid") int mid) {
		ModelAndView mv = new ModelAndView("redirect:/ViewMovie");

		mdao.delete(mid);

		return mv;
	}
	
	@RequestMapping("/ViewOneMovie/{mid}")
	public ModelAndView ViewOneMovie(@PathVariable("mid") int mid) {
		ModelAndView mv = new ModelAndView("ViewOneMovie");

		mv.addObject("Movie", mdao.getMovie(mid));

		return mv;
	}


}
package movies;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import movies.Cart.CartDAO;
import movies.Genre.Genre;
import movies.Genre.GenreDAO;
import movies.Genre.GenreDAOImpl;

import movies.Movie.*;


@Controller
public class MyController {

	@Autowired
	CartDAO cartdao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("WelcomeMessage", "Welcome to the Spring Jungle");

		return mv;
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView mv = new ModelAndView("LoginPage");
		
		return mv;
	}
	
	
	
	public String test()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && !auth.getName().equals("anonymousUser"))
	    {    
	    	System.out.println(auth.getName());
	    	//System.out.println("User present");
	    	return "loggedin";
	    }
	    else
	    {
	    	System.out.println("User not present");
	    	return "notloggedin";
	    }
	 }
		
}

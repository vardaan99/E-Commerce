package movies;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;

import movies.Genre.Genre;
import movies.Genre.GenreDAO;
import movies.Genre.GenreDAOImpl;

import movies.Movie.*;

@Controller
public class MyController {

	@Autowired
	GenreDAO gdao;
	
	@Autowired
	MovieDAO mdao;


	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("WelcomeMessage", "Welcome to the Spring Jungle");

		return mv;
	}

	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView("signup");

		mv.addObject("WelcomeMessage", "Welcome to the Signup Page");

		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");

		mv.addObject("WelcomeMessage", "Welcome to the login Page");

		return mv;
	}

	@RequestMapping("/AddGenre")
	public ModelAndView AddGenre() {
		ModelAndView mv = new ModelAndView("AddGenre");

		Genre g = new Genre();

		mv.addObject("Genre", g);

		return mv;
	}

	@RequestMapping(value = "/AddGenreToDB", method = RequestMethod.POST)
	public ModelAndView AddGenreToDB(@ModelAttribute("Genre") Genre g) {
		ModelAndView mv = new ModelAndView("redirect:/AddGenre");

		gdao.insert(g);

		return mv;
	}
	
	@RequestMapping("/UpdateGenre/{id}")
	public ModelAndView UpdateGenre( @PathVariable("id") int id )
	{
		ModelAndView mv = new ModelAndView("UpdateGenre");
		
		mv.addObject("Genre",  gdao.getGenre(id));
		
		return mv;
	}
	@RequestMapping("/ViewGenre")
	public ModelAndView ViewGenre() {
		ModelAndView mv = new ModelAndView("ViewGenre");

		mv.addObject("AllGenre", gdao.getGenre());

		return mv;
	}

	@RequestMapping(value="/UpdateGenre/UpdateGenreToDB",method=RequestMethod.POST)
	public ModelAndView UpdateGenreToDB( @ModelAttribute("Genre") Genre g )
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewGenre");
		
		gdao.update(g);
		
		return mv;
	}

	@RequestMapping("/DeleteGenreFromDB/{id}")
	public ModelAndView DeleteGenreFromDB(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("redirect:/ViewGenre");

		gdao.delete(id);

		return mv;
	}
	
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
	            
	            /*Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
	            		  "cloud_name", "my_cloud_name",
	            		  "api_key", "my_api_key",
	            		  "api_secret", "my_api_secret"));
	            
	            Map uploadResult = cloudinary.uploader().upload(f1, ObjectUtils.emptyMap());*/
			
	            //System.out.println( uploadResult );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		
		
		//mdao.insert(m);

		return mv;
	}

	@RequestMapping("/UpdateMovie/{mid}")
	public ModelAndView UpdateMovie(@PathVariable("id") int mid) {
		ModelAndView mv = new ModelAndView("UpdateMovie");

		mv.addObject("Movie", mdao.getMovie(mid));

		return mv;
	}

	@RequestMapping("/ViewMovie")
	public ModelAndView ViewMovie() {
		ModelAndView mv = new ModelAndView("ViewMovie");

		mv.addObject("AllMovie", mdao.getMovie());

		return mv;
	}

	@RequestMapping("/UpdateMovieFromDB/{m}")
	public ModelAndView UpdateMovieFromDB(@ModelAttribute("m") Movie m) {
		ModelAndView mv = new ModelAndView("redirect:/ViewMovie");

		mdao.update(m);

		return mv;
	}

	@RequestMapping("/DeleteMovieFromDB/{mid}")
	public ModelAndView DeleteMovieFromDB(@PathVariable("id") int mid) {
		ModelAndView mv = new ModelAndView("redirect:/ViewMovie");

		mdao.delete(mid);

		return mv;
	}

}

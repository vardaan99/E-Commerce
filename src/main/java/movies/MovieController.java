package movies;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import com.cloudinary.utils.ObjectUtils;
import com.cloudinary.Cloudinary;

import movies.Movie.*;

@Controller
public class MovieController {
	
	@Autowired
	MovieDAO mdao;

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
	            		  "cloud_name", "my_cloud_name",
	            		  "api_key", "my_api_key",
	            		  "api_secret", "my_api_secret"));
	            
	            Map uploadResult = cloudinary.uploader().upload(f1, ObjectUtils.emptyMap());
			
	            System.out.println( uploadResult );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		
		
		
		mdao.insert(m);

		return mv;
	}

	@RequestMapping("/UpdateMovie/{id}")
	public ModelAndView UpdateMovie(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("UpdateMovie");

		mv.addObject("Movie", mdao.getMovie(id));

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

	@RequestMapping("/DeleteMovieFromDB/{id}")
	public ModelAndView DeleteMovieFromDB(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("redirect:/ViewMovie");

		mdao.delete(id);

		return mv;
	}


}
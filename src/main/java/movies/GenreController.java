package movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;

import movies.Genre.*;


@Controller
public class GenreController {

	@Autowired
	GenreDAO gdao;
	
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

}
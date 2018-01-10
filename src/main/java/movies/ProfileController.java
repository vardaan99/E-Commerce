package movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;


import movies.Profiles.*;

@Controller
public class ProfileController {

	@Autowired
	ProfilesDAO pdao;
	

	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView("signup");

		Profiles p = new Profiles();

		mv.addObject("Profiles", p);

		return mv;

	}

	@RequestMapping(value = "/AddProfilesToDB", method = RequestMethod.POST)
	public ModelAndView AddProfilesToDB(@ModelAttribute("Profiles") Profiles p) {
		ModelAndView mv = new ModelAndView("redirect:/signup");

		pdao.insert(p);

		return mv;
	}
	
	/*@RequestMapping("/UpdateGenre/{id}")
	public ModelAndView UpdateProfiles( @PathVariable("id") int id )
	{
		ModelAndView mv = new ModelAndView("UpdateGenre");
		
		mv.addObject("Profiles",  pdao.getProfiles());
		
		return mv;
	}
	@RequestMapping("/ViewGenre")
	public ModelAndView ViewGenre() {
		ModelAndView mv = new ModelAndView("ViewGenre");

		mv.addObject("AllGenre", pdao.getProfiles());

		return mv;
	}

	@RequestMapping(value="/UpdateGenre/UpdateGenreToDB",method=RequestMethod.POST)
	public ModelAndView UpdateGenreToDB( @ModelAttribute("Genre") Profiles p )
	{
		ModelAndView mv = new ModelAndView("redirect:/ViewGenre");
		
		pdao.update(p);
		
		return mv;
	}

	@RequestMapping("/DeleteGenreFromDB/{id}")
	public ModelAndView DeleteGenreFromDB(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("redirect:/ViewGenre");

		pdao.delete(id);

		return mv;
	}*/
}
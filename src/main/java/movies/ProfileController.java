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
	
	
	@RequestMapping("/ViewProfiles")
	public ModelAndView ViewProfiles() {
		ModelAndView mv = new ModelAndView("ViewProfiles");

		mv.addObject("AllProfiles", pdao.getProfiles());

		return mv;
	}

}
	
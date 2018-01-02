package movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {

	@Autowired
	GenreDAO gdao;


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
		ModelAndView mv = new ModelAndView("redirect:/ViewGenre");

		gdao.insert(g);

		return mv;
	}

	@RequestMapping("/UpdateGenre/{id}")
	public ModelAndView UpdateGenre(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("UpdateGenre");

		mv.addObject("Genre", gdao.getGenre(id));

		return mv;
	}

	@RequestMapping("/ViewGenre")
	public ModelAndView ViewGenre() {
		ModelAndView mv = new ModelAndView("ViewGenre");

		mv.addObject("AllGenre", gdao.getGenre());

		return mv;
	}

	@RequestMapping("/UpdateGenreFromDB/{g}")
	public ModelAndView UpdateGenreFromDB(@ModelAttribute("g") Genre g) {
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

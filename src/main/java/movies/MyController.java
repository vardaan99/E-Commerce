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

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("WelcomeMessage", "Welcome to the Spring Jungle");

		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");

		mv.addObject("WelcomeMessage", "Welcome to the login Page");

		return mv;
	}

		
	}

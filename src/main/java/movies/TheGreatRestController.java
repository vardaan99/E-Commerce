package movies;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import movies.Cart.Cart;
import movies.Cart.CartDAO;
import movies.Movie.Movie;
import movies.Movie.MovieDAO;
import movies.Profiles.Profiles;


@RestController
public class TheGreatRestController {

	@Autowired
	CartDAO cdao;
	
	@Autowired
	MovieDAO mdao;
	
	
	
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
	
	@RequestMapping(value="fetchCartItems",method=RequestMethod.POST)
	public ResponseEntity<String> fetchCartItems()
	{
		JSONObject jobj= new JSONObject();
		
		System.out.println(jobj.toJSONString());
		
		JSONArray jarr = new JSONArray();
		
		String user = this.getCurrentUser();
		
		for( Cart c : cdao.getCart() ){
		
			
			if( c.getEmail().equals(user) )
			{
				jobj = new JSONObject();
				
				Movie m = mdao.getMovie(c.getId());
				
				jobj.put("cid", c.getId());
				jobj.put("pname", m.getName());
				jobj.put("pprice", m.getRating());
				jobj.put("pqty",c.getQuantity());
				jobj.put("pimg",m.getImagePath());
				
				jarr.add(jobj);
			}
			
		}
		
		System.out.println(jarr.toJSONString());
		
		return new ResponseEntity<String>(jarr.toJSONString(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/AddCartToDB", method = RequestMethod.POST)
	public ModelAndView AddCartToDB(@ModelAttribute("Cart") Cart c) {
		ModelAndView mv = new ModelAndView("redirect:/cart");

		cdao.insert(c);

		return mv;
	}
}
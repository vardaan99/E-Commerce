package movies;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import movies.Cart.*;
import movies.Movie.*;
import movies.Profiles.Profiles;
import movies.Profiles.ProfilesDAO;


@RestController
public class TheGreatRestController {

	@Autowired
	CartDAO cdao;
	
	@Autowired
	MovieDAO mdao;
	
	@Autowired
	ProfilesDAO pdao;
	
	
	
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
	
@RequestMapping(value="/getAllCartItems",method=RequestMethod.POST)
public String getAllCartItems()
{
	System.out.println("getAllCartItems");

	String currUser = "";
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null && !auth.getName().equals("anonymousUser"))
    	currUser = auth.getName();
	
	JSONArray jarr = new JSONArray();
	
	for( Cart c : cdao.getCart() )
	{
		if( c.getEmail() != null && c.getEmail().equals(currUser) )
		{
			JSONObject jobj = new JSONObject();
			
			Movie m = mdao.getProductsbyId(c.getMid());
			
			jobj.put("qty", c.getQuantity());
			jobj.put("id", c.getId());
			jobj.put("pname",  m.getName() );
			jobj.put("pprice",  m.getPrice() );
			jobj.put("pdesc", m.getDescription() );
			jobj.put("pimg", m.getImagePath());
			jobj.put("shipaddr", c.getShipping_Address());
			jobj.put("billaddr", c.getBilling_Address());
		
			jarr.add(jobj);
		}
		
	}
	
	System.out.println(jarr.toJSONString());
	
	return jarr.toJSONString();
}

@RequestMapping(value="/DeleteCartItems",method=RequestMethod.POST)
public String DeleteCartItems()
{
	System.out.println("DeleteCartItems");

	String user = this.getCurrentUser();
	
	for( Cart c : cdao.getCart() )
	{
		if( c.getEmail().equals(user) )
		{	
		int a=c.getId();
		cdao.delete(a);	
		}
	}
	return "{\"msg\":\"Deleted Items\"}";
}
@RequestMapping(value="/UpdateCartAddToDB",method=RequestMethod.POST)
public String UpdateCartToDB(@RequestBody String data)
{
	System.out.println("UpdateCartAddToDB");
	
	String user = this.getCurrentUser();
    
    System.out.println(data);

	try{
		JSONParser jparr = new JSONParser();
		
		JSONObject inp = (JSONObject)jparr.parse(data);
		
		System.out.println(inp);
		
		String ship = inp.get("ship").toString();
		String bill = inp.get("bill").toString();
		cdao.update(user, ship, bill);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	return "{\"msg\":\"Updated\"}";
}

@RequestMapping(value="/deletefromcart",method=RequestMethod.POST)
public String deletefromcart(@RequestBody String data)
{
	System.out.println("deletefromcart");

	System.out.println(data);
	
	try{
		JSONParser jparr = new JSONParser();
		
		JSONObject inp = (JSONObject)jparr.parse(data);
		
		System.out.println(inp);
		
		int id = Integer.parseInt( inp.get("id").toString() );
		
		Cart c=cdao.getCart(id);
		int q =c.getQuantity();
		
		Movie m = mdao.getMovie(c.getId());
		int i= m.getQuantity();
		i=i+q;
		
		String qty = String.valueOf(i);
		m.setQuantity(i);
		this.mdao.update(m);
		cdao.delete(id);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	return "{\"msg\":\"Deleted\"}";
}

@RequestMapping(value="/getAddress",method=RequestMethod.POST)
public String getAddress()
{
	System.out.println("getAddress");
	
	String currUser = "";
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null && !auth.getName().equals("anonymousUser"))
    	currUser = auth.getName();
    
    JSONObject jobj = new JSONObject();
		
	for( Profiles p : pdao.getAll())
	{
		
		if( p.getEmail().equals(currUser))
		{	
			String add = p.getAddress();
			
			System.out.println(add);
			jobj.put("Billing_Address", p.getAddress());
			jobj.put("Shipping_Address", p.getAddress());
			
			
			return jobj.toJSONString();
		}
		
	}
	
	return jobj.toJSONString();
}

	
}
package movies;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import movies.Cart.Cart;
import movies.Cart.CartDAO;


@RestController
public class TheGreatRestController {

	@Autowired
	CartDAO cdao;
	
	@RequestMapping(value="/fetchCartItems",method=RequestMethod.POST)
	public ResponseEntity<String> fetchCartItems()
	{
		
		JSONObject jobj = new JSONObject();
		
		
		jobj.put("name", "vasudev");
		
		System.out.println(jobj.toJSONString());
		
		JSONArray jarr = new JSONArray();
		
		for( Cart c :  cdao.getCart()){
			jobj = new JSONObject();
			jobj.put("name", c.getEmail());
			jarr.add(jobj);
		}
		
		System.out.println(jarr.toJSONString());
		
		return new ResponseEntity<String>(jarr.toJSONString(),HttpStatus.OK);
	}
	
}

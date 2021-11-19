package com.example.RestAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 

@Controller
public class CardController {
	
	@Autowired
	ValidatingCards validatingCards;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String HelloWelcome( ) {
		return "CardsControllerPage.jsp"; 	
	}

 	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String sayHelloWelcome(ModelMap model,@RequestParam String cNumber ) {
	 	
 		try 
		{ 
			Double.parseDouble(cNumber);  		 
			
			if(cNumber.length()< 20 && cNumber.length()>14) {
				
				model.put("card", "It's an " + validatingCards.checkCard(cNumber) + " card.");
	 		
			}else {
				 
				model.put("msg", "Number Should be greater than 14 and less than 16 ");
			}
			
		}  
		catch (NumberFormatException e)  
		{ 
			model.put("msg", "invalid input" );
		}
	 
	 	return "CardsControllerPage.jsp";
		}
}

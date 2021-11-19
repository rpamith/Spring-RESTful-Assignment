package com.example.RestAssignment;

import org.springframework.stereotype.Component;

@Component
public class ValidatingCards {
	
	public String checkCard(String cardNumber) {
		
		int first4 = Integer.parseInt((String) cardNumber.subSequence(0, 4));
		int first6 = Integer.parseInt((String) cardNumber.subSequence(0, 6));
		int first =  Integer.parseInt((String) cardNumber.subSequence(0,1));
		int second =  Integer.parseInt((String) cardNumber.subSequence(1,2));
	 
		
			if((first4 == 2014 || first4 == 2149) && cardNumber.length() == 15 ) {
				 return "enRout";
			}else if(first4 >= 3528 && first4 <= 2149 && (cardNumber.length() >= 16 || cardNumber.length() >= 19)){
				  return "jcb";
			}else if(((first6 >= 601100 && first6 <= 601109) || (first6 >= 601120 && first6 <= 601149) ||
					(first6 == 601174) || (first6 >= 601177 && first6 <= 601179) || 
					(first6 >= 601186 && first6 <= 601199) || (first6 >= 644000 && first6 <= 659999)) && cardNumber.length() == 16){
				  return "American express";
			}else if(((first==5 && (second >0 || second < 6)) || (first==5 && (second > 1 || second < 8 )))&& cardNumber.length() == 16){
				 return "Master Card";
			}else if( first==4 && cardNumber.length() <=19){
				 return "visa";
			}
 		 
		return null;	
	} 
}

package org.insset.shared;

public class FieldVerifier {

   
    public static boolean isValidName(String name) {
        if ((name == null) || (name.isEmpty()) || name == " ") {
            return false;
        }
        return true;
    }

    public static boolean isValidDecimal(Integer nbr) {
        //Implement your code
        if ((nbr == null) || (nbr<=0)) {
            return false;
        }
        return true;
   }

    public static boolean isValidRoman(String nbr) {
        if ((nbr == null) || (nbr.isEmpty()) || (nbr ==" ") ) {
            return false;
        }
        return true;
    }

    public static boolean isValidDate(String date) {
        //Implement your code
        return true;
    }
    
      
   //Add the code 
    
    public static boolean isValidPrice(String price){
        boolean status = true;
            if(price ==null || price.isEmpty() ){
                status=!status ;
            }
        return status;
    }
    
    public static boolean isValideDiscount(String discount){
        boolean status = true;
        if(discount == null || discount.isEmpty()){
            status = !status;
        }    
        return status;   
    }
}
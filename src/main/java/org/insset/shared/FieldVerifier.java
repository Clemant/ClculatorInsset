package org.insset.shared;

public class FieldVerifier {

    public FieldVerifier(){}
   
    public static boolean isValidName(String name) {
        if ((name == null) || (name.isEmpty()) || name == " ") {
            return false;
        }
        return true;
    }

    public static boolean isValidDecimal(Integer nbr) {
        
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
       if ((date == null) || (date.isEmpty()) || (date ==" ") ) {
            return false;
        }
        return true;
    }
    
}
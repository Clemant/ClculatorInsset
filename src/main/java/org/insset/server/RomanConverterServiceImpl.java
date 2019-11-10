package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements RomanConverterService {

    private static final int []     nbre   = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static final String []  valeur = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
    private static Logger rootLogger = Logger.getLogger("");
    
    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }

    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        return 3;
    }

    @Override
    public String convertArabeToRomans(Integer nbr) throws IllegalArgumentException {
       
        String roman = "";
       
        int taille = nbre.length;
        while(nbr>0){
          for(int i=0;i<taille;i++){
              if(nbr>=nbre[i]){
                  int count = nbr/nbre[i];
                  for(int j=0;j<count;j++){
                      roman=roman+valeur[i];
                  }
                  nbr=nbr-(count*nbre[i]);
              }
            }
          nbr=0;
          }
        return new String(roman);
    }
}

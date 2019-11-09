package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.PourcentageService;

public class PourcentageServiceImpl extends RemoteServiceServlet implements PourcentageService {

    public double getFinalPrice (double prix_initial, double remise_initial) throws Exception {
            
            double resultat = 0.0d;
           
            if(remise_initial<0 || prix_initial<=0){
                throw new Exception("Erreur sur le prix ou remise");
            }else{
            resultat = prix_initial-(prix_initial*remise_initial/100);
            if(resultat<0){
                throw new Exception();
            }
           }  
        return resultat;
    }
    
    public double getInitialPrice(double finalPrice,double discount) throws Exception{
        double resultat = 0;
      
        if(finalPrice<0 || discount<0){
            throw new Exception("Erreur sur les valeur");
        }
        resultat = finalPrice *(100/(100-discount));
        return resultat;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.insset.client.service.PourcentageService;

/**
 *
 * @author victoire
 */
public class PourcentageServiceImpl extends RemoteServiceServlet implements
        PourcentageService {

    

    @Override
    public double pourcentage (String prix, String remise) throws Exception {
            
            double resultat = 0.0d;
        
            double prix_initial = Double.parseDouble(prix);
            double remise_initial = Double.parseDouble(remise);
            
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
    
    public double getInitialPrice(String price,String remise) throws Exception{
        double resultat = 0;
        double finalPrice = Double.parseDouble(price);
        double discount = Double.parseDouble(remise);
        
        if(finalPrice<0 || discount<0){
            throw new Exception("Erreur sur les valeur");
        }
        resultat = finalPrice *(100/(100-discount));
        
        return resultat;
    }
    
}

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
    public double pourcentage (String prix, String remise) throws Exception  {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.      
        double resultat =0.0d;
        
       
            double prix_initial = Double.parseDouble(prix);
            double remise_initial = Double.parseDouble(remise);
            
            if(remise_initial<=0 || prix_initial<=0){
                throw new Exception();
            }else{
            resultat = prix_initial-(prix_initial*remise_initial/100);
            //display ="Le prix avec la remise de "+remise+" est:"+resultat;
              
           }
         
        
        return resultat;
    }
    
    
}

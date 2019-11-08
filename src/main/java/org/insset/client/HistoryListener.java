/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Button;
import java.util.logging.Level;
import org.insset.client.exemple.ExemplePresenter;
import org.insset.client.calculator.CalculatorDecimalPresenter;
import org.insset.client.calculator.CalculatorPourcentage;

import java.util.logging.Logger;




/**
 *
 * @author user
 */
public class HistoryListener implements ValueChangeHandler<String> {
    
    private static Logger rootLogger = Logger.getLogger("");

    
   
      //Logger logger = Logger.getLogger("NomLogger");

    
    @Override
    public void onValueChange(ValueChangeEvent<String> event) {

        //Accès a la page de conversion roman
       /* if (event.getValue().equals("roman")) {
            RootPanel.get().clear();
            RootPanel.get().add(new CalculatorDecimalPresenter());
        }
*/
        //Accès a la page d'exemple
       /* if (event.getValue().equals("example")) {
            RootPanel.get().clear();
            RootPanel.get().add(new ExemplePresenter());
        }else if (event.getValue().equals("pourcentage")){
            RootPanel.get().clear();
            RootPanel.get().add(new PourcentagePresenter());
        }else{
            RootPanel.get().clear();
            RootPanel.get().add(new CalculatorDecimalPresenter());
        }
*/
        //Accès a la page pourcentage
        //Add your code 
        String ele = event.getValue();
        rootLogger.log(Level.SEVERE,"-->"+event.getValue());
        rootLogger.log(Level.SEVERE, "pageIndex selected: " + event.getValue().getClass().getName());
        
       /*
       

        switch(ele){
            case "pourcentage":
                rootLogger.log(Level.INFO,"Test");
                RootPanel.get().clear();
                rootLogger.log(Level.SEVERE,"OK retest2");
                //RootPanel.get().add(new Button("Test"));
                displayPresenter(new PourcentagePresenter());
                break;
            case "roman":
                rootLogger.log(Level.INFO,"Test pass roman");
                 RootPanel.get().clear();
                 rootLogger.log(Level.INFO,"Test pass 2 roman");
                 RootPanel.get().add(new CalculatorDecimalPresenter());
                break;
            default:
                RootPanel.get().clear();
                RootPanel.get().add(new ExemplePresenter());
                break;
        }
        */
        
        if(ele == "pourcentage"){
            rootLogger.log(Level.INFO,"Test");
                RootPanel.get().clear();
                RootPanel.get().add(new CalculatorPourcentage());
                rootLogger.log(Level.SEVERE,"OK retest2");
                //RootPanel.get().add(new Button("Test"));
                
        }
       
        
    }
    public void displayPresenter(Object o){
        
            rootLogger.log(Level.INFO,"Iformation sur le type class"+o.getClass().getName());
     }

}

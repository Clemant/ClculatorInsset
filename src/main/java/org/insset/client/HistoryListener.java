package org.insset.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;
import java.util.logging.Level;
import org.insset.client.exemple.ExemplePresenter;
import org.insset.client.calculator.CalculatorDecimalPresenter;
import org.insset.client.pourcentage.CalculatorPourcentage;

import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class HistoryListener implements ValueChangeHandler<String> {
    
    private static Logger rootLogger = Logger.getLogger("");

 
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
        String urlValue = event.getValue();
        rootLogger.log(Level.SEVERE,"-->"+event.getValue());
        rootLogger.log(Level.SEVERE, "pageIndex selected: " + event.getValue().getClass().getName());
        
       
       

        switch(urlValue){
            case "pourcentage":
                rootLogger.log(Level.INFO,"Test");
                RootPanel.get().clear();
                rootLogger.log(Level.INFO,"OK retest 2");
                RootPanel.get().add(new CalculatorPourcentage());
                rootLogger.log(Level.INFO,"OK the test pass 3");
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
       
        
        
        
    }
    

}

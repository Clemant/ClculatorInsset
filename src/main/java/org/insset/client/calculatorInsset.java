package org.insset.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class calculatorInsset implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        String initToken = History.getToken();

        
        if (initToken.length() == 0) {
            History.newItem("exemple");
        }
        

        History.addValueChangeHandler(new HistoryListener());
        History.fireCurrentHistoryState();

              
       
    }
    
    
    
}

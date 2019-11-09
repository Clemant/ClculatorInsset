package org.insset.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;

public interface PourcentageServiceAsync {
    void getFinalPrice( double prix, double remise, AsyncCallback<String> callback);
    void getInitialPrice(double finalPrice, double discount,AsyncCallback<String> callback);
}

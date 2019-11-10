package org.insset.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;

public interface PourcentageServiceAsync {
    void getFinalPrice( double prix, double remise, AsyncCallback<Double> callback);
    void getInitialPrice(double finalPrice, double discount,AsyncCallback<Double> callback);
}

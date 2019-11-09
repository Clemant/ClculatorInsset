package org.insset.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("pourcentage")
public interface PourcentageService extends RemoteService {
    
    double getFinalPrice(double initialPrice, double discount) throws Exception;
    double getInitialPrice(double finalPrice, double discount) throws Exception;
    
}

package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.ExempleService;

@SuppressWarnings("serial")
public class ExempleServiceImpl extends RemoteServiceServlet implements ExempleService {
    
    public ExempleServiceImpl(){}

    public String inverserChaine(String input) throws IllegalArgumentException {
        int longueur = input.length();
        StringBuffer envers = new StringBuffer();
        int i;

        for (i = 0; i < longueur; i++) {
            envers.append(input.charAt(longueur - i - 1));
        }
        return new String(envers);
    }
}
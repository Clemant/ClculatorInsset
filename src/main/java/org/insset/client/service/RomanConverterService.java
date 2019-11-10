package org.insset.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author user
 */
@RemoteServiceRelativePath("romanConvert")
public interface RomanConverterService extends RemoteService {

    /**
     * Convertion Chiffre romain en chiffre arabe
     *
     * @param nbr
     * @return
     * @throws IllegalArgumentException
     */
    Integer convertRomanToArabe(String nbr) throws IllegalArgumentException;

    String convertArabeToRomans(Integer nbr) throws IllegalArgumentException;

    String convertDateYears(String nbr) throws IllegalArgumentException;
}

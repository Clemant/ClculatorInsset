/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author talend
 */
public class PourcentageServiceImplTest {
    
    private PourcentageServiceImpl pourcentageService;
    private static Logger rootLogger = Logger.getLogger("");
    
    public PourcentageServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        pourcentageService = new PourcentageServiceImpl();
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void isPourcentageTest() throws Exception{
        
            double resultat = pourcentageService.pourcentage("40","60");
            assertEquals(null, resultat, 16.0, 0);
           // rootLogger.log(Level.INFO, "Resultat: "+resultat);
                           
    } 
    
    @Test(expected=Exception.class)
    public void isPourcentageExceptionDiscountTest() throws Exception{
        
        pourcentageService.pourcentage("12","1-0");  
        rootLogger.log(Level.INFO,"Exception must be throw");
       
    }
    
    @Test(expected=Exception.class)
    public void isPourcentageExceptionPriceTest() throws Exception{
        pourcentageService.pourcentage("-12","10");  
      
    }
   
    @Test(expected=Exception.class)
    public void isPourcentageExceptionPriceEmptyTest() throws Exception{
        pourcentageService.pourcentage(" ","10");   
    }
    
    @Test(expected=Exception.class)
    public void isPourcentageExceptionDiscountEmptyTest() throws Exception{
        pourcentageService.pourcentage("10"," ");   
    }
    
    @Test(expected=Exception.class)
    public void isPourcentageErrorTest() throws Exception{
        pourcentageService.pourcentage("5","-200");
        
    }
    
    
//    Create the text for the seconde method
    
    @Test(expected=Exception.class)
    public void getInitalPriceDefaultTest() throws Exception{
        pourcentageService.getInitialPrice("16", "");
    }
    
    @Test
    public void getInitialPriceTest() throws Exception{
        double initalPrice = pourcentageService.getInitialPrice("16", "60");
        assertEquals("le test est ok",40,initalPrice,0);
    }
}

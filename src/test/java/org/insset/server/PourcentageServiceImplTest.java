package org.insset.server;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


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
            double resultat = pourcentageService.getFinalPrice(40,60);
            assertEquals(null, resultat, 16.0, 0);
    } 
    
    @Test(expected=Exception.class)
    public void isPourcentageExceptionDiscountTest() throws Exception{
        pourcentageService.getFinalPrice(12,-1);  
    }
    
    @Test(expected=Exception.class)
    public void isPourcentageExceptionPriceTest() throws Exception{
        pourcentageService.getFinalPrice(-12,10);     
    }
    
    @Test(expected=Exception.class)
    public void isPourcentageErrorTest() throws Exception{
        pourcentageService.getFinalPrice(5,200);    
    }
    
    
    @Test
    public void getInitialPriceTest() throws Exception{
        double initalPrice = pourcentageService.getInitialPrice(16, 60);
        assertEquals("le test est ok",40,initalPrice,0);
    }
    
    @Test(expected=Exception.class)
    public void getInitalPriceFailTest() throws Exception{
        pourcentageService.getInitialPrice(-10, 0);
    }
    
    @Test(expected=Exception.class)
    public void getInitalDicountFailTest() throws Exception{
        pourcentageService.getInitialPrice(10, -10);
    }
    
}
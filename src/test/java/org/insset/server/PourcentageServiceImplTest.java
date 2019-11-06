/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

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
        
            double resulat = pourcentageService.pourcentage("40","60");
            assertEquals(null, resulat, 16.0, 0);
        
    } 
    
    @Test(expected=Exception.class)
    public void isPourcentageExceptionDiscountTest() throws Exception{
        
        pourcentageService.pourcentage("12","0");  
       
        
       
    }
    
    @Test(expected=Exception.class)
    public void isPourcentageExceptionPriceTest() throws Exception{
        
        pourcentageService.pourcentage("-12","10");  
       
    }
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.shared;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victoire
 */
public class FieldVerifierTest {
    
    
    private FieldVerifier field;
    
    public FieldVerifierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    
        field = new FieldVerifier();
    }
    
    @After
    public void tearDown() {
    }
    
    
  /*  @Test
    public void isValidNameTest(){
        boolean status = field.isValidName("Phrase");
        assertTrue("",status);
    }
    
    @Test
    public void isValidNameFailTest(){
        boolean status = field.isValidName(null);
        System.out.println(status);
        assertFalse("The test passed",status);
    }
    
  /*  

   @Test(expected=Exception.class)
   public void isValidPriceExceptionTest() throws Exception{
       boolean status =field.isValidPrice("12e");
       System.out.println();
       assertTrue("OK",status);
   }
    
   @Test
   public void isValidPriceTes(){
       boolean status = field.isValidPrice("23");
       assertTrue("OK",status);
   }
   */
}

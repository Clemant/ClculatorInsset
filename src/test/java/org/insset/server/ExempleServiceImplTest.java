package org.insset.server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExempleServiceImplTest {
    
    public ExempleServiceImplTest() {
    }
    
    private static ExempleServiceImpl instance;
    
    @Before
    public void setUp() {
        instance = new ExempleServiceImpl();
    }
 
//    @Test
//    public void testInverserChaine() {
//        String input = "" ;
//        String expResult = "";
//        String result = instance.inverserChaine(input);
//        assertEquals(expResult, result);    
//    }
    
    @Test
    public void testInverseChaineFail(){
        String result = instance.inverserChaine("kayak");
        assertEquals("kayak", result);
    }
    
    
}

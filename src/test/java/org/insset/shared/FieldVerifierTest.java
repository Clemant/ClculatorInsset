package org.insset.shared;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FieldVerifierTest {
    
    
    private FieldVerifier field;
    private final static String chaine =" ";
    
    public FieldVerifierTest() {}
    
    @Before
    public void setUp() {
    
        field = new FieldVerifier();
    }
    
    @After
    public void tearDown() {}
    
    
    @Test
    public void isValidNameTest(){
        boolean status = field.isValidName("Phrase");
        assertTrue("The test passed:return true",status);
        assertTrue("",field.isValidName(" Phrase"));
    }
 
    @Test
    public void isValidNameFailTest(){
        boolean status = field.isValidName(null);
        assertFalse("The test passed:return false",status);
        status = field.isValidName("");
        assertFalse("The test passed:return false",status);
        status = field.isValidName(chaine);
        assertFalse("The test passed:return false",status);
        
    }
    
    @Test
    public void isValidDecimalTest(){
        boolean status = field.isValidDecimal(13);
        assertTrue("The test passed:return false",status);
    }
    
    @Test
    public void isValidDecimalFailTest(){
        boolean status = field.isValidDecimal(0);
        assertFalse("The test passed:return false",status);
        assertFalse("",field.isValidDecimal(null));
        assertFalse("",field.isValidDecimal(-12));
        assertFalse("",field.isValidDecimal(3000));
    } 
    
    @Test
    public void isValidRomanTest(){
        boolean status = field.isValidRoman("0");
        assertTrue("The test passed:return false",status);
    }
     
    @Test
    public void isValidRomanFailureTest(){
        boolean status = field.isValidRoman(null);
        assertFalse("The test passed:return false",status);
        status = field.isValidRoman(chaine);
        assertFalse("The test passed:return "+status,status);
    }
    
    @Test
    public void isValidDateTest(){
        assertTrue("",field.isValidDate("XX"));
    }
    
    @Test
    public void isValidDateFailTest(){
        assertFalse("",field.isValidDate(null));
        assertFalse("",field.isValidDate(chaine));
        assertFalse("",field.isValidDate(""));
    }
}
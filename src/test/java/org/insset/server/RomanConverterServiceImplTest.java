package org.insset.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RomanConverterServiceImplTest {
    
    public RomanConverterServiceImplTest() {}
    
    private static RomanConverterServiceImpl romanConvertServiceImpl;
    
    @Before
    public void setUp() {
         romanConvertServiceImpl = new RomanConverterServiceImpl();
    }
    
    @After
    public void tearDown() { }

    @Test
    public void testConvertDateYears() {}

    @Test
    public void testConvertRomanToArabe() {}

    @Test
    public void testConvertArabeToRoman() {
        String resultat = romanConvertServiceImpl.convertArabeToRomans(12);
        assertEquals(resultat, "XII");       
    }
    
}

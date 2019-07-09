/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leo
 */
public class TransacaoIT {
    
    public TransacaoIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of formatToInsert method, of class Transacao.
     */
    @Test
    public void testFormatToInsert() {
        System.out.println("formatToInsert");
        String beginningSeparator = "(\"";
        String midSeparator = "\", \"";
        String endingSeparator = "\")";
        Transacao instance = new Transacao();
        String expResult = beginningSeparator + "0" + midSeparator + 
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + 
                midSeparator + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                midSeparator + "" + endingSeparator;
        String result = instance.formatToInsert();
        assertEquals(expResult, result);
    }
    
}

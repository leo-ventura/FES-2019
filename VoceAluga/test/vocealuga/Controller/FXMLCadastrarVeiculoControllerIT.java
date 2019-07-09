/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga.Controller;

import java.net.URL;
import java.util.ResourceBundle;
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
public class FXMLCadastrarVeiculoControllerIT {
    
    public FXMLCadastrarVeiculoControllerIT() {
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
     * Test of initialize method, of class FXMLCadastrarVeiculoController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        FXMLCadastrarVeiculoController instance = new FXMLCadastrarVeiculoController();
        instance.initialize(url, rb);
    }

    /**
     * Test of validateCPF method, of class FXMLCadastrarVeiculoController.
     */
    @Test
    public void testValidateCPF() {
        System.out.println("validateCPF");
        String CPF = "";
        boolean expResult = false;
        boolean result = FXMLCadastrarVeiculoController.validateCPF(CPF);
        assertEquals(expResult, result);
    }
    
}

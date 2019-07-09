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
public class FXMLCadastrarClienteControllerIT {
    
    public FXMLCadastrarClienteControllerIT() {
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
     * Test of cadastraCliente method, of class FXMLCadastrarClienteController.
     */
    @Test
    public void testCadastraCliente() {
        System.out.println("cadastraCliente");
        String name = "";
        String address = "";
        String creditCard = "";
        String date = "";
        String cpf = "";
        String cnh = "";
        int specialNeeds = 0;
        FXMLCadastrarClienteController instance = new FXMLCadastrarClienteController();
        boolean expResult = false;
        boolean result = instance.cadastraCliente(name, address, creditCard, date, cpf, cnh, specialNeeds);
        assertEquals(expResult, result);
    }

    /**
     * Test of initialize method, of class FXMLCadastrarClienteController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        FXMLCadastrarClienteController instance = new FXMLCadastrarClienteController();
        instance.initialize(url, rb);
    }

    /**
     * Test of validateCC method, of class FXMLCadastrarClienteController.
     */
    @Test
    public void testValidateCC() {
        System.out.println("validateCC");
        String cc = "";
        FXMLCadastrarClienteController instance = new FXMLCadastrarClienteController();
        boolean expResult = false;
        boolean result = instance.validateCC(cc);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateCPF method, of class FXMLCadastrarClienteController.
     */
    @Test
    public void testValidateCPF() {
        System.out.println("validateCPF");
        String CPF = "";
        boolean expResult = false;
        boolean result = FXMLCadastrarClienteController.validateCPF(CPF);
        assertEquals(expResult, result);
    }
    
}

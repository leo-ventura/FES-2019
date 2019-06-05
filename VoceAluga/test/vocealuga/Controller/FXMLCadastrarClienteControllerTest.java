/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Felipe
 */
public class FXMLCadastrarClienteControllerTest {
    
    public FXMLCadastrarClienteControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

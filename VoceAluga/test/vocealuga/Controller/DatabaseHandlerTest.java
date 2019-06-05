/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga.Controller;

import java.sql.ResultSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vocealuga.Model.Cliente;

/**
 *
 * @author Felipe
 */
public class DatabaseHandlerTest {
    
    public DatabaseHandlerTest() {
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
     * Test of query method, of class DatabaseHandler.
     */
    @Test
    public void testQuery() throws Exception {
        System.out.println("query");
        String query = "";
        DatabaseHandler instance = new DatabaseHandler();
        ResultSet expResult = null;
        ResultSet result = instance.query(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fetchClienteInfo method, of class DatabaseHandler.
     */
    @Test
    public void testFetchClienteInfo() throws Exception {
        System.out.println("fetchClienteInfo");
        Cliente cliente = null;
        DatabaseHandler instance = new DatabaseHandler();
        ResultSet expResult = null;
        ResultSet result = instance.fetchClienteInfo(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCPF method, of class DatabaseHandler.
     */
    @Test
    public void testCheckCPF() throws Exception {
        System.out.println("checkCPF");
        String cpf = "";
        DatabaseHandler instance = new DatabaseHandler();
        ResultSet expResult = null;
        ResultSet result = instance.checkCPF(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCliente method, of class DatabaseHandler.
     */
    @Test
    public void testRemoveCliente() throws Exception {
        System.out.println("removeCliente");
        String cpf = "";
        DatabaseHandler instance = new DatabaseHandler();
        boolean expResult = false;
        boolean result = instance.removeCliente(cpf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertIntoClienteTable method, of class DatabaseHandler.
     */
    @Test
    public void testInsertIntoClienteTable() throws Exception {
        System.out.println("insertIntoClienteTable");
        String values = "";
        DatabaseHandler instance = new DatabaseHandler();
        int expResult = 0;
        int result = instance.insertIntoClienteTable(values);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertIntoVeiculoTable method, of class DatabaseHandler.
     */
    @Test
    public void testInsertIntoVeiculoTable() throws Exception {
        System.out.println("insertIntoVeiculoTable");
        String values = "";
        DatabaseHandler instance = new DatabaseHandler();
        int expResult = 0;
        int result = instance.insertIntoVeiculoTable(values);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class DatabaseHandler.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        DatabaseHandler instance = new DatabaseHandler();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

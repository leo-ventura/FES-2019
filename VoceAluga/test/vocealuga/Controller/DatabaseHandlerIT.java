/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga.Controller;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vocealuga.Model.Cliente;
import vocealuga.Model.Veiculo;

/**
 *
 * @author leo
 */
public class DatabaseHandlerIT {
    
    public DatabaseHandlerIT() {
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
    }

    /**
     * Test of insertIntoClienteTable method, of class DatabaseHandler.
     */
    @Test
    public void testInsertIntoClienteTable() throws Exception {
        System.out.println("insertIntoClienteTable");
        String values = "";
        DatabaseHandler instance = new DatabaseHandler();
        int expResult = -1;
        int result = instance.insertIntoClienteTable(values);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertIntoVeiculoTable method, of class DatabaseHandler.
     */
    @Test
    public void testInsertIntoVeiculoTable() throws Exception {
        System.out.println("insertIntoVeiculoTable");
        String values = "";
        DatabaseHandler instance = new DatabaseHandler();
        int expResult = -1;
        int result = instance.insertIntoVeiculoTable(values);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertIntoHistoricoTable method, of class DatabaseHandler.
     */
    @Test
    public void testInsertIntoHistoricoTable() throws Exception {
        System.out.println("insertIntoHistoricoTable");
        String values = "";
        DatabaseHandler instance = new DatabaseHandler();
        int expResult = -1;
        int result = instance.insertIntoHistoricoTable(values);
        assertEquals(expResult, result);
    }

    /**
     * Test of getVeiculos method, of class DatabaseHandler.
     */
    @Test
    public void testGetVeiculos() throws Exception {
        System.out.println("getVeiculos");
        DatabaseHandler instance = new DatabaseHandler();
        String expResult = "[Marca: Tesla. Modelo: Model X. Grupo: sp. Placa: "+
                "P4D4R14., Marca: Honda. Modelo: Civic. Grupo: a. Placa: " +
                "LEO3264., Marca: Toyota. Modelo: Etios. Grupo: b. Placa: " +
                "COL1020., Marca: Chevrolet. Modelo: Corsa. Grupo: c. Placa: " +
                "KGB1954., Marca: Fiat. Modelo: Uno. Grupo: d. Placa: " +
                "USA1929., Marca: Chevrolet. Modelo: Ipanema. Grupo: d. Placa: " +
                "BRA2314., Marca: Tesla. Modelo: Model X. Grupo: SP. Placa: ZIM8R40.]";
        ArrayList<Veiculo> result = instance.getVeiculos();
        assertEquals(expResult, result.toString());
    }

    /**
     * Test of isFreeAtRange method, of class DatabaseHandler.
     */
    @Test
    public void testIsFreeAtRange() throws Exception {
        System.out.println("isFreeAtRange");
        int cardId = 0;
        LocalDate inicio = null;
        LocalDate fim = null;
        DatabaseHandler instance = new DatabaseHandler();
        boolean expResult = false;
        boolean result = instance.isFreeAtRange(cardId, inicio, fim);
        assertEquals(expResult, result);
    }

    /**
     * Test of close method, of class DatabaseHandler.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        DatabaseHandler instance = new DatabaseHandler();
        instance.close();
    }
    
}

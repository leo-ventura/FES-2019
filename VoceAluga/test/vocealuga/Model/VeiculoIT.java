/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga.Model;

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
public class VeiculoIT {
    
    public VeiculoIT() {
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
     * Test of getPlaca method, of class Veiculo.
     */
    @Test
    public void testGetPlaca() {
        System.out.println("getPlaca");
        Veiculo instance = new Veiculo();
        String expResult = "";
        String result = instance.getPlaca();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMarca method, of class Veiculo.
     */
    @Test
    public void testGetMarca() {
        System.out.println("getMarca");
        Veiculo instance = new Veiculo();
        String expResult = "";
        String result = instance.getMarca();
        assertEquals(expResult, result);
    }

    /**
     * Test of getModelo method, of class Veiculo.
     */
    @Test
    public void testGetModelo() {
        System.out.println("getModelo");
        Veiculo instance = new Veiculo();
        String expResult = "";
        String result = instance.getModelo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGrupo method, of class Veiculo.
     */
    @Test
    public void testGetGrupo() {
        System.out.println("getGrupo");
        Veiculo instance = new Veiculo();
        String expResult = "";
        String result = instance.getGrupo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Veiculo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Veiculo instance = new Veiculo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Veiculo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Veiculo instance = new Veiculo();
        String expResult = "Marca: . Modelo: . Grupo: . Placa: .";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of formatToInsert method, of class Veiculo.
     */
    @Test
    public void testFormatToInsert() {
        System.out.println("formatToInsert");
        String beginningSeparator = "(\"";
        String midSeparator = "\", \"";
        String endingSeparator = "\")";
        Veiculo instance = new Veiculo();
        String expResult = beginningSeparator + "" + midSeparator + "" +
                midSeparator + "" + midSeparator + "" + endingSeparator;
        String result = instance.formatToInsert();
        assertEquals(expResult, result);
    }
    
}

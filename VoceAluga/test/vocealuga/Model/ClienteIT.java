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
public class ClienteIT {
    
    public ClienteIT() {
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
     * Test of setNome method, of class Cliente.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Cliente instance = new Cliente();
        instance.setNome(nome);
    }

    /**
     * Test of setEndereco method, of class Cliente.
     */
    @Test
    public void testSetEndereco() {
        System.out.println("setEndereco");
        String endereco = "";
        Cliente instance = new Cliente();
        instance.setEndereco(endereco);
    }

    /**
     * Test of setCC method, of class Cliente.
     */
    @Test
    public void testSetCC() {
        System.out.println("setCC");
        String cc = "";
        Cliente instance = new Cliente();
        instance.setCC(cc);
    }

    /**
     * Test of setData method, of class Cliente.
     */
    @Test
    public void testSetData_LocalDate() {
        System.out.println("setData");
        LocalDate data = null;
        Cliente instance = new Cliente();
        instance.setData(data);
    }

    /**
     * Test of setData method, of class Cliente.
     */
    @Test
    public void testSetData_String() {
        System.out.println("setData");
        String data = "";
        Cliente instance = new Cliente();
        instance.setData(data);
    }

    /**
     * Test of setCPF method, of class Cliente.
     */
    @Test
    public void testSetCPF() {
        System.out.println("setCPF");
        String cpf = "";
        Cliente instance = new Cliente();
        instance.setCPF(cpf);
    }

    /**
     * Test of setCNH method, of class Cliente.
     */
    @Test
    public void testSetCNH() {
        System.out.println("setCNH");
        String cnh = "";
        Cliente instance = new Cliente();
        instance.setCNH(cnh);
    }

    /**
     * Test of setNecessidadesEspeciais method, of class Cliente.
     */
    @Test
    public void testSetNecessidadesEspeciais() {
        System.out.println("setNecessidadesEspeciais");
        int sp = 0;
        Cliente instance = new Cliente();
        instance.setNecessidadesEspeciais(sp);
    }

    /**
     * Test of setDataDeCadastro method, of class Cliente.
     */
    @Test
    public void testSetDataDeCadastro_LocalDate() {
        System.out.println("setDataDeCadastro");
        LocalDate data = null;
        Cliente instance = new Cliente();
        instance.setDataDeCadastro(data);
    }

    /**
     * Test of setDataDeCadastro method, of class Cliente.
     */
    @Test
    public void testSetDataDeCadastro_String() {
        System.out.println("setDataDeCadastro");
        String data = "";
        Cliente instance = new Cliente();
        instance.setDataDeCadastro(data);
    }

    /**
     * Test of getNome method, of class Cliente.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndereco method, of class Cliente.
     */
    @Test
    public void testGetEndereco() {
        System.out.println("getEndereco");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getEndereco();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCC method, of class Cliente.
     */
    @Test
    public void testGetCC() {
        System.out.println("getCC");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getCC();
        assertEquals(expResult, result);
    }

    /**
     * Test of getData method, of class Cliente.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Cliente instance = new Cliente();
        String expResult = LocalDate.MIN.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String result = instance.getData();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCPF method, of class Cliente.
     */
    @Test
    public void testGetCPF() {
        System.out.println("getCPF");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getCPF();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCNH method, of class Cliente.
     */
    @Test
    public void testGetCNH() {
        System.out.println("getCNH");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getCNH();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNecessidadesEspeciais method, of class Cliente.
     */
    @Test
    public void testGetNecessidadesEspeciais() {
        System.out.println("getNecessidadesEspeciais");
        Cliente instance = new Cliente();
        int expResult = 0;
        int result = instance.getNecessidadesEspeciais();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDatadeCadastro method, of class Cliente.
     */
    @Test
    public void testGetDatadeCadastro() {
        System.out.println("getDatadeCadastro");
        Cliente instance = new Cliente();
        String expResult = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String result = instance.getDatadeCadastro();
        assertEquals(expResult, result);
    }

    /**
     * Test of formatToInsert method, of class Cliente.
     */
    @Test
    public void testFormatToInsert() {
        System.out.println("formatToInsert");
        String beginningSeparator = "(\"";
        String midSeparator = "\", \"";
        String endingSeparator = "\")";
        Cliente instance = new Cliente();
        String expResult = beginningSeparator + "" + midSeparator + "" + midSeparator + "" +
                midSeparator + "" + LocalDate.MIN.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                midSeparator + "" + midSeparator + "" + midSeparator +
                "0" + midSeparator + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + 
                midSeparator + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                endingSeparator;
        String result = instance.formatToInsert();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Cliente.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}

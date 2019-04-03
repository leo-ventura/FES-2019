/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga;

// importing sql lib
import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.naming.NamingException;


/**
 *
 * @author matheus
 * @author leo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    // Cliente variables being passed via FXML
    @FXML
    private TextField TFNome;
    @FXML
    private TextField TFEndereco;
    @FXML
    private TextField TFCC;
    @FXML
    private TextField TFData;
    @FXML
    private TextField TFCPF;
    @FXML
    private TextField TFCNH;
    @FXML
    private CheckBox CBSpecialNeeds;
    
    @FXML
    private void handleCadastrar(ActionEvent event) throws ClassNotFoundException, SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        
        Cliente cliente = new Cliente(TFNome.getText(), TFEndereco.getText(),
                TFCC.getText(), TFData.getText(), TFCPF.getText(), TFCNH.getText(),
                (CBSpecialNeeds.isSelected() ? 1 : 0)
        );
    
        System.out.println("TFNome.getText(): " + TFNome.getText());
//        cliente.setNome(TFNome.getText());
        
        System.out.println("TFEndereco.getText(): " + TFEndereco.getText());
//        cliente.setEndereco(TFEndereco.getText());
        
        System.out.println("TFCC.getText(): " + TFCC.getText());
//        cliente.setCC(TFCC.getText());
        
        System.out.println("TFData.getText(): " + TFData.getText());
//        cliente.setData(TFData.getText());
        
        System.out.println("TFCPF.getText(): " + TFCPF.getText());
//        cliente.setCPF(TFCPF.getText());
        
        System.out.println("TFCNH.getText(): " + TFCNH.getText());
//        cliente.setCNH(TFCNH.getText());
        
        System.out.println("CBSpecialNeeds.getText(): " + CBSpecialNeeds.isSelected());
//        int specialNeedsStatus = 0;
//        if(CBSpecialNeeds.isSelected())
//            specialNeedsStatus = 1; // true
//        cliente.setNecessidadesEspeciais(specialNeedsStatus);
        
        // checking if cpf is already being used
        System.out.println("Cliente.getCPF(): " + cliente.getCPF());
        ResultSet rs = dbHandler.query("select CPF from VoceAluga.Cliente where CPF = \""+
                cliente.getCPF() + "\";");
        
        System.out.println("rs.first(): " + rs.first());
        if(rs.first()) {
            System.out.println("The provided CPF is already in use!");
            // TODO: Add an alert telling that to the user
        } else {
            
            String clienteValues = cliente.formatToInsert();
            System.out.println(clienteValues);

            int r = dbHandler.insertIntoClienteTable(clienteValues);
            System.out.println("Values have been inserted!\n" + r);
        }
        
        // closing connection
        dbHandler.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

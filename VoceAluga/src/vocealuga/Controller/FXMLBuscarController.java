package vocealuga.Controller;

// importing sql lib
import java.sql.*;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import vocealuga.Model.Cliente;

/**
 *
 * @author leo
 */

public class FXMLBuscarController implements Initializable {

    // Cliente variables being passed via FXML
    @FXML
    private TextField TFBuscarNome;
    @FXML
    private TextField TFBuscarEndereco;
    @FXML
    private TextField TFBuscarCC;
    @FXML
    private TextField TFBuscarDataNascimento;
    @FXML
    private TextField TFBuscarCPF;
    @FXML
    private TextField TFBuscarCNH;
    
    @FXML
    private void handleBuscar(ActionEvent event) throws SQLException, ClassNotFoundException {
        String name = TFBuscarNome.getText();
        String address = TFBuscarEndereco.getText();
        String creditCard = TFBuscarCC.getText();
        String date = TFBuscarDataNascimento.getText();
        String cpf = TFBuscarCPF.getText();
        String cnh = TFBuscarCNH.getText();
        
        // database handler
        DatabaseHandler dbHandler = new DatabaseHandler();
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

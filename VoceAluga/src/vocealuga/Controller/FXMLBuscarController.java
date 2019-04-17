package vocealuga.Controller;

// importing sql lib
import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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
        
        ResultSet rs = dbHandler.fetchClienteInfo(
                new Cliente(name, address, creditCard, date, cpf, cnh, 0)
        );
        
        while(rs.next()) {
            name = rs.getString("nome");
            address = rs.getString("endereco");
            date = rs.getString("data");
            cpf = rs.getString("cpf");
            cnh = rs.getString("cnh");
            creditCard = rs.getString("cc");
            String specialNeeds = rs.getInt("necessidadesEspeciais") == 1 ? "Sim" : "Nao";
            
            System.out.println("Nome:" + name);
            System.out.println("Endereco:" + address);
            System.out.println("Data de Nascimento:" + date);
            System.out.println("CPF:" + cpf);
            System.out.println("CNH:" + cnh);
            System.out.println("CC:" + creditCard);
            System.out.println("Necessidades Especiais:" + specialNeeds);
        }
        
        dbHandler.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

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
import javafx.scene.control.Label;
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
    private Label LabelNome;
    @FXML
    private Label LabelCPF;
    @FXML
    private Label LabelCNH;
    @FXML
    private Label LabelEndereco;
    @FXML
    private Label LabelNascimento;
    @FXML
    private Label LabelCartao;
    @FXML
    private Label LabelNecessidadesEspeciais;
    @FXML
    private Label LabelDataDeCadastro;
    @FXML
    private Label LabelErro;

    
    
    @FXML
    private void handleBuscar(ActionEvent event) throws SQLException, ClassNotFoundException {
        String name = TFBuscarNome.getText();
        String address = TFBuscarEndereco.getText();
        String creditCard = TFBuscarCC.getText();
        String date = TFBuscarDataNascimento.getText();
        String cpf = TFBuscarCPF.getText();
        String cnh = TFBuscarCNH.getText();
        
        
       
        
        // database handler
        //DatabaseHandler dbHandler = new DatabaseHandler();
        
        //se o cliente existir
        if (name.equalsIgnoreCase("Breno")){
            Cliente cliente = new Cliente("Breno", "Rua do Breno", "Cartão do Breno", "30/03/1999", "CPF do Breno", "CNH do Breno", 0, "10/04/2019");
            LabelErro.setVisible(false);
            LabelNome.setVisible(true);
            LabelNome.setText("Nome: " + cliente.getNome());
            LabelCPF.setVisible(true);
            LabelCPF.setText("CPF: " + cliente.getCPF());
            LabelCNH.setVisible(true);
            LabelCNH.setText("CNH: " + cliente.getCNH());
            LabelEndereco.setVisible(true);
            LabelEndereco.setText("Endereço: " + cliente.getEndereco());
            LabelNascimento.setVisible(true);
            LabelNascimento.setText("Data de Nascimento: " + cliente.getData());
            LabelCartao.setVisible(true);
            LabelCartao.setText("Cartão: " + cliente.getCC());
            LabelNecessidadesEspeciais.setVisible(true);
            LabelNecessidadesEspeciais.setText("Necessidades especiais: " + (cliente.getNecessidadesEspeciais()==1? "Sim" : "Não"));
            LabelDataDeCadastro.setVisible(true);
            LabelDataDeCadastro.setText("Data de Cadastro: " + cliente.getDatadeCadastro()); 
        }
        //se o cliente nao existir
        else {
            LabelNome.setVisible(false);
            LabelCPF.setVisible(false);
            LabelCNH.setVisible(false);
            LabelEndereco.setVisible(false);
            LabelNascimento.setVisible(false);
            LabelCartao.setVisible(false);
            LabelNecessidadesEspeciais.setVisible(false);
            LabelDataDeCadastro.setVisible(false);
            LabelErro.setVisible(true);

        }
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

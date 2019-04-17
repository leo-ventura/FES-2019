package vocealuga.Controller;

// importing sql lib
import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
//    @FXML
//    private TextField TFBuscarEndereco;
//    @FXML
//    private TextField TFBuscarCC;
//    @FXML
//    private TextField TFBuscarDataNascimento;
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
//        String address = TFBuscarEndereco.getText();
//        String creditCard = TFBuscarCC.getText();
//        String date = TFBuscarDataNascimento.getText();
        String cpf = TFBuscarCPF.getText();
        String cnh = TFBuscarCNH.getText();
        
        // database handler
        DatabaseHandler dbHandler = new DatabaseHandler();
        
        ResultSet rs = dbHandler.fetchClienteInfo(
                new Cliente(name,/* address, creditCard, date,*/ cpf, cnh)
        );
        
        System.out.println("rs.first(): " + rs.first());
        
        
        if(rs.first()) {
            // pelo menos um cliente existe
            while(rs.next()) {
                name = rs.getString("nome");
                String address = rs.getString("endereco");
                String date = rs.getString("data");
                cpf = rs.getString("cpf");
                cnh = rs.getString("cnh");
                String creditCard = rs.getString("cc");
                String specialNeeds = rs.getInt("necessidadesEspeciais") == 1 ? "Sim" : "Nao";
                String dataDeCadastro = rs.getString("dataDeCadastro");

                LabelErro.setVisible(false);
                LabelNome.setVisible(true);
                LabelNome.setText("Nome: " + name);
                LabelCPF.setVisible(true);
                LabelCPF.setText("CPF: " + cpf);
                LabelCNH.setVisible(true);
                LabelCNH.setText("CNH: " + cnh);
                LabelEndereco.setVisible(true);
                LabelEndereco.setText("Endereço: " + address);
                LabelNascimento.setVisible(true);
                LabelNascimento.setText("Data de Nascimento: " + date);
                LabelCartao.setVisible(true);
                LabelCartao.setText("Cartão: " + creditCard);
                LabelNecessidadesEspeciais.setVisible(true);
                LabelNecessidadesEspeciais.setText("Necessidades especiais: " + specialNeeds);
                LabelDataDeCadastro.setVisible(true);
                LabelDataDeCadastro.setText("Data de Cadastro: " + dataDeCadastro);
                
                // System.out.println("Nome:" + name);
                // System.out.println("Endereco:" + address);
                // System.out.println("Data de Nascimento:" + date);
                // System.out.println("CPF:" + cpf);
                // System.out.println("CNH:" + cnh);
                // System.out.println("CC:" + creditCard);
                // System.out.println("Necessidades Especiais:" + specialNeeds);
            }
        } else {
            // cliente nao existe
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

        dbHandler.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

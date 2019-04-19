package vocealuga.Controller;

// importing sql lib
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import vocealuga.Model.Cliente;

/**
 *
 * @author leo
 * @author avellar
 */

public class FXMLBuscarController implements Initializable {

    // Cliente variables being passed via FXML
    @FXML
    private TextField TFBuscarNome;
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
    private Button ButtonBuscar;
    
    @FXML
    private void handleBuscar(ActionEvent event) throws SQLException, ClassNotFoundException {
        // Desativa o botão para evitar buscas concorrentes
        ButtonBuscar.setDisable(true);

        // Pega informaçãoes providas pelo usuário
        String name = TFBuscarNome.getText();
        String cpf = TFBuscarCPF.getText();
        String cnh = TFBuscarCNH.getText();

        DatabaseHandler dbHandler;
        ResultSet rs;
        try {
            // Busca pelas informações no banco de dados
            dbHandler = new DatabaseHandler();
            rs = dbHandler.fetchClienteInfo(
                new Cliente(name, cpf, cnh)
            );
        } catch(ClassNotFoundException
                | CommunicationsException
                | NullPointerException e) {
            // Algo deu errado!
            System.out.println("Oh no: " + e);

            // Mostra o texto de erro
            LabelErro.setVisible(true);
            LabelErro.setText("Erro na conexão com o BD");

            // Reativa o botão
            ButtonBuscar.setDisable(false);
            return;
        }
        

        // jeito mais facil de lidar com usuarios que nao existem
        // eh utilizar uma variavel booleana
        // apesar de ser ma pratica, funciona
        /* TODO: refatorar futuramente */
        // APARENTEMENTE, rs.first() faz o iterador andar pra frente quando nao queremos
        boolean clienteExists = false;

        /* FIXME: while() faz ele pegar todos os clientes... Supondo CPF único,
         * não poderíamos simplemente usar um if()?
         */
        while(rs.next()) {
            // Existe pelo menos um cliente com os valores dados
            clienteExists = true;

            // Substitui as informações dadas pelo usuário pelas informações do
            // banco de dados, e pega o resto das informações
            name = rs.getString("nome");
            String address = rs.getString("endereco");
            String date = rs.getString("data");
            cpf = rs.getString("cpf");
            cnh = rs.getString("cnh");
            String creditCard = rs.getString("cc");
            String specialNeeds = (rs.getInt("necessidadesEspeciais") == 1)
                    ? "Sim"
                    : "Não";
            String dataDeCadastro = rs.getString("dataDeCriacao");

            // Retira possíveis erros recebidos em buscas anteriores
            LabelErro.setVisible(false);
            
            // Reativa os textos da interface
            LabelNome.setDisable(false);
            LabelCPF.setDisable(false);
            LabelCNH.setDisable(false);
            LabelEndereco.setDisable(false);
            LabelNascimento.setDisable(false);
            LabelCartao.setDisable(false);
            LabelNecessidadesEspeciais.setDisable(false);
            LabelDataDeCadastro.setDisable(false);

            // Atualiza os textos com as informações encontradas
            LabelNome.setText("Nome: " + name);
            LabelCPF.setText("CPF: " + cpf);
            LabelCNH.setText("CNH: " + cnh);
            LabelEndereco.setText("Endereço: " + address);
            LabelNascimento.setText("Data de Nascimento: " + date);
            LabelCartao.setText("Cartão: " + creditCard);
            LabelNecessidadesEspeciais.setText("Possui ecessidades especiais: "
                                                + specialNeeds);
            LabelDataDeCadastro.setText("Data de Cadastro: " + dataDeCadastro);

            // Imprime (para debug) as informações encontradas
            System.out.println("Nome: " + name);
            System.out.println("Endereco: " + address);
            System.out.println("Data de Nascimento: " + date);
            System.out.println("CPF: " + cpf);
            System.out.println("CNH: " + cnh);
            System.out.println("CC: " + creditCard);
            System.out.println("Necessidades Especiais: " + specialNeeds);
        }
        
        // Se não existe cliente com os dados recebidos...
        if(!clienteExists) {
            // ...desativa novamente o texto...
            LabelNome.setDisable(true);
            LabelCPF.setDisable(true);
            LabelCNH.setDisable(true);
            LabelEndereco.setDisable(true);
            LabelNascimento.setDisable(true);
            LabelCartao.setDisable(true);
            LabelNecessidadesEspeciais.setDisable(true);
            LabelDataDeCadastro.setDisable(true);
            
            // ...e mostra o texto de erro
            LabelErro.setVisible(true);
            LabelErro.setText("Cliente não encontrado");
        }

        // Encerra a conexão com o banco de dados
        dbHandler.close();

        // Reativa o botão para próximas buscas
        ButtonBuscar.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

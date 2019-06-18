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

import vocealuga.Model.Veiculo;

/**
 *
 * @author leo
 * @author avellar
 */

public class FXMLBuscarVeiculoController implements Initializable {    
    
    // Cliente variables being passed via FXML
    @FXML
    private TextField TFBuscarPlaca;
    @FXML
    private TextField TFBuscarCPF;
    @FXML
    private TextField TFBuscarCNH;
    @FXML
    private Label LabelErro;
    @FXML
    private Label LabelMarca;
    @FXML
    private Label LabelModelo;
    @FXML
    private Label LabelGrupo;
    @FXML
    private Label LabelPlaca;
    @FXML
    private Label LabelAlugado;
    @FXML
    private Label LabelDataInicio;
    @FXML
    private Label LabelDataTermino;
    @FXML
    private Label LabelCPF;
    @FXML
    private Button ButtonBuscar;
    
    @FXML
    private void handleBuscar(ActionEvent event) throws SQLException, ClassNotFoundException {
//        // Desativa o botão para evitar buscas concorrentes
//        ButtonBuscar.setDisable(true);
//
//        // Pega informaçãoes providas pelo usuário
//        String placa = TFBuscarPlaca.getText();
//        String cpf = TFBuscarCPF.getText();
//        String cnh = TFBuscarCNH.getText();
//
//        DatabaseHandler dbHandler;
//        ResultSet rs;
//        try {
//            // Busca pelas informações no banco de dados
//            dbHandler = new DatabaseHandler();;;;;;
//
//            rs = dbHandler.fetchClienteInfo(
//                new Cliente(name, cpf, cnh)
//            );
//        } catch(ClassNotFoundException
//                | CommunicationsException
//                | NullPointerException e) {
//            // Algo deu errado!
//            System.out.println("Oh no: " + e);
//
//            // Mostra o texto de erro
//            LabelErro.setVisible(true);
//            LabelErro.setText("Erro na conexão com o BD");
//
//            // Reativa o botão
//            ButtonBuscar.setDisable(false);
//            return;
//        }
//
//        /* FIXME: while() faz ele pegar todos os clientes... Supondo CPF único,
//         * não poderíamos simplemente usar um if()?
//         * Decisao: usaremos um if, pegando apenas o primeiro resultado,
//         * independente da quantidade de matches.
//         */
//
//        if(rs.first()) {
//            // Existe pelo menos um cliente com os valores dados
//
//            System.out.println("Veículo encontrado!");
//            // Substitui as informações dadas pelo usuário pelas informações do
//            // banco de dados, e pega o resto das informações
//            placa = rs.getString("Nome");
//            String address = rs.getString("Endereco");
//            String date = rs.getString("DataDeNascimento");
//            cpf = rs.getString("CPF");
//            cnh = rs.getString("CNH");
//            String creditCard = rs.getString("CreditCard");
//            String specialNeeds = (rs.getInt("NecessidadesEspeciais") == 1)
//                    ? "Sim"
//                    : "Não";
//            String dataDeCadastro = rs.getString("DataDeCadastro");
//            String dataDeAlteracao = rs.getString("DataDeAlteracao");
//
//            // Retira possíveis erros recebidos em buscas anteriores
//            LabelErro.setVisible(false);
//            
//            // Reativa os textos da interface
//            LabelMarca.setDisable(false);
//            LabelModelo.setDisable(false);
//            LabelGrupo.setDisable(false);
//            LabelPlaca.setDisable(false);
//            LabelAlugado.setDisable(false);
//            LabelDataInicio.setDisable(false);
//            LabelDataTermino.setDisable(false);
//            LabelCPF.setDisable(false);
//
//            // Atualiza os textos com as informações encontradas
//            LabelMarca.setText("Nome: " + placa);
//            LabelModelo.setText("CPF: " + cpf);
//            LabelGrupo.setText("CNH: " + cnh);
//            LabelPlaca.setText("Endereço: " + address);
//            LabelAlugado.setText("Data de Nascimento: " + date);
//            LabelDataInicio.setText("Cartão: " + creditCard);
//            LabelDataTermino.setText("Possui n " + specialNeeds);
//            LabelCPF.setText("Data de Cadastro: " + dataDeCadastro);
//
//            // Imprime (para debug) as informações encontradas
//            System.out.println("Nome: " + name);
//            System.out.println("Endereco: " + address);
//            System.out.println("Data de Nascimento: " + date);
//            System.out.println("CPF: " + cpf);
//            System.out.println("CNH: " + cnh);
//            System.out.println("CC: " + creditCard);
//            System.out.println("Necessidades Especiais: " + specialNeeds);
//        } else {
//            // Se não existe cliente com os dados recebidos...
//            // ...desativa novamente o texto e remove o cliente anterior
//            LabelMarca.setDisable(true);
//            LabelModelo.setDisable(true);
//            LabelGrupo.setDisable(true);
//            LabelPlaca.setDisable(true);
//            LabelAlugado.setDisable(true);
//            LabelDataInicio.setDisable(true);
//            LabelDataTermino.setDisable(true);
//            LabelCPF.setDisable(true);
//
//            LabelMarca.setText("Nome: ");
//            LabelModelo.setText("CPF: ");
//            LabelGrupo.setText("CNH: ");
//            LabelPlaca.setText("Endereço: ");
//            LabelAlugado.setText("Data de Nascimento: ");
//            LabelDataInicio.setText("Cartão: ");
//            LabelDataTermino.setText("Possui necessidades especiais: ");
//            LabelCPF.setText("Data de Cadastro: ");
//            
//            // ...e mostra o texto de erro
//            LabelErro.setVisible(true);
//            LabelErro.setText("Veículo não encontrado");
//        }
//
//        // Encerra a conexão com o banco de dados
//        dbHandler.close();
//
//        // Reativa o botão para próximas buscas
//        ButtonBuscar.setDisable(false);
    }
    
    @FXML
    private void removeVeiculo(ActionEvent event) throws ClassNotFoundException, SQLException {
//        // inicializando outro handler para database;
//        // database pode ter mudado de estado desde a ultima interacao
//        // de cadastro ou remocao
//        // Pros: garante que sempre teremos um estado da database atualizado
//        // Contras: varias conexoes podem acabar sendo abertas, congestionando
//        // o banco de dados
//        DatabaseHandler dbHandler = new DatabaseHandler();
//        
//        // Pegando o CPF do Cliente a ser removido
//        // Como o CPF eh um dado unico, podemos remover usando apenas ele
//        // como parametro para a query
//        String cpf = TFBuscarCPF.getText();
//        
//        dbHandler.removeCliente(cpf);
//        
//        // Encerra a conexão com o banco de dados
//        dbHandler.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

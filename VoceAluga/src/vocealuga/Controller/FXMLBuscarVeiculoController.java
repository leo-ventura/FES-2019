package vocealuga.Controller;

// importing sql lib
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.geometry.Insets;
import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

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
    private ScrollPane SPVeiculos;
    @FXML
    private Label LabelErro;
    @FXML
    private Button ButtonBuscar;
    
    // Variável para conter o elemento (VBox) selecionado no momento
    private VBox selectedItem = null;
    
    // Retorna o elemento selecionado no momento
    private VBox getSelected() {
        return selectedItem;
    }
    
    // Executada ao clicar em um elemento, atualiza o elemento selecionado
    private void setSelected(VBox item) {
        // Des-seleciona todos os irmãos (para evitar múltiplos selecionados)
        VBox parent = (VBox)item.getParent();
        parent.getChildren().forEach((n) -> {
            n.setStyle("-fx-background-color:#fff;-fx-border-color:#fff");
        });
        // Atualiza o estilo do selecionado atualmente
        item.setStyle("-fx-background-color:#fefefe;-fx-border-color:#000");
        // Atualiza a variável que contem o elemento selecionado
        selectedItem = item;
    }

    // Retorna um novo item que pode ser adicionado no ScrollPane
    private VBox createListItem(String placa, String marca, String modelo) {
        // Cria e configura o estilo e evento do elemento
        VBox div = new VBox();
        div.setPadding(new Insets(10));
        div.setSpacing(5);
        div.setStyle("-fx-background-color:#fff;-fx-border-color:#fff");
        div.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent m) -> {
            m.consume();
            setSelected((VBox)m.getSource());
        });

        // Cria os textos de dentro do elemento
        // Nota: aqui podem entrar outros elementos além de Label's
        Label LabelPlaca = new Label("Placa: " + placa);
        Label LabelMarca = new Label("Marca: " + marca);
        Label LabelModelo = new Label("Modelo: " + modelo);

        // Adiciona todos textos dentro do elemento
        div.getChildren().addAll(
            LabelPlaca,
            LabelMarca,
            LabelModelo
        );
        return div;
    }
    
    @FXML
    private void handleBuscar(ActionEvent event) throws SQLException, ClassNotFoundException {
        // Se o usuário clicou "buscar", não há elemento selecionado no momento
        selectedItem = null;
        // Cria uma ordenação vertical para os veículos encontrados
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        // Define que o ScrollPane terá essa ordenação como conteúdo...
        SPVeiculos.setContent(root);
        // ...e possui scroll por click'n'drag
        SPVeiculos.setPannable(true);
 
    /* <DEMO> */
        // Em um while ou for dos resultados da busca:
        //   root.getChildren().add(createListItem( {dados do veículo } );
        // Exemplos:
        root.getChildren().add(createListItem("PAD4R14","Tesla","Model X"));
        root.getChildren().add(createListItem("ZIM8R40","Tesla","Model 3"));
        root.getChildren().add(createListItem("FES2019","Tesla","Model S"));
        root.getChildren().add(createListItem("JUM3N70","Tesla","Model X"));
        // ...
    /* </DEMO> */

        
        
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
//        // FIXME: Busca de veículo, não de cliente; alterar de acordo
//        try {
//            // Busca pelas informações no banco de dados
//            dbHandler = new DatabaseHandler();
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
//
//        while(rs.first()) {
//          // Organizar todos os veículos na lista
//        }
//
//        // Encerra a conexão com o banco de dados
//        dbHandler.close();
//
//        // Reativa o botão para próximas buscas
//        ButtonBuscar.setDisable(false);
    }
    
    // FIXME: Remoção de veículo, não de cliente
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

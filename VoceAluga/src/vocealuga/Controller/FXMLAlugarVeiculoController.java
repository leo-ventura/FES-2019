package vocealuga.Controller;

// importing sql lib
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import javafx.geometry.Insets;
import java.sql.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import vocealuga.Model.Transacao;

import vocealuga.Model.Veiculo;

/**
 *
 * @author leo
 * @author avellar
 */

public class FXMLAlugarVeiculoController implements Initializable {    
    
    // Cliente variables being passed via FXML
    @FXML
    private TextField TFDataInicio;
    @FXML
    private TextField TFCPFCliente;
    @FXML
    private TextField TFDataFim;
    @FXML
    private ScrollPane SPVeiculos;
    @FXML
    private Label LabelErro;
    @FXML
    private Button ButtonAlugar;
    
    // Variável para conter o elemento (VBox) selecionado no momento
    private int selectedItem = -1;
    
    
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
        //System.out.println(item.getAccessibleText());
        selectedItem = Integer.valueOf(item.getAccessibleText());
    }
    
   

    @FXML
    private void handleAlugar(ActionEvent event) throws SQLException, ClassNotFoundException{
        //System.out.println(selectedItem);
        String CPF = TFCPFCliente.getText().trim();
        LocalDate dataInicio = null;
        LocalDate dataFim = null;
        DateTimeFormatter formatter;
        try {
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
            dataInicio = LocalDate.parse(TFDataInicio.getText().trim(), formatter);
            dataFim = LocalDate.parse(TFDataFim.getText().trim(), formatter);
        } catch (Exception e){
            LabelErro.setVisible(true);
            LabelErro.setText("Data inválida");
        }
        if (CPF.isEmpty()){
            LabelErro.setVisible(true);
            LabelErro.setText("Insira o CPF do cliente");
        }
        else if (selectedItem == -1) {
            LabelErro.setVisible(true);
            LabelErro.setText("Selecione algum carro");
        }
        else if (dataInicio.isBefore(LocalDate.now())){
            LabelErro.setVisible(true);
            LabelErro.setText("A data desejada já passou!");
        }
        else if (dataInicio.isAfter(dataFim)){
            LabelErro.setVisible(true);
            LabelErro.setText("A data de início não pode ser maior");
        }
        else {
            LabelErro.setVisible(true);
            LabelErro.setText("Conectando ao banco de dados");
            
            DatabaseHandler db = new DatabaseHandler();
            if (db.isFreeAtRange(selectedItem, dataInicio, dataFim)){
                Transacao trans = new Transacao(CPF, dataInicio, dataFim, selectedItem);
                System.out.println(trans.formatToInsert());
                LabelErro.setVisible(false);
                try {
                    db.insertIntoHistoricoTable(trans.formatToInsert());
                    LabelErro.setVisible(true);
                    LabelErro.setText("Inserido com sucesso!");    
                } catch(Exception e){
                    LabelErro.setVisible(true);
                    LabelErro.setText(e.getMessage());
                }
            }
            else {
                LabelErro.setVisible(true);
                LabelErro.setText("Carro ocupado na data desejada!");
            }
            db.close();
            
            
        }
    }
    
    // Retorna um novo item que pode ser adicionado no ScrollPane
    private VBox createListItem(Veiculo veiculo) {
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
        Label LabelPlaca = new Label("Placa: " + veiculo.getPlaca());
        Label LabelMarca = new Label("Marca: " + veiculo.getMarca());
        Label LabelModelo = new Label("Modelo: " + veiculo.getModelo());
        Label LabelGrupo = new Label("Grupo: "+ veiculo.getGrupo());

        // Adiciona todos textos dentro do elemento
        div.getChildren().addAll(
            LabelPlaca,
            LabelMarca,
            LabelModelo,
            LabelGrupo
        );
        div.setAccessibleText(String.valueOf(veiculo.getId()));
        return div;
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                //selectedItem = null;
        // Cria uma ordenação vertical para os veículos encontrados
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        // Define que o ScrollPane terá essa ordenação como conteúdo...
        SPVeiculos.setContent(root);
        // ...e possui scroll por click'n'drag
        SPVeiculos.setPannable(true);
 
        System.out.println("Acessando banco de dados");
        try {
            DatabaseHandler db = new DatabaseHandler();
            ArrayList<Veiculo> veiculos = db.getVeiculos();
            System.out.println(veiculos.size() + " veículos encontrados");
            for (Veiculo veiculo: veiculos){
                root.getChildren().add(createListItem(veiculo));
            }
        db.close();

        } catch(Exception e){
            LabelErro.setVisible(true);
            LabelErro.setText("Erro ao acessar banco de dados");
        }


    }
    
}

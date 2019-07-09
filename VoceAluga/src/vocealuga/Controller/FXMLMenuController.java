package vocealuga.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author avellar
 */
public class FXMLMenuController implements Initializable {

    Stage secondaryWindow = new Stage();
    
    private void openSecondaryWindow(String file, String title) {
        try {
            // Pega o path do arquivo .fxml a ser usado
            URL url = new File("src/vocealuga/View/" + file + ".fxml").toURI().toURL();
            // Carrega o arquivo (usando seu path)
            Parent view_file = FXMLLoader.load(url);
            // Define o título da janela a ser aberta
            secondaryWindow.setTitle(title + " – Você-Aluga");
            // Cria uma "cena" para conter a janela
            Scene secondaryScene = new Scene(view_file);
            secondaryWindow.setScene(secondaryScene);
            // Desabilita o redimensionamento da janela
            secondaryWindow.setResizable(false);
            // Abre a janela para o usuário
            secondaryWindow.show();
        } catch(IOException e) {
//            e.printStackTrace();
        }
    }

    @FXML
    private void openCadastrarCliente(ActionEvent event) throws ClassNotFoundException, IOException {
        openSecondaryWindow("FXMLCadastrarCliente", "Cadastrar Cliente");
    }   

    @FXML
    private void openCadastrarVeiculo(ActionEvent event) {
        openSecondaryWindow("FXMLCadastrarVeiculo", "Cadastrar Veículo");
    }

    @FXML
    private void openBuscarCliente(ActionEvent event) throws ClassNotFoundException, IOException {
        openSecondaryWindow("FXMLBuscarCliente", "Buscar cliente");
    }

    @FXML
    private void openAlugarVeiculo(ActionEvent event) throws ClassNotFoundException, IOException {
        openSecondaryWindow("FXMLAlugarVeiculo", "Alugar veículo");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
    
}

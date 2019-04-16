/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    @FXML
    private void openCadastrar(ActionEvent event) throws ClassNotFoundException, IOException {
        try {
            URL url = new File("src/vocealuga/View/FXMLCadastrar.fxml").toURI().toURL();
            Parent vCadastrar = FXMLLoader.load(url);
            secondaryWindow.setTitle("Cadastrar Cliente – Você-Aluga");
            Scene sceneBuscar = new Scene(vCadastrar);
            secondaryWindow.setScene(sceneBuscar);
            secondaryWindow.setResizable(false);
            secondaryWindow.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void openBuscar(ActionEvent event) throws ClassNotFoundException, IOException {
        try {
            URL url = new File("src/vocealuga/View/FXMLBuscar.fxml").toURI().toURL();
            Parent vCadastrar = FXMLLoader.load(url);
            secondaryWindow.setTitle("Buscar – Você-Aluga");
            Scene sceneBuscar = new Scene(vCadastrar);
            secondaryWindow.setScene(sceneBuscar);
            secondaryWindow.setResizable(false);
            secondaryWindow.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

package vocealuga.Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import vocealuga.Model.Veiculo;


/**
 *
 * @author avellar
 */
public class FXMLCadastrarVeiculoController implements Initializable {

    @FXML
    private Button buttonCancel;
    
    @FXML
    private TextField TFMarca;
    @FXML
    private TextField TFModelo;
    @FXML
    private TextField TFGrupo;
    @FXML
    private TextField TFPlaca;
    @FXML
    private RadioButton buttonLivre;
    @FXML
    private RadioButton buttonAlugado;
    @FXML
    private RadioButton buttonReservado;
    @FXML
    private TextField TFCPF;
    @FXML
    private TextField TFDataInicio;
    @FXML
    private TextField TFDataTermino;
    

    @FXML
    private void handleClose(ActionEvent event) {
        // TODO: Adicionar um popup confirmando o cancelamento de cadastro
        // (para não perder possíveis informações inseridas)
        ((Stage) buttonCancel.getScene().getWindow()).close();
    }
    
    @FXML
    private void handleHabilitar(ActionEvent event){
        TFCPF.setDisable(false);
        TFDataInicio.setDisable(false);
        TFDataTermino.setDisable(false);
    }
    
   @FXML
    private void handleDesabilitar(ActionEvent event){
        TFCPF.setDisable(true);
        TFDataInicio.setDisable(true);
        TFDataTermino.setDisable(true);
    }
    
    @FXML
    private void handleCadastrar(ActionEvent event) throws ClassNotFoundException, SQLException {
        int LIVRE = 1;
        int ALUGADO = 2;
        int RESERVADO = 3;
        
        String marca = TFMarca.getText().trim();
        String modelo = TFModelo.getText().trim();
        String grupo = TFGrupo.getText().trim();
        String placa = TFPlaca.getText().trim();
        int status = buttonLivre.isSelected()? LIVRE : buttonAlugado.isSelected()? ALUGADO : RESERVADO;
        
        Veiculo veiculo = new Veiculo(marca, modelo, grupo, placa);
        
        DatabaseHandler dbHandler = new DatabaseHandler();
        
        if(dbHandler.cadastrarVeiculo(veiculo)) {
            // caso exista pelo menos uma linha de resposta a query
            
            
        }
        
        System.out.println("Veiculo: " + veiculo);
        System.out.println("Status: " + status);
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

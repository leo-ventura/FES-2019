package vocealuga.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 *
 * @author avellar
 */
public class FXMLCadastrarVeiculoController implements Initializable {

    @FXML
    private Button buttonCancel;

    @FXML
    private void handleClose(ActionEvent event) {
        // TODO: Adicionar um popup confirmando o cancelamento de cadastro
        // (para não perder possíveis informações inseridas)
        ((Stage) buttonCancel.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

package vocealuga;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author matheus
 */
public class VoceAluga extends Application {

    @Override
    public void start(Stage primaryWindow) throws Exception {
        Parent vMenu = FXMLLoader.load(getClass().getResource("View/FXMLMenu.fxml"));
        primaryWindow.setTitle("Menu – Você-Aluga");
        Scene sceneMenu = new Scene(vMenu);
        primaryWindow.setScene(sceneMenu);
        primaryWindow.setResizable(false);
        primaryWindow.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

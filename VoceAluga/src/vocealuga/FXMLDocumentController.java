/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga;

// importing sql lib
import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.naming.NamingException;


/**
 *
 * @author matheus
 * @author leo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, NamingException {
        try{  
            // configuring database
            String url = "jdbc:mysql://localhost:3306/VoceAluga";
            
            // open connection
            Connection connection = DriverManager.getConnection(url, "root", "mysql-root");
            
            // displaying information that our database has been connected successfully
            label.setText("Database connected!");
            
            
            // trying to work with the information available in the db
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Cliente;");
            
            label.setText(rs.getInt(1) + " " + rs.getString(2));
            
            connection.close();
            
        } catch(Exception e){
            System.err.println(e);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                label.setText("Driver loaded!");
            } catch (ClassNotFoundException ex) {
                System.err.println("Cannot find the driver in the classpath!" + ex);
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

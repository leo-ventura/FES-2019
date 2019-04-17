package vocealuga.Controller;

// importing sql lib
import java.sql.*;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import vocealuga.Model.Cliente;

/**
 *
 * @author avellar
 * @author leo
 */
public class FXMLCadastrarController implements Initializable {

    // Cliente variables being passed via FXML
    @FXML
    private TextField TFNome;
    @FXML
    private TextField TFEndereco;
    @FXML
    private TextField TFCC;
    @FXML
    private TextField TFData;
    @FXML
    private TextField TFCPF;
    @FXML
    private TextField TFCNH;
    @FXML
    private CheckBox CBSpecialNeeds;
    
    @FXML
    private Button buttonCancel;
    
    @FXML
    private void handleClose(ActionEvent event) {
        // TODO: Adicionar um popup confirmando o cancelamento de cadastro
        // (para não perder possíveis informações inseridas)
        ((Stage) buttonCancel.getScene().getWindow()).close();
    }
    
    @FXML
    private void handleCadastrar(ActionEvent event) throws SQLException {
        String name = TFNome.getText();
        String address = TFEndereco.getText();
        String creditCard = TFCC.getText();
        String date = TFData.getText();
        String cpf = TFCPF.getText();
        String cnh = TFCNH.getText();
        int specialNeeds = CBSpecialNeeds.isSelected() ? 1 : 0;
        

        if(name.isEmpty()){
            System.out.println("Insira o nome");
        }
        else if(address.isEmpty()){
            System.out.println("Insira o endereço");
        }
        else if(creditCard.isEmpty()){
            System.out.println("Insira o cartão de crédito");
        }
        else if(date.isEmpty()){
            System.out.println("Insira a data de nascimento");
        }
        else if(cpf.isEmpty()){
            System.out.println("Insira o CPF");
        }
        else if (!isCPF(cpf)){
            System.out.println("CPF invalido");
        }
        else if(cnh.isEmpty()){
            System.out.println("Insira a CNH");
        }
        else {
            try {
                Cliente cliente = new Cliente(name, address, creditCard, date,
                                        cpf, cnh, specialNeeds);
                
                System.out.println("Cliente.getCPF(): " + cliente.getCPF());

                DatabaseHandler dbHandler = new DatabaseHandler();
                
                // checking if cpf is already being used
                System.out.println("Cliente.getCPF(): " + cliente.getCPF());
                ResultSet rs = dbHandler.checkCPF(cliente.getCPF());

                System.out.println("rs.first(): " + rs.first());
                if(rs.first()) {
                    System.out.println("The provided CPF is already in use!");
                    // TODO: Add an alert telling that to the user
                    // CC: @avellar
                } else {

                    String clienteValues = cliente.formatToInsert();
                    System.out.println(clienteValues);

                    int r = dbHandler.insertIntoClienteTable(clienteValues);
                    System.out.println("Values have been inserted!\n" + r);
                }

                // closing connection
                dbHandler.close();

                System.out.println(cliente);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return false;
          
        char dig10, dig11;
        int sm, i, r, num, peso;
          
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {              
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0         
                // (48 eh a posicao de '0' na tabela ASCII) 
                num = (int)(CPF.charAt(i) - 48); 
                sm = sm + (num * peso);
                peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
          
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);
          
            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return true;
            else return false;
        } catch (InputMismatchException erro) {
            return false;
        }
    }
}

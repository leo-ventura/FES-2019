package vocealuga.Controller;

// importing sql lib
import java.sql.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import vocealuga.Model.Cliente;

/**
 *
 * @author avellar
 * @author leo
 */
public class FXMLCadastrarClienteController implements Initializable {

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
    private Label LabelError;
    
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
        cadastraCliente("","","","","","",2);
    }
    
    public boolean cadastraCliente(String name, String address, String creditCard,
                            String date, String cpf, String cnh, int specialNeeds){
        boolean retValue = false;
        
        // Checando se os TextFields sao nulos
        // isso pode quebrar algo?
        // se o programa der problema, checar aqui
        if(TFNome == null || TFEndereco == null || TFCC == null
        || TFData == null || TFCPF == null || TFCNH == null)
            return retValue;
        
        // Remove espaços no início e fim das strings de nome e endereço
        if(name.equals("")) name = TFNome.getText().trim();
        if(address.equals("")) address = TFEndereco.getText().trim();
        // Remove todos os espaços da string de cartão
        if(creditCard.equals("")) creditCard = TFCC.getText().replaceAll(" ", "");
        // Substitui '-' por '/' na strng de data
        if(date.equals("")) date = TFData.getText().trim().replaceAll("-", "/");
        // Remove ' ', '.' e '-' da string de CPF
        if(cpf.equals("")) cpf = TFCPF.getText().replaceAll("[ \\.-]", "");
        // Remove todos os espaços da string de CNH
        if(cnh.equals("")) cnh = TFCNH.getText().replaceAll(" ", "");
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if(specialNeeds == 2) specialNeeds = CBSpecialNeeds.isSelected() ? 1 : 0;
        
        /* TODO: Padronizar mensagem de erro e mostrá-la ao usuário */
        if(name.isEmpty()){
            //System.out.println("Insira o nome");
            LabelError.setVisible(true);
            LabelError.setText("Insira o nome");
        }
        else if(address.isEmpty()){
            //System.out.println("Insira o endereço");
            LabelError.setVisible(true);
            LabelError.setText("Insira o endereço");
        }
        else if(!validateCC(creditCard)){
            //System.out.println("Insira um cartão de crédito válido");
            LabelError.setVisible(true);
            LabelError.setText("Insira um cartão de crédito válido");
        }
        else if(date.isEmpty()){
            //System.out.println("Insira a data de nascimento");
            LabelError.setVisible(true);
            LabelError.setText("Insira a data de nascimento");
        }
        else if(cpf.isEmpty()){
            //System.out.println("Insira o CPF");
            LabelError.setVisible(true);
            LabelError.setText("Insira o CPF");
        }
        else if (!validateCPF(cpf)){
            //System.out.println("CPF invalido");
            LabelError.setVisible(true);
            LabelError.setText("CPF inválido");
        }
        else if(cnh.isEmpty()){
            //System.out.println("Insira a CNH");
            LabelError.setVisible(true);
            LabelError.setText("Insira a CNH");
        }
        else {
            LabelError.setVisible(false);
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
                    //System.out.println("The provided CPF is already in use!");
                    LabelError.setVisible(true);
                    LabelError.setText("CPF já está em uso");
                } else {

                    String clienteValues = cliente.formatToInsert();
                    System.out.println(clienteValues);

                    int r = dbHandler.insertIntoClienteTable(clienteValues);
                    System.out.println("Values have been inserted!\n" + r);
                    TFNome.setText("");
                    TFCNH.setText("");
                    TFCC.setText("");
                    TFCPF.setText("");
                    TFData.setText("");
                    TFEndereco.setText("");
                    
                    LabelError.setVisible(true);
                    LabelError.setText("Cliente cadastrado com sucesso!");
                    
                    retValue = true;
                }

                // closing connection
                dbHandler.close();

                System.out.println(cliente);
            } catch (Exception e){
                System.out.println(e.getMessage());
                LabelError.setVisible(true);
                LabelError.setText("Data de nascimento inválida");
            }
        }       
        return retValue;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        
    public boolean validateCC(String cc) {
        // Se o tamanho do número for diferente de 16, ou se a string conter
        // algum caractere que não é um algarismo, é inválido
        if(cc.length() != 16 || cc.replaceAll("[^0-9]", "_").contains("_"))
            return false;
        // Senão, é válido
        return true;
    }
    
    public static boolean validateCPF(String CPF) {
        // Se a string recebida tem um tamanho diferente de 11, não pode ser um
        // número de CPF válido
        if(CPF.length() != 11)
            return false;

        // CPFs formados por uma sequência de números iguais são inválidos
        if(CPF.matches("^(.)\\1*$"))
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
        } catch (InputMismatchException e) {
            return false;
        }
    }
}

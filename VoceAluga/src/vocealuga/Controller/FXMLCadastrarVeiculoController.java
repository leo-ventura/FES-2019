package vocealuga.Controller;

import java.net.URL;
<<<<<<< HEAD
<<<<<<< HEAD
import java.sql.ResultSet;
import java.sql.SQLException;
=======
import java.util.InputMismatchException;
>>>>>>> cadastro-de-veiculo
=======
import java.sql.ResultSet;
import java.sql.SQLException;
>>>>>>> 193e3332faeff6fc64a76b5ef26685786c997409
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
    private Label LabelErro;
    

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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 193e3332faeff6fc64a76b5ef26685786c997409
    private void handleCadastrar(ActionEvent event) throws ClassNotFoundException, SQLException {
        int LIVRE = 1;
=======
    private void handleCadastrar(ActionEvent event){
        int LIVRE = 0;
        int RESERVADO = 1;
>>>>>>> cadastro-de-veiculo
        int ALUGADO = 2;
        
        String marca = TFMarca.getText().trim();
        String modelo = TFModelo.getText().trim();
        String grupo = TFGrupo.getText().trim();
        String placa = TFPlaca.getText().trim();
        String cpf;
        String dataInicio;
        String dataTermino;
        int status = buttonLivre.isSelected()? LIVRE : buttonAlugado.isSelected()? ALUGADO : RESERVADO;
        
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 193e3332faeff6fc64a76b5ef26685786c997409
        Veiculo veiculo = new Veiculo(marca, modelo, grupo, placa);
        
        DatabaseHandler dbHandler = new DatabaseHandler();
        
        if(dbHandler.cadastrarVeiculo(veiculo)) {
            // caso exista pelo menos uma linha de resposta a query
            
            
        }
        
        System.out.println("Veiculo: " + veiculo);
        System.out.println("Status: " + status);
<<<<<<< HEAD
=======
        //se o status for LIVRE, cpf e datas são null
        if (status == LIVRE){
            cpf = null;
            dataInicio = null;
            dataTermino = null;
        }
        //caso contrario, seta cpf e datas
        else {
            cpf = TFCPF.getText().trim();
            dataInicio = TFDataInicio.getText().trim();
            dataTermino = TFDataTermino.getText().trim();
        }
        
        //TODO inserir verificacao dos campos
        if (marca.isEmpty()){
            LabelErro.setVisible(true);
            LabelErro.setText("Insira a marca");
        }
        else if (modelo.isEmpty()){
            LabelErro.setVisible(true);
            LabelErro.setText("Insira o modelo");
        }
        else if (grupo.isEmpty()){
            LabelErro.setVisible(true);
            LabelErro.setText("Insira o grupo");
        }
        else if (placa.isEmpty()){
            LabelErro.setVisible(true);
            LabelErro.setText("Insira a placa");
        }
        else if (status != LIVRE && cpf.isEmpty()){
            LabelErro.setVisible(true);
            LabelErro.setText("Insira o cpf");
        }
        else if (status != LIVRE && !validateCPF(cpf)){
            LabelErro.setVisible(true);
            LabelErro.setText("CPF invalido");
        }
        else if (status != LIVRE && dataInicio.isEmpty()){
            LabelErro.setVisible(true);
            LabelErro.setText("Insira a data de inicio");
        }
        else if (status != LIVRE && dataTermino.isEmpty()){
            LabelErro.setVisible(true);
            LabelErro.setText("Insira a data de termino");
        }
        else {
            try {
                Veiculo veiculo;
                if (status == LIVRE){
                    veiculo = new Veiculo(marca, modelo, grupo, placa);
                }
                else {
                    veiculo = new Veiculo(marca, modelo, grupo, placa, cpf, dataInicio, dataTermino, status);
                }
                    
                //testando se ta pegando tudo certo
                System.out.println("Veiculo: " + veiculo);
                
                DatabaseHandler dbHandler = new DatabaseHandler();
                String veiculoValues = veiculo.formatToInsert();
                System.out.println(veiculoValues);
                int r = dbHandler.insertIntoVeiculoTable(veiculoValues);
                System.out.println("Values have been inserted!\n" + r);
                TFMarca.setText("");
                TFDataInicio.setText("");
                TFCPF.setText("");
                TFGrupo.setText("");
                TFModelo.setText("");
                TFPlaca.setText("");
                buttonLivre.setSelected(true);
                dbHandler.close();
                
                
                
                LabelErro.setVisible(true);
                LabelErro.setText("Veiculo criado com sucesso");
                

            }
            catch(Exception e){
                System.out.println(e.getMessage());
                LabelErro.setVisible(true);
                LabelErro.setText("Formato de data invalido");
            }
        
        }
        
        
        
        
        
    
        
        
>>>>>>> cadastro-de-veiculo
=======
>>>>>>> 193e3332faeff6fc64a76b5ef26685786c997409
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

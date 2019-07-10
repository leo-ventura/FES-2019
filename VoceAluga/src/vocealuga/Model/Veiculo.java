package vocealuga.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author breno
 */
public class Veiculo {
//    private int LIVRE = 0;
//    private int RESERVADO = 1;
//    private int ALUGADO = 2;
//    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private int id = 0;
    private String marca;
    private String modelo;
    private String grupo;
    private String placa;
    //incluir no Sprint 5
    private double quilometragem;
    private String combustivel;
    
    public Veiculo() {
        this.marca = "";
        this.modelo = "";
        this.grupo = "";
        this.placa = "";
    }
    
    public Veiculo(String marca, String modelo, String grupo, String placa){
        this.marca = marca;
        this.modelo = modelo;
        this.grupo = grupo;
        this.placa = placa;
//        this.CPF = null;
//        this.DataInicio = null;
//        this.DataTermino = null; 
//        this.status = LIVRE;
    }

    public Veiculo(int id, String marca, String modelo, String grupo, String placa){
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.grupo = grupo;
        this.placa = placa;
    }

//    public Veiculo(String marca, String modelo, String grupo, String placa, String CPF, String DataInicio, String DataTermino, int status){
//        this.marca = marca;
//        this.modelo = modelo;
//        this.grupo = grupo;
//        this.placa = placa;
//        this.CPF = CPF;
//        this.DataInicio = LocalDate.parse(DataInicio, formatter);
//        this.DataTermino = LocalDate.parse(DataTermino, formatter);
//        this.status = status;
//    }
    
    public String getPlaca() {
        return this.placa;
    }
    public String getMarca() {
        return this.marca;
    }
    public String getModelo() {
        return this.modelo;
    }
    public String getGrupo() {
        return this.grupo;
    }
    public int getId() {
        return this.id;
    }
    public String toString() {
//        return String.format("Marca: %s. Modelo: %s. Grupo: %s. Placa: %s.\nSatus: %s.\nCPF: %s, Data Inicio: %s, Data Termino: %s.", 
//                this.marca, this.modelo, this.grupo, this.placa, (this.status == 0)? "Livre" : (this.status == 1)? "Reservado" : "Alugado", 
//                (this.status != 0)? this.CPF: "null", (this.status != 0)? this.DataInicio.format(formatter): "null", 
//                (this.status != 0)? this.DataTermino.format(formatter) : "null" );
        return String.format("Marca: %s. Modelo: %s. Grupo: %s. Placa: %s.", 
                this.marca, this.modelo, this.grupo, this.placa);
    }
    
    public String formatToInsert(){
        String beginningSeparator = "(\"";
        String midSeparator = "\", \"";
        String endingSeparator = "\")";
//        if (this.status == LIVRE){
//            return beginningSeparator + this.status + midSeparator + 
//                this.modelo + midSeparator + this.marca + midSeparator + 
//                this.placa + midSeparator + this.grupo + midSeparator + 
//                " " + midSeparator + " " + midSeparator + " " + endingSeparator;
//        }
//        return beginningSeparator + this.status + midSeparator + 
//                this.modelo + midSeparator + this.marca + midSeparator + 
//                this.placa + midSeparator + this.grupo + midSeparator + 
//                this.CPF + midSeparator + this.DataInicio.format(formatter) + midSeparator + this.DataTermino.format(formatter) + endingSeparator;
        return beginningSeparator + 
                this.modelo + midSeparator + this.marca + midSeparator + 
                this.placa + midSeparator + this.grupo + endingSeparator;
    }

}



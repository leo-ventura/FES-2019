/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author breno
 */
public class Transacao {
    private String CPFCliente;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int carId;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
   public Transacao() {
       this.CPFCliente = "";
       this.carId = 0;
       this.dataFim = LocalDate.now();
       this.dataInicio = LocalDate.now();
   }
   
   public Transacao(String cpf, String dataInicio, String dataFim, int carId){
       this.CPFCliente = cpf;
       this.carId = carId;
       this.dataFim = LocalDate.parse(dataFim, formatter);
       this.dataInicio = LocalDate.parse(dataInicio, formatter);
   }
   
   public Transacao(String cpf, LocalDate dataInicio, LocalDate dataFim, int carId){
       this.CPFCliente = cpf;
       this.carId = carId;
       this.dataFim = dataFim;
       this.dataInicio = dataInicio;
   }
   
    public String formatToInsert() {
        String beginningSeparator = "(\"";
        String midSeparator = "\", \"";
        String endingSeparator = "\")";
        return beginningSeparator + this.carId + midSeparator + 
                this.dataInicio.format(formatter) + midSeparator + 
                this.dataFim.format(formatter) + midSeparator + this.CPFCliente + 
                endingSeparator;
 }

}

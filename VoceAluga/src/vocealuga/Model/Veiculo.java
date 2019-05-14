/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga.Model;

/**
 *
 * @author breno
 */
public class Veiculo {
    private String marca;
    private String modelo;
    private String grupo;
    private String placa;
    
    
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
    }
    
    public String toString() {
        return String.format("Marca: %s. Modelo: %s. Grupo: %s. Placa: %s", this.marca, this.modelo, this.grupo, this.placa);
    }

}



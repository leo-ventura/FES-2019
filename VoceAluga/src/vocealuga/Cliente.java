/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga;

//import java.util.Date;

/**
 *
 * @author leo
 */
public class Cliente {
    private String nome;
    private String endereco;
    private String cc;
    private String dataDeNascimento;
    private String cpf;
    private String cnh;
    // Date dataDeNascimento; // it may be better to use it as a string
    // can't use boolean because mysql can't handle it
    // though we can still use it as 0 => false and 2 => true
    private int necessidadesEspeciais;
    
    public Cliente() {
        this.nome = "";
        this.endereco = "";
        this.cc = "";
        this.dataDeNascimento = "";
        this.cpf = "";
        this.cnh = "";
        this.necessidadesEspeciais = 0;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void setCC(String cc) {
        this.cc = cc;
    }
    
    public void setData(String data) {
        this.dataDeNascimento = data;
    }
    
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
    
    public void setCNH(String cnh) {
        this.cnh = cnh;
    }
    
    public void setNecessidadesEspeciais(int sp) {
        this.necessidadesEspeciais = sp;
    }
    
    
    public String formatToInsert() {
        return "(\"" + this.nome + "\", \"" + this.endereco + "\", \"" + this.cc + "\", \"" +
                this.dataDeNascimento + "\", \"" + this.cpf + "\", \"" + 
                this.cnh + "\", \"" + this.necessidadesEspeciais + "\")";
    }
}

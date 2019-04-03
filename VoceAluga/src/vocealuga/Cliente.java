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
    // though we can still use it as 0 => false and 1 => true
    private int necessidadesEspeciais;
    
    // simple constructor
    public Cliente() {
        this.nome = "";
        this.endereco = "";
        this.cc = "";
        this.dataDeNascimento = "";
        this.cpf = "";
        this.cnh = "";
        this.necessidadesEspeciais = 0;
    }
    
    // overloading Cliente constructor to simplify our code
    public Cliente(String nome, String endereco, String cc,
            String dataDeNascimento, String cpf, String cnh, 
            int necessidadesEspeciais) {


        this.nome = nome;
        this.endereco = endereco;
        this.cc = cc;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.cnh = cnh;
        this.necessidadesEspeciais = necessidadesEspeciais;
    
    }
    
    // setters
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
    
    
    // getters
    public String getNome() {
        return this.nome;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    
    public String getCC() {
        return this.cc;
    }
    
    public String getData() {
        return this.dataDeNascimento;
    }
    
    public String getCPF() {
        return this.cpf;
    }
    
    public String getCNH() {
        return this.cnh;
    }
    
    public int getNecessidadesEspeciais() {
        return this.necessidadesEspeciais;
    }
    
    
    public String formatToInsert() {
        return "(\"" + this.nome + "\", \"" + this.endereco + "\", \"" + this.cc + "\", \"" +
                this.dataDeNascimento + "\", \"" + this.cpf + "\", \"" + 
                this.cnh + "\", \"" + this.necessidadesEspeciais + "\")";
    }
}

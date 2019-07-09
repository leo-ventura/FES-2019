/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga.Model;

//import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author leo
 */

public class Cliente {
    private String nome;
    private String endereco;
    private String cc;
    private LocalDate dataDeNascimento;
    private String cpf;
    private String cnh;
    private int necessidadesEspeciais;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate dataDeCadastro = LocalDate.now();
    private LocalDate dataDeAlteracao = LocalDate.now();
    
    // simple constructor
    public Cliente() {
        this.nome = "";
        this.endereco = "";
        this.cc = "";
        this.dataDeNascimento = LocalDate.MIN;
        this.cpf = "";
        this.cnh = "";
        this.necessidadesEspeciais = 0;
    }
    
    // overloading Cliente constructor to simplify our code
    public Cliente(String nome, String endereco, String cc,
            LocalDate dataDeNascimento, String cpf, String cnh, 
            int necessidadesEspeciais) {


        this.nome = nome;
        this.endereco = endereco;
        this.cc = cc;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.cnh = cnh;
        this.necessidadesEspeciais = necessidadesEspeciais;
    
    }
    
    public Cliente(String nome, String endereco, String cc,
            String dataDeNascimento, String cpf, String cnh, 
            int necessidadesEspeciais) {


        this.nome = nome;
        this.endereco = endereco;
        this.cc = cc;
        this.dataDeNascimento = LocalDate.parse(dataDeNascimento, formatter);
        this.cpf = cpf;
        this.cnh = cnh;
        this.necessidadesEspeciais = necessidadesEspeciais;
    
    }
    
    public Cliente(String nome, //String endereco, String cc,
            /*String dataDeNascimento,*/ String cpf, String cnh) {

        this.nome = nome;
//        this.endereco = endereco;
//        this.cc = cc;
//        this.dataDeNascimento = LocalDate.parse(dataDeNascimento, formatter);
        this.cpf = cpf;
        this.cnh = cnh;    
    }
    
    public Cliente(String nome, String endereco, String cc,
            String dataDeNascimento, String cpf, String cnh, 
            int necessidadesEspeciais, String dataDeCadastro) {


        this.nome = nome;
        this.endereco = endereco;
        this.cc = cc;
        this.dataDeNascimento = LocalDate.parse(dataDeNascimento, formatter);
        this.cpf = cpf;
        this.cnh = cnh;
        this.necessidadesEspeciais = necessidadesEspeciais;
        this.dataDeCadastro = LocalDate.parse(dataDeCadastro, formatter);
        // dataDeAlteracao comecara igual a data de cadastro
        this.dataDeAlteracao = LocalDate.parse(dataDeCadastro, formatter);
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
    
    public void setData(LocalDate data) {
        this.dataDeNascimento = data;
    }
    
    public void setData(String data) {
        if(!data.equalsIgnoreCase("") && data != null)
            this.dataDeNascimento = LocalDate.parse(data, formatter);
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
    
    public void setDataDeCadastro(LocalDate data) {
        this.dataDeCadastro = data;
    }
    
    public void setDataDeCadastro(String data) {
        if(!data.equalsIgnoreCase("") && data != null)
            this.dataDeCadastro = LocalDate.parse(data, formatter);
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
        if(this.dataDeNascimento != null)
            return this.dataDeNascimento.format(formatter);
        System.out.println("Nao foi possivel acessar data de nascimento");
        return "";
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
    
    public String getDatadeCadastro() {
        if(formatter != null)
            return this.dataDeCadastro.format(formatter);
        System.out.println("Nao foi possivel acessar data de cadastro");
        return "";
    }
    
    
    public String formatToInsert() {
        String beginningSeparator = "(\"";
        String midSeparator = "\", \"";
        String endingSeparator = "\")";
        return beginningSeparator + this.nome + midSeparator + this.endereco +
                midSeparator + this.cc + midSeparator + this.dataDeNascimento.format(formatter) +
                midSeparator + this.cpf + midSeparator + this.cnh + midSeparator +
                this.necessidadesEspeciais + midSeparator +
                this.dataDeCadastro.format(formatter) + midSeparator +
                this.dataDeAlteracao.format(formatter) + endingSeparator;
    }
    
    public String toString() {
        if(this.nome.equals("") || this.endereco.equals("") || this.cc.equals("")
        || this.cpf.equals("") || this.cnh.equals("")
        || this.dataDeNascimento == null || this.dataDeCadastro == null) {
            System.out.println("Existem campos vazios ou nulos nesse Cliente");
            return "";
        }
            
            
        return String.format("Nome: %s\nEndereco: %s\n"
                + "Data de nascimento: %s\nCartão de Crédito: %s\n"
                + "CPF: %s\nCNH: %s\nNecessidades Especiais: %s\n"
                + "Data de cadastro: %s\n",
                this.nome, this.endereco, this.dataDeNascimento.format(formatter),
                this.cc, this.cpf, this.cnh, this.necessidadesEspeciais==0?"Nao":"Sim",
                this.dataDeCadastro.format(formatter));
    }
}

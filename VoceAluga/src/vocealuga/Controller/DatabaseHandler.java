package vocealuga.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import vocealuga.Model.Cliente;
import vocealuga.Model.Veiculo;

/**
 *
 * @author leo
 */

public class DatabaseHandler {
    private Connection connection;
    
    public DatabaseHandler() throws ClassNotFoundException, SQLException {
        try {
            String remoteIP = System.getenv("MYSQL_REMOTE_IP");
            String databaseUser = System.getenv("MYSQL_REMOTE_USER");
            String databasePassword = System.getenv("MYSQL_REMOTE_PASSWORD");

            // loading driver
            Class.forName("com.mysql.cj.jdbc.Driver");            
            
            // configuring database
            String url = "jdbc:mysql://" + remoteIP + ":3306/VoceAluga";

            // open connection
            this.connection = DriverManager.getConnection(url, databaseUser, databasePassword);

            // printing status
//            System.out.println("Database connected sucessfully");
        } catch(ClassNotFoundException ClassNotFoundError) {
            System.out.println("Cannot find the driver in the classpath! " + ClassNotFoundError);
        } catch(SQLException SQLError) {
            System.out.println("Error: " + SQLError);
        }
    }
    
    public ResultSet query(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        if(query != null && !query.equalsIgnoreCase(""))
            return stmt.executeQuery(query);
        return null;
    }
    
    public ResultSet fetchClienteInfo(Cliente cliente) throws SQLException {
        // todo: funcao pode ser melhorada usando PreparedStatement
        // procurando primeiro por dados que, em teoria, sao unicos:
        // cpf, cnh
        // depois procuramos por dados que talvez nao sejam unicos e, consequentemente,
        // podem nao retornar apenas um resultado
        if(cliente == null)
            return null;
        String query = "select * from VoceAluga.Cliente where ";
        String target = "";
        if(!cliente.getCPF().equals("")) {
            query += "CPF = ?";
            target = cliente.getCPF();
        }
        else if(!cliente.getCNH().equals("")) {
            query += "CNH = ?";
            target = cliente.getCNH();
        }
        else if(!cliente.getNome().equals("")) {
            query += "Nome = ?";
            target = cliente.getNome();
        } else {
            // Nenhuma informacao foi provida, retornamos null
            return null;
        }
        
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, target);
        System.out.println(preparedStmt);
        return preparedStmt.executeQuery();
    }
    
    public ResultSet checkCPF(String cpf) throws SQLException {
        if(cpf != null && !cpf.equalsIgnoreCase(""))
            return query("select CPF from VoceAluga.Cliente where CPF = \"" + cpf + "\";");
        return null;
    }
    
    public boolean removeCliente(String cpf) throws SQLException {
        String query = "delete from VoceAluga.Cliente where CPF = ?";
        
        System.out.println("removing Cliente identified by CPF: " + cpf);
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, cpf);
        
        // preparedStmt.executeUpdate() retorna a quantidade de linhas modificadas
        // System.out.println(preparedStmt.executeUpdate());
        if(preparedStmt.executeUpdate() > 0){
            System.out.println("Cliente removido com sucesso!");
            return true;
        }
        else{
            System.out.println("Nao foi possivel remover tal cliente");
            return false;
        }
    }
    
    public int insertIntoClienteTable(String values) throws SQLException {
        String cmd = "insert into VoceAluga.Cliente (Nome, Endereco, CreditCard,"
                + "DataDeNascimento, CPF, CNH, NecessidadesEspeciais, DataDeCadastro,"
                + "DataDeAlteracao) values "
                + values + ";";
        
//        insert into Cliente (nome, endereco, cc, data, cpf, cnh, necessidades_especiais) values ("test", "end", "cc", "data", "cpf", "cnh", 1);
        System.out.println(cmd);
        
        if(cmd != null && values != null && !values.equalsIgnoreCase("")) {
            Statement stmt = connection.createStatement();
            return stmt.executeUpdate(cmd);
        }
        return -1;
    }
    
    public int insertIntoVeiculoTable(String values) throws SQLException {
//        String cmd = "insert into VoceAluga.Veiculos (Status, Modelo, Marca, Placa, Grupo, CPF, DataInicio, DataTermino) values"
//                + values + ";";
        String cmd = "insert into VoceAluga.Veiculos (Modelo, Marca, Placa, Grupo) values"
                + values + ";";
        System.out.println(cmd);
        if (values != null && !values.equalsIgnoreCase("") ) {
            Statement stmt = connection.createStatement();
            return stmt.executeUpdate(cmd);
        }
        return -1;
    }
    
    public int insertIntoHistoricoTable(String values) throws SQLException {
        String cmd = "insert into VoceAluga.HistoricoVeiculos (CarId, DataDeInicio, DataDeTermino, ClienteCPF) values" 
                + values + ";";
        System.out.println(cmd);
        if (values != null && !values.equalsIgnoreCase("")) {
            Statement stmt = connection.createStatement();
            return stmt.executeUpdate(cmd);
        }
        return -1;
    }
    
    public ArrayList<Veiculo> getVeiculos() throws SQLException{
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        Statement smt = connection.createStatement();
        ResultSet result = smt.executeQuery("Select * from VoceAluga.Veiculos");
        while (result.next()){
            int id = result.getInt("CarId");
            String modelo = result.getString("Modelo");
            String marca = result.getString("Marca");
            String placa = result.getString("Placa");
            String grupo = result.getString("Grupo");
            veiculos.add(new Veiculo(id, marca, modelo, grupo, placa));
        }
        System.out.println(veiculos);
        return veiculos;
    }
    
    public boolean isFreeAtRange(int cardId, LocalDate inicio, LocalDate fim) throws SQLException{
        if(inicio == null || fim == null)
            return false;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Statement smt = connection.createStatement();
        int i = 1;
        ResultSet result = smt.executeQuery("Select * from VoceAluga.HistoricoVeiculos where carId = " + cardId);
        while (result.next()){
            System.out.println("Comparando com a transacao " + i++);
            LocalDate auxInicio = LocalDate.parse(result.getString("DataDeInicio"), formatter);
            LocalDate auxFim = LocalDate.parse(result.getString("DataDeTermino"), formatter);
            if ((inicio.isAfter(auxInicio) && inicio.isBefore(auxFim)) || fim.isAfter(auxInicio) && fim.isBefore(auxFim)){
                System.out.println("Veiculo ocupado na data desejada");
                return false;
            }
            if (inicio.isBefore(auxInicio) && fim.isAfter(auxFim)){
                System.out.println("Veiculo ocupado na data desejada");
                return false;
            }
            
            
        }
        System.out.println("Veiculo livre na data desejada!");
        return true;

    }
    
    public void close() throws SQLException {
        try {
            connection.close();
        } catch(SQLException SQLEx) {
            System.out.println("Error while attempting to close: " + SQLEx);
        }
    }
}

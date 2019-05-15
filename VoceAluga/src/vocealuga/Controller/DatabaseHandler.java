package vocealuga.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vocealuga.Model.Cliente;

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
            System.out.println("Database connected sucessfully");
        } catch(ClassNotFoundException ClassNotFoundError) {
            System.out.println("Cannot find the driver in the classpath! " + ClassNotFoundError);
        } catch(SQLException SQLError) {
            System.out.println("Error: " + SQLError);
        }
    }
    
    public ResultSet query(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }
    
    public ResultSet fetchClienteInfo(Cliente cliente) throws SQLException {
        // todo: funcao pode ser melhorada usando PreparedStatement
        // procurando primeiro por dados que, em teoria, sao unicos:
        // cpf, cnh
        // depois procuramos por dados que talvez nao sejam unicos e, consequentemente,
        // podem nao retornar apenas um resultado
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
        return query("select CPF from VoceAluga.Cliente where CPF = \"" + cpf + "\";");
    }
    
    public void removeCliente(String cpf) throws SQLException {
        String query = "delete from VoceAluga.Cliente where CPF = ?";
        
        System.out.println("removing Cliente identified by CPF: " + cpf);
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, cpf);
        
        // preparedStmt.executeUpdate() retorna a quantidade de linhas modificadas
        // System.out.println(preparedStmt.executeUpdate());
        if(preparedStmt.executeUpdate() > 0)
            System.out.println("Cliente removido com sucesso!");
        else
            System.out.println("Nao foi possivel remover tal cliente");
    }
    
    public int insertIntoClienteTable(String values) throws SQLException {
        String cmd = "insert into VoceAluga.Cliente (Nome, Endereco, CreditCard,"
                + "DataDeNascimento, CPF, CNH, NecessidadesEspeciais, DataDeCadastro,"
                + "DataDeAlteracao) values "
                + values + ";";
        
//        insert into Cliente (nome, endereco, cc, data, cpf, cnh, necessidades_especiais) values ("test", "end", "cc", "data", "cpf", "cnh", 1);
        Statement stmt = connection.createStatement();
        System.out.println(cmd);
        return stmt.executeUpdate(cmd);
    }
    
    public void close() throws SQLException {
        try {
            connection.close();
        } catch(SQLException SQLEx) {
            System.out.println("Error while attempting to close: " + SQLEx);
        }
    }
}

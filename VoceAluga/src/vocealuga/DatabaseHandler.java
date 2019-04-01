/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vocealuga;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author leo
 */
public class DatabaseHandler {
    Connection connection;
    
    public DatabaseHandler() throws ClassNotFoundException, SQLException {
        try {
            // loading driver
            Class.forName("com.mysql.cj.jdbc.Driver");            
            
            // configuring database
            String url = "jdbc:mysql://localhost:3306/VoceAluga";

            // open connection
            this.connection = DriverManager.getConnection(url, "root", "mysql-root");

            // printing status
            System.out.println("Database connected sucessfully");
        } catch(ClassNotFoundException ClassNotFoundError) {
            System.out.println("Cannot find the driver in the classpath!" + ClassNotFoundError);
        } catch(SQLException SQLError) {
            System.out.println("Error: " + SQLError);
        }
    }
    
    public ResultSet query(String query) throws SQLException {
        // trying to work with the information available in the db
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }
    
    public int insertIntoClienteTable(String values) throws SQLException {
        String cmd = "insert into VoceAluga.Cliente (nome, endereco, cc, data, cpf, cnh, necessidades_especiais) values "
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


package br.com.cwi.crescer.exerciciosdesql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtils {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "cwi";
    private static final String PASS = "cwi";
    
    public static Connection getConexao() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

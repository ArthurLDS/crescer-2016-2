package br.com.cwi.crescer.exerciciosdesql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MeuSQLUtils {
    
    public void executaSQLDeArquivo(String query){
    
    }
    
    public void executarSQL(String query){
        
        try{
            final Connection conexao = ConexaoUtils.getConexao();
            final Statement statement = conexao.createStatement();
            
            try{
                final ResultSet resultSet = statement.executeQuery(query);
                
                while(resultSet.next()) {
                    final long idPessoa = resultSet.getLong("ID_PESSOA");
                    final String nmPessoa = resultSet.getString("NM_PESSOA");
                    
                    System.out.format("ID: %s NOME: %s\n", idPessoa, nmPessoa);
                }
                
            }
            catch(final SQLException e){
                System.err.format("SQLException: %s", e);
            }
        }
        catch(final SQLException e){
            System.err.format("SQLException: %s", e);
        }
    }
    public void importarArquivo(String arquivo){
        
    }
    
    public void exportarArquivo(String arquivo){
        
    }
    
}
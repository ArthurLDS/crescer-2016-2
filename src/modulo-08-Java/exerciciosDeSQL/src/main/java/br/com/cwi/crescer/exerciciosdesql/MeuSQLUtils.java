package br.com.cwi.crescer.exerciciosdesql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.cwi.crescer.exerciciosdesql.ConexaoUtils;
import java.sql.PreparedStatement;

public class MeuSQLUtils {

    public static void executaSQLDeArquivo(String arquivo) {
        try {
            final Reader reader = new FileReader(arquivo);
            final BufferedReader bufferReader = new BufferedReader(reader);

            String linha = bufferReader.readLine();
            while (linha != null) {
                executarSQL(linha);
                linha = bufferReader.readLine();
            }
        } catch (Exception e) {
            
        }
    }

    public static void executarSQL(String query) {

        try {
            final Connection conexao = new ConexaoUtils().getConexao();
            final Statement statement = conexao.createStatement();

            try {
                final ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    final long idPessoa = resultSet.getLong("id");
                    final String nmPessoa = resultSet.getString("nome");
                    System.out.format("ID: %s NOME: %s\n", idPessoa, nmPessoa);
                }

            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
    
    public static void inserir(String[] propriedades){
        final String insert = "INSERT INTO Pessoa (id, nome, telefone) VALUES("
                +       propriedades[0] + ","
                + "'" + propriedades[1] + "',"
                + "'" + propriedades[2] + "')";
        try{
            final Connection conexao = new ConexaoUtils().getConexao();
            final PreparedStatement preparedStatement = conexao.prepareStatement(insert);
            
            preparedStatement.executeUpdate(insert);
        }
        catch(final SQLException e){
            System.err.format("SQLException: %s", e);
        }
    }

    public static void exportarArquivo(String arquivo) {
        try {
            final Reader reader = new FileReader(arquivo);
            final BufferedReader bufferReader = new BufferedReader(reader);
            
            String propriedades[];
            
            String linha = bufferReader.readLine();
            while (linha != null) {
                propriedades = linha.split(";");
                inserir(propriedades);
                linha = bufferReader.readLine();
            }
        } catch (Exception e) {
            
        }
    }
    
    public static void importarArquivo(String arquivo) {
        
    }

}

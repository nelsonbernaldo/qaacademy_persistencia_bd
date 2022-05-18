package dao;


import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteDao {
    public static Connection connection;
    public static Statement stmt;

    @BeforeClass
    public static void beforeClass() throws SQLException {
        System.out.println("Iniciando conexao");
        connection = ConnectionFactory.getConnection();
        System.out.println("conexao feita com sucesso");
        stmt = connection.createStatement();
        connection.setAutoCommit(false);


    }

    @Test
    public void testeRetornoSelectDadosteste() throws SQLException {
        String comandoSql = "SELECT dt.MASSA_TESTE  FROM DADOS_TESTE dt WHERE ID_CASO_TESTE = 1";
        ResultSet resultSet = stmt.executeQuery(comandoSql);
        resultSet.next();

        String jsonMassaTeste = resultSet.getString(1);
        Assert.assertTrue(jsonMassaTeste.contains("\"url\":\"https://amazon.com.br\""));


    }
    @After
    public void after() throws SQLException {
        stmt.close();
        connection.close();
        System.out.println("Conexao fechadas com sucesso");

    }

}

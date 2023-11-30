package org.example.DAO;

import org.example.models.Capuz;
import org.example.models.Couro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CouroDAO extends ConnectionDAO{
    boolean sucesso = false; //Para saber se funcionou
    int idGerado;
    //INSERT
    public boolean insertCouro(Couro couro) {

        connectToDB();

        String sql = "INSERT INTO recurso (quantidade, preco, encantamento, grau) VALUES (?, ?, ?, ?)";
        try {
            // Use RETURN_GENERATED_KEYS para obter as chaves geradas automaticamente
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, couro.getQuantidade());
            pst.setInt(2, couro.getPreco());
            pst.setString(3, String.valueOf(couro.getEncantamento()));
            pst.setString(4, String.valueOf(couro.getGrau()));

            // Use executeUpdate() em vez de execute()
            int linhasAfetadas = pst.executeUpdate();

            // Verifique se a inserção foi bem-sucedida
            if (linhasAfetadas > 0) {
                // Obtenha as chaves geradas
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    idGerado = generatedKeys.getInt(1);
                }
            }

            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        connectToDB();
        sql = "INSERT INTO couro (Recurso_id) values(?)";
        try {

            pst = con.prepareStatement(sql);
            pst.setInt(1, idGerado);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
}

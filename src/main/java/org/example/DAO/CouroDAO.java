package org.example.DAO;

import org.example.models.*;
import org.example.models.Couro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    //DELETE
    public boolean deleteCouro(int id) {
        connectToDB();
        String sql = "DELETE FROM recurso where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
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

    //SELECT
    public ArrayList<Couro> selectCouro() {
        ArrayList<Couro> couros = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM recurso JOIN couro ON couro.Recurso_id = recurso.id;";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de couros: ");

            while (rs.next()) {

                Couro couroAux = new Couro(rs.getInt("id"),rs.getInt("quantidade"),rs.getInt("preco"),rs.getInt("encantamento"),rs.getInt("grau"));

                System.out.println("id = " + couroAux.getId());
                System.out.println("quantidade = " + couroAux.getQuantidade());
                System.out.println("encantamento = " + couroAux.getEncantamento());
                System.out.println("grau = " + couroAux.getGrau());
                System.out.println("preco = " + couroAux.getPreco());
                System.out.println("--------------------------------");

                couros.add(couroAux);
            }
            sucesso = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return couros;
    }

    //UPDATE
    public boolean updateCouro(int id, Couro couro) {
        connectToDB();
        String sql = "UPDATE recurso SET quantidade=?, preco=?, encantamento=?, grau=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, couro.getQuantidade());
            pst.setInt(2, couro.getPreco());
            pst.setString(3, String.valueOf(couro.getEncantamento()));
            pst.setString(4, String.valueOf(couro.getGrau()));
            pst.setInt(5,id);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
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

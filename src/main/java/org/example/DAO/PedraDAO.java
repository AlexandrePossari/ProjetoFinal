package org.example.DAO;

import org.example.models.Pedra;
import org.example.models.Pedra;
import org.example.models.Pedra;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedraDAO extends ConnectionDAO{
    boolean sucesso = false; //Para saber se funcionou
    int idGerado;
    //INSERT
    public boolean insertPedra(Pedra pedra) {

        connectToDB();

        String sql = "INSERT INTO recurso (quantidade, preco, encantamento, grau) VALUES (?, ?, ?, ?)";
        try {
            // Use RETURN_GENERATED_KEYS para obter as chaves geradas automaticamente
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, pedra.getQuantidade());
            pst.setInt(2, pedra.getPreco());
            pst.setString(3, String.valueOf(pedra.getEncantamento()));
            pst.setString(4, String.valueOf(pedra.getGrau()));

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
        sql = "INSERT INTO pedra (Recurso_id) values(?)";
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
    public boolean deletePedra(int id) {
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
    public ArrayList<Pedra> selectPedra() {
        ArrayList<Pedra> pedras = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM recurso JOIN pedra ON pedra.Recurso_id = recurso.id;";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de pedras: ");

            while (rs.next()) {

                Pedra pedraAux = new Pedra(rs.getInt("id"),rs.getInt("quantidade"),rs.getInt("preco"),rs.getInt("encantamento"),rs.getInt("grau"));

                System.out.println("id = " + pedraAux.getId());
                System.out.println("quantidade = " + pedraAux.getQuantidade());
                System.out.println("encantamento = " + pedraAux.getEncantamento());
                System.out.println("grau = " + pedraAux.getGrau());
                System.out.println("preco = " + pedraAux.getPreco());
                System.out.println("--------------------------------");

                pedras.add(pedraAux);
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
        return pedras;
    }

    //UPDATE
    public boolean updatePedra(int id, Pedra pedra) {
        connectToDB();
        String sql = "UPDATE recurso SET quantidade=?, preco=?, encantamento=?, grau=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pedra.getQuantidade());
            pst.setInt(2, pedra.getPreco());
            pst.setString(3, String.valueOf(pedra.getEncantamento()));
            pst.setString(4, String.valueOf(pedra.getGrau()));
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

package org.example.DAO;

import org.example.models.Esconderijo;
import org.example.models.Transmutacao;

import java.sql.SQLException;
import java.util.ArrayList;

public class TransmutacaoDAO extends ConnectionDAO{
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertTransmutacao(Transmutacao transmutacao) {

        connectToDB();

        String sql = "INSERT INTO transmutacao (preco, encantamento, grau) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, transmutacao.getPreco());
            pst.setString(2, String.valueOf(transmutacao.getEncantamento()));
            pst.setString(3, String.valueOf(transmutacao.getGrau()));
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
    public boolean deleteTransmutacao(int id) {
        connectToDB();
        String sql = "DELETE FROM transmutacao where id=?";
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
    public ArrayList<Transmutacao> selectTransmutacao() {
        ArrayList<Transmutacao> transmutacaos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM transmutacao";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de transmutacaos: ");

            while (rs.next()) {

                Transmutacao transmutacaoAux = new Transmutacao(rs.getInt("id"),rs.getInt("encantamento"),rs.getInt("grau"),rs.getInt("preco"));

                System.out.println("id = " + transmutacaoAux.getId());
                System.out.println("encantamento = " + transmutacaoAux.getEncantamento());
                System.out.println("grau = " + transmutacaoAux.getGrau());
                System.out.println("preco = " + transmutacaoAux.getPreco());
                System.out.println("--------------------------------");

                transmutacaos.add(transmutacaoAux);
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
        return transmutacaos;
    }

    //UPDATE
    public boolean updateTransmutacao(int id, Transmutacao transmutacao) {
        connectToDB();
        String sql = "UPDATE transmutacao SET preco=?, encantamento=?, grau=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, transmutacao.getPreco());
            pst.setString(2, String.valueOf(transmutacao.getEncantamento()));
            pst.setString(3, String.valueOf(transmutacao.getGrau()));
            pst.setInt(4,id);
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

package org.example.DAO;

import org.example.models.Capuz;
import org.example.models.Capuz;
import org.example.models.Capuz;

import java.sql.SQLException;
import java.util.ArrayList;

public class CapuzDAO extends ConnectionDAO{
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertCapuz(Capuz capuz) {

        connectToDB();

        String sql = "INSERT INTO capuz (preco, encantamento, grau) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, capuz.getPreco());
            pst.setString(2, String.valueOf(capuz.getEncantamento()));
            pst.setString(3, String.valueOf(capuz.getGrau()));
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
    public boolean deleteCapuz(int id) {
        connectToDB();
        String sql = "DELETE FROM capuz where id=?";
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
    public ArrayList<Capuz> selectCapuz() {
        ArrayList<Capuz> capuzs = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM capuz";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de capuzs: ");

            while (rs.next()) {

                Capuz capuzAux = new Capuz(rs.getInt("id"),rs.getInt("preco"),rs.getInt("encantamento"),rs.getInt("grau"));

                System.out.println("id = " + capuzAux.getId());
                System.out.println("encantamento = " + capuzAux.getEncantamento());
                System.out.println("grau = " + capuzAux.getGrau());
                System.out.println("preco = " + capuzAux.getPreco());
                System.out.println("--------------------------------");

                capuzs.add(capuzAux);
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
        return capuzs;
    }

    //UPDATE
    public boolean updateCapuz(int id, Capuz capuz) {
        connectToDB();
        String sql = "UPDATE capuz SET preco=?, encantamento=?, grau=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, capuz.getPreco());
            pst.setString(2, String.valueOf(capuz.getEncantamento()));
            pst.setString(3, String.valueOf(capuz.getGrau()));
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

    //Crafta
    public boolean craftar(int idCapuz, Capuz capuz, int idCouro) {
        connectToDB();
        String sql = "UPDATE capuz SET receita=? where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, capuz.getReceita());
            pst.setInt(2, idCapuz);
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

        connectToDB();
        sql = "UPDATE couro SET Capuz_id=? where Recurso_id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idCapuz);
            pst.setInt(2, idCouro);
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


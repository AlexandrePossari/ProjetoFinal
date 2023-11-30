package org.example.DAO;

import org.example.models.Esconderijo;
import org.example.models.Esconderijo;

import java.sql.SQLException;
import java.util.ArrayList;

public class EsconderijoDAO extends ConnectionDAO{
    boolean sucesso = false; //Para saber se funcionou

    //INSERT
    public boolean insertEsconderijo(Esconderijo esconderijo) {

        connectToDB();

        String sql = "INSERT INTO esconderijo (preco, encantamento, grau) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, esconderijo.getPreco());
            pst.setString(2, String.valueOf(esconderijo.getEncantamento()));
            pst.setString(3, String.valueOf(esconderijo.getGrau()));
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
    public boolean deleteEsconderijo(int id) {
        connectToDB();
        String sql = "DELETE FROM esconderijo where id=?";
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
    public ArrayList<Esconderijo> selectEsconderijo() {
        ArrayList<Esconderijo> esconderijos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM esconderijo";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de esconderijos: ");

            while (rs.next()) {

                Esconderijo esconderijoAux = new Esconderijo(rs.getInt("id"),rs.getInt("preco"),rs.getInt("encantamento"),rs.getInt("grau"));

                System.out.println("id = " + esconderijoAux.getId());
                System.out.println("encantamento = " + esconderijoAux.getEncantamento());
                System.out.println("grau = " + esconderijoAux.getGrau());
                System.out.println("preco = " + esconderijoAux.getPreco());
                System.out.println("--------------------------------");

                esconderijos.add(esconderijoAux);
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
        return esconderijos;
    }
}

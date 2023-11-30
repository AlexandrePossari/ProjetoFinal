package org.example.DAO;

import org.example.models.Capuz;

import java.sql.SQLException;

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

}


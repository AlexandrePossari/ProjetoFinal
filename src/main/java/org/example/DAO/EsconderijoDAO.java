package org.example.DAO;

import org.example.models.Capuz;
import org.example.models.Esconderijo;

import java.sql.SQLException;

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
}

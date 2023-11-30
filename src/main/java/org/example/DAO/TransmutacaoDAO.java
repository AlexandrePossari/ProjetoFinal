package org.example.DAO;

import org.example.models.Esconderijo;
import org.example.models.Transmutacao;

import java.sql.SQLException;

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
}

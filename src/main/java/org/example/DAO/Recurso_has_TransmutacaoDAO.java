package org.example.DAO;

import org.example.models.Couro;
import org.example.models.Esconderijo;
import org.example.models.Recurso;

import java.sql.SQLException;
import java.util.ArrayList;

public class Recurso_has_TransmutacaoDAO extends ConnectionDAO{
    boolean sucesso;
    public ArrayList<Couro> selectRecurso() {
        ArrayList<Couro> recursos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM recurso;";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("Lista de Recursos: ");

            while (rs.next()) {

                Couro recursoAux = new Couro(rs.getInt("id"),rs.getInt("quantidade"),rs.getInt("preco"),rs.getInt("encantamento"),rs.getInt("grau"));

                System.out.println("id = " + recursoAux.getId());
                System.out.println("quantidade = " + recursoAux.getQuantidade());
                System.out.println("encantamento = " + recursoAux.getEncantamento());
                System.out.println("grau = " + recursoAux.getGrau());
                System.out.println("preco = " + recursoAux.getPreco());
                System.out.println("--------------------------------");

                recursos.add(recursoAux);
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
        return recursos;
    }

    //INSERT
    public boolean insertRecursoHasTransmutacao(int idTransmutacao, int idRecurso) {
        boolean sucesso;

        connectToDB();
        String sql = "INSERT INTO Recurso_has_Transmutacao (Recurso_id, Transmutacao_id) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, (idRecurso));
            pst.setInt(2, (idTransmutacao));
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

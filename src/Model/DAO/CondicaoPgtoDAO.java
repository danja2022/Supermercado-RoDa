package Model.DAO;

import Model.bo.CondicaoPgto;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class CondicaoPgtoDAO implements InterfaceDAO<CondicaoPgto> {

    @Override
    public void create(CondicaoPgto objeto) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar = "INSERT INTO condicaopagamento (descricaoCondicao, numeroParcelas, diasPrimeiraParcela, "
                + " diasEntreParcela, status)"
                + " VALUES(?,?,?,?,?);";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoCondicao());
            pstm.setInt(2, objeto.getNumeroParcelas());
            pstm.setInt(3, objeto.getDiasPrimeiraParcela());
            pstm.setInt(4, objeto.getDiaEntreParcela());
            pstm.setString(5, String.valueOf(objeto.getStatus()));

            pstm.executeUpdate();
            ConnectionFactory.closeConnection(conexao, pstm);

        } catch (SQLException ex) {
            Logger.getLogger(CondicaoPgtoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionFactory.closeConnection(conexao, pstm);
        }

    }

    @Override
    public CondicaoPgto retrieve(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricaoCondicao, numeroParcelas, diasPrimeiraParcela, diasEntreParcela, status "
                + " FROM condicaopagamento"
                + " WHERE id = ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            CondicaoPgto condicaoPgto = new CondicaoPgto();

            while (rst.next()) {
                condicaoPgto.setId(rst.getInt("id"));
                condicaoPgto.setDescricaoCondicao(rst.getString("descricaoCondicao"));
                condicaoPgto.setNumeroParcelas(rst.getInt("numeroParcelas"));
                condicaoPgto.setDiasPrimeiraParcela(rst.getInt("diasPrimeiraParcela"));
                condicaoPgto.setDiaEntreParcela(rst.getInt("diasEntreParcela"));
                condicaoPgto.setStatus(rst.getString("status").charAt(0));

            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return condicaoPgto;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public CondicaoPgto retrieve(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricaoCondicao, numeroParcelas, diasPrimeiraParcela, diasEntreParcela, status  FROM condicaopagamento WHERE descricao = ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            CondicaoPgto condicaoPgto = new CondicaoPgto();

            while (rst.next()) {
                condicaoPgto.setId(rst.getInt("id"));
                condicaoPgto.setDescricaoCondicao(rst.getString("descricaoCondicao"));
                condicaoPgto.setNumeroParcelas(rst.getInt("numeroParcelas"));
                condicaoPgto.setDiasPrimeiraParcela(rst.getInt("diasPrimeiraParcela"));
                condicaoPgto.setDiaEntreParcela(rst.getInt("diasEntreParcela"));
                condicaoPgto.setStatus(rst.getString("status").charAt(0));

            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return condicaoPgto;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public List<CondicaoPgto> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricaoCondicao, numeroParcelas, diasPrimeiraParcela, diasEntreParcela, status FROM condicaoPgto ";

        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<CondicaoPgto> listacondicaoPgto = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();

            while (rst.next()) {
                CondicaoPgto condicaoPgto = new CondicaoPgto();
                condicaoPgto.setId(rst.getInt("id"));
                condicaoPgto.setDescricaoCondicao(rst.getString("descricaoCondicao"));
                condicaoPgto.setNumeroParcelas(rst.getInt("diasPrimeiraParcela"));
                condicaoPgto.setDiasPrimeiraParcela(rst.getInt("diasEntreParcela"));
                condicaoPgto.setStatus(rst.getString("status").charAt(0));
                listacondicaoPgto.add(condicaoPgto);

            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listacondicaoPgto;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }

    }

    @Override
    public void update(CondicaoPgto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE condicaopagamento SET descricaoCondicao = ?, numeroParcelas = ?, diasPrimeiraParcela = ?, diasEntreParcela = ?, status = ? ,  "
                + "WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoCondicao());
            pstm.setInt(2, objeto.getNumeroParcelas());
            pstm.setInt(3, objeto.getDiasPrimeiraParcela());
            pstm.setInt(4, objeto.getDiaEntreParcela());
            pstm.setString(5, String.valueOf(objeto.getStatus()));

            pstm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public int delete(CondicaoPgto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}

package Model.DAO;

import java.sql.Connection;
import Model.bo.Cidade;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAO.ConnectionFactory;

public class CidadeDAO implements InterfaceDAO<Cidade> {

    @Override
    public void create(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cidade (descricao) VALUES (?)";
        PreparedStatement pstm = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(0, objeto.getDescricao());
            pstm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public Cidade retrieve(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT cidade.id, bairro.descricao from cidade where cidade.id = ?";

        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(0, codigo);
            rst = pstm.executeQuery();
            Cidade cidade = new Cidade();

            while (rst.next()) {
                cidade.setCidade(codigo);
                cidade.setDescricao(rst.getString("descricao"));

            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cidade;

        } catch (SQLException ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Cidade retrieve(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT cidade.id, cidade.descricao from bairro where cidade.descricao = ?";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;
        
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(0, descricao);
            rst = pstm.executeQuery();
            Cidade cidade = new Cidade();
            
            while (rst.next()){
                cidade.setCidade(rst.getInt("id"));
                cidade.setDescricao(rst.getString("descricao"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return cidade;
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
            
        }
            
        
    }

    @Override
    public List<Cidade> retrieve() {
       Connection conexao = ConnectionFactory.getConnection();
       String sqlExecutar = "SELECT cidade.id, cidade.descricao from cidade";
       
       PreparedStatement pstm = null;
       ResultSet rst = null;
       
       List<Cidade> listaCidade = new ArrayList<>();
       
       
       
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            while (rst.next()) {
            Cidade cidade = new Cidade();
            cidade.setCidade(rst.getInt("id"));
            cidade.setDescricao(rst.getString("descricao"));
            listaCidade.add(cidade);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaCidade;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
       
      
    }

    @Override
    public void update(Cidade objeto) {
       Connection conexao = ConnectionFactory.getConnection();
       String sqlExecutar = "UPDATE cidade set cidade.descricao = ? where cidade.id = ?";
       PreparedStatement pstm = null;
       
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
           
            pstm.setString(0,objeto.getDescricao());
            
            pstm.setInt(1, objeto.getCidade());
            pstm.executeUpdate();
       
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Cidade objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM cidade where cidade.id = ?";
        PreparedStatement pstm = null;
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(0, objeto.getCidade());
            pstm.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
       ConnectionFactory.closeConnection(conexao,pstm);
    
    }

}

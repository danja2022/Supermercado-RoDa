
package Model.DAO;

import Model.bo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.DAO.ConnectionFactory;
import Model.bo.Endereco;
import java.util.ArrayList;


public class ClienteDAO implements InterfaceDAO<Cliente> {

    @Override
    public void create(Cliente objeto) {
        Connection conexao = ConnectionFactory.getConnection();

        
        String sqlExecutar = "INSERT INTO cliente (nome, fone1, fone2, "
                + " complemento, email, dataCadastro, observacao, status, CPF, rg, dataNascimento, endereco_id, sexo) "
                 + " VALUES(?,?,?,?,?,NOW(),?,?,?,?,?,?,?);";

        // select 
        PreparedStatement pstm = null;       
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1,objeto.getNome());
            pstm.setString(2,objeto.getFone());
            pstm.setString(3,objeto.getFone2());
            pstm.setString(4,objeto.getComplementoEndereco());
            pstm.setString(5,objeto.getEmail());
 
            pstm.setString(6, objeto.getObservacao());
            
            pstm.setString(7, String.valueOf(objeto.getStatus()));
            
            pstm.setString(8,objeto.getCpf());
            pstm.setString(9, objeto.getRg());
            pstm.setString(10, objeto.getDtNascimento());
            pstm.setInt(11, objeto.getEndereco().getId());
            pstm.setString(12, String.valueOf(objeto.getSexo()));
            pstm.executeUpdate();
            ConnectionFactory.closeConnection(conexao, pstm);
        
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionFactory.closeConnection(conexao, pstm);
        }
        
        
        
    }

    @Override
    public Cliente retrieve(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente retrieve(String descricao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, nome, fone1, fone2, complemento, email, dataCadastro, observacao, status, cpf, rg, dataNascimento, endereco_id, sexo FROM cliente";
        
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Cliente> listaCliente = new ArrayList<>();
        
        try{
           pstm = conexao.prepareStatement(sqlExecutar);
           rst = pstm.executeQuery();
           
           
           while(rst.next()){
            Cliente cliente = new Cliente();
            cliente.setId(rst.getInt("id"));
            cliente.setNome(rst.getString("nome"));
            cliente.setFone(rst.getString("fone1"));
            cliente.setFone2(rst.getString("fone2"));
            cliente.setComplementoEndereco(rst.getString("complemento"));
            cliente.setEmail(rst.getString("email"));
            cliente.setDtCadastro(rst.getString("dataCadastro"));
            cliente.setObservacao(rst.getString("observacao"));
            cliente.setStatus(rst.getString("status").charAt(0));
            cliente.setCpf(rst.getString("cpf"));
            cliente.setRg(rst.getString("rg"));
            cliente.setDtNascimento(rst.getString("dataNascimento"));
            Endereco endereco = new Endereco();
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            endereco = enderecoDAO.retrieve(cliente.getId());
            cliente.setEndereco(endereco);
            cliente.setSexo(rst.getString("sexo").charAt(0));
            
            listaCliente.add(cliente);
           }
           ConnectionFactory.closeConnection(conexao, pstm, rst);
           return listaCliente;  
            
        }catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionFactory.closeConnection(conexao, pstm);
            return null;
        }
            
    }

    @Override
    public void update(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

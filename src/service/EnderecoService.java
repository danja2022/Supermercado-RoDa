
package service;


import Model.DAO.EnderecoDAO;
import Model.bo.Endereco;
import java.util.List;

public class EnderecoService {
    
    public static void criar(Endereco objeto) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.create(objeto);
    }

    public static Endereco buscar(int codigo) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        
        
      return enderecoDAO.retrieve(codigo);
    }

    public static Endereco buscar(String descricao) {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrieve(descricao);

    }

    public static List<Endereco> buscar() {
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        return enderecoDAO.retrieve();

    }

    public static void atualizar(Endereco objeto) {

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.update(objeto);
    }

    public static int excluir(Endereco objeto) {
         EnderecoDAO enderecoDAO = new EnderecoDAO();
           return enderecoDAO.delete(objeto);
        
    }

}

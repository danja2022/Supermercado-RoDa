
package service;

import Model.DAO.CondicaoPgtoDAO;
import Model.bo.CondicaoPgto;
import java.util.List;


public class CondPagService {
    
    public static void criar(CondicaoPgto objeto) {
        CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
        condicaoPgtoDAO.create(objeto);
    }

    public static CondicaoPgto buscar(int codigo) {
       CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();

        return condicaoPgtoDAO.retrieve(codigo);
    }

    public static CondicaoPgto buscar(String descricao) {
        CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
        return condicaoPgtoDAO.retrieve(descricao);

    }

    public static List<CondicaoPgto> buscar() {
        CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
        return condicaoPgtoDAO.retrieve();

    }

    public static void atualizar(CondicaoPgto objeto) {

        CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
        condicaoPgtoDAO.update(objeto);
    }

    public static int excluir(CondicaoPgto objeto) {
        CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
        return condicaoPgtoDAO.delete(objeto);

    }
}

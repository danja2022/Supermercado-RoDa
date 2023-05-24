
package service;

import Model.DAO.ClasseDAO;
import Model.bo.Classe;
import java.util.List;

public class ClasseService {
    public static void criar(Classe objeto) {
        ClasseDAO classeDAO = new ClasseDAO();
        classeDAO.create(objeto);
    }

    public static Classe buscar(int codigo) {
       ClasseDAO classeDAO = new ClasseDAO();

        return classeDAO.retrieve(codigo);
    }

    public static Classe buscar(String descricao) {
        ClasseDAO classeDAO = new ClasseDAO();
        return classeDAO.retrieve(descricao);

    }

    public static List<Classe> buscar() {
        ClasseDAO classeDAO = new ClasseDAO();
        return classeDAO.retrieve();

    }

    public static void atualizar(Classe objeto) {

        ClasseDAO classeDAO = new ClasseDAO();
        classeDAO.update(objeto);
    }

    public static int excluir(Classe objeto) {
        ClasseDAO classeDAO = new ClasseDAO();
        return classeDAO.delete(objeto);

    }
}

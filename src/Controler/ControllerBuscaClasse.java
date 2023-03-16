package Controler;

import Model.DAO.ClasseDAO;
import Model.bo.Cidade;
import Model.bo.Classe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.FoBuscaClasses;

public class ControllerBuscaClasse implements ActionListener {

    FoBuscaClasses foBuscaClasses;

    public ControllerBuscaClasse(FoBuscaClasses foBuscaClasses) {
        this.foBuscaClasses = foBuscaClasses;

        foBuscaClasses.getjButtonCarregar().addActionListener(this);
        foBuscaClasses.getjButtonSair().addActionListener(this);

        //carregar
        
        DefaultTableModel tabela = (DefaultTableModel) this.foBuscaClasses.getjTablebusca().getModel();
        ClasseDAO classeDAO = new ClasseDAO();
        for (Classe classeAtualDaLista: classeDAO.retrieve()){
        
            tabela.addRow(new Object[]{classeAtualDaLista.getId(),
                                        classeAtualDaLista.getDescricao()});
        
        
        }
        
    }



@Override
        public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaClasses.getjButtonCarregar()){
           
        }
        
        if (acao.getSource() == this.foBuscaClasses.getjButtonSair()){
           this.foBuscaClasses.dispose();
        }
    }

}



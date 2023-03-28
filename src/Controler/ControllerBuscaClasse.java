package Controler;

import Model.DAO.ClasseDAO;
import Model.bo.Classe;
import Controler.ControllerCadClasse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.FoBuscaClasses;

public class ControllerBuscaClasse implements ActionListener {

    FoBuscaClasses foBuscaClasses;
    ControllerCadClasse cadClasse;

    public ControllerBuscaClasse(FoBuscaClasses foBuscaClasses, ControllerCadClasse aCadClasse) {
        this.foBuscaClasses = foBuscaClasses;
        this.cadClasse = aCadClasse;

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
             if(this.foBuscaClasses.getjTablebusca().getValueAt(this.foBuscaClasses.getjTablebusca().getSelectedRow(),0) != null){
                this.cadClasse.atualizaCampos((int) this.foBuscaClasses.getjTablebusca().getValueAt(this.foBuscaClasses.getjTablebusca().getSelectedRow(),0));
                this.foBuscaClasses.dispose();
            }
           
        }
        
        if (acao.getSource() == this.foBuscaClasses.getjButtonSair()){
           this.foBuscaClasses.dispose();
        }
    }

}



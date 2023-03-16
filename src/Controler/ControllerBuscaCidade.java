package Controler;

import Model.DAO.CidadeDAO;
import Model.bo.Cidade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import view.FoBuscaCidade;

public class ControllerBuscaCidade implements ActionListener {

    FoBuscaCidade foBuscaCidade;

    //fazer o que irá acontecer quando carregar ou quando sair
    public ControllerBuscaCidade(FoBuscaCidade foBuscaCidade) {

        this.foBuscaCidade = foBuscaCidade;

        foBuscaCidade.getjButtonCarregarBuscaCidade().addActionListener(this);
        foBuscaCidade.getjButtonSairBuscaCidades().addActionListener(this);

        //carregar
        DefaultTableModel tabela = (DefaultTableModel) this.foBuscaCidade.getjTablebusca().getModel();
        
        CidadeDAO cidadeDAO = new CidadeDAO();
       
        for (Cidade cidadeAtualDaLista : cidadeDAO.retrieve()) {
            
            //codigo para repassar do cidadeAtualDaLista para dentro da tablemodel
               tabela.addRow(new Object[]{cidadeAtualDaLista.getCidade(),
                                   cidadeAtualDaLista.getDescricao()});
            



            
        }
        
       
            
            
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaCidade.getjButtonCarregarBuscaCidade()) {

        }

        if (acao.getSource() == this.foBuscaCidade.getjButtonSairBuscaCidades()) {
            this.foBuscaCidade.dispose();
        }

    }
}

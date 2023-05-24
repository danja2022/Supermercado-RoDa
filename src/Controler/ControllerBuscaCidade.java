package Controler;

import Model.DAO.CidadeDAO;
import Model.bo.Cidade;
import Controler.ControllerCadCidade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import service.CidadeService;
import view.FoBuscaCidade;

public class ControllerBuscaCidade implements ActionListener {

    FoBuscaCidade foBuscaCidade;
    ControllerCadCidade cadCidade;

    //fazer o que irá acontecer quando carregar ou quando sair
    public ControllerBuscaCidade(FoBuscaCidade foBuscaCidade, ControllerCadCidade aCadCidade) {

        this.foBuscaCidade = foBuscaCidade;
        this.cadCidade = aCadCidade;

        foBuscaCidade.getjButtonCarregarBuscaCidade().addActionListener(this);
        foBuscaCidade.getjButtonSairBuscaCidades().addActionListener(this);

        //carregar
        DefaultTableModel tabela = (DefaultTableModel) this.foBuscaCidade.getjTablebusca().getModel();

      

        for (Cidade cidadeAtualDaLista : CidadeService.buscar()) {

            //codigo para repassar do cidadeAtualDaLista para dentro da tablemodel
            tabela.addRow(new Object[]{cidadeAtualDaLista.getId(),
                cidadeAtualDaLista.getDescricao()});

        }

    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaCidade.getjButtonCarregarBuscaCidade()) {
            if(this.foBuscaCidade.getjTablebusca().getValueAt(this.foBuscaCidade.getjTablebusca().getSelectedRow(),0) != null){
                this.cadCidade.atualizaCampos((int) this.foBuscaCidade.getjTablebusca().getValueAt(this.foBuscaCidade.getjTablebusca().getSelectedRow(),0));
                this.foBuscaCidade.dispose();
            }

        }

        if (acao.getSource() == this.foBuscaCidade.getjButtonSairBuscaCidades()) {
            this.foBuscaCidade.dispose();
        }

    }
}


package Controler;

import Model.DAO.ColaboradorDAO;
import Model.bo.Colaborador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.FoBuscaColaborador;


public class ControllerBuscaColaborador implements ActionListener {

    FoBuscaColaborador foBuscaColaborador;
    
    public ControllerBuscaColaborador (FoBuscaColaborador foBuscaColaborador){
        this.foBuscaColaborador = foBuscaColaborador;
        
            
            foBuscaColaborador.getjButtonCarregar().addActionListener(this);
            foBuscaColaborador.getjButtonSair().addActionListener(this);
    
            //carregar
            
            DefaultTableModel tabela = (DefaultTableModel) this.foBuscaColaborador.getjTablebusca().getModel();
            ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
            for (Colaborador colaboradorAtualDaLista: colaboradorDAO.retrieve()) {
            
            
                tabela.addRow(new Object[]{colaboradorAtualDaLista.getId(),colaboradorAtualDaLista.getNome(),
                                           colaboradorAtualDaLista.getFone(),colaboradorAtualDaLista.getFone2(),
                                           colaboradorAtualDaLista.getComplementoEndereco(),colaboradorAtualDaLista.getEmail(),
                                           colaboradorAtualDaLista.getDtCadastro(),colaboradorAtualDaLista.getObservacao(),
                                           colaboradorAtualDaLista.getStatus(),colaboradorAtualDaLista.getLogin(),
                                           colaboradorAtualDaLista.getSenha()
                });
            
            }
            
            
            
            
   
}

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaColaborador.getjButtonCarregar()){
           
        }
        
        if (acao.getSource() == this.foBuscaColaborador.getjButtonSair()){
           this.foBuscaColaborador.dispose();
        }
    }
}
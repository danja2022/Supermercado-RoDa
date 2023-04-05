
package Controler;

import Model.DAO.FornecedorDAO;
import Model.bo.Fornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.FoBuscaFornecedor;


public class ControllerBuscaFornecedor implements ActionListener {
    FoBuscaFornecedor   foBuscaFornecedor; 
    ControllerCadFornecedor cadFornecedor;
    
    public ControllerBuscaFornecedor (FoBuscaFornecedor foBuscaFornecedor, ControllerCadFornecedor cadFornecedor){
        this.foBuscaFornecedor = foBuscaFornecedor;
        this.cadFornecedor = cadFornecedor;
        
            
            foBuscaFornecedor.getjButtonCarregar().addActionListener(this);
            foBuscaFornecedor.getjButtonSair().addActionListener(this);
            
            //carregar
            
            DefaultTableModel tabela = (DefaultTableModel) this.foBuscaFornecedor.getjTablebusca().getModel();
            FornecedorDAO fornecedorDAO = new FornecedorDAO ();
            for (Fornecedor fornecedorAtualdaLista: fornecedorDAO.retrieve()){
            
                tabela.addRow((new Object[]{fornecedorAtualdaLista.getId(),fornecedorAtualdaLista.getNome(),fornecedorAtualdaLista.getFone(),
                    fornecedorAtualdaLista.getDtCadastro(),fornecedorAtualdaLista.getRazaoSocial(),fornecedorAtualdaLista.getStatus()}));}
            
            
            
            
            }
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaFornecedor.getjButtonCarregar()){
           if(this.foBuscaFornecedor.getjTablebusca().getValueAt(this.foBuscaFornecedor.getjTablebusca().getSelectedRow(), 0) != null){
               this.cadFornecedor.atualizaCampos((int) this.foBuscaFornecedor.getjTablebusca().getValueAt(this.foBuscaFornecedor.getjTablebusca().getSelectedRow(), 0));
               this.foBuscaFornecedor.dispose();
           }
        }
        
        if (acao.getSource() == this.foBuscaFornecedor.getjButtonSair()){
           this.foBuscaFornecedor.dispose();
        }
            
    }
    
}


package Controler;

import Model.DAO.FornecedorDAO;
import Model.bo.Fornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.FoBuscaFornecedor;


public class ControllerBuscaFornecedor implements ActionListener {
    FoBuscaFornecedor   foBuscaFornecedor; 
    
    public ControllerBuscaFornecedor (FoBuscaFornecedor foBuscaFornecedor){
        this.foBuscaFornecedor = foBuscaFornecedor;
        
            
            foBuscaFornecedor.getjButtonCarregar().addActionListener(this);
            foBuscaFornecedor.getjButtonSair().addActionListener(this);
            
            //carregar
            
            DefaultTableModel tabela = (DefaultTableModel) this.foBuscaFornecedor.getjTablebusca().getModel();
            FornecedorDAO fornecedorDAO = new FornecedorDAO ();
            for (Fornecedor fornecedorAtualdaLista: fornecedorDAO.retrieve()){
            
                tabela.addRow((new Object[]{fornecedorAtualdaLista.getId(),fornecedorAtualdaLista.getNome(),fornecedorAtualdaLista.getFone(),
                    fornecedorAtualdaLista.getFone2(),fornecedorAtualdaLista.getComplementoEndereco(),fornecedorAtualdaLista.getEmail(),
                    fornecedorAtualdaLista.getDtCadastro(),fornecedorAtualdaLista.getObservacao(),fornecedorAtualdaLista.getStatus(),
                    fornecedorAtualdaLista.getCnpj(),fornecedorAtualdaLista.getInscEstadual(),
                    fornecedorAtualdaLista.getContato(),fornecedorAtualdaLista.getRazaoSocial(),
                    fornecedorAtualdaLista.getCpf(),fornecedorAtualdaLista.getRg()}));            }
            
            
            
            
            }
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaFornecedor.getjButtonCarregar()){
           
        }
        
        if (acao.getSource() == this.foBuscaFornecedor.getjButtonSair()){
           this.foBuscaFornecedor.dispose();
        }
            
    }
    
}

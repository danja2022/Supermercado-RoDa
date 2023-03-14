
package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FoBuscaFornecedor;


public class ControllerBuscaFornecedor implements ActionListener {
    FoBuscaFornecedor   foBuscaFornecedor; 
    
    public ControllerBuscaFornecedor (FoBuscaFornecedor foBuscaFornecedor){
        this.foBuscaFornecedor = foBuscaFornecedor;
        
            
            foBuscaFornecedor.getjButtonCarregar().addActionListener(this);
            foBuscaFornecedor.getjButtonSair().addActionListener(this);
            
            
            //carregar
            
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

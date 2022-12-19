
package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FoBuscaProduto;


public class ControllerBuscaProduto implements ActionListener {

    FoBuscaProduto foBuscaProduto;
    
    public ControllerBuscaProduto (FoBuscaProduto foBuscaProduto){
        this.foBuscaProduto = foBuscaProduto;
        
            
            foBuscaProduto.getjButtonCarregar().addActionListener(this);
            foBuscaProduto.getjButtonSair().addActionListener(this);
            
            
            //carregar
            
            }
    
    
    @Override
    public void actionPerformed(ActionEvent acao) {
    if (acao.getSource() == this.foBuscaProduto.getjButtonCarregar()){
           
        }
        
        if (acao.getSource() == this.foBuscaProduto.getjButtonSair()){
           this.foBuscaProduto.dispose();
        }
    }
    
}

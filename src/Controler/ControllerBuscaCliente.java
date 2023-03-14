
package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.FoBuscaCliente;


public class ControllerBuscaCliente implements ActionListener {

    FoBuscaCliente foBuscaCliente;
    
    public ControllerBuscaCliente (FoBuscaCliente foBuscaCliente){
        this.foBuscaCliente = foBuscaCliente;
        
            
            foBuscaCliente.getjButtonCarregar().addActionListener(this);
            foBuscaCliente.getjButtonSair().addActionListener(this);
            
            
            //carregar
            
            }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent acao) {
       if (acao.getSource() == this.foBuscaCliente.getjButtonCarregar()){
           
        }
        
        if (acao.getSource() == this.foBuscaCliente.getjButtonSair()){
           this.foBuscaCliente.dispose();
        }
    }
    
}

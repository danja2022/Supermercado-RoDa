
package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FoBuscaEndereco;


public class ControllerBuscaEndereco implements ActionListener {

    FoBuscaEndereco foBuscaEndereco;
    
     public ControllerBuscaEndereco (FoBuscaEndereco foBuscaEndereco){
        this.foBuscaEndereco = foBuscaEndereco;
        
            
            foBuscaEndereco.getjButtonCarregar().addActionListener(this);
            foBuscaEndereco.getjButtonSair().addActionListener(this);
            
            
            //carregar
            }
    
     
    @Override
    public void actionPerformed(ActionEvent acao) {
      if (acao.getSource() == this.foBuscaEndereco.getjButtonCarregar()){
           
        }
        
        if (acao.getSource() == this.foBuscaEndereco.getjButtonSair()){
           this.foBuscaEndereco.dispose();
        }
            
        }
  }
    


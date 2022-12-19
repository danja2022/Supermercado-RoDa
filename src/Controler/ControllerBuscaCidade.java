
package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FoBuscaCidade;


public class ControllerBuscaCidade implements ActionListener {

    FoBuscaCidade foBuscaCidade;
    
    
    //fazer o que irá acontecer quando carregar ou quando sair
    
    
    
     public ControllerBuscaCidade (FoBuscaCidade foBuscaCidade){
        this.foBuscaCidade = foBuscaCidade;
        
            
            foBuscaCidade.getjButtonCarregarBuscaCidade().addActionListener(this);
            foBuscaCidade.getjButtonSairBuscaCidades().addActionListener(this);
            
            
            //carregar
            
  }
  
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaCidade.getjButtonCarregarBuscaCidade()){
           
        }
        
        if (acao.getSource() == this.foBuscaCidade.getjButtonSairBuscaCidades()){
           this.foBuscaCidade.dispose();
        }
            
        }
 }
    


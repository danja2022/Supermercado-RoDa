
package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FoBuscaBairro;


/**
 *
 * @author Daniel
 */
public class ControllerBuscaBairro implements ActionListener {

    
    FoBuscaBairro foBuscaBairro;
    
    
    //fazer o que irá acontecer quando carregar ou quando sair
    
    
    
     public ControllerBuscaBairro (FoBuscaBairro foBuscaBairro){
        this.foBuscaBairro = foBuscaBairro;
        
            
            foBuscaBairro.getjButtonCarregar().addActionListener(this);
            foBuscaBairro.getjButtonSair().addActionListener(this);
            
            
            //carregar
            
            }
   
 /** 
 
 */
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaBairro.getjButtonCarregar()){
           
        }
        
        if (acao.getSource() == this.foBuscaBairro.getjButtonSair()){
           this.foBuscaBairro.dispose();
        }
            
        }

}

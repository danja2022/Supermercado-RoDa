
package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FoBuscaMarca;


public class ControllerBuscaMarca implements ActionListener {

    FoBuscaMarca foBuscaMarca;
    
    public ControllerBuscaMarca (FoBuscaMarca foBuscaMarca){
        this.foBuscaMarca = foBuscaMarca;
        
            
            foBuscaMarca.getjButtonCarregar().addActionListener(this);
            foBuscaMarca.getjButtonSair().addActionListener(this);
            
            
            //carregar
            
            }
    
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaMarca.getjButtonCarregar()){
           
        }
        
        if (acao.getSource() == this.foBuscaMarca.getjButtonSair()){
           this.foBuscaMarca.dispose();
        }
    }
    
}

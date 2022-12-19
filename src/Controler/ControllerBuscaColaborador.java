
package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FoBuscaColaborador;


public class ControllerBuscaColaborador implements ActionListener {

    FoBuscaColaborador foBuscaColaborador;
    
    public ControllerBuscaColaborador (FoBuscaColaborador foBuscaColaborador){
        this.foBuscaColaborador = foBuscaColaborador;
        
            
            foBuscaColaborador.getjButtonCarregar().addActionListener(this);
            foBuscaColaborador.getjButtonSair().addActionListener(this);
    
   
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
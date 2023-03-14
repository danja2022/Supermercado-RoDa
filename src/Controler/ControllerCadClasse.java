
/*package Controler;*/
package Controler;

import Model.bo.Classe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FoBuscaClasses;


import view.FoCadastroClasse;


public class ControllerCadClasse implements ActionListener {

FoCadastroClasse telaCadClasse;

 public ControllerCadClasse (FoCadastroClasse parTelaCadClasse){
        this.telaCadClasse = parTelaCadClasse;

        telaCadClasse.getBtBuscar().addActionListener(this);
            telaCadClasse.getBtCancelar().addActionListener(this);
            telaCadClasse.getBtSalvar().addActionListener(this);
            telaCadClasse.getBtNovo().addActionListener(this);
            telaCadClasse.getBtSair().addActionListener(this);
    
            
    
            telaCadClasse.ativa(true);
            telaCadClasse.ligaDesliga(false);
            
            }


    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadClasse.getBtNovo()) {
            telaCadClasse.ativa(false);
            telaCadClasse.ligaDesliga(true);
            telaCadClasse.getjTextFieldIdClasse().setEnabled(false);
            
        } else if (acao.getSource() == telaCadClasse.getBtCancelar()) {
            telaCadClasse.ativa(true);
            telaCadClasse.ligaDesliga(false);
        
        } else if (acao.getSource() == telaCadClasse.getBtSalvar()){
            
            if (telaCadClasse.getjTextFieldDescricaoClasseProduto().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "O campo descrição é bbrigatório");
            } else {
                
                Classe classe = new Classe();
                classe.setDescricao(telaCadClasse.getjTextFieldDescricaoClasseProduto().getText());
                
                
                telaCadClasse.ativa(true);
                telaCadClasse.ligaDesliga(false);
                
            }
            
            
             } else if (acao.getSource() == telaCadClasse.getBtBuscar()) {
            
            FoBuscaClasses telaBuscaClasses = new FoBuscaClasses();
            ControllerBuscaClasse controllerBuscaClasse = new ControllerBuscaClasse(telaBuscaClasses) {};
            telaBuscaClasses.setVisible(true);
    } else if (acao.getSource() == telaCadClasse.getBtSair()) {
            telaCadClasse.dispose();
    }
  }
}

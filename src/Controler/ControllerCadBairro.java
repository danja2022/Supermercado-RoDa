
package Controler;

import Model.bo.Bairro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FoCadBairroFinal;
import view.FoBuscaBairro;
import Controler.ControllerBuscaBairro;





public class ControllerCadBairro implements ActionListener
{
    
    FoCadBairroFinal telaCadBairro;
    
    public ControllerCadBairro (FoCadBairroFinal parTelaCadBairro){
        this.telaCadBairro = parTelaCadBairro;
        
            
            telaCadBairro.getBtBuscar().addActionListener(this);
            telaCadBairro.getBtCancelar().addActionListener(this);
            telaCadBairro.getBtSalvar().addActionListener(this);
            telaCadBairro.getBtNovo().addActionListener(this);
            telaCadBairro.getBtSair().addActionListener(this);
    
            
    
            telaCadBairro.ativa(true);
            telaCadBairro.ligaDesliga(false);
            
            }

    @Override
    public void actionPerformed(ActionEvent acao) {

        if (acao.getSource() == telaCadBairro.getBtNovo()) {
            telaCadBairro.ativa(false);
            telaCadBairro.ligaDesliga(true);
            telaCadBairro.getjTextFieldId().setEnabled(false);

        } else if (acao.getSource() == telaCadBairro.getBtCancelar()) {
            telaCadBairro.ativa(true);
            telaCadBairro.ligaDesliga(false);

        } else if (acao.getSource() == telaCadBairro.getBtSalvar()) {
            
            if (telaCadBairro.getjTextFieldBairro().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo descrição é obrigatório");
            } else {
                
                Bairro bairro = new Bairro();
                bairro.setDescricao(telaCadBairro.getjTextFieldBairro().getText());
                
                //persistir o objeto de bairro criado
                
                telaCadBairro.ativa(true);
                telaCadBairro.ligaDesliga(false);
            }

        } else if (acao.getSource() == telaCadBairro.getBtBuscar()) {
            
            FoBuscaBairro telaBuscaBairro = new FoBuscaBairro();
            ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(telaBuscaBairro) {};
            telaBuscaBairro.setVisible(true);
            
        } else if (acao.getSource() == telaCadBairro.getBtSair()) {
            telaCadBairro.dispose();
        }
    }
    
    
}

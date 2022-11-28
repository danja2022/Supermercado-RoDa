
package Controler;

import Model.bo.Bairro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FoCadBairroFinal;





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
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            } else {
                
                Bairro bairro = new Bairro();
                bairro.setDescricao(telaCadBairro.getjTextFieldBairro().getText());
                
                //persistir o objeto de bairro criado
                
                telaCadBairro.ativa(true);
                telaCadBairro.ligaDesliga(false);
            }

        } else if (acao.getSource() == telaCadBairro.getBtBuscar()) {

            // Carregar a tela da busca
        } else if (acao.getSource() == telaCadBairro.getBtSair()) {
            telaCadBairro.dispose();
        }
    }
    
    
}

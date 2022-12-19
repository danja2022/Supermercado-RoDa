
package Controler;


import Model.bo.Cidade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FoBuscaBairro;
import view.FoBuscaCidade;
import view.FoCadCidade;



public class ControllerCadCidade implements ActionListener {

       FoCadCidade telaCadCidade;
    
        public ControllerCadCidade (FoCadCidade partelaCadCidade){
        this.telaCadCidade = partelaCadCidade;
    
            telaCadCidade.getBtBuscar().addActionListener(this);
            telaCadCidade.getBtCancelar().addActionListener(this);
            telaCadCidade.getBtSalvar().addActionListener(this);
            telaCadCidade.getBtNovo().addActionListener(this);
            telaCadCidade.getBtSair().addActionListener(this);
    
            
    
            telaCadCidade.ativa(true);
            telaCadCidade.ligaDesliga(false);
            
            }
    
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        
        if (acao.getSource() == telaCadCidade.getBtNovo()) {
            telaCadCidade.ativa(false);
            telaCadCidade.ligaDesliga(true);
            telaCadCidade.getjTextFieldCadCidade().setEnabled(false);
        }   else if (acao.getSource() == telaCadCidade.getBtCancelar()){
            telaCadCidade.ativa(true);
            telaCadCidade.ligaDesliga(false);
        }   else if (acao.getSource() == telaCadCidade.getBtSalvar()){
            if (telaCadCidade.getjTextFieldCadCity().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            } else {
                Cidade cidade = new Cidade();
                cidade.setDescricao(telaCadCidade.getjTextFieldCadCity().getText());
                
                telaCadCidade.ativa(true);
                telaCadCidade.ligaDesliga(false);
            }
            
        } else if (acao.getSource() == telaCadCidade.getBtBuscar()){
            
            FoBuscaCidade telaBuscaCidade = new FoBuscaCidade();
            ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(telaBuscaCidade) {};
            telaBuscaCidade.setVisible(true);
            
        }   else if (acao.getSource() == telaCadCidade.getBtSair()) {
            telaCadCidade.dispose();
            
        }
    }
}

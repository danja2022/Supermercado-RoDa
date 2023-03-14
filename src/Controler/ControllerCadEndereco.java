
package Controler;


import Model.bo.Endereco;
import Model.bo.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FoCadastroEndereco;
import view.FoBuscaEndereco;


public class ControllerCadEndereco implements ActionListener {
    
    FoCadastroEndereco telaCadEndereco;
    
    
    public ControllerCadEndereco (FoCadastroEndereco partelaCadEndereco){
        this.telaCadEndereco = partelaCadEndereco;
    
            telaCadEndereco.getBtBuscar().addActionListener(this);
            telaCadEndereco.getBtCancelar().addActionListener(this);
            telaCadEndereco.getBtSalvar().addActionListener(this);
            telaCadEndereco.getBtNovo().addActionListener(this);
            telaCadEndereco.getBtSair().addActionListener(this);
    
            
    
            telaCadEndereco.ativa(true);
            telaCadEndereco.ligaDesliga(false);
            
            }
           
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        
         if (acao.getSource() == telaCadEndereco.getBtNovo()) {
            telaCadEndereco.ativa(false);
            telaCadEndereco.ligaDesliga(true);
            telaCadEndereco.getjTextFieldCadIdEndereco().setEnabled(false);
        }  else if (acao.getSource() == telaCadEndereco.getBtCancelar()){
            telaCadEndereco.ativa(true);
            telaCadEndereco.ligaDesliga(false);
            
        }   else if (acao.getSource() == telaCadEndereco.getBtSalvar()){
                if (telaCadEndereco.getjTextFieldCep().getText().trim().equalsIgnoreCase("")){
                     JOptionPane.showMessageDialog(null, "Atributo CEP é Obrigatório");
                } else if (telaCadEndereco.getjTextFieldDescricaoLogradouro().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Logradouro é Obrigatório");
                }else{
                Endereco endereco = new Endereco();
                endereco.setCep(telaCadEndereco.getjTextFieldCep().getText());
                endereco.setLogradouro(telaCadEndereco.getjTextFieldDescricaoLogradouro().getText());

                
                telaCadEndereco.ativa(true);
                telaCadEndereco.ligaDesliga(false);
            }   
                
            }  else if (acao.getSource() == telaCadEndereco.getBtBuscar()){
            
                FoBuscaEndereco telaBuscaEndereco = new FoBuscaEndereco();
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(telaBuscaEndereco) {};
            telaBuscaEndereco.setVisible(true);
                
            }  else if (acao.getSource() == telaCadEndereco.getBtSair()) {
            telaCadEndereco.dispose();
        }
    }

}
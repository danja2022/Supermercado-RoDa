
package Controler;

import Model.bo.Marca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FoBuscaMarca;
import view.FoCadastroMarca;


public class ControllerCadMarca implements ActionListener {
    
    FoCadastroMarca telaCadMarca;
    
    
    public ControllerCadMarca (FoCadastroMarca partelaCadMarca){
        this.telaCadMarca = partelaCadMarca;
    
    
            telaCadMarca.getBtBuscar().addActionListener(this);
            telaCadMarca.getBtCancelar().addActionListener(this);
            telaCadMarca.getBtSalvar().addActionListener(this);
            telaCadMarca.getBtNovo().addActionListener(this);
            telaCadMarca.getBtSair().addActionListener(this);
    
            
    
            telaCadMarca.ativa(true);
            telaCadMarca.ligaDesliga(false);
            
            }
    
    

    @Override
    public void actionPerformed(ActionEvent acao) {
       if (acao.getSource() == telaCadMarca.getBtNovo()) {
            telaCadMarca.ativa(false);
            telaCadMarca.ligaDesliga(true);
            telaCadMarca.getjTextFieldIdMarca().setEnabled(false);
       
       }   else if (acao.getSource() == telaCadMarca.getBtCancelar()) {
            telaCadMarca.ativa(true);
            telaCadMarca.ligaDesliga(false);
    
       }    else if (acao.getSource() == telaCadMarca.getBtSalvar()){

       if (telaCadMarca.getjTextFieldCadMarca().getText().trim().equalsIgnoreCase("")) {
           JOptionPane.showMessageDialog(null, "Campo Marca é Obrigatório");
       } else {
           
                Marca marca = new Marca();
                marca.setDescricao(telaCadMarca.getjTextFieldCadMarca().getText());
                
                 //persistir o objeto de bairro criado
                
                telaCadMarca.ativa(true);
                telaCadMarca.ligaDesliga(false);
            }
           
       } else if (acao.getSource() == telaCadMarca.getBtBuscar()){
            FoBuscaMarca telaBuscaMarca = new FoBuscaMarca();
            ControllerBuscaMarca controllerBuscaMarca = new ControllerBuscaMarca(telaBuscaMarca) {};
            telaBuscaMarca.setVisible(true);
           
       }else if (acao.getSource() == telaCadMarca.getBtSair()){
            telaCadMarca.dispose();
       }
    }
}

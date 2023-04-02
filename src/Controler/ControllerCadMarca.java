
package Controler;

import Model.DAO.MarcaDAO;
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
    public void atualizaCampos(int codigo){
        Marca marca = new Marca();
        MarcaDAO marcaDAO = new MarcaDAO();
        marca = marcaDAO.retrieve(codigo);
        
        telaCadMarca.ativa(false);
        telaCadMarca.ligaDesliga(true);
        
        
        
        
        
        telaCadMarca.getjTextFieldIdMarca().setText(marca.getId()+"");
        telaCadMarca.getjTextFieldCadMarca().setText(marca.getDescricao());
        telaCadMarca.getjTextFieldIdMarca().setEnabled(false);
        
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
                MarcaDAO marcaDAO = new MarcaDAO();
                marca.setDescricao(telaCadMarca.getjTextFieldCadMarca().getText());
                
                 //persistir o objeto de bairro criado
                if (telaCadMarca.getjTextFieldIdMarca().getText().equalsIgnoreCase("")) {
                    marcaDAO.create(marca);
                }else{
                    marca.setId(Integer.parseInt(telaCadMarca.getjTextFieldIdMarca().getText()));
                    marcaDAO.update(marca);
                    
                }
                
                
                
                telaCadMarca.ativa(true);
                telaCadMarca.ligaDesliga(false);
            }
           
       } else if (acao.getSource() == telaCadMarca.getBtBuscar()){
            FoBuscaMarca telaBuscaMarca = new FoBuscaMarca();
            ControllerBuscaMarca controllerBuscaMarca = new ControllerBuscaMarca(telaBuscaMarca, this) {};
            telaBuscaMarca.setVisible(true);
           
       }else if (acao.getSource() == telaCadMarca.getBtSair()){
            telaCadMarca.dispose();
       }
    }
}

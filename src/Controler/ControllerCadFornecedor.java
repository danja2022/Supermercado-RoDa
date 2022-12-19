
package Controler;


import Model.bo.Fornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FoBuscaFornecedor;
import view.FoCadastroFornecedor;


public class ControllerCadFornecedor implements ActionListener {

    
    FoCadastroFornecedor telaCadFornecedor;
    
    public ControllerCadFornecedor (FoCadastroFornecedor partelaCadFornecedor){
        this.telaCadFornecedor = partelaCadFornecedor;
        
            
            telaCadFornecedor.getBtBuscar().addActionListener(this);
            telaCadFornecedor.getBtCancelar().addActionListener(this);
            telaCadFornecedor.getBtSalvar().addActionListener(this);
            telaCadFornecedor.getBtNovo().addActionListener(this);
            telaCadFornecedor.getBtSair().addActionListener(this);
    
            
    
            telaCadFornecedor.ativa(true);
            telaCadFornecedor.ligaDesliga(false);
            
            }
   
    
    @Override
    public void actionPerformed(ActionEvent acao) {
      if (acao.getSource() == telaCadFornecedor.getBtNovo()) {
            telaCadFornecedor.ativa(false);
            telaCadFornecedor.ligaDesliga(true);
            telaCadFornecedor.getjTextFieldIdCadFornecedor().setEnabled(false);

        } else if (acao.getSource() == telaCadFornecedor.getBtCancelar()) {
            telaCadFornecedor.ativa(true);
            telaCadFornecedor.ligaDesliga(false);

        } else if (acao.getSource() == telaCadFornecedor.getBtSalvar()) {
            
            if (telaCadFornecedor.getTfNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção!Os campos com '*' são obrigatórios!");
            } else {
                
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setNome(telaCadFornecedor.getTfNome().getText());
                
                
                
                telaCadFornecedor.ativa(true);
                telaCadFornecedor.ligaDesliga(false);
            }

        } else if (acao.getSource() == telaCadFornecedor.getBtBuscar()) {

            FoBuscaFornecedor telaBuscaFornecedor = new FoBuscaFornecedor();
            ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(telaBuscaFornecedor) {};
            telaBuscaFornecedor.setVisible(true);
        
        } else if (acao.getSource() == telaCadFornecedor.getBtSair()) {
            telaCadFornecedor.dispose();
        }
        
    }
    
}

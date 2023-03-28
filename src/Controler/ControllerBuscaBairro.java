
package Controler;

import Model.DAO.BairroDAO;
import Model.bo.Bairro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.FoBuscaBairro;


public class ControllerBuscaBairro implements ActionListener {

    
    FoBuscaBairro foBuscaBairro;
    ControllerCadBairro CCadBairro;
    
    
    //fazer o que irá acontecer quando carregar ou quando sair
    
    
    
     public ControllerBuscaBairro (FoBuscaBairro foBuscaBairro, ControllerCadBairro controllerCadBairro){
        this.foBuscaBairro = foBuscaBairro;
        this.CCadBairro = controllerCadBairro;
        
            
            this.foBuscaBairro.getjButtonCarregar().addActionListener(this);
            this.foBuscaBairro.getjButtonSair().addActionListener(this);
            
            //carregar
            
            DefaultTableModel tabela = (DefaultTableModel) this.foBuscaBairro.getjTablebusca().getModel();
            BairroDAO bairroDAO = new BairroDAO();
            for (Bairro objetoAtualDaLista: bairroDAO.retrieve()) {
                
      
               tabela.addRow(new Object[]{objetoAtualDaLista.getId(),
                                       objetoAtualDaLista.getDescricao()}); 
                
            }
            
            
            }
   
 /** 
 
 */
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaBairro.getjButtonCarregar()){
           
            if(this.foBuscaBairro.getjTablebusca().getValueAt(this.foBuscaBairro.getjTablebusca().getSelectedRow(), 0)!= null){
               this.CCadBairro.atualizaCampos((int) this.foBuscaBairro.getjTablebusca().getValueAt(this.foBuscaBairro.getjTablebusca().getSelectedRow(), 0));
               this.foBuscaBairro.dispose();
            }
        }
        
      if (acao.getSource() == this.foBuscaBairro.getjButtonSair()){
           this.foBuscaBairro.dispose();
           
        }
            
        }
    
   }


package Controler;

import Model.DAO.EnderecoDAO;
import Model.bo.Endereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.FoBuscaEndereco;


public class ControllerBuscaEndereco implements ActionListener {

    FoBuscaEndereco foBuscaEndereco;
    
     public ControllerBuscaEndereco (FoBuscaEndereco foBuscaEndereco){
        this.foBuscaEndereco = foBuscaEndereco;
        
            
            foBuscaEndereco.getjButtonCarregar().addActionListener(this);
            foBuscaEndereco.getjButtonSair().addActionListener(this);
            
            
            //carregar
            
            DefaultTableModel tabela = (DefaultTableModel) this.foBuscaEndereco.getjTablebusca().getModel();
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            for (Endereco enderecoAtualDaLista: enderecoDAO.retrieve()){
            
                tabela.addRow(new Object[]{enderecoAtualDaLista.getId(),enderecoAtualDaLista.getLogradouro(),enderecoAtualDaLista.getCep()});
            
            
            }
            
            
            
            }
    
     
    @Override
    public void actionPerformed(ActionEvent acao) {
      if (acao.getSource() == this.foBuscaEndereco.getjButtonCarregar()){
           
        }
        
        if (acao.getSource() == this.foBuscaEndereco.getjButtonSair()){
           this.foBuscaEndereco.dispose();
        }
            
        }
  }
    


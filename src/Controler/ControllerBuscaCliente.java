
package Controler;

import Model.DAO.ClienteDAO;
import Model.bo.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import view.FoBuscaCliente;


public class ControllerBuscaCliente implements ActionListener {

    FoBuscaCliente foBuscaCliente;
    
    public ControllerBuscaCliente (FoBuscaCliente foBuscaCliente){
        this.foBuscaCliente = foBuscaCliente;
        
            
            foBuscaCliente.getjButtonCarregar().addActionListener(this);
            foBuscaCliente.getjButtonSair().addActionListener(this);
            
            //carregar
            
            DefaultTableModel tabela = (DefaultTableModel) this.foBuscaCliente.getjTablebusca().getModel();
            ClienteDAO clienteDAO = new ClienteDAO();
            for (Cliente clienteAtualDaLista: clienteDAO.retrieve()){
            
                tabela.addRow(new Object[]{clienteAtualDaLista.getId(),
                                           clienteAtualDaLista.getNome(),clienteAtualDaLista.getCpf(),clienteAtualDaLista.getRg(),clienteAtualDaLista.getDtNascimento(),
                                           clienteAtualDaLista.getSexo(),clienteAtualDaLista.getFone(),clienteAtualDaLista.getFone2(),clienteAtualDaLista.getEndereco(),
                                           clienteAtualDaLista.getObservacao(), clienteAtualDaLista.getDtCadastro(), clienteAtualDaLista.getStatus()});
               
            
            
            }
            
            }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent acao) {
       if (acao.getSource() == this.foBuscaCliente.getjButtonCarregar()){
           
        }
        
        if (acao.getSource() == this.foBuscaCliente.getjButtonSair()){
           this.foBuscaCliente.dispose();
        }
    }
    
}

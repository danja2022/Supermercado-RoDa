
package Controler;

import Model.DAO.ClienteDAO;
import Model.bo.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import service.ClienteService;

import view.FoBuscaCliente;


public class ControllerBuscaCliente implements ActionListener {

    FoBuscaCliente foBuscaCliente;
    ControllerCadCliente cadCliente;
    
    
    public ControllerBuscaCliente (FoBuscaCliente foBuscaCliente, ControllerCadCliente cCadCliente){
        this.foBuscaCliente = foBuscaCliente;
        this.cadCliente = cCadCliente;
        
            
            foBuscaCliente.getjButtonCarregar().addActionListener(this);
            foBuscaCliente.getjButtonSair().addActionListener(this);
            
            //carregar
            
            DefaultTableModel tabela = (DefaultTableModel) this.foBuscaCliente.getjTablebusca().getModel();
            ClienteDAO clienteDAO = new ClienteDAO();
            for (Cliente clienteAtualDaLista: ClienteService.buscar()){
            
                tabela.addRow(new Object[]{clienteAtualDaLista.getId(),
                                           clienteAtualDaLista.getNome(),clienteAtualDaLista.getSexo(),clienteAtualDaLista.getFone(),clienteAtualDaLista.getFone2(),
                                           clienteAtualDaLista.getDtCadastro(), clienteAtualDaLista.getStatus()});
                                           
               
            
            
            }
            
            }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent acao) {
       if (acao.getSource() == this.foBuscaCliente.getjButtonCarregar()){
           if(this.foBuscaCliente.getjTablebusca().getValueAt(this.foBuscaCliente.getjTablebusca().getSelectedRow(), 0) != null){
               this.cadCliente.atualizaCampos((int) this.foBuscaCliente.getjTablebusca().getValueAt(this.foBuscaCliente.getjTablebusca().getSelectedRow(),0));
               this.foBuscaCliente.dispose();
           }
               
           
        }
        
        if (acao.getSource() == this.foBuscaCliente.getjButtonSair()){
           this.foBuscaCliente.dispose();
        }
    }
    
}


package Controler;

import Model.DAO.MarcaDAO;
import Model.bo.Marca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.FoBuscaMarca;


public class ControllerBuscaMarca implements ActionListener {

    FoBuscaMarca foBuscaMarca;
    
    public ControllerBuscaMarca (FoBuscaMarca foBuscaMarca){
        this.foBuscaMarca = foBuscaMarca;
        
            
            foBuscaMarca.getjButtonCarregar().addActionListener(this);
            foBuscaMarca.getjButtonSair().addActionListener(this);
            
            
            //carregar
            DefaultTableModel tabela = (DefaultTableModel) this.foBuscaMarca.getjTablebusca().getModel();
            MarcaDAO marcaDAO = new MarcaDAO();
            for(Marca marcaAtualDaLista: marcaDAO.retrieve()){
            
                tabela.addRow(new Object[]{marcaAtualDaLista.getId(),marcaAtualDaLista.getDescricao()});
            
            }
            
            
            
            }
    
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaMarca.getjButtonCarregar()){
           
        }
        
        if (acao.getSource() == this.foBuscaMarca.getjButtonSair()){
           this.foBuscaMarca.dispose();
        }
    }
    
}

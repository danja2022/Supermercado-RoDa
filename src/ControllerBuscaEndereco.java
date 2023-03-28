package Controler;

import Model.DAO.EnderecoDAO;
import Model.bo.Endereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.FoBuscaEndereco;

public class ControllerBuscaEndereco implements ActionListener {

    FoBuscaEndereco foBuscaEndereco;
    ControllerCadEndereco cadEndereco;

    public ControllerBuscaEndereco(FoBuscaEndereco foBuscaEndereco, ControllerCadEndereco enderecoCad) {
        this.foBuscaEndereco = foBuscaEndereco;
        this.cadEndereco = enderecoCad;

        this.foBuscaEndereco.getjButtonCarregar().addActionListener(this);
        this.foBuscaEndereco.getjButtonSair().addActionListener(this);

        //carregar
        DefaultTableModel tabela = (DefaultTableModel) this.foBuscaEndereco.getjTablebusca().getModel();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        for (Endereco enderecoAtualDaLista : enderecoDAO.retrieve()) {

            tabela.addRow(new Object[]{enderecoAtualDaLista.getId(), enderecoAtualDaLista.getLogradouro(), enderecoAtualDaLista.getCep(),
                enderecoAtualDaLista.getBairro().getDescricao(), enderecoAtualDaLista.getCidade().getDescricao()});

        }

    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaEndereco.getjButtonCarregar()) {
            if(this.foBuscaEndereco.getjTablebusca().getValueAt(this.foBuscaEndereco.getjTablebusca().getSelectedRow(), 0)!= null){
               this.cadEndereco.atualizaCampos((int) this.foBuscaEndereco.getjTablebusca().getValueAt(this.foBuscaEndereco.getjTablebusca().getSelectedRow(), 0));
               this.foBuscaEndereco.dispose();
            } 

        }

        if (acao.getSource() == this.foBuscaEndereco.getjButtonSair()) {
            this.foBuscaEndereco.dispose();
        }

    }
}

package Controler;

import Model.DAO.MarcaDAO;
import Model.DAO.ProdutoDAO;
import Model.bo.Marca;
import Model.bo.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.FoBuscaProduto;

public class ControllerBuscaProduto implements ActionListener {

    FoBuscaProduto foBuscaProduto;
    ControllerCadastroProduto cadProduto;

    public ControllerBuscaProduto(FoBuscaProduto foBuscaProduto, ControllerCadastroProduto cadProduto) {
        this.cadProduto = cadProduto;
        this.foBuscaProduto = foBuscaProduto;

        this.foBuscaProduto.getjButtonCarregar().addActionListener(this);
        this.foBuscaProduto.getjButtonSair().addActionListener(this);

        //carregar
        DefaultTableModel tabela = (DefaultTableModel) this.foBuscaProduto.getjTablebusca().getModel();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        for (Produto produtoAtualDaLista : produtoDAO.retrieve()) {

            tabela.addRow(new Object[]{produtoAtualDaLista.getId(), produtoAtualDaLista.getDescricao(),
                produtoAtualDaLista.getValorVenda(),
                produtoAtualDaLista.getMarca().getDescricao(),
                produtoAtualDaLista.getDataCadastro(),
                produtoAtualDaLista.getStatus()
            });

        }

    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaProduto.getjButtonCarregar()) {
             if(this.foBuscaProduto.getjTablebusca().getValueAt(this.foBuscaProduto.getjTablebusca().getSelectedRow(),0) != null){
                this.cadProduto.atualizaCampos((int) this.foBuscaProduto.getjTablebusca().getValueAt(this.foBuscaProduto.getjTablebusca().getSelectedRow(),0));
                this.foBuscaProduto.dispose();
        }
        }

        if (acao.getSource() == this.foBuscaProduto.getjButtonSair()) {
            this.foBuscaProduto.dispose();
        }
    }

}

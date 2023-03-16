package Controler;

import Model.DAO.ProdutoDAO;
import Model.bo.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.FoBuscaProduto;

public class ControllerBuscaProduto implements ActionListener {

    FoBuscaProduto foBuscaProduto;

    public ControllerBuscaProduto(FoBuscaProduto foBuscaProduto) {
        this.foBuscaProduto = foBuscaProduto;

        foBuscaProduto.getjButtonCarregar().addActionListener(this);
        foBuscaProduto.getjButtonSair().addActionListener(this);

        //carregar
        DefaultTableModel tabela = (DefaultTableModel) this.foBuscaProduto.getjTablebusca().getModel();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        for (Produto produtoAtualDaLista: produtoDAO.retrieve()){
        
            tabela.addRow(new Object[]{produtoAtualDaLista.getId(),produtoAtualDaLista.getDescricao(),produtoAtualDaLista.getValorCompra(),
                                        produtoAtualDaLista.getValorVenda(),produtoAtualDaLista.getUndCompra(),produtoAtualDaLista.getUndVenda(),
                                        produtoAtualDaLista.getFatorConversao(),produtoAtualDaLista.getStatus(),produtoAtualDaLista.getDataCadastro(),
                                        produtoAtualDaLista.getBarraEntrada(),produtoAtualDaLista.getBarraSaida(),produtoAtualDaLista.getEstoqueMinimo(),
                                        produtoAtualDaLista.getEstoqueMaximo()});
        
        }
            
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == this.foBuscaProduto.getjButtonCarregar()) {

        }

        if (acao.getSource() == this.foBuscaProduto.getjButtonSair()) {
            this.foBuscaProduto.dispose();
        }
    }

}

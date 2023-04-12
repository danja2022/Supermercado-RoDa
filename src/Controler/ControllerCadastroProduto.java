package Controler;

import Model.DAO.ClasseDAO;
import Model.DAO.MarcaDAO;
import Model.DAO.ProdutoDAO;
import Model.bo.Classe;
import Model.bo.Marca;
import Model.bo.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import view.FoBuscaProduto;
import view.FoCadastroProduto;

public class ControllerCadastroProduto implements ActionListener {

    FoCadastroProduto telaCadProduto;

    public ControllerCadastroProduto(FoCadastroProduto parTelaCadProduto) {
        this.telaCadProduto = parTelaCadProduto;

        telaCadProduto.getBtBuscar().addActionListener(this);
        telaCadProduto.getBtCancelar().addActionListener(this);
        telaCadProduto.getBtSalvar().addActionListener(this);
        telaCadProduto.getBtNovo().addActionListener(this);
        telaCadProduto.getBtSair().addActionListener(this);
        telaCadProduto.getBtCadMarca().addActionListener(this);
        telaCadProduto.getBtCadClasse().addActionListener(this);

        telaCadProduto.ativa(true);
        telaCadProduto.ligaDesliga(false);
        setComboBox();

    }

    //2002-06-10
    private String dateToString(String data) {
        String aData = "";
        int dia = 8, mes = 5, ano = 0;

        for (int i = dia; i < (dia + 2); i++) {
            aData = aData + data.charAt(i);
        }
        //  aData = aData + '-';
        for (int i = mes; i < (mes + 2); i++) {
            aData = aData + data.charAt(i);
        }
        //   aData = aData + '-';
        for (int i = ano; i < (ano + 4); i++) {
            aData = aData + data.charAt(i);
        }
        return aData;
    }

    public void setComboBox() {
        List<Marca> listaMarca = new ArrayList<>();
        List<Classe> listaClasse = new ArrayList<>();
        MarcaDAO marcaDAO = new MarcaDAO();
        ClasseDAO classeDAO = new ClasseDAO();

        listaMarca = marcaDAO.retrieve();
        listaClasse = classeDAO.retrieve();

        telaCadProduto.getjComboBoxClasse().removeAllItems();
        telaCadProduto.getjComboBoxMarca().removeAllItems();

        for (Marca marca : listaMarca) {
            telaCadProduto.getjComboBoxMarca().addItem(marca.getDescricao());
        }
        for (Classe classe : listaClasse) {
            telaCadProduto.getjComboBoxClasse().addItem(classe.getDescricao());
        }
    }

    public void atualizaCampos(int codigo) {

        telaCadProduto.ativa(false);
        telaCadProduto.ligaDesliga(true);
        Produto produto = new Produto();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        produto = produtoDAO.retrieve(codigo);

        telaCadProduto.getjTextFieldId().setText(produto.getId() + "");
        telaCadProduto.getjTextFieldEstoqMin().setText(produto.getEstoqueMinimo() + "");
        telaCadProduto.getjTextFieldEstoqMax().setText(produto.getEstoqueMaximo() + "");
        telaCadProduto.getjComboBoxClasse().setSelectedItem(produto.getClasse().getDescricao());
        telaCadProduto.getjComboBoxMarca().setSelectedItem(produto.getMarca().getDescricao());
        if (produto.getStatus() == 'A') {
            telaCadProduto.getjRadioBtAtivo().setSelected(true);
        } else {
            telaCadProduto.getjRadioBtInativo().setSelected(true);
        }
        telaCadProduto.getjTextFieldBarraEntrada().setText(produto.getBarraEntrada());
        telaCadProduto.getjTextFieldBarraSaida().setText(produto.getBarraSaida());
        telaCadProduto.getjFTextFieldDtCadastro().setText(dateToString(produto.getDataCadastro()));
        telaCadProduto.getjTextFieldFatorConversao().setText(produto.getFatorConversao() + "");
        telaCadProduto.getjTextFieldNomeDescProd().setText(produto.getDescricao());
        telaCadProduto.getjTextFieldUnidadeCompra().setText(produto.getUndCompra());
        telaCadProduto.getjTextFieldUnidadeVenda().setText(produto.getUndVenda());
        telaCadProduto.getjTextFieldValorCompra().setText(produto.getValorCompra() + "");
        telaCadProduto.getjTextFieldValorVenda().setText(produto.getValorVenda() + "");

    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadProduto.getBtNovo()) {
            telaCadProduto.ativa(false);
            telaCadProduto.ligaDesliga(true);

            //devo criar o text field de cada um?; Quero entender o que está acontecendo nessa parte do código;
        } else if (acao.getSource() == telaCadProduto.getBtCancelar()) {
            telaCadProduto.ativa(true);
            telaCadProduto.ligaDesliga(false);

        } else if (acao.getSource() == telaCadProduto.getBtSalvar()) {
            //campo descrição mercadoria será obrigatório
            if (telaCadProduto.getjTextFieldNomeDescProd().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            } else if (telaCadProduto.getjTextFieldValorCompra().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Valor Compra é Obrigatório");
            } else if (telaCadProduto.getjTextFieldValorVenda().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Valor Venda é Obrigatório");
            } else {
                Produto produto = new Produto();
                produto.setDescricao(telaCadProduto.getjTextFieldNomeDescProd().getText());
                produto.setValorVenda(parseFloat(telaCadProduto.getjTextFieldValorVenda().getText()));
                produto.setValorCompra(parseFloat(telaCadProduto.getjTextFieldValorCompra().getText()));

                if (!telaCadProduto.getjTextFieldEstoqMin().getText().trim().equalsIgnoreCase("")) {
                    produto.setEstoqueMinimo(parseFloat(telaCadProduto.getjTextFieldEstoqMin().getText()));
                } else {
                    produto.setEstoqueMinimo(0);
                }

                if (!telaCadProduto.getjTextFieldEstoqMax().getText().trim().equalsIgnoreCase("")) {
                    produto.setEstoqueMaximo(parseFloat(telaCadProduto.getjTextFieldEstoqMax().getText()));
                } else {
                    produto.setEstoqueMinimo(0);
                }

                //está certo?
                if (!telaCadProduto.getjTextFieldUnidadeCompra().getText().trim().equalsIgnoreCase("")) {
                    produto.setUndCompra(telaCadProduto.getjTextFieldUnidadeCompra().getText());
                } else {
                    produto.setUndCompra("");
                }
                //está certo?

                if (!telaCadProduto.getjTextFieldUnidadeVenda().getText().trim().equalsIgnoreCase("")) {
                    produto.setUndVenda(telaCadProduto.getjTextFieldUnidadeVenda().getText());
                } else {
                    produto.setUndVenda("");
                }

                //esta certo?
                if (!telaCadProduto.getjTextFieldFatorConversao().getText().trim().equalsIgnoreCase("")) {
                    produto.setFatorConversao(Integer.parseInt(telaCadProduto.getjTextFieldFatorConversao().getText()));
                } else {
                    produto.setFatorConversao(0);
                }

                //está certo?
                if (!telaCadProduto.getjTextFieldBarraEntrada().getText().trim().equalsIgnoreCase("")) {
                    produto.setBarraEntrada(telaCadProduto.getjTextFieldBarraEntrada().getText());
                } else {
                    produto.setBarraEntrada("");
                }

                //está certo?
                if (!telaCadProduto.getjTextFieldBarraSaida().getText().trim().equalsIgnoreCase("")) {
                    produto.setBarraSaida(telaCadProduto.getjTextFieldBarraSaida().getText());
                } else {
                    produto.setBarraSaida("");
                }

                if (telaCadProduto.getjRadioBtAtivo().isSelected()) {
                    produto.setStatus('A');
                } else {
                    produto.setStatus('I');
                }

                Marca marca = new Marca();
                Classe classe = new Classe();
                MarcaDAO marcaDAO = new MarcaDAO();
                ClasseDAO classeDAO = new ClasseDAO();
                classe = classeDAO.retrieve(telaCadProduto.getjComboBoxClasse().getSelectedItem().toString());
                marca = marcaDAO.retrieve(telaCadProduto.getjComboBoxMarca().getSelectedItem().toString());
                produto.setMarca(marca);
                produto.setClasse(classe);

                ProdutoDAO produtoDAO = new ProdutoDAO();
                if (telaCadProduto.getjTextFieldId().getText().trim().equalsIgnoreCase("")) {
                    produtoDAO.create(produto);
                } else {
                    produto.setId(Integer.parseInt(telaCadProduto.getjTextFieldId().getText().trim()));
                    produtoDAO.update(produto);

                }

                telaCadProduto.ativa(true);
                telaCadProduto.ligaDesliga(false);
            }

        } else if (acao.getSource() == telaCadProduto.getBtBuscar()) {
            FoBuscaProduto telaBuscaProduto = new FoBuscaProduto();
            ControllerBuscaProduto controllerBuscaProduto = new ControllerBuscaProduto(telaBuscaProduto, this) {
            };
            telaBuscaProduto.setVisible(true);

        } else if (acao.getSource() == telaCadProduto.getBtSair()) {
            telaCadProduto.dispose();
        }
    }

}

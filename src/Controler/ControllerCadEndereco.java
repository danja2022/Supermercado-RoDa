package Controler;

import Model.DAO.BairroDAO;
import Model.DAO.CidadeDAO;
import Model.DAO.EnderecoDAO;
import Model.bo.Bairro;
import Model.bo.Cidade;
import Model.bo.Endereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import view.FoCadastroEndereco;
import view.FoBuscaEndereco;
import view.FoCadBairroFinal;
import view.FoCadCidade;

public class ControllerCadEndereco implements ActionListener {

    FoCadastroEndereco telaCadEndereco;
    ControllerCadCliente cadCliente;
    ControllerCadFornecedor cadFornecedor;
    ControllerCadColaborador cadColaborador;

    public ControllerCadEndereco(FoCadastroEndereco partelaCadEndereco) {
        this.telaCadEndereco = partelaCadEndereco;
        this.cadCliente = null;
        this.cadFornecedor = null;
        this.cadColaborador = null;

        adicionaAction();

    }

    public ControllerCadEndereco(FoCadastroEndereco partelaCadEndereco, ControllerCadCliente cadCliente) {
        this.telaCadEndereco = partelaCadEndereco;
        this.cadCliente = cadCliente;
        this.cadFornecedor = null;
        this.cadColaborador = null;

        adicionaAction();

    }

    public ControllerCadEndereco(FoCadastroEndereco partelaCadEndereco, ControllerCadFornecedor cadFornecedor) {
        this.telaCadEndereco = partelaCadEndereco;
        this.cadCliente = null;
        this.cadFornecedor = cadFornecedor;
        this.cadColaborador = null;

        adicionaAction();

    }

    public ControllerCadEndereco(FoCadastroEndereco partelaCadEndereco, ControllerCadColaborador cadColaborador) {
        this.telaCadEndereco = partelaCadEndereco;
        this.cadCliente = null;
        this.cadFornecedor = null;
        this.cadColaborador = cadColaborador;

        adicionaAction();

    }

    private void adicionaAction() {
        telaCadEndereco.getBtBuscar().addActionListener(this);
        telaCadEndereco.getBtCancelar().addActionListener(this);
        telaCadEndereco.getBtSalvar().addActionListener(this);
        telaCadEndereco.getBtNovo().addActionListener(this);
        telaCadEndereco.getBtSair().addActionListener(this);
        telaCadEndereco.getjBtCadBairro().addActionListener(this);
        telaCadEndereco.getjBtCadCidade().addActionListener(this);
        telaCadEndereco.getBtDeletar().addActionListener(this);

        telaCadEndereco.ativa(true);
        telaCadEndereco.ligaDesliga(false);
        setComboBox();

    }

    public void atualizaCampos(int codigo) {
        Endereco endereco = new Endereco();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        endereco = enderecoDAO.retrieve(codigo);

        telaCadEndereco.ativa(false);
        telaCadEndereco.ligaDesliga(true);

        telaCadEndereco.getjTextFieldCadIdEndereco().setText(endereco.getId() + "");
        telaCadEndereco.getjTextFieldDescricaoLogradouro().setText(endereco.getLogradouro());
        telaCadEndereco.getjTfCep().setText(endereco.getCep() + "");

        telaCadEndereco.getjComboBoxBairro().setSelectedItem(endereco.getBairro().getDescricao());
        telaCadEndereco.getjComboBoxCidade().setSelectedItem(endereco.getCidade().getDescricao());

        telaCadEndereco.getjTextFieldCadIdEndereco().setEnabled(false);

    }

    public void setComboBox() {
        List<Cidade> listaCidade = new ArrayList<>();
        List<Bairro> listaBairro = new ArrayList<>();
        BairroDAO bairroDAO = new BairroDAO();
        CidadeDAO cidadeDAO = new CidadeDAO();

        listaCidade = cidadeDAO.retrieve();
        listaBairro = bairroDAO.retrieve();

        telaCadEndereco.getjComboBoxCidade().removeAllItems();
        telaCadEndereco.getjComboBoxBairro().removeAllItems();

        if (listaCidade != null) {
            for (Cidade cidade : listaCidade) {
                telaCadEndereco.getjComboBoxCidade().addItem(cidade.getDescricao());
            }
        }
        if (listaBairro != null) {
            for (Bairro bairro : listaBairro) {
                telaCadEndereco.getjComboBoxBairro().addItem(bairro.getDescricao());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent acao) {

        if (acao.getSource() == telaCadEndereco.getBtNovo()) {
            telaCadEndereco.ativa(false);
            telaCadEndereco.ligaDesliga(true);
            telaCadEndereco.getjTextFieldCadIdEndereco().setEnabled(false);
            //setComboBox();
        } else if (acao.getSource() == telaCadEndereco.getBtCancelar()) {
            telaCadEndereco.ativa(true);
            telaCadEndereco.ligaDesliga(false);

        } else if (acao.getSource() == telaCadEndereco.getBtSalvar()) {
            if (telaCadEndereco.getjTfCep().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo CEP é Obrigatório");
            } else if (telaCadEndereco.getjTextFieldDescricaoLogradouro().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Logradouro é Obrigatório");
            } else {
                Endereco endereco = new Endereco();
                Bairro bairro = new Bairro();
                Cidade cidade = new Cidade();
                BairroDAO bairroDAO = new BairroDAO();
                CidadeDAO cidadeDAO = new CidadeDAO();

                endereco.setCep(telaCadEndereco.getjTfCep().getText());
                endereco.setLogradouro(telaCadEndereco.getjTextFieldDescricaoLogradouro().getText());
                bairro = bairroDAO.retrieve(telaCadEndereco.getjComboBoxBairro().getSelectedItem().toString());
                cidade = cidadeDAO.retrieve(telaCadEndereco.getjComboBoxCidade().getSelectedItem().toString());
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);

                EnderecoDAO enderecoDAO = new EnderecoDAO();

                if (telaCadEndereco.getjTextFieldCadIdEndereco().getText().equalsIgnoreCase("")) {
                    enderecoDAO.create(endereco);
                } else {
                    endereco.setId(Integer.parseInt(telaCadEndereco.getjTextFieldCadIdEndereco().getText()));
                    enderecoDAO.update(endereco);
                }

                telaCadEndereco.ativa(true);
                telaCadEndereco.ligaDesliga(false);
            }

        } else if (acao.getSource() == telaCadEndereco.getBtBuscar()) {

            FoBuscaEndereco telaBuscaEndereco = new FoBuscaEndereco();
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(telaBuscaEndereco, this);
            telaBuscaEndereco.setVisible(true);

        } else if (acao.getSource() == telaCadEndereco.getBtSair()) {
            if (this.cadCliente != null) {
                this.cadCliente.setComboBox();
            } else if (this.cadFornecedor != null) {
                this.cadFornecedor.setComboBox();
            } else if (this.cadColaborador != null) {
                this.cadColaborador.setComboBox();
            }

            telaCadEndereco.dispose();

        } else if (acao.getSource() == telaCadEndereco.getjBtCadBairro()) {
            FoCadBairroFinal telaCadBairro = new FoCadBairroFinal();
            ControllerCadBairro cadBairro = new ControllerCadBairro(telaCadBairro, this);
            telaCadBairro.setVisible(true);
            // telaCadEndereco.ativa(true);
            //  telaCadEndereco.ligaDesliga(false);

        } else if (acao.getSource() == telaCadEndereco.getjBtCadCidade()) {
            FoCadCidade telaCadCidade = new FoCadCidade();
            ControllerCadCidade cadCidade = new ControllerCadCidade(telaCadCidade, this);
            telaCadCidade.setVisible(true);
            //telaCadEndereco.ativa(true);
            //telaCadEndereco.ligaDesliga(false);
        } else if (acao.getSource() == telaCadEndereco.getBtDeletar()) {
            if (!telaCadEndereco.getjTextFieldCadIdEndereco().getText().trim().equalsIgnoreCase("")) {
                Endereco endereco = new Endereco();
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrieve(Integer.parseInt(telaCadEndereco.getjTextFieldCadIdEndereco().getText()));

                if (enderecoDAO.delete(endereco) == -1) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar, verifique se o endereço está cadastrado em algum cliente/colaborador");
                } else {
                    telaCadEndereco.ativa(true);
                    telaCadEndereco.ligaDesliga(false);
                    setComboBox();
                }

            }
        }
    }

}

package Controler;

import Model.bo.Cidade;
import Model.DAO.CidadeDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FoBuscaBairro;
import view.FoBuscaCidade;
import view.FoCadCidade;

public class ControllerCadCidade implements ActionListener {

    FoCadCidade telaCadCidade;
    ControllerCadEndereco cadEndereco;

    public ControllerCadCidade(FoCadCidade partelaCadCidade) {
        this.telaCadCidade = partelaCadCidade;
        this.cadEndereco = null;

        telaCadCidade.getBtBuscar().addActionListener(this);
        telaCadCidade.getBtCancelar().addActionListener(this);
        telaCadCidade.getBtSalvar().addActionListener(this);
        telaCadCidade.getBtNovo().addActionListener(this);
        telaCadCidade.getBtSair().addActionListener(this);

        utilities.Utils.ativa(true, telaCadCidade.getjPanel4());
        utilities.Utils.ligaDesliga(false, telaCadCidade.getPnCentro());

    }

    public ControllerCadCidade(FoCadCidade telaCadCidade, ControllerCadEndereco cadEndereco) {
        this.telaCadCidade = telaCadCidade;
        this.cadEndereco = cadEndereco;

        this.telaCadCidade.getBtBuscar().addActionListener(this);
        this.telaCadCidade.getBtCancelar().addActionListener(this);
        this.telaCadCidade.getBtSalvar().addActionListener(this);
        this.telaCadCidade.getBtNovo().addActionListener(this);
        this.telaCadCidade.getBtSair().addActionListener(this);
        this.telaCadCidade.getBtDeletar().addActionListener(this);

        utilities.Utils.ativa(true, telaCadCidade.getjPanel4());
        utilities.Utils.ligaDesliga(false, telaCadCidade.getPnCentro());

    }

    public void atualizaCampos(int codigo) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        Cidade cidade = new Cidade();
        cidade = cidadeDAO.retrieve(codigo);

        utilities.Utils.ativa(false, telaCadCidade.getjPanel4());
        utilities.Utils.ligaDesliga(true, telaCadCidade.getPnCentro());
        telaCadCidade.getjTextFieldId().setText(cidade.getId() + "");
        telaCadCidade.getjTextFieldDescricao().setText(cidade.getDescricao());
        telaCadCidade.getjTextFieldId().setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent acao) {

        if (acao.getSource() == telaCadCidade.getBtNovo()) {
            utilities.Utils.ativa(false, telaCadCidade.getjPanel4());
            utilities.Utils.ligaDesliga(true, telaCadCidade.getPnCentro());
            telaCadCidade.getjTextFieldId().setEnabled(false);
        } else if (acao.getSource() == telaCadCidade.getBtCancelar()) {
            utilities.Utils.ativa(true, telaCadCidade.getjPanel4());
            utilities.Utils.ligaDesliga(false, telaCadCidade.getPnCentro());
        } else if (acao.getSource() == telaCadCidade.getBtSalvar()) {
            if (telaCadCidade.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            } else {
                Cidade cidade = new Cidade();
                CidadeDAO cidadeDAO = new CidadeDAO();
                cidade.setDescricao(telaCadCidade.getjTextFieldDescricao().getText());

                if (telaCadCidade.getjTextFieldId().getText().equalsIgnoreCase("")) {
                    cidadeDAO.create(cidade);
                } else {
                    cidade.setId(Integer.parseInt(telaCadCidade.getjTextFieldId().getText()));
                    cidadeDAO.update(cidade);
                }

                utilities.Utils.ativa(true, telaCadCidade.getjPanel4());
                utilities.Utils.ligaDesliga(false, telaCadCidade.getPnCentro());
            }

        } else if (acao.getSource() == telaCadCidade.getBtBuscar()) {

            FoBuscaCidade telaBuscaCidade = new FoBuscaCidade();
            ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(telaBuscaCidade, this) {
            };
            telaBuscaCidade.setVisible(true);

        } else if (acao.getSource() == telaCadCidade.getBtSair()) {
            if (this.cadEndereco != null) {
                this.cadEndereco.setComboBox();
            }
            telaCadCidade.dispose();
        } else if (acao.getSource() == telaCadCidade.getBtDeletar()) {
            if (!telaCadCidade.getjTextFieldId().getText().trim().equalsIgnoreCase("")) {
                Cidade cidade = new Cidade();
                CidadeDAO cidadeDAO = new CidadeDAO();
                cidade = cidadeDAO.retrieve(Integer.parseInt(telaCadCidade.getjTextFieldId().getText()));

                if (cidadeDAO.delete(cidade) == -1) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar. Verifique se a cidade está cadastrado em algum endereço");
                } else {
                    utilities.Utils.ativa(true, telaCadCidade.getjPanel4());
                    utilities.Utils.ligaDesliga(false, telaCadCidade.getPnCentro());
                }
            }
        }
    }
}

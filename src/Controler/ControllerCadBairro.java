package Controler;

import Model.bo.Bairro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FoCadBairroFinal;
import view.FoBuscaBairro;
import Controler.ControllerBuscaBairro;
import Model.DAO.BairroDAO;

public class ControllerCadBairro implements ActionListener {

    FoCadBairroFinal telaCadBairro;
    ControllerCadEndereco cadEndereco;

    // public static int codigo;
    public ControllerCadBairro(FoCadBairroFinal parTelaCadBairro) {
        this.telaCadBairro = parTelaCadBairro;
        this.cadEndereco = null;

        adicionaAction();

    }

    public ControllerCadBairro(FoCadBairroFinal telaCadBairro, ControllerCadEndereco cEndereco) {
        this.telaCadBairro = telaCadBairro;
        this.cadEndereco = cEndereco;

        adicionaAction();

    }

    private void adicionaAction() {
        this.telaCadBairro.getBtBuscar().addActionListener(this);
        this.telaCadBairro.getBtCancelar().addActionListener(this);
        this.telaCadBairro.getBtSalvar().addActionListener(this);
        this.telaCadBairro.getBtNovo().addActionListener(this);
        this.telaCadBairro.getBtSair().addActionListener(this);
        this.telaCadBairro.getBtDeletar().addActionListener(this);
        this.telaCadBairro.ativa(true);
        this.telaCadBairro.ligaDesliga(false);
        this.telaCadBairro.getjTextFieldBairro().setEnabled(false);

    }

    public void atualizaCampos(int Codigo) {
        Bairro bairro = new Bairro();
        BairroDAO bairroDAO = new BairroDAO();
        bairro = bairroDAO.retrieve(Codigo);

        telaCadBairro.ligaDesliga(true);
        telaCadBairro.ativa(false);
        //telaCadBairro.getjTextFieldBairro().setEnabled(true);

        telaCadBairro.getjTextFieldId().setText(bairro.getId() + "");
        telaCadBairro.getjTextFieldBairro().setText(bairro.getDescricao());
        telaCadBairro.getjTextFieldId().setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent acao) {

        if (acao.getSource() == telaCadBairro.getBtNovo()) {
            telaCadBairro.ativa(false);
            telaCadBairro.ligaDesliga(true);
            telaCadBairro.getjTextFieldId().setEnabled(false);

        } else if (acao.getSource() == telaCadBairro.getBtCancelar()) {
            telaCadBairro.ativa(true);
            telaCadBairro.ligaDesliga(false);

        } else if (acao.getSource() == telaCadBairro.getBtSalvar()) {

            if (telaCadBairro.getjTextFieldBairro().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo descrição é obrigatório");
            } else {

                Bairro bairro = new Bairro();
                bairro.setDescricao(telaCadBairro.getjTextFieldBairro().getText());

                //persistir o objeto de bairro criado
                BairroDAO bairroDAO = new Model.DAO.BairroDAO();

                if (this.telaCadBairro.getjTextFieldId().getText().equalsIgnoreCase("")) {
                    bairroDAO.create(bairro);
                } else {
                    bairro.setId(Integer.parseInt(telaCadBairro.getjTextFieldId().getText()));
                    bairroDAO.update(bairro);
                }
                telaCadBairro.ativa(true);
                telaCadBairro.ligaDesliga(false);
            }
        } //Mudará na proxima aula
        else if (acao.getSource() == telaCadBairro.getBtBuscar()) {

            //this.codigo = 0;
            FoBuscaBairro telaBuscaBairro = new FoBuscaBairro();
            ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(telaBuscaBairro, this);
            telaBuscaBairro.setVisible(true);

        } else if (acao.getSource() == telaCadBairro.getBtSair()) {
            if (this.cadEndereco != null) {
                this.cadEndereco.setComboBox();
            }
            telaCadBairro.dispose();
        } else if (acao.getSource() == telaCadBairro.getBtDeletar()) {
            if (!telaCadBairro.getjTextFieldId().getText().trim().equalsIgnoreCase("")) {
                Bairro bairro = new Bairro();
                BairroDAO bairroDAO = new BairroDAO();
                bairro = bairroDAO.retrieve(Integer.parseInt(telaCadBairro.getjTextFieldId().getText()));

                if (bairroDAO.delete(bairro) == -1) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar. Verifique se o bairro está cadastrado em algum endereço");
                } else {
                    telaCadBairro.ativa(true);
                    telaCadBairro.ligaDesliga(false);
                }
            }
        }
    }

}

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
    public static int codigo;

    public ControllerCadBairro(FoCadBairroFinal parTelaCadBairro) {
        this.telaCadBairro = parTelaCadBairro;

        telaCadBairro.getBtBuscar().addActionListener(this);
        telaCadBairro.getBtCancelar().addActionListener(this);
        telaCadBairro.getBtSalvar().addActionListener(this);
        telaCadBairro.getBtNovo().addActionListener(this);
        telaCadBairro.getBtSair().addActionListener(this);

        telaCadBairro.getjTextFieldId().setEditable(true);
        
        telaCadBairro.ativa(true);
        telaCadBairro.ligaDesliga(false);
        telaCadBairro.getjTextFieldBairro().setEnabled(false);

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

                    telaCadBairro.ativa(true);
                    telaCadBairro.ligaDesliga(false);
                }
            }
        }
        //Mudará na proxima aula
        else if (acao.getSource() == telaCadBairro.getBtBuscar()) {

            this.codigo = 0;

            FoBuscaBairro telaBuscaBairro = new FoBuscaBairro();
            ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(telaBuscaBairro);
            telaBuscaBairro.setVisible(true);

            if (this.codigo != 0) {
                //carregar bairro paara edicao

                Bairro bairro = new Bairro();
                BairroDAO bairroDAO = new BairroDAO();
                bairro = bairroDAO.retrieve(codigo);

                telaCadBairro.ativa(false);
                telaCadBairro.ligaDesliga(true);
                telaCadBairro.getjTextFieldId().setText(bairro.getId() + "");
                telaCadBairro.getjTextFieldBairro().setText(bairro.getDescricao());
                telaCadBairro.getjTextFieldId().setEnabled(false);
            }

        } else if (acao.getSource() == telaCadBairro.getBtSair()) {
            telaCadBairro.dispose();
        }
    }

}


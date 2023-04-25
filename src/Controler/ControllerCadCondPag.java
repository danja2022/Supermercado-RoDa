package Controler;

import Model.DAO.CondicaoPgtoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FoCadCondicaoPagamento;
import Model.bo.CondicaoPgto;
import javax.swing.JOptionPane;
import view.FoBuscaCondicaoPagamento;

public class ControllerCadCondPag implements ActionListener {

    FoCadCondicaoPagamento telaCadCondicaoPagamento;

    public ControllerCadCondPag(FoCadCondicaoPagamento partelacadCondiPagamento) {
        this.telaCadCondicaoPagamento = partelacadCondiPagamento;

        telaCadCondicaoPagamento.getBtBuscar().addActionListener(this);
        telaCadCondicaoPagamento.getBtCancelar().addActionListener(this);
        telaCadCondicaoPagamento.getBtSalvar().addActionListener(this);
        telaCadCondicaoPagamento.getBtNovo().addActionListener(this);
        telaCadCondicaoPagamento.getBtSair().addActionListener(this);
        telaCadCondicaoPagamento.getBtDeletar().addActionListener(this);

        telaCadCondicaoPagamento.ativa(true);
        telaCadCondicaoPagamento.ligaDesliga(false);

    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadCondicaoPagamento.getBtNovo()) {
            telaCadCondicaoPagamento.ativa(false);
            telaCadCondicaoPagamento.ligaDesliga(true);
            telaCadCondicaoPagamento.getjTfIdConPag().setEnabled(false);

        } else if (acao.getSource() == telaCadCondicaoPagamento.getBtCancelar()) {
            telaCadCondicaoPagamento.ativa(true);
            telaCadCondicaoPagamento.ligaDesliga(false);

        } else if (acao.getSource() == telaCadCondicaoPagamento.getBtSalvar()) {

            if (telaCadCondicaoPagamento.getjTfDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo 'Descrição' é obrigatório!");
            } else if (telaCadCondicaoPagamento.getjTfDiaEntreParcela().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo 'Dias Entrega' é obrigatório!");
            } else if (telaCadCondicaoPagamento.getjTfNumParcelas().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo 'Número de Parcelas' é obrigatório!");
            } else if (telaCadCondicaoPagamento.getjTfPrimeiraParcela().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo 'Primeira Parcela' é obrigatório!");
            } else {
                CondicaoPgto condicaoPgto = new CondicaoPgto();

                condicaoPgto.setDescricaoCondicao(telaCadCondicaoPagamento.getjTfDescricao().getText());
                condicaoPgto.setDiaEntreParcela(Integer.parseInt(telaCadCondicaoPagamento.getjTfDiaEntreParcela().getText()));
                condicaoPgto.setDiasPrimeiraParcela(Integer.parseInt(telaCadCondicaoPagamento.getjTfPrimeiraParcela().getText()));
                condicaoPgto.setNumeroParcelas(Integer.parseInt(telaCadCondicaoPagamento.getjTfNumParcelas().getText()));

                if (telaCadCondicaoPagamento.getjRadioBtAtivo().isSelected()) {
                    condicaoPgto.setStatus('A');
                } else {
                    condicaoPgto.setStatus('I');
                }
                
                CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
                if (telaCadCondicaoPagamento.getjTfIdConPag().getText().trim().equalsIgnoreCase("")){
                    condicaoPgtoDAO.create(condicaoPgto);
                }else {
                    condicaoPgto.setId(Integer.parseInt(telaCadCondicaoPagamento.getjTfIdConPag().getText()));
                    condicaoPgtoDAO.update(condicaoPgto);
                }
                
                
                telaCadCondicaoPagamento.ativa(true);
                telaCadCondicaoPagamento.ligaDesliga(false);
            }

        } else if (acao.getSource() == telaCadCondicaoPagamento.getBtBuscar()) {

            FoBuscaCondicaoPagamento telaCadCondicaoPagamento = new FoBuscaCondicaoPagamento();
            ControllerBuscaCondPag controllerBuscaCondPag = new ControllerBuscaCondPag(telaCadCondicaoPagamento, this) {
            };
            telaCadCondicaoPagamento.setVisible(true);

        } else if (acao.getSource() == telaCadCondicaoPagamento.getBtSair()) {
            telaCadCondicaoPagamento.dispose();
        } else if (acao.getSource() == telaCadCondicaoPagamento.getBtDeletar()) {

        }
    }

}

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

    public void atualizaCampos(int codigo) {
        CondicaoPgto condicaoPgto = new CondicaoPgto();
        CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
        condicaoPgto = condicaoPgtoDAO.retrieve(codigo);

        telaCadCondicaoPagamento.ativa(false);
        telaCadCondicaoPagamento.ligaDesliga(true);

        telaCadCondicaoPagamento.getjTfIdConPag().setText(condicaoPgto.getId() + "");
        telaCadCondicaoPagamento.getjTfDescricao().setText(condicaoPgto.getDescricaoCondicao());
        telaCadCondicaoPagamento.getjTfDiaEntreParcela().setText(condicaoPgto.getDiaEntreParcela() + "");
        telaCadCondicaoPagamento.getjTfNumParcelas().setText(condicaoPgto.getNumeroParcelas() + "");
        telaCadCondicaoPagamento.getjFTfDiaPrimeiraParcela().setText(dateToString(condicaoPgto.getDiasPrimeiraParcela()));

        if (condicaoPgto.getStatus() == 'A') {
            telaCadCondicaoPagamento.getjRadioBtAtivo().setSelected(true);
        } else {
            telaCadCondicaoPagamento.getjRadioBtInativo().setSelected(true);
        }

    }

    private String stringToDate(String data) {
        String aData = "";
        int dia = 0, mes = 3, ano = 6;

        for (int i = ano; i < (ano + 4); i++) {
            aData = aData + data.charAt(i);
        }
        aData = aData + '-';
        for (int i = mes; i < (mes + 2); i++) {
            aData = aData + data.charAt(i);
        }
        aData = aData + '-';
        for (int i = dia; i < (dia + 2); i++) {
            aData = aData + data.charAt(i);
        }

        return aData;
    }

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

    private boolean verificaData(String data) {
        String aData = "";
        for (int i = 0; i < data.length(); i++) {
            if ((data.charAt(i) != ' ') && (data.charAt(i) != '-')) {
                aData = aData + data.charAt(i);
            }
        }
        return aData.length() == 8;
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
            } else if (!verificaData( telaCadCondicaoPagamento.getjFTfDiaPrimeiraParcela().getText().trim())) {
                JOptionPane.showMessageDialog(null, "O campo 'Primeira Parcela' é obrigatório!");
            } else {
                CondicaoPgto condicaoPgto = new CondicaoPgto();

                condicaoPgto.setDescricaoCondicao(telaCadCondicaoPagamento.getjTfDescricao().getText());
                condicaoPgto.setDiaEntreParcela(Integer.parseInt(telaCadCondicaoPagamento.getjTfDiaEntreParcela().getText()));
                condicaoPgto.setDiasPrimeiraParcela(stringToDate(telaCadCondicaoPagamento.getjFTfDiaPrimeiraParcela().getText().trim()));
                condicaoPgto.setNumeroParcelas(Integer.parseInt(telaCadCondicaoPagamento.getjTfNumParcelas().getText()));

                if (telaCadCondicaoPagamento.getjRadioBtAtivo().isSelected()) {
                    condicaoPgto.setStatus('A');
                } else {
                    condicaoPgto.setStatus('I');
                }

                CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
                if (telaCadCondicaoPagamento.getjTfIdConPag().getText().trim().equalsIgnoreCase("")) {
                    condicaoPgtoDAO.create(condicaoPgto);
                } else {
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
            if (!telaCadCondicaoPagamento.getjTfIdConPag().getText().trim().equalsIgnoreCase("")) {
                CondicaoPgto condicaoPgto = new CondicaoPgto();
                CondicaoPgtoDAO condicaoPgtoDAO = new CondicaoPgtoDAO();
                condicaoPgto = condicaoPgtoDAO.retrieve(Integer.parseInt(telaCadCondicaoPagamento.getjTfIdConPag().getText()));

                if (condicaoPgtoDAO.delete(condicaoPgto) == -1) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar");
                } else {
                    telaCadCondicaoPagamento.ativa(true);
                    telaCadCondicaoPagamento.ligaDesliga(false);
                }

            }

        }
    }

}

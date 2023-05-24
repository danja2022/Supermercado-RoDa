
/*package Controler;*/
package Controler;

import Model.DAO.ClasseDAO;
import Model.bo.Classe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import service.ClasseService;
import view.FoBuscaClasses;

import view.FoCadastroClasse;

public class ControllerCadClasse implements ActionListener {

    FoCadastroClasse telaCadClasse;
    ControllerCadastroProduto cadProd;

    public ControllerCadClasse(FoCadastroClasse parTelaCadClasse) {
        this.telaCadClasse = parTelaCadClasse;
        this.cadProd = null;

        adicionaAction();

    }

    public ControllerCadClasse(FoCadastroClasse parTelaCadClasse, ControllerCadastroProduto cadProd) {
        this.telaCadClasse = parTelaCadClasse;
        this.cadProd = cadProd;

        adicionaAction();

    }

    private void adicionaAction() {
        telaCadClasse.getBtBuscar().addActionListener(this);
        telaCadClasse.getBtCancelar().addActionListener(this);
        telaCadClasse.getBtSalvar().addActionListener(this);
        telaCadClasse.getBtNovo().addActionListener(this);
        telaCadClasse.getBtSair().addActionListener(this);
        telaCadClasse.getBtDeletar().addActionListener(this);

        utilities.Utils.ativa(true, telaCadClasse.getjPanel4());
        utilities.Utils.ligaDesliga(false, telaCadClasse.getPnCentro());
    }

    public void atualizaCampos(int codigo) {
        Classe classe = new Classe();
        
        classe = ClasseService.buscar(codigo);

        utilities.Utils.ativa(false, telaCadClasse.getjPanel4());
        utilities.Utils.ligaDesliga(true, telaCadClasse.getPnCentro());

        telaCadClasse.getjTextFieldIdClasse().setText(classe.getId() + "");
        telaCadClasse.getjTextFieldDescricaoClasseProduto().setText(classe.getDescricao());
        telaCadClasse.getjTextFieldIdClasse().setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadClasse.getBtNovo()) {
            utilities.Utils.ativa(false, telaCadClasse.getjPanel4());
            utilities.Utils.ligaDesliga(true, telaCadClasse.getPnCentro());

            telaCadClasse.getjTextFieldIdClasse().setEnabled(false);

        } else if (acao.getSource() == telaCadClasse.getBtCancelar()) {
            utilities.Utils.ativa(true, telaCadClasse.getjPanel4());
            utilities.Utils.ligaDesliga(false, telaCadClasse.getPnCentro());

        } else if (acao.getSource() == telaCadClasse.getBtSalvar()) {

            if (telaCadClasse.getjTextFieldDescricaoClasseProduto().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo descrição é bbrigatório");
            } else {

                Classe classe = new Classe();
                
                classe.setDescricao(telaCadClasse.getjTextFieldDescricaoClasseProduto().getText());

                if (telaCadClasse.getjTextFieldIdClasse().getText().equalsIgnoreCase("")) {
                    ClasseService.criar(classe);
                } else {
                    classe.setId(Integer.parseInt(telaCadClasse.getjTextFieldIdClasse().getText()));
                    ClasseService.atualizar(classe);

                }

                utilities.Utils.ativa(true, telaCadClasse.getjPanel4());
                utilities.Utils.ligaDesliga(false, telaCadClasse.getPnCentro());

            }

        } else if (acao.getSource() == telaCadClasse.getBtBuscar()) {

            FoBuscaClasses telaBuscaClasse = new FoBuscaClasses();
            ControllerBuscaClasse controllerBuscaClasse = new ControllerBuscaClasse(telaBuscaClasse, this);
            telaBuscaClasse.setVisible(true);
        } else if (acao.getSource() == telaCadClasse.getBtSair()) {
            telaCadClasse.dispose();
            cadProd.setComboBox();
        } else if (acao.getSource() == telaCadClasse.getBtDeletar()) {
            if (!telaCadClasse.getjTextFieldIdClasse().getText().trim().equalsIgnoreCase("")) {
                Classe classe = new Classe();
                
                classe = ClasseService.buscar(Integer.parseInt(telaCadClasse.getjTextFieldIdClasse().getText()));

                if (ClasseService.excluir(classe) == -1) {
                    JOptionPane.showMessageDialog(null, "Erro ao deletar. Verifique se a classe está cadastrado em algum produto");
                } else {
                    utilities.Utils.ativa(true, telaCadClasse.getjPanel4());
        utilities.Utils.ligaDesliga(false, telaCadClasse.getPnCentro());

                }
            }
        }
    }
}

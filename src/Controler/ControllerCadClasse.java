
/*package Controler;*/
package Controler;

import Model.DAO.ClasseDAO;
import Model.bo.Classe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FoBuscaClasses;

import view.FoCadastroClasse;

public class ControllerCadClasse implements ActionListener {

    FoCadastroClasse telaCadClasse;

    public ControllerCadClasse(FoCadastroClasse parTelaCadClasse) {
        this.telaCadClasse = parTelaCadClasse;

        telaCadClasse.getBtBuscar().addActionListener(this);
        telaCadClasse.getBtCancelar().addActionListener(this);
        telaCadClasse.getBtSalvar().addActionListener(this);
        telaCadClasse.getBtNovo().addActionListener(this);
        telaCadClasse.getBtSair().addActionListener(this);

        telaCadClasse.ativa(true);
        telaCadClasse.ligaDesliga(false);

    }
    
    public void atualizaCampos(int codigo){
        Classe classe = new Classe();
        ClasseDAO classeDAO = new ClasseDAO();
        classe = classeDAO.retrieve(codigo);
        
        telaCadClasse.ativa(false);
        telaCadClasse.ligaDesliga(true);
        
        
        telaCadClasse.getjTextFieldIdClasse().setText(classe.getId()+"");
        telaCadClasse.getjTextFieldDescricaoClasseProduto().setText(classe.getDescricao());
        telaCadClasse.getjTextFieldIdClasse().setEnabled(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadClasse.getBtNovo()) {
            telaCadClasse.ativa(false);
            telaCadClasse.ligaDesliga(true);
            telaCadClasse.getjTextFieldIdClasse().setEnabled(false);

        } else if (acao.getSource() == telaCadClasse.getBtCancelar()) {
            telaCadClasse.ativa(true);
            telaCadClasse.ligaDesliga(false);

        } else if (acao.getSource() == telaCadClasse.getBtSalvar()) {

            if (telaCadClasse.getjTextFieldDescricaoClasseProduto().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo descrição é bbrigatório");
            } else {

                Classe classe = new Classe();
                ClasseDAO classeDAO = new ClasseDAO();
                classe.setDescricao(telaCadClasse.getjTextFieldDescricaoClasseProduto().getText());
                

                if (telaCadClasse.getjTextFieldIdClasse().getText().equalsIgnoreCase("")) {
                    classeDAO.create(classe);
                }else{
                    classe.setId(Integer.parseInt(telaCadClasse.getjTextFieldIdClasse().getText()));
                    classeDAO.update(classe);
                    
                }
                

                telaCadClasse.ativa(true);
                telaCadClasse.ligaDesliga(false);

            }

        } else if (acao.getSource() == telaCadClasse.getBtBuscar()) {

            FoBuscaClasses telaBuscaClasse = new FoBuscaClasses();
            ControllerBuscaClasse controllerBuscaClasse = new ControllerBuscaClasse(telaBuscaClasse,this);
            telaBuscaClasse.setVisible(true);
        } else if (acao.getSource() == telaCadClasse.getBtSair()) {
            telaCadClasse.dispose();
        }
    }
}

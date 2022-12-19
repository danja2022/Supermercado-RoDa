
package Controler;


import Model.bo.Colaborador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FoBuscaColaborador;
import view.FoCadastroColaborador;


public class ControllerCadColaborador implements ActionListener {

    FoCadastroColaborador telacadColaborador;
    
    public ControllerCadColaborador (FoCadastroColaborador partelacadColaborador){
        this.telacadColaborador = partelacadColaborador;
        
            
            telacadColaborador.getBtBuscar().addActionListener(this);
            telacadColaborador.getBtCancelar().addActionListener(this);
            telacadColaborador.getBtSalvar().addActionListener(this);
            telacadColaborador.getBtNovo().addActionListener(this);
            telacadColaborador.getBtSair().addActionListener(this);
    
            telacadColaborador.ativa(true);
            telacadColaborador.ligaDesliga(false);
            
            }
    
    
    @Override
    public void actionPerformed(ActionEvent acao) {
       
        if (acao.getSource() == telacadColaborador.getBtNovo()) {
            telacadColaborador.ativa(false);
            telacadColaborador.ligaDesliga(true);
            telacadColaborador.getjTextFieldIDCadColaborador().setEnabled(false);

        } else if (acao.getSource() == telacadColaborador.getBtCancelar()) {
            telacadColaborador.ativa(true);
            telacadColaborador.ligaDesliga(false);

        } else if (acao.getSource() == telacadColaborador.getBtSalvar()) {
            
            if (telacadColaborador.getTfNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atenção!Os campos com '*' são obrigatórios!");
            } else {
                
                Colaborador colaborador = new Colaborador();
                colaborador.setNome(telacadColaborador.getTfNome().getText());
                
                
                
                telacadColaborador.ativa(true);
                telacadColaborador.ligaDesliga(false);
            }

        } else if (acao.getSource() == telacadColaborador.getBtBuscar()) {

            FoBuscaColaborador telaBuscaColaborador = new FoBuscaColaborador();
            ControllerBuscaColaborador controllerBuscaColaborador = new ControllerBuscaColaborador(telaBuscaColaborador) {};
            telaBuscaColaborador.setVisible(true);
            
           
        } else if (acao.getSource() == telacadColaborador.getBtSair()) {
            telacadColaborador.dispose();
        }
    }
    
}

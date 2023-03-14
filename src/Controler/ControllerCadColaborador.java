
package Controler;


import Model.bo.Colaborador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
                JOptionPane.showMessageDialog(null, "O campo 'Nome' é obrigatório!");
            } else if (telacadColaborador.getTfEmail().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo 'Email' é obrigatório!");
            } else if (telacadColaborador.getFtfTelefone1().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo 'Telefone 1' é obrigatório!");
            } else if (telacadColaborador.getTfUsuario().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo 'Usuário' é obrigatório!");
            } else if (telacadColaborador.getPfSenha().getPassword()== null) {
                JOptionPane.showMessageDialog(null, "O campo 'Senha' é obrigatório!");
            } else if (telacadColaborador.getPfSenhaConfirm().getPassword() == null) {
                JOptionPane.showMessageDialog(null, "O campo 'Confirme Senha' é obrigatório!");
            } else if (Arrays.equals(telacadColaborador.getPfSenha().getPassword(), telacadColaborador.getPfSenhaConfirm().getPassword())){
                Colaborador colaborador = new Colaborador();
                
                colaborador.setNome(telacadColaborador.getTfNome().getText());
                colaborador.setEmail(telacadColaborador.getTfEmail().getText());
                colaborador.setFone(telacadColaborador.getFtfTelefone1().getText());
                colaborador.setFone2(telacadColaborador.getFtfTelefone2().getText());
                colaborador.setLogin(telacadColaborador.getTfUsuario().getText());
                colaborador.setSenha(Arrays.toString(telacadColaborador.getPfSenha().getPassword()));
                colaborador.setEndereco(telacadColaborador.getFtfCEP().getText());
                colaborador.setComplementoEndereco(telacadColaborador.getTfComplemento().getText());                
                
                telacadColaborador.ativa(true);
                telacadColaborador.ligaDesliga(false);
            
            } else{
                JOptionPane.showMessageDialog(null, "As Senhas não conferem");
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

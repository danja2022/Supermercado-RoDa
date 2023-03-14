 
package Controler;


import Model.bo.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.FoBuscaCliente;
import view.FoCadastroCliente;


public class ControllerCadCliente implements ActionListener {

    FoCadastroCliente telaCadCliente;
    
    public ControllerCadCliente (FoCadastroCliente parTelaCadCliente){
        this.telaCadCliente = parTelaCadCliente;
        
            
            telaCadCliente.getBtBuscar().addActionListener(this);
            telaCadCliente.getBtCancelar().addActionListener(this);
            telaCadCliente.getBtSalvar().addActionListener(this);
            telaCadCliente.getBtNovo().addActionListener(this);
            telaCadCliente.getBtSair().addActionListener(this);
    
            telaCadCliente.ativa(true);
            telaCadCliente.ligaDesliga(false);
            
            }
  
    @Override
    public void actionPerformed(ActionEvent acao) {
        
        if (acao.getSource() == telaCadCliente.getBtNovo()) {
            telaCadCliente.ativa(false);
            telaCadCliente.ligaDesliga(true);
            telaCadCliente.getjTextFieldIDCadClient().setEnabled(false);

        } else if (acao.getSource() == telaCadCliente.getBtCancelar()) {
            telaCadCliente.ativa(true);
            telaCadCliente.ligaDesliga(false);

        } else if (acao.getSource() == telaCadCliente.getBtSalvar()) {
            
            if (telaCadCliente.getTfNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo nome é obrigatório!");
            } else if (telaCadCliente.getFtfDtNasc().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo Data de Nascimento é obrigatório!");
            } else if (telaCadCliente.getFtfCPF().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo CPF é obrigatório!");
            } else if (telaCadCliente.getTfRG().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo RG é obrigatório!");
            } else if (telaCadCliente.getFtfTelefone1().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo Telefone 1 é obrigatório!");
            } else if (telaCadCliente.getTfEmail().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo Email é obrigatório!");
            } else if (telaCadCliente.getFtfCEP().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo CEP é obrigatório!");
            } else {
                
                Cliente cliente = new Cliente();
                cliente.setNome(telaCadCliente.getTfNome().getText());
                cliente.setDtNascimento(telaCadCliente.getFtfDtNasc().getText());
                cliente.setCpf(telaCadCliente.getFtfCPF().getText());
                cliente.setFone(telaCadCliente.getFtfTelefone1().getText());
                cliente.setFone2(telaCadCliente.getFtfTelefone2().getText());
                cliente.setEmail(telaCadCliente.getTfEmail().getText());
                
                
                
                
                //persistir o objeto de bairro criado
                
                telaCadCliente.ativa(true);
                telaCadCliente.ligaDesliga(false);
            }

        } else if (acao.getSource() == telaCadCliente.getBtBuscar()) {

            FoBuscaCliente telaBuscaCidade = new FoBuscaCliente();
            ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(telaBuscaCidade) {};
            telaBuscaCidade.setVisible(true);
            
        } else if (acao.getSource() == telaCadCliente.getBtSair()) {
            telaCadCliente.dispose();
        }
    
    }
    
}

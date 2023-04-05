
package Controler;


import Model.DAO.ColaboradorDAO;
import Model.DAO.EnderecoDAO;
import Model.bo.Colaborador;
import Model.bo.Endereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import view.FoBuscaColaborador;
import view.FoCadastroColaborador;
import view.FoCadastroEndereco;


public class ControllerCadColaborador implements ActionListener {

    FoCadastroColaborador telacadColaborador;
    
    public ControllerCadColaborador (FoCadastroColaborador partelacadColaborador){
        this.telacadColaborador = partelacadColaborador;
        
            
            telacadColaborador.getBtBuscar().addActionListener(this);
            telacadColaborador.getBtCancelar().addActionListener(this);
            telacadColaborador.getBtSalvar().addActionListener(this);
            telacadColaborador.getBtNovo().addActionListener(this);
            telacadColaborador.getBtSair().addActionListener(this);
            telacadColaborador.getBtCadCep().addActionListener(this);
            telacadColaborador.getjCbCep().addActionListener(this);
            
    
            telacadColaborador.ativa(true);
            telacadColaborador.ligaDesliga(false);
            this.setComboBox();
            
            }
    
    public void atualizaCampos(int codigo){
        Colaborador colaborador = new Colaborador();
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        colaborador = colaboradorDAO.retrieve(codigo);
        
        telacadColaborador.ativa(false);
        telacadColaborador.ligaDesliga(true);
        
        telacadColaborador.gettFId().setText(colaborador.getId()+"");
        if (colaborador.getStatus() == 'A')
            telacadColaborador.getjRadioBtAtivo().setSelected(true);
        else
            telacadColaborador.getjRadioBtInativo().setSelected(true);
        telacadColaborador.getFtDataCadastro().setText(dateToString(colaborador.getDtCadastro()));
        telacadColaborador.getTfNome().setText(colaborador.getNome());
        telacadColaborador.getTfEmail().setText(colaborador.getEmail());
        telacadColaborador.getFtfTelefone1().setText(colaborador.getFone());
        telacadColaborador.getFtfTelefone2().setText(colaborador.getFone2());
        telacadColaborador.getjTextArea1().setText(colaborador.getObservacao());
        telacadColaborador.getTfUsuario().setText(colaborador.getLogin());
        telacadColaborador.getPfSenha().setText(colaborador.getSenha());
         
        
            
        
    }
    
    public void setComboBox() {
        List<Endereco> listaEndereco = new ArrayList<>();

        EnderecoDAO enderecoDAO = new EnderecoDAO();

        listaEndereco = enderecoDAO.retrieve();

        telacadColaborador.getjCbCep().removeAllItems();

        for (Endereco endereco : listaEndereco) {
            telacadColaborador.getjCbCep().addItem(endereco.getCep());
        }
    }
    
    private boolean verificaNumero(String fone) {
        String aFone = "";
        for (int i = 0; i < fone.length(); i++) {
            if ((fone.charAt(i) != '(') && (fone.charAt(i) != ')') && (fone.charAt(i) != '-') && (fone.charAt(i) != ' ')) {
                aFone = aFone + fone.charAt(i);
            }
        }
        return aFone.length() == 11;
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
    
    
    @Override
    public void actionPerformed(ActionEvent acao) {
       
        if (acao.getSource() == telacadColaborador.getBtNovo()) {
            telacadColaborador.ativa(false);
            telacadColaborador.ligaDesliga(true);
            telacadColaborador.gettFId().setEnabled(false);

        } else if (acao.getSource() == telacadColaborador.getBtCancelar()) {
            telacadColaborador.ativa(true);
            telacadColaborador.ligaDesliga(false);

        } else if (acao.getSource() == telacadColaborador.getBtSalvar()) {
            
            if (telacadColaborador.getTfNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo 'Nome' é obrigatório!");
            } else if (telacadColaborador.getTfEmail().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo 'Email' é obrigatório!");
            } else if (!verificaNumero(telacadColaborador.getFtfTelefone1().getText().trim())) {
                JOptionPane.showMessageDialog(null, "Preencha o telefone 1 corretamente");
            } else if (telacadColaborador.getTfUsuario().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo 'Usuário' é obrigatório!");
            } else if (telacadColaborador.getPfSenha().getPassword()== null) {
                JOptionPane.showMessageDialog(null, "O campo 'Senha' é obrigatório!");
            } else if (telacadColaborador.getPfSenhaConfirm().getPassword() == null) {
                JOptionPane.showMessageDialog(null, "O campo 'Confirme Senha' é obrigatório!");
            } else if (Arrays.equals(telacadColaborador.getPfSenha().getPassword(), telacadColaborador.getPfSenhaConfirm().getPassword())){
                Colaborador colaborador = new Colaborador();
                ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
                
                colaborador.setNome(telacadColaborador.getTfNome().getText());
                colaborador.setEmail(telacadColaborador.getTfEmail().getText());
                colaborador.setFone(telacadColaborador.getFtfTelefone1().getText());
                if(verificaNumero(telacadColaborador.getFtfTelefone2().getText()))
                    colaborador.setFone2(telacadColaborador.getFtfTelefone2().getText());
                else
                    colaborador.setFone2("");
                
                if(telacadColaborador.getjRadioBtAtivo().isSelected())
                    colaborador.setStatus('A');
                else
                    colaborador.setStatus('I');
                String strPass = new String(telacadColaborador.getPfSenha().getPassword());
                colaborador.setLogin(telacadColaborador.getTfUsuario().getText());
                colaborador.setSenha(strPass);
                colaborador.setComplementoEndereco(telacadColaborador.getTfComplemento().getText()); 
                
                Endereco endereco = new Endereco();
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrieve(telacadColaborador.getjCbCep().getSelectedItem().toString());
                colaborador.setEndereco(endereco);
                
                if(telacadColaborador.gettFId().getText().trim().equalsIgnoreCase(""))
                   colaboradorDAO.create(colaborador);
                else{
                    colaborador.setId(Integer.parseInt(telacadColaborador.gettFId().getText()));
                    colaboradorDAO.update(colaborador);
                }
                
                telacadColaborador.ativa(true);
                telacadColaborador.ligaDesliga(false);
            
            } else{
                JOptionPane.showMessageDialog(null, "As Senhas não conferem");
            }

        } else if (acao.getSource() == telacadColaborador.getBtBuscar()) {

            FoBuscaColaborador telaBuscaColaborador = new FoBuscaColaborador();
            ControllerBuscaColaborador controllerBuscaColaborador = new ControllerBuscaColaborador(telaBuscaColaborador, this){};
            telaBuscaColaborador.setVisible(true);
        } else if (acao.getSource() == telacadColaborador.getBtSair()) {
            telacadColaborador.dispose();
        }else if(acao.getSource() == telacadColaborador.getjCbCep()){
            if (telacadColaborador.getjCbCep().getSelectedItem() != null) {
                Endereco endereco = new Endereco();
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrieve(telacadColaborador.getjCbCep().getSelectedItem().toString());
                telacadColaborador.getTfBairro().setText(endereco.getBairro().getDescricao());
                telacadColaborador.getTfCidade().setText(endereco.getCidade().getDescricao());
                telacadColaborador.getTfLogradouro().setText(endereco.getLogradouro());
            }
            
        }else if(acao.getSource() == telacadColaborador.getBtCadCep()){
            FoCadastroEndereco telaCadEndereco = new FoCadastroEndereco();
            ControllerCadEndereco cadEndereco = new ControllerCadEndereco(telaCadEndereco, this);
            telaCadEndereco.setVisible(true);
        }
    }
    
}

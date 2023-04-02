package Controler;

import Model.DAO.ClienteDAO;
import Model.DAO.EnderecoDAO;
import Model.bo.Cliente;
import Model.bo.Endereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import view.FoBuscaCliente;
import view.FoCadastroCliente;
import view.FoCadastroEndereco;

public class ControllerCadCliente implements ActionListener {

    FoCadastroCliente telaCadCliente;

    public ControllerCadCliente(FoCadastroCliente parTelaCadCliente) {
        this.telaCadCliente = parTelaCadCliente;

        telaCadCliente.getBtBuscar().addActionListener(this);
        telaCadCliente.getBtCancelar().addActionListener(this);
        telaCadCliente.getBtSalvar().addActionListener(this);
        telaCadCliente.getBtNovo().addActionListener(this);
        telaCadCliente.getBtSair().addActionListener(this);
        telaCadCliente.getjComboBoxCep().addActionListener(this);
        telaCadCliente.getjBtCadCep().addActionListener(this);

        telaCadCliente.ativa(true);
        telaCadCliente.ligaDesliga(false);
        this.setComboBox();

    }
    public void atualizaCampos(int codigo){
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO();
        cliente = clienteDAO.retrieve(codigo);
        
        telaCadCliente.ativa(false);
        telaCadCliente.ligaDesliga(true);
        
        telaCadCliente.getTfNome().setText(cliente.getNome());
        telaCadCliente.getjTfId().setText(cliente.getId()+ "");
        if(cliente.getStatus() == 'A')
            telaCadCliente.getjRadioBtAtivo().setSelected(true);
        else
            telaCadCliente.getjRadioBtInativo().setSelected(true);
        
        telaCadCliente.getFtfDtNasc().setText(dateToString(cliente.getDtNascimento()));
        telaCadCliente.getFtfCPF().setText(cliente.getCpf());
        telaCadCliente.getTfRG().setText(cliente.getRg());
        
        if(cliente.getSexo() == 'M')
            telaCadCliente.getRbMasculino().setSelected(true);
        else if (cliente.getSexo() == 'F')
            telaCadCliente.getRbFeminino().setSelected(true);
        else
            telaCadCliente.getRbNaoInformar().setSelected(true);
        
        telaCadCliente.getFtfTelefone1().setText(cliente.getFone());
        telaCadCliente.getFtfTelefone2().setText(cliente.getFone2());
        telaCadCliente.getTfEmail().setText(cliente.getEmail());
        telaCadCliente.getjTextArea1().setText(cliente.getObservacao());
        telaCadCliente.getjComboBoxCep().setSelectedItem(cliente.getEndereco().getCep());
        telaCadCliente.getTfComplemento().setText(cliente.getComplementoEndereco()); 

    }

    private boolean verificaCpf(String cpf) {
        String aCpf = "";
        for (int i = 0; i < cpf.length(); i++) {
            if ((cpf.charAt(i) != '.') && (cpf.charAt(i) != '-') && (cpf.charAt(i) != ' ')) {
                aCpf = aCpf + cpf.charAt(i);
            }
        }
        return aCpf.length() == 11;

    }
    private boolean verificaNumero(String fone){
        String aFone = "";
        for(int i = 0; i< fone.length(); i++){
            if((fone.charAt(i) != '(') && (fone.charAt(i)!= ')') && (fone.charAt(i) != '-') && (fone.charAt(i) != ' '))
                aFone = aFone + fone.charAt(i);
        }
        return aFone.length() == 11;
    }
    private boolean verificaData(String data){
        String aData = "";
        for(int i = 0; i < data.length(); i++){
            if((data.charAt(i) != ' ') && (data.charAt(i) != '-'))
                aData = aData + data.charAt(i);
        }
        return aData.length() == 8;
                
    }
    //10-06-2002
    private String stringToDate(String data){
        String aData = "";
        int dia = 0, mes = 3, ano = 6;
        
        for(int i = ano; i < (ano+4); i++){
            aData = aData + data.charAt(i);
        }
        aData = aData + '-';
        for (int i = mes; i < (mes+2); i++){
            aData = aData + data.charAt(i);
        }
        aData = aData + '-';
        for (int i = dia; i< (dia +2); i ++){
            aData = aData + data.charAt(i);
        }
        
        return aData;
    }
   //2002-06-10
    private String dateToString(String  data){
        String aData = "";
        int dia = 8, mes = 5, ano = 0;
        
        for(int i = dia; i < (dia+2); i++){
            aData = aData + data.charAt(i);
        }
      //  aData = aData + '-';
        for (int i = mes; i < (mes+2); i++){
            aData = aData + data.charAt(i);
        }
     //   aData = aData + '-';
        for(int i = ano; i < (ano+4); i++){
            aData = aData + data.charAt(i);
        }
        return aData;        
    }

    public void setComboBox() {
        List<Endereco> listaEndereco = new ArrayList<>();

        EnderecoDAO enderecoDAO = new EnderecoDAO();

        listaEndereco = enderecoDAO.retrieve();

        telaCadCliente.getjComboBoxCep().removeAllItems();

        for (Endereco endereco : listaEndereco) {
            telaCadCliente.getjComboBoxCep().addItem(endereco.getCep());
        }
    }

    @Override
    public void actionPerformed(ActionEvent acao) {

        if (acao.getSource() == telaCadCliente.getBtNovo()) {
            telaCadCliente.ativa(false);
            telaCadCliente.ligaDesliga(true);
            telaCadCliente.getjTfId().setEnabled(false);

        } else if (acao.getSource() == telaCadCliente.getBtCancelar()) {
            telaCadCliente.ativa(true);
            telaCadCliente.ligaDesliga(false);

        } else if (acao.getSource() == telaCadCliente.getBtSalvar()) {

            if (telaCadCliente.getTfNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo nome é obrigatório!");
            } else if (!verificaData( telaCadCliente.getFtfDtNasc().getText().trim())) {
                JOptionPane.showMessageDialog(null, "O campo Data de Nascimento é obrigatório!");
            } else if (!verificaCpf(telaCadCliente.getFtfCPF().getText().trim())) {
                JOptionPane.showMessageDialog(null, "Preencha o CPF corretamente!");
            } else if (telaCadCliente.getTfRG().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo RG é obrigatório!");
            } else if (!verificaNumero(telaCadCliente.getFtfTelefone1().getText().trim())) {
                JOptionPane.showMessageDialog(null, "Preencha o telefone 1 corretamente!");
            } else if (telaCadCliente.getTfEmail().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo Email é obrigatório!");
            } else {

                Cliente cliente = new Cliente();
                cliente.setNome(telaCadCliente.getTfNome().getText());
                cliente.setDtNascimento(stringToDate( telaCadCliente.getFtfDtNasc().getText()));
                cliente.setCpf(telaCadCliente.getFtfCPF().getText());
                cliente.setFone(telaCadCliente.getFtfTelefone1().getText());
                if(verificaNumero(telaCadCliente.getFtfTelefone2().getText()))
                    cliente.setFone2(telaCadCliente.getFtfTelefone2().getText());
                else
                    cliente.setFone2("");
                if(!telaCadCliente.getTfEmail().getText().trim().equalsIgnoreCase(""))
                    cliente.setEmail(telaCadCliente.getTfEmail().getText());
                else
                    cliente.setEmail("");

                if (telaCadCliente.getRbFeminino().isSelected()) {
                    cliente.setSexo('F');
                } else if (telaCadCliente.getRbMasculino().isSelected()) {
                    cliente.setSexo('M');
                } else {
                    cliente.setSexo('I');
                }

                cliente.setRg(telaCadCliente.getTfRG().getText());

                if (telaCadCliente.getjRadioBtAtivo().isSelected()) {
                    cliente.setStatus('A');
                } else {
                    cliente.setStatus('I');
                }
                if(!telaCadCliente.getTfComplemento().getText().trim().equalsIgnoreCase(""))
                    cliente.setComplementoEndereco(telaCadCliente.getTfComplemento().getText());
                else
                    cliente.setComplementoEndereco("");
                Endereco endereco = new Endereco();
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrieve(telaCadCliente.getjComboBoxCep().getSelectedItem().toString());
                cliente.setEndereco(endereco);
                cliente.setObservacao(telaCadCliente.getjTextArea1().getText().trim());

                ClienteDAO clienteDAO = new ClienteDAO();

                if (telaCadCliente.getjTfId().getText().trim().equalsIgnoreCase("")) {
                    clienteDAO.create(cliente);
                } else {
                    cliente.setId(Integer.parseInt(telaCadCliente.getjTfId().getText()));
                    clienteDAO.update(cliente);
                }

                //persistir o objeto de bairro criado
                telaCadCliente.ativa(true);
                telaCadCliente.ligaDesliga(false);
            }

        } else if (acao.getSource() == telaCadCliente.getBtBuscar()) {

            FoBuscaCliente telaBuscaCidade = new FoBuscaCliente();
            ControllerBuscaCliente controllerBuscaCliente = new ControllerBuscaCliente(telaBuscaCidade,this) {
            };
            telaBuscaCidade.setVisible(true);

        } else if (acao.getSource() == telaCadCliente.getBtSair()) {
            telaCadCliente.dispose();
        }else if(acao.getSource() == telaCadCliente.getjComboBoxCep()){
            if(telaCadCliente.getjComboBoxCep().getSelectedItem() != null){
                Endereco endereco = new Endereco();
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                endereco = enderecoDAO.retrieve(telaCadCliente.getjComboBoxCep().getSelectedItem().toString());
                telaCadCliente.getTfBairro().setText(endereco.getBairro().getDescricao());
                telaCadCliente.getTfCidade().setText(endereco.getCidade().getDescricao());
                telaCadCliente.getTfLogradouro().setText(endereco.getLogradouro());
            }
           
        }else if(acao.getSource() == telaCadCliente.getjBtCadCep()){
            FoCadastroEndereco telaCadEndereco = new FoCadastroEndereco();
            ControllerCadEndereco cadEndereco = new ControllerCadEndereco(telaCadEndereco, this);
            telaCadEndereco.setVisible(true);
        }

    }

}

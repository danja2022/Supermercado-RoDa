
package Controler;


import Model.bo.Fornecedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import view.FoBuscaFornecedor;
import view.FoCadastroFornecedor;


public class ControllerCadFornecedor implements ActionListener {

    
    FoCadastroFornecedor telaCadFornecedor;
    
    public ControllerCadFornecedor (FoCadastroFornecedor partelaCadFornecedor){
        this.telaCadFornecedor = partelaCadFornecedor;
        
            
            telaCadFornecedor.getBtBuscar().addActionListener(this);
            telaCadFornecedor.getBtCancelar().addActionListener(this);
            telaCadFornecedor.getBtSalvar().addActionListener(this);
            telaCadFornecedor.getBtNovo().addActionListener(this);
            telaCadFornecedor.getBtSair().addActionListener(this);
    
            
    
            telaCadFornecedor.ativa(true);
            telaCadFornecedor.ligaDesliga(false);
            
            }
    /*
            String aCpf = "";
        for (int i = 0; i < cpf.length(); i++) {
            if ((cpf.charAt(i) != '.') && (cpf.charAt(i) != '-') && (cpf.charAt(i) != ' ')) {
                aCpf = aCpf + cpf.charAt(i);
            }
        }
        return aCpf.length() == 11;

    }*/
    
    private boolean verificaCnpj(String cnpj){
        String aCnpj = "";
        for(int i =0; i<cnpj.length(); i++){
            if((cnpj.charAt(i) != '.') && (cnpj.charAt(i) != '/') && (cnpj.charAt(i) != '-') && (cnpj.charAt(i) != ' ') ){
                aCnpj = aCnpj+ cnpj;
            }    
        }
        return aCnpj.length() == 15;
    }
   
    
    @Override
    public void actionPerformed(ActionEvent acao) {
      if (acao.getSource() == telaCadFornecedor.getBtNovo()) {
            telaCadFornecedor.ativa(false);
            telaCadFornecedor.ligaDesliga(true);
            telaCadFornecedor.getjTextFieldIdCadFornecedor().setEnabled(false);

        } else if (acao.getSource() == telaCadFornecedor.getBtCancelar()) {
            telaCadFornecedor.ativa(true);
            telaCadFornecedor.ligaDesliga(false);

        } else if (acao.getSource() == telaCadFornecedor.getBtSalvar()) {
            
            if (telaCadFornecedor.getTfNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "O campo com Nome é obrigatório!");
            } else if(telaCadFornecedor.getFtfCPF().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "O campo CPF é obrigatório");
            }else if(telaCadFornecedor.getFtfRG().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,"O campo RG é obrigatório");
            }else if(telaCadFornecedor.getFtfCNPJ().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "O campo CNPJ é obrigatório");
            }else if(telaCadFornecedor.getFtfTelefone1().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "O campo Telefone 1 é obrigatório");
            }else if(telaCadFornecedor.getTfEmail().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "O campo EMAIL é obrigatório");
            }else if(telaCadFornecedor.getFtfCEP().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "O campo CEP é obrigatório");
            }else{
                
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setNome(telaCadFornecedor.getTfNome().getText());
                fornecedor.setRazaoSocial(telaCadFornecedor.getTfRazaoSocial().getText());
                fornecedor.setCpf( telaCadFornecedor.getFtfCPF().getText());
                fornecedor.setRg(telaCadFornecedor.getFtfRG().getText());
                fornecedor.setCnpj(telaCadFornecedor.getFtfCNPJ().getText());
                fornecedor.setInscEstadual(telaCadFornecedor.getTfInscricaoEst().getText());
                fornecedor.setFone(telaCadFornecedor.getFtfTelefone1().getText());
                fornecedor.setFone2(telaCadFornecedor.getFtfTelefone2().getText());
                fornecedor.setEmail(telaCadFornecedor.getTfEmail().getText());
                fornecedor.setObservacao(telaCadFornecedor.getjTextArea1().getText());
                fornecedor.setComplementoEndereco(telaCadFornecedor.getTfComplemento().getText());
                
                
                telaCadFornecedor.ativa(true);
                telaCadFornecedor.ligaDesliga(false);
            }

        } else if (acao.getSource() == telaCadFornecedor.getBtBuscar()) {

            FoBuscaFornecedor telaBuscaFornecedor = new FoBuscaFornecedor();
            ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(telaBuscaFornecedor) {};
            telaBuscaFornecedor.setVisible(true);
        
        } else if (acao.getSource() == telaCadFornecedor.getBtSair()) {
            telaCadFornecedor.dispose();
        }
        
    }
    
}

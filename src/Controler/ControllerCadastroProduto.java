
package Controler;



import Model.bo.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import view.FoBuscaProduto;
import view.FoCadastroProduto;




public class ControllerCadastroProduto implements ActionListener {

    FoCadastroProduto telaCadProduto;
    
    
    public ControllerCadastroProduto (FoCadastroProduto parTelaCadProduto){
        this.telaCadProduto = parTelaCadProduto;
    
    
            telaCadProduto.getBtBuscar().addActionListener(this);
            telaCadProduto.getBtCancelar().addActionListener(this);
            telaCadProduto.getBtSalvar().addActionListener(this);
            telaCadProduto.getBtNovo().addActionListener(this);
            telaCadProduto.getBtSair().addActionListener(this);
            
            
            telaCadProduto.ativa(true);
            telaCadProduto.ligaDesliga(false);
            
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if (acao.getSource() == telaCadProduto.getBtNovo()) {
            telaCadProduto.ativa(false);
            telaCadProduto.ligaDesliga(true);
            telaCadProduto.getjTextFieldId().setEnabled(false);

        //devo criar o text field de cada um?; Quero entender o que está acontecendo nessa parte do código;
            
            
        } else if (acao.getSource() == telaCadProduto.getBtCancelar()) {
            telaCadProduto.ativa(true);
            telaCadProduto.ligaDesliga(false);

        } else if (acao.getSource() == telaCadProduto.getBtSalvar()) {
           //campo descrição mercadoria será obrigatório
             if (telaCadProduto.getjTextFieldNomeDescProd().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
            } else if(telaCadProduto.getjTextFieldValorCompra().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Valor Compra é Obrigatório");
            }else if(telaCadProduto.getjTextFieldValorVenda().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Valor Venda é Obrigatório");
            } else {
                Produto produto = new Produto();
                produto.setDescricao(telaCadProduto.getjTextFieldValorVenda().getText());
                produto.setValorVenda(parseFloat(telaCadProduto.getjTextFieldValorVenda().getText()));
                produto.setValorCompra(parseFloat(telaCadProduto.getjTextFieldValorCompra().getText()));
                produto.setEstoqueMinimo(parseFloat(telaCadProduto.getjTextFieldEstoqMin().getText()));
                produto.setEstoqueMaximo(parseFloat(telaCadProduto.getjTextFieldEstoqMax().getText()));
                produto.setUndCompra(telaCadProduto.getjTextFieldUnidadeCompra().getText());
                produto.setUndVenda(telaCadProduto.getjTextFieldUnidadeVenda().getText());
                produto.setFatorConversao(parseInt(telaCadProduto.getjTextFieldFatorConversao().getText()));
                produto.setBarraEntrada(telaCadProduto.getjTextFieldBarraEntrada().getText());
                produto.setBarraSaida(telaCadProduto.getjTextFieldBarraSaida().getText());
                
                if(telaCadProduto.getButtonGroup1().getSelection() == telaCadProduto.getjRadioBtAtivo())
                    produto.setStatus('A');
                else
                    produto.setStatus('I');
                
                
                telaCadProduto.ativa(true);
                telaCadProduto.ligaDesliga(false);
            }
           
        } else if (acao.getSource() == telaCadProduto.getBtBuscar()) {
            FoBuscaProduto telaBuscaProduto = new FoBuscaProduto();
            ControllerBuscaProduto controllerBuscaProduto = new ControllerBuscaProduto(telaBuscaProduto) {};
            telaBuscaProduto.setVisible(true);
          
        } else if (acao.getSource() == telaCadProduto.getBtSair()) {
            telaCadProduto.dispose();
        }
    }
    
}




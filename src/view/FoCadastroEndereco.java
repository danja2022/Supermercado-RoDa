/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class FoCadastroEndereco extends javax.swing.JFrame {

    /**
     * Creates new form ObjetoCadastro
     */
    public FoCadastroEndereco() {
        
        initComponents();
    }

    public JButton getBtBuscar() {
        return btBuscar;
    }

    public void setBtBuscar(JButton btBuscar) {
        this.btBuscar = btBuscar;
    }

    public JButton getBtCancelar() {
        return btCancelar;
    }

    public void setBtCancelar(JButton btCancelar) {
        this.btCancelar = btCancelar;
    }

    public JButton getBtNovo() {
        return btNovo;
    }

    public void setBtNovo(JButton btNovo) {
        this.btNovo = btNovo;
    }

    public JButton getBtSair() {
        return btSair;
    }

    public void setBtSair(JButton btSair) {
        this.btSair = btSair;
    }

    public JButton getBtSalvar() {
        return btSalvar;
    }

    public void setBtSalvar(JButton btSalvar) {
        this.btSalvar = btSalvar;
    }

    public JTextField getjTextFieldCadIdEndereco() {
        return jTextFieldCadIdEndereco;
    }

    public void setjTextFieldCadIdEndereco(JTextField jTextFieldCadIdEndereco) {
        this.jTextFieldCadIdEndereco = jTextFieldCadIdEndereco;
    }

    public JTextField getjTextFieldDescricaoLogradouro() {
        return jTextFieldDescricaoLogradouro;
    }

    public void setjTextFieldDescricaoLogradouro(JTextField jTextFieldDescricaoLogradouro) {
        this.jTextFieldDescricaoLogradouro = jTextFieldDescricaoLogradouro;
    }

    public JPanel getPnCentro() {
        return pnCentro;
    }

    public void setPnCentro(JPanel pnCentro) {
        this.pnCentro = pnCentro;
    }

    public JTextField getjTextFieldCep() {
        return jTextFieldCep;
    }

    public void setjTextFieldCep(JTextField jTextFieldCep) {
        this.jTextFieldCep = jTextFieldCep;
    }

    
    
    
    public void ativa (boolean estadoComponente){
        btNovo.setEnabled(estadoComponente);
        btSalvar.setEnabled(!estadoComponente);
        btBuscar.setEnabled(estadoComponente);
        btCancelar.setEnabled(!estadoComponente);
        btSair.setEnabled(estadoComponente);
      
    }
    
    public void ligaDesliga (boolean estadoComponente){
    
        Component[] componentes = pnCentro.getComponents();
        for (Component componente : componentes ) {
            if(componente instanceof JTextField){
                ((JTextField)componente).setText("");
        }
            else if (componente instanceof JFormattedTextField){
                ((JFormattedTextField)componente).setText ("");
        }
            else if (componente instanceof JTextArea){
               ((JTextArea)componente).setText ("");     
        }
            else if (componente instanceof JComboBox){
                ((JComboBox)componente).setSelectedIndex(0);
                    }
          //  else if (componente instanceof JScrollPane){
            //    ((JScrollPane)componente).get
       // }
            componente.setEnabled(estadoComponente);
        }
    
    }
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCentro = new javax.swing.JPanel();
        jLabelIdEndereco = new javax.swing.JLabel();
        jTextFieldCadIdEndereco = new javax.swing.JTextField();
        jLabelLogradouro = new javax.swing.JLabel();
        jTextFieldDescricaoLogradouro = new javax.swing.JTextField();
        jLabelCadCep = new javax.swing.JLabel();
        jTextFieldCep = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxBairroTelaEndereco = new javax.swing.JComboBox<>();
        jComboBoxCidadeTelaEndereco = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelCadastroEndereco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnCentro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelIdEndereco.setText("Id:");

        jLabelLogradouro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelLogradouro.setText("Logradouro* : ");

        jLabelCadCep.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCadCep.setText("Cep*  :");

        jLabel1.setText("Bairro:");

        jLabel2.setText("Cidade:");

        jComboBoxBairroTelaEndereco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxBairroTelaEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBairroTelaEnderecoActionPerformed(evt);
            }
        });

        jComboBoxCidadeTelaEndereco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnCentroLayout = new javax.swing.GroupLayout(pnCentro);
        pnCentro.setLayout(pnCentroLayout);
        pnCentroLayout.setHorizontalGroup(
            pnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCentroLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(pnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelLogradouro)
                    .addComponent(jLabelIdEndereco)
                    .addComponent(jLabelCadCep)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(pnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCentroLayout.createSequentialGroup()
                        .addComponent(jComboBoxBairroTelaEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxCidadeTelaEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldDescricaoLogradouro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                        .addComponent(jTextFieldCep, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnCentroLayout.createSequentialGroup()
                            .addComponent(jTextFieldCadIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(103, 103, 103))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCentroLayout.setVerticalGroup(
            pnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCentroLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdEndereco)
                    .addComponent(jTextFieldCadIdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogradouro)
                    .addComponent(jTextFieldDescricaoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCadCep)
                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxBairroTelaEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxCidadeTelaEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel4.add(btNovo);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Download.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel4.add(btSalvar);

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Cancel.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setEnabled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btCancelar);

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Eye.png"))); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(btBuscar);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel4.add(btSair);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelCadastroEndereco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelCadastroEndereco.setText("Cadastro de Endere??o");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCadastroEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabelCadastroEndereco)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
       
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        ligaDesliga(false);
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        ativa(false);
    }//GEN-LAST:event_btSairActionPerformed

    private void jComboBoxBairroTelaEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBairroTelaEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxBairroTelaEnderecoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FoCadastroEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoCadastroEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoCadastroEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoCadastroEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FoCadastroEndereco().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> jComboBoxBairroTelaEndereco;
    private javax.swing.JComboBox<String> jComboBoxCidadeTelaEndereco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCadCep;
    private javax.swing.JLabel jLabelCadastroEndereco;
    private javax.swing.JLabel jLabelIdEndereco;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldCadIdEndereco;
    private javax.swing.JTextField jTextFieldCep;
    private javax.swing.JTextField jTextFieldDescricaoLogradouro;
    private javax.swing.JPanel pnCentro;
    // End of variables declaration//GEN-END:variables
}

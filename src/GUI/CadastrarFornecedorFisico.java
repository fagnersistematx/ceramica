package GUI;

import Controler.FornecedorController;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class CadastrarFornecedorFisico extends javax.swing.JDialog {

    private FornecedorController fornecedorController;

    public CadastrarFornecedorFisico(java.awt.Frame parent) {
        super(parent);
        initComponents();
        this.fornecedorController = new FornecedorController();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfDataNas = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfTel = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfTelCel1 = new javax.swing.JFormattedTextField();
        tfTelCel2 = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        tfMail = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        tfSite = new javax.swing.JTextField();
        tfRG = new javax.swing.JTextField();
        tfCPF = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        tfEmpresa = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tfLogradouro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfComplemento = new javax.swing.JTextArea();
        tfCidade = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        tfCEP = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfOBSCliente = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Fornecedor - Físico");

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Fornecedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel5.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel1.setText("Nome");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(10, 21, 40, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel2.setText(" CPF");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(220, 80, 30, 20);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabel4.setText("Data de Nas.");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(10, 141, 120, 20);
        jPanel5.add(tfNome);
        tfNome.setBounds(10, 41, 330, 30);

        try {
            tfDataNas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel5.add(tfDataNas);
        tfDataNas.setBounds(10, 161, 110, 30);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contatos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel4.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setText("Telefone Fixo:");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(10, 20, 130, 30);

        try {
            tfTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel4.add(tfTel);
        tfTel.setBounds(140, 20, 140, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setText("Telefone Celular-1:");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(10, 70, 150, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel7.setText("Telefone Celular-2:");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(10, 120, 150, 30);

        try {
            tfTelCel1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel4.add(tfTelCel1);
        tfTelCel1.setBounds(140, 70, 140, 30);

        try {
            tfTelCel2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel4.add(tfTelCel2);
        tfTelCel2.setBounds(140, 120, 140, 30);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel14.setText("Site");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(10, 220, 120, 20);
        jPanel4.add(tfMail);
        tfMail.setBounds(10, 180, 310, 30);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel16.setText("E-Mail");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(10, 160, 120, 14);
        jPanel4.add(tfSite);
        tfSite.setBounds(10, 240, 310, 30);

        jPanel5.add(jPanel4);
        jPanel4.setBounds(10, 200, 330, 290);
        jPanel5.add(tfRG);
        tfRG.setBounds(240, 160, 100, 30);

        try {
            tfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel5.add(tfCPF);
        tfCPF.setBounds(220, 100, 120, 30);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel17.setText("Empresa");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(10, 80, 100, 20);
        jPanel5.add(tfEmpresa);
        tfEmpresa.setBounds(10, 100, 200, 30);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel19.setText("RG");
        jPanel5.add(jLabel19);
        jLabel19.setBounds(240, 140, 20, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel9.setText("Sexo");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(140, 140, 40, 20);

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        cbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSexoActionPerformed(evt);
            }
        });
        jPanel5.add(cbSexo);
        cbSexo.setBounds(130, 160, 96, 30);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(10, 61, 350, 520);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel6.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel10.setText("Logradouro");
        jPanel6.add(jLabel10);
        jLabel10.setBounds(10, 21, 130, 20);
        jPanel6.add(tfLogradouro);
        tfLogradouro.setBounds(10, 41, 330, 30);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel11.setText("Bairro");
        jPanel6.add(jLabel11);
        jLabel11.setBounds(10, 81, 100, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel12.setText("Número");
        jPanel6.add(jLabel12);
        jLabel12.setBounds(360, 21, 70, 20);
        jPanel6.add(tfNumero);
        tfNumero.setBounds(360, 41, 80, 30);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel13.setText("Cidade");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(160, 86, 39, 15);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel15.setText("CEP");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(310, 81, 30, 20);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Complemento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tfComplemento.setColumns(20);
        tfComplemento.setRows(5);
        tfComplemento.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tfComplementoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tfComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfComplementoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tfComplemento);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(10, 151, 430, 130);
        jPanel6.add(tfCidade);
        tfCidade.setBounds(160, 100, 130, 30);
        jPanel6.add(tfBairro);
        tfBairro.setBounds(10, 100, 130, 30);

        try {
            tfCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel6.add(tfCEP);
        tfCEP.setBounds(310, 100, 130, 30);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(370, 61, 450, 290);

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observações do Fornecedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel7.setLayout(new java.awt.BorderLayout());

        tfOBSCliente.setColumns(20);
        tfOBSCliente.setRows(5);
        tfOBSCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        tfOBSCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfOBSClienteKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tfOBSCliente);

        jPanel7.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel7);
        jPanel7.setBounds(370, 351, 450, 230);

        jToolBar1.setBackground(new java.awt.Color(204, 204, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setRollover(true);

        btSalvar.setFont(new java.awt.Font("Arial", 1, 12));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/gravar.png"))); // NOI18N
        btSalvar.setMnemonic('s');
        btSalvar.setText("Salvar");
        btSalvar.setToolTipText("Salvar (Alt+S)");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btSalvar);

        btNovo.setFont(new java.awt.Font("Arial", 1, 12));
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Novo.png"))); // NOI18N
        btNovo.setMnemonic('n');
        btNovo.setText("Novo");
        btNovo.setToolTipText("Novo (Alt+N)");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btNovo);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 12));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cancelar.png"))); // NOI18N
        btCancelar.setMnemonic('c');
        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("Cancelar (Alt+C)");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btCancelar);

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(10, 11, 810, 40);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-836)/2, (screenSize.height-619)/2, 836, 619);
    }// </editor-fold>//GEN-END:initComponents

    private void cbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSexoActionPerformed

    private void tfComplementoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tfComplementoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tfComplementoAncestorAdded

    private void tfComplementoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfComplementoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            tfComplemento.transferFocus();
        }
    }//GEN-LAST:event_tfComplementoKeyPressed

    private void tfOBSClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfOBSClienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            tfOBSCliente.transferFocus();
        }
    }//GEN-LAST:event_tfOBSClienteKeyPressed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed


        if (tfNome.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, " O campo nome é obrigatório.\n Fornecedor não cadastrado.", "Atenção", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean cond = fornecedorController.cadastrarFornecedorFisico(tfNome.getText(), tfEmpresa.getText(), tfSite.getText(), tfMail.getText(),
                tfCPF.getText(), tfRG.getText(), tfDataNas.getText(), tfTel.getText(), tfTelCel1.getText(), tfTelCel2.getText(),
                cbSexo.getSelectedItem().toString(), tfLogradouro.getText(), tfCidade.getText(), tfBairro.getText(), tfNumero.getText(), tfCEP.getText(),
                tfComplemento.getText(), tfOBSCliente.getText());

        if (cond) {
            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado.");

            int op = JOptionPane.showConfirmDialog(null, "Deseja retorna?", "Mensagem", JOptionPane.YES_OPTION);
            if (op == JOptionPane.YES_OPTION) {
                setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o fornecedor \"" + tfNome.getText() + ".", "Atenção", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        tfBairro.setText("");
        tfCEP.setText("");
        tfCPF.setText("");
        tfCidade.setText("");
        tfComplemento.setText("");
        tfDataNas.setText("");
        tfLogradouro.setText("");
        tfMail.setText("");
        tfNome.setText("");
        tfNumero.setText("");
        tfOBSCliente.setText("");
        tfRG.setText("");
        tfTel.setText("");
        tfTelCel1.setText("");
        tfTelCel2.setText("");
        tfEmpresa.setText("");
        tfSite.setText("");
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja concluir?", "Cadastro de Fornecedor", JOptionPane.YES_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            btNovoActionPerformed(evt);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btCancelarActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JFormattedTextField tfCEP;
    private javax.swing.JFormattedTextField tfCPF;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextArea tfComplemento;
    private javax.swing.JFormattedTextField tfDataNas;
    private javax.swing.JTextField tfEmpresa;
    private javax.swing.JTextField tfLogradouro;
    private javax.swing.JFormattedTextField tfMail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tfNumero;
    private javax.swing.JTextArea tfOBSCliente;
    private javax.swing.JTextField tfRG;
    private javax.swing.JTextField tfSite;
    private javax.swing.JFormattedTextField tfTel;
    private javax.swing.JFormattedTextField tfTelCel1;
    private javax.swing.JFormattedTextField tfTelCel2;
    // End of variables declaration//GEN-END:variables
}

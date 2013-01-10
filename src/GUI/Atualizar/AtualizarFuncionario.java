package GUI.Atualizar;

import Controler.FuncionarioController;
import Entidade.Funcionario;
import GUI.*;
import Util.Converte;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class AtualizarFuncionario extends javax.swing.JDialog {

    private FuncionarioController funcionarioController;
    private PesquisarFuncionario pesquisarUsuario;
    private Funcionario funcionario;
    private Long codigo;
    private boolean tipo = true;

    public AtualizarFuncionario(java.awt.Frame parent, PesquisarFuncionario pesquisarUsuario, Long codigo) {
        super(parent);
        initComponents();
        this.codigo = codigo;
        this.pesquisarUsuario = pesquisarUsuario;
        this.funcionarioController = new FuncionarioController();
        mostrarDados();
        tfComplemento.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        tfOBSCliente.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
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
        cbSexo = new javax.swing.JComboBox();
        cbEstadoCivil = new javax.swing.JComboBox();
        tfRG = new javax.swing.JTextField();
        tfCPF = new javax.swing.JFormattedTextField();
        cbFuncao = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        tfSalario = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
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
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rbGerencial = new javax.swing.JRadioButton();
        rbOperacional = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tfSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar dados do Funcionário");

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel5.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Nome");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(10, 21, 40, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText(" CPF");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(10, 81, 30, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Função");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(140, 140, 70, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data de Nas.");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(10, 141, 120, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Estado Civil");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(20, 430, 100, 15);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Sexo");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(220, 430, 40, 15);
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

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Telefone Celular-1:");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(10, 70, 150, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("E-Mail");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(10, 160, 120, 14);
        jPanel4.add(tfMail);
        tfMail.setBounds(10, 180, 310, 30);

        jPanel5.add(jPanel4);
        jPanel4.setBounds(10, 201, 330, 220);

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        cbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSexoActionPerformed(evt);
            }
        });
        jPanel5.add(cbSexo);
        cbSexo.setBounds(210, 451, 96, 30);

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Solteiro(a)", "Casado(a)", "Viúvo(a)", "Divorciado(a)" }));
        jPanel5.add(cbEstadoCivil);
        cbEstadoCivil.setBounds(20, 450, 110, 30);
        jPanel5.add(tfRG);
        tfRG.setBounds(140, 100, 90, 30);

        try {
            tfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel5.add(tfCPF);
        tfCPF.setBounds(10, 100, 110, 30);

        cbFuncao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "função" }));
        jPanel5.add(cbFuncao);
        cbFuncao.setBounds(140, 160, 180, 30);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Salário");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(250, 80, 60, 20);

        tfSalario.setText("0");
        jPanel5.add(tfSalario);
        tfSalario.setBounds(250, 100, 70, 30);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setText("RG");
        jPanel5.add(jLabel19);
        jLabel19.setBounds(140, 80, 20, 20);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(10, 61, 350, 520);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel6.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Logradouro");
        jPanel6.add(jLabel10);
        jLabel10.setBounds(10, 21, 130, 20);
        jPanel6.add(tfLogradouro);
        tfLogradouro.setBounds(10, 41, 330, 30);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Bairro");
        jPanel6.add(jLabel11);
        jLabel11.setBounds(10, 81, 100, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Número");
        jPanel6.add(jLabel12);
        jLabel12.setBounds(360, 21, 70, 20);
        jPanel6.add(tfNumero);
        tfNumero.setBounds(360, 41, 80, 30);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Cidade");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(160, 86, 49, 15);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("CEP");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(310, 81, 30, 20);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Complemento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        tfComplemento.setColumns(20);
        tfComplemento.setRows(5);
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
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observações do Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
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
        jPanel7.setBounds(570, 351, 250, 230);

        jToolBar1.setBackground(new java.awt.Color(204, 204, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setRollover(true);

        btSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alterar.png"))); // NOI18N
        btSalvar.setMnemonic('s');
        btSalvar.setText("Atualizar");
        btSalvar.setToolTipText("Salvar (Alt+S)");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btSalvar);

        btNovo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Novo.png"))); // NOI18N
        btNovo.setMnemonic('n');
        btNovo.setText("Limpar");
        btNovo.setToolTipText("Novo (Alt+N)");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btNovo);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Voltar.png"))); // NOI18N
        btCancelar.setMnemonic('v');
        btCancelar.setText("Voltar");
        btCancelar.setToolTipText("Voltar (Alt+V)");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btCancelar);

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(10, 11, 810, 40);

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permições de Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel8.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel3.setLayout(null);

        rbGerencial.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rbGerencial);
        rbGerencial.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbGerencial.setText("Gerencial");
        rbGerencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGerencialActionPerformed(evt);
            }
        });
        jPanel3.add(rbGerencial);
        rbGerencial.setBounds(10, 50, 120, 24);

        rbOperacional.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rbOperacional);
        rbOperacional.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        rbOperacional.setSelected(true);
        rbOperacional.setText("Operacional");
        rbOperacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOperacionalActionPerformed(evt);
            }
        });
        jPanel3.add(rbOperacional);
        rbOperacional.setBounds(10, 20, 130, 24);

        jPanel8.add(jPanel3);
        jPanel3.setBounds(10, 140, 170, 80);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("Login de Acesso");
        jPanel8.add(jLabel16);
        jLabel16.setBounds(20, 20, 160, 20);
        jPanel8.add(tfLogin);
        tfLogin.setBounds(20, 40, 170, 30);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Senha");
        jPanel8.add(jLabel18);
        jLabel18.setBounds(20, 80, 60, 20);
        jPanel8.add(tfSenha);
        tfSenha.setBounds(20, 100, 170, 30);

        jPanel1.add(jPanel8);
        jPanel8.setBounds(370, 350, 200, 230);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-839)/2, (screenSize.height-635)/2, 839, 635);
    }// </editor-fold>//GEN-END:initComponents

private void cbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSexoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_cbSexoActionPerformed

private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
    float salario = 0;
    try {
        salario = Converte.getInstance().converteTextoNumero(tfSalario.getText());
    } catch (NumberFormatException err) {
        JOptionPane.showMessageDialog(null, "Formato de numero invalido.", "Atenção", 0);
        return;
    }
    if (tfLogin.getText().length() < 6) {
        JOptionPane.showMessageDialog(null, " Login de acesso muito curto, o mínimo são seis caracteres.\n Funcionário não cadastrado.", "Atenção", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (tfSenha.getText().length() < 6) {
        JOptionPane.showMessageDialog(null, " Senha muito curta, o mínimo são seis caracteres.\n Funcionário não cadastrado.", "Atenção", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (tfNome.getText().equalsIgnoreCase("")) {
        JOptionPane.showMessageDialog(null, " O campo nome é obrigatório.\n Funcionário não cadastrado.", "Atenção", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String senha = JOptionPane.showInputDialog(null, "Redigite a senha para confirmação.", "Confirmar Senha", 1);

    if (senha.equalsIgnoreCase(tfSenha.getText().toString())) {

        funcionarioController.toString();

        boolean cond = funcionarioController.atualizarFuncionario(funcionario, tfNome.getText(), tfLogin.getText(), tfSenha.getText(), tfMail.getText(),
                tfCPF.getText(), tfRG.getText(), tfDataNas.getText(), tfTel.getText(), tfTelCel1.getText(), tfTelCel2.getText(),
                cbSexo.getSelectedItem().toString(), cbEstadoCivil.getSelectedItem().toString(), cbFuncao.getSelectedItem().toString(),
                salario, tipo, tfLogradouro.getText(), tfCidade.getText(), tfBairro.getText(), tfNumero.getText(), tfCEP.getText(),
                tfComplemento.getText(), tfOBSCliente.getText());

        if (cond) {
            JOptionPane.showMessageDialog(null, "Dados Atualizados.");
        }
        int op = JOptionPane.showConfirmDialog(null, "Deseja retorna?", "Mensagem", JOptionPane.YES_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            this.pesquisarUsuario.setVisible(true);
            this.setVisible(false);
        }
    } else {
        JOptionPane.showMessageDialog(null, "A senha informada e diferente, por favor, corrija.\n Funcionário não cadastrado.", "Atenção", JOptionPane.ERROR_MESSAGE);
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
    tfLogin.setText("");
    tfSenha.setText("");
    tfSalario.setText("0");
}//GEN-LAST:event_btNovoActionPerformed

private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
    int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja concluir?", "Cadastro de Cliente", JOptionPane.YES_OPTION);

    if (op == JOptionPane.YES_OPTION) {
        btNovoActionPerformed(evt);
        this.pesquisarUsuario.setVisible(true);
        this.setVisible(false);
    }
}//GEN-LAST:event_btCancelarActionPerformed

private void rbGerencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGerencialActionPerformed
    this.tipo = false;
}//GEN-LAST:event_rbGerencialActionPerformed

private void rbOperacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOperacionalActionPerformed
    this.tipo = true;
}//GEN-LAST:event_rbOperacionalActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbEstadoCivil;
    private javax.swing.JComboBox cbFuncao;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JRadioButton rbGerencial;
    private javax.swing.JRadioButton rbOperacional;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JFormattedTextField tfCEP;
    private javax.swing.JFormattedTextField tfCPF;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextArea tfComplemento;
    private javax.swing.JFormattedTextField tfDataNas;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JTextField tfLogradouro;
    private javax.swing.JFormattedTextField tfMail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tfNumero;
    private javax.swing.JTextArea tfOBSCliente;
    private javax.swing.JTextField tfRG;
    private javax.swing.JTextField tfSalario;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JFormattedTextField tfTel;
    private javax.swing.JFormattedTextField tfTelCel1;
    private javax.swing.JFormattedTextField tfTelCel2;
    // End of variables declaration//GEN-END:variables

    private void mostrarDados() {
        try {

            funcionario = funcionarioController.findPesquisa(codigo);

            tfNome.setText(funcionario.getNome());
            tfBairro.setText(funcionario.getEndereco().getBairro());
            tfCEP.setText(funcionario.getEndereco().getCep());
            tfCPF.setText(funcionario.getCpf_cnpj());
            tfCidade.setText(funcionario.getEndereco().getCidade());
            tfComplemento.setText(funcionario.getEndereco().getComp());
            tfDataNas.setText(funcionario.getData_nas());
            tfLogradouro.setText(funcionario.getEndereco().getLogradouro());
            tfMail.setText(funcionario.getEmail());
            tfNumero.setText(funcionario.getEndereco().getNumero());
            tfOBSCliente.setText(funcionario.getEndereco().getObs());
            tfRG.setText(funcionario.getRg());
            tfTel.setText(funcionario.getTel_fixo());
            tfTelCel1.setText(funcionario.getCel1());
            tfTelCel2.setText(funcionario.getCel2());
            tfLogin.setText(funcionario.getLogin());
            tfSenha.setText(funcionario.getSenha());
            tfSalario.setText("" + funcionario.getSalario());

            cbEstadoCivil.setSelectedItem(funcionario.getEstado_civil());
            cbFuncao.setSelectedItem(funcionario.getFuncao());
            cbSexo.setSelectedItem(funcionario.getSexo());

            if (!funcionario.isTipo()) {
                rbGerencial.setSelected(true);
            } else {
                rbOperacional.setSelected(true);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel mostrar os dados deste funcionário.");
        }
    }
}

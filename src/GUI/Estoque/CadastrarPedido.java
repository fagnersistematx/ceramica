package GUI.Estoque;

import GUI.Pesquisa;
import Util.JCalendar;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class CadastrarPedido extends javax.swing.JDialog {

    private Long codigo;
    private JCalendar jcalendar;
    private int tab;
    private Pesquisa pesquisa;

    public CadastrarPedido(java.awt.Frame parent, Pesquisa pesquisa) {
        super(parent);
        initComponents();
        this.pesquisa = pesquisa;
        this.calendario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfReceber = new javax.swing.JTextField();
        btReceber = new javax.swing.JButton();
        tfReceber1 = new javax.swing.JTextField();
        btReceber1 = new javax.swing.JButton();
        tfReceber2 = new javax.swing.JTextField();
        painelData = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPessoa = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        tfReceber3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_obs = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfReceber4 = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        BTVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pedido");

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabel1.setText("Cliente");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 80, 39, 16);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabel3.setText("Valor Total do Pedido");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(680, 540, 120, 16);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabel4.setText("Responsável");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 140, 73, 16);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabel5.setText("Data da Entrega");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(680, 80, 90, 16);
        jPanel1.add(tfReceber);
        tfReceber.setBounds(20, 100, 250, 30);

        btReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/2960_32x32.png"))); // NOI18N
        btReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceberActionPerformed(evt);
            }
        });
        jPanel1.add(btReceber);
        btReceber.setBounds(270, 90, 40, 40);
        jPanel1.add(tfReceber1);
        tfReceber1.setBounds(20, 160, 250, 30);

        btReceber1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/2960_32x32.png"))); // NOI18N
        btReceber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceber1ActionPerformed(evt);
            }
        });
        jPanel1.add(btReceber1);
        btReceber1.setBounds(270, 150, 40, 40);

        tfReceber2.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jPanel1.add(tfReceber2);
        tfReceber2.setBounds(670, 560, 200, 30);

        painelData.setBackground(java.awt.Color.lightGray);
        painelData.setPreferredSize(new java.awt.Dimension(200, 160));

        javax.swing.GroupLayout painelDataLayout = new javax.swing.GroupLayout(painelData);
        painelData.setLayout(painelDataLayout);
        painelDataLayout.setHorizontalGroup(
            painelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        painelDataLayout.setVerticalGroup(
            painelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        jPanel1.add(painelData);
        painelData.setBounds(670, 100, 200, 160);

        jtPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome do Produto", "Quantidades de Sacos", "Valor Unit. Sacos R$", "Preço por KG", "Total em R$"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPessoaMouseClicked(evt);
            }
        });
        jtPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtPessoaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtPessoa);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 360, 860, 160);

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1358474864_Package-Warning.png"))); // NOI18N
        jButton1.setText("Remover Produto");
        jPanel1.add(jButton1);
        jButton1.setBounds(200, 310, 170, 41);

        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1358474969_Package-Add.png"))); // NOI18N
        jButton2.setText("Adicionar Produto");
        jPanel1.add(jButton2);
        jButton2.setBounds(20, 310, 170, 41);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(10, 290, 860, 10);

        tfReceber3.setEditable(false);
        jPanel1.add(tfReceber3);
        tfReceber3.setBounds(20, 220, 250, 30);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabel6.setText("Codições de Pagamento");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 200, 138, 16);

        tf_obs.setColumns(20);
        tf_obs.setRows(5);
        jScrollPane2.setViewportView(tf_obs);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(350, 100, 280, 150);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel7.setText("OBS.:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(360, 80, 90, 15);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 12));
        jLabel8.setText("Desconto");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(40, 540, 54, 16);

        tfReceber4.setFont(new java.awt.Font("Ubuntu", 1, 12));
        tfReceber4.setText("0");
        jPanel1.add(tfReceber4);
        tfReceber4.setBounds(30, 560, 190, 30);

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

        BTVoltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTVoltar.setIcon(null);
        BTVoltar.setMnemonic('v');
        BTVoltar.setText("Voltar");
        BTVoltar.setToolTipText("Voltar (Alt+V)");
        BTVoltar.setFocusable(false);
        BTVoltar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BTVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTVoltarActionPerformed(evt);
            }
        });
        jToolBar1.add(BTVoltar);

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(10, 11, 860, 40);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-888)/2, (screenSize.height-661)/2, 888, 661);
    }// </editor-fold>//GEN-END:initComponents

    private void btReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceberActionPerformed
    }//GEN-LAST:event_btReceberActionPerformed

    private void btReceber1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceber1ActionPerformed
    }//GEN-LAST:event_btReceber1ActionPerformed

    private void jtPessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPessoaMouseClicked
        int linha = jtPessoa.getSelectedRow();
        codigo = (Long) jtPessoa.getValueAt(linha, 0);
    }//GEN-LAST:event_jtPessoaMouseClicked

    private void jtPessoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPessoaKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                jtPessoaMouseClicked(null);
            }
            if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                if (tab % 2 == 0) {
                    jtPessoa.transferFocus();
                }
                tab++;
            }
        } catch (Exception erro) {
        }
    }//GEN-LAST:event_jtPessoaKeyPressed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
       
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja concluir?", "Cadastro de Fornecedor", JOptionPane.YES_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            btNovoActionPerformed(evt);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btCancelarActionPerformed

private void BTVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTVoltarActionPerformed
    pesquisa.setVisible(true);
    this.setVisible(false);
}//GEN-LAST:event_BTVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastrarPedido dialog = new CadastrarPedido(new javax.swing.JFrame(), null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTVoltar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btReceber;
    private javax.swing.JButton btReceber1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable jtPessoa;
    private javax.swing.JPanel painelData;
    private javax.swing.JTextField tfReceber;
    private javax.swing.JTextField tfReceber1;
    private javax.swing.JTextField tfReceber2;
    private javax.swing.JTextField tfReceber3;
    private javax.swing.JTextField tfReceber4;
    private javax.swing.JTextArea tf_obs;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo para adicionar calendario aos paineis painelData e
     * painelDataDespesa.
     */
    private void calendario() {
        jcalendar = new JCalendar();
        jcalendar.setBounds(1, 1, painelData.getWidth(), painelData.getHeight());
        painelData.add(jcalendar);
        pack();
    }
}

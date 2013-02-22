package GUI.Conta;

import Entidade.Conta.Conta;
import Fachada.Fachada;
import GUI.PesquisaPessoa;
import Util.Converte;
import Util.JCalendar;
import gerenciadorclientes.GerenciadorClientesApp;
import java.util.Calendar;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author fagner
 */
public class TelaReceita extends javax.swing.JDialog {

    private JCalendar jcalendarReceita;
    private JCalendar jcalendarDespesa;
    private JDialog adicionarPlanoConta;
    private JDialog pesquisaPessoa;
    private Long codigoReceber;
    private String funcaoReceber;
    private String nomeReceber;
    private Long codigoPagar;
    private String funcaoPagar;
    private String nomePagar;
    private static final int RECEITA = 1;
    private static final int DESPESA = 2;
    private ComboMenuBar cd;

    public TelaReceita(java.awt.Frame parent, int index) {
        super(parent);
        initComponents();
        calendario();
        menuComboBox();
        selectedTipoDeConta(index);
        preencheComboBoxConta();
    }

    /**
     * Metodo para adicionar calendario aos paineis painelData e
     * painelDataDespesa.
     */
    private void calendario() {
        jcalendarReceita = new JCalendar();
        jcalendarReceita.setBounds(1, 1, painelData.getWidth(), painelData.getHeight());
        painelData.add(jcalendarReceita);
        pack();

        jcalendarDespesa = new JCalendar();
        jcalendarDespesa.setBounds(1, 1, painelDataDespesa.getWidth(), painelDataDespesa.getHeight());
        painelDataDespesa.add(jcalendarDespesa);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        painelConta = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbContaReceita = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_obs = new javax.swing.JTextArea();
        painelData = new javax.swing.JPanel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        painelMenuReceita = new javax.swing.JPanel();
        btAddPlano = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        tfReceber = new javax.swing.JTextField();
        btReceber = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbContaDespesa = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfObsDespesa = new javax.swing.JTextArea();
        painelDataDespesa = new javax.swing.JPanel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        btSalvarDespesa = new javax.swing.JButton();
        btCancelarDespesa = new javax.swing.JButton();
        painelMenuDespesa = new javax.swing.JPanel();
        btAddPlanoContaDespesa = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        tfValorDespesa = new javax.swing.JTextField();
        btPagar = new javax.swing.JButton();
        tfPagar = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(null);

        painelConta.setBackground(new java.awt.Color(38, 116, 217));
        painelConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelContaMouseClicked(evt);
            }
        });
        painelConta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                painelContaKeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Receber De:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 80, 120, 15);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Plano de Conta:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 140, 150, 15);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Conta:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 20, 90, 15);

        jPanel2.add(cbContaReceita);
        cbContaReceita.setBounds(20, 40, 278, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("OBS.:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(330, 20, 90, 15);

        tf_obs.setColumns(20);
        tf_obs.setRows(5);
        jScrollPane1.setViewportView(tf_obs);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(320, 40, 280, 150);

        painelData.setBackground(new java.awt.Color(255, 255, 255));
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

        jPanel2.add(painelData);
        painelData.setBounds(50, 220, 200, 160);
        jPanel2.add(jFormattedTextField1);
        jFormattedTextField1.setBounds(745, 231, 162, 32);

        jButton1.setText("Salvar");
        jPanel2.add(jButton1);
        jButton1.setBounds(360, 340, 90, 30);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar);
        btCancelar.setBounds(480, 340, 90, 30);

        painelMenuReceita.setLayout(new java.awt.BorderLayout());
        jPanel2.add(painelMenuReceita);
        painelMenuReceita.setBounds(20, 160, 250, 30);

        btAddPlano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        btAddPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddPlanoActionPerformed(evt);
            }
        });
        jPanel2.add(btAddPlano);
        btAddPlano.setBounds(270, 150, 40, 40);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jTextField1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(380, 230, 170, 70);

        tfReceber.setEditable(false);
        jPanel2.add(tfReceber);
        tfReceber.setBounds(20, 100, 250, 30);

        btReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/2960_32x32.png"))); // NOI18N
        btReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReceberActionPerformed(evt);
            }
        });
        jPanel2.add(btReceber);
        btReceber.setBounds(270, 90, 40, 40);

        painelConta.addTab(" Depósito", jPanel2);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Pagar Para:");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(20, 80, 120, 15);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Plano de Conta:");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(20, 140, 150, 15);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Conta:");
        jPanel6.add(jLabel8);
        jLabel8.setBounds(20, 20, 90, 15);

        jPanel6.add(cbContaDespesa);
        cbContaDespesa.setBounds(20, 40, 278, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("OBS.:");
        jPanel6.add(jLabel2);
        jLabel2.setBounds(330, 20, 90, 15);

        tfObsDespesa.setColumns(20);
        tfObsDespesa.setRows(5);
        jScrollPane2.setViewportView(tfObsDespesa);

        jPanel6.add(jScrollPane2);
        jScrollPane2.setBounds(320, 40, 280, 150);

        painelDataDespesa.setBackground(new java.awt.Color(255, 255, 255));
        painelDataDespesa.setPreferredSize(new java.awt.Dimension(200, 160));

        javax.swing.GroupLayout painelDataDespesaLayout = new javax.swing.GroupLayout(painelDataDespesa);
        painelDataDespesa.setLayout(painelDataDespesaLayout);
        painelDataDespesaLayout.setHorizontalGroup(
            painelDataDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        painelDataDespesaLayout.setVerticalGroup(
            painelDataDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        jPanel6.add(painelDataDespesa);
        painelDataDespesa.setBounds(50, 220, 200, 160);
        jPanel6.add(jFormattedTextField2);
        jFormattedTextField2.setBounds(745, 231, 162, 32);

        btSalvarDespesa.setText("Salvar");
        btSalvarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarDespesaActionPerformed(evt);
            }
        });
        jPanel6.add(btSalvarDespesa);
        btSalvarDespesa.setBounds(360, 340, 90, 30);

        btCancelarDespesa.setText("Cancelar");
        btCancelarDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarDespesaActionPerformed(evt);
            }
        });
        jPanel6.add(btCancelarDespesa);
        btCancelarDespesa.setBounds(480, 340, 90, 30);

        painelMenuDespesa.setLayout(new java.awt.BorderLayout());
        jPanel6.add(painelMenuDespesa);
        painelMenuDespesa.setBounds(20, 160, 250, 30);

        btAddPlanoContaDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        btAddPlanoContaDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddPlanoContaDespesaActionPerformed(evt);
            }
        });
        jPanel6.add(btAddPlanoContaDespesa);
        btAddPlanoContaDespesa.setBounds(270, 150, 40, 40);

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel7.setLayout(new java.awt.BorderLayout());
        jPanel7.add(tfValorDespesa, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel7);
        jPanel7.setBounds(380, 230, 170, 70);

        btPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/2960_32x32.png"))); // NOI18N
        btPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPagarActionPerformed(evt);
            }
        });
        jPanel6.add(btPagar);
        btPagar.setBounds(270, 90, 40, 40);

        tfPagar.setEditable(false);
        jPanel6.add(tfPagar);
        tfPagar.setBounds(20, 100, 250, 30);

        painelConta.addTab("Despesa", jPanel6);

        jPanel1.add(painelConta);
        painelConta.setBounds(20, 10, 620, 430);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-654)/2, (screenSize.height-484)/2, 654, 484);
    }// </editor-fold>//GEN-END:initComponents

private void painelContaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_painelContaKeyPressed
// TODO add your handling code here:
}//GEN-LAST:event_painelContaKeyPressed

private void painelContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelContaMouseClicked
    tituloJanela();
}//GEN-LAST:event_painelContaMouseClicked

    private void btAddPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddPlanoActionPerformed
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        adicionarPlanoConta = new AdicionarPlanoDeConta(mainFrame, true, this);
        GerenciadorClientesApp.getApplication().show(adicionarPlanoConta);
        adicionarPlanoConta.setSize(486, 387);
        setVisible(false);
    }//GEN-LAST:event_btAddPlanoActionPerformed

    private void btAddPlanoContaDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddPlanoContaDespesaActionPerformed
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        adicionarPlanoConta = new AdicionarPlanoDeConta(mainFrame, false, this);
        GerenciadorClientesApp.getApplication().show(adicionarPlanoConta);
        adicionarPlanoConta.setSize(486, 387);
        setVisible(false);
    }//GEN-LAST:event_btAddPlanoContaDespesaActionPerformed

    private void btReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReceberActionPerformed
        pesquisarPessoa(RECEITA);
    }//GEN-LAST:event_btReceberActionPerformed

    private void btPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPagarActionPerformed
        pesquisarPessoa(DESPESA);
    }//GEN-LAST:event_btPagarActionPerformed

    private void btSalvarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarDespesaActionPerformed
        float valor = 0;
        valor = Converte.getInstance().converteTextoNumero(tfValorDespesa.getText());
        if (valor != 0) {
            if (null == Fachada.getInstance().criarFluxoDespesa("", valor, tfObsDespesa.getText(), Calendar.getInstance(), jcalendarDespesa.getCalendar(),
                    Fachada.getInstance().pesquisarPessoa(codigoPagar, funcaoPagar), Fachada.getInstance().buscaItensPlanoConta(cd.getSelectedItem()), cbContaDespesa.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar esta Despesa", "Atenção", JOptionPane.ERROR_MESSAGE);
            }
        } else {
        }
    }//GEN-LAST:event_btSalvarDespesaActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
       
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btCancelarDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarDespesaActionPerformed
        
    }//GEN-LAST:event_btCancelarDespesaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReceita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaReceita dialog = new TelaReceita(new javax.swing.JFrame(), 0);
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
    private javax.swing.JButton btAddPlano;
    private javax.swing.JButton btAddPlanoContaDespesa;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelarDespesa;
    private javax.swing.JButton btPagar;
    private javax.swing.JButton btReceber;
    private javax.swing.JButton btSalvarDespesa;
    private javax.swing.JComboBox cbContaDespesa;
    private javax.swing.JComboBox cbContaReceita;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTabbedPane painelConta;
    private javax.swing.JPanel painelData;
    private javax.swing.JPanel painelDataDespesa;
    private javax.swing.JPanel painelMenuDespesa;
    private javax.swing.JPanel painelMenuReceita;
    private javax.swing.JTextArea tfObsDespesa;
    private javax.swing.JTextField tfPagar;
    private javax.swing.JTextField tfReceber;
    private javax.swing.JTextField tfValorDespesa;
    private javax.swing.JTextArea tf_obs;
    // End of variables declaration//GEN-END:variables

    public void menuComboBox() {

        painelMenuDespesa.removeAll();
        painelMenuReceita.removeAll();
        cd = new ComboBoxMenu(false).getComboMenu();
        painelMenuDespesa.add(cd);
        painelMenuReceita.add(new ComboBoxMenu(true).getComboMenu());
    }
   
    private void tituloJanela() {
        if (painelConta.getSelectedIndex() == 0) {
            this.setTitle("Receita");
        }
        if (painelConta.getSelectedIndex() == 1) {
            this.setTitle("Despesa");
        }
        if (painelConta.getSelectedIndex() == 2) {
            this.setTitle("Transferência");
        }
    }

    private void selectedTipoDeConta(int index) {
        painelConta.setSelectedIndex(index);
        tituloJanela();
    }

    private void preencheComboBoxConta() {
        List<Object> contas = Fachada.getInstance().listarContas();
        for (Object o : contas) {
            Conta c = (Conta) o;
            cbContaDespesa.addItem(c.getNome());
            cbContaReceita.addItem(c.getNome());
        }
    }

    public void receberDe(Long id, String nome, String funcao) {
        tfReceber.setText(nome);
        this.codigoReceber = id;
        this.nomeReceber = nome;
        this.funcaoReceber = funcao;
    }

    public void pagarPara(Long id, String nome, String funcao) {
        tfPagar.setText(nome);
        this.codigoPagar = id;
        this.nomeReceber = nome;
        this.funcaoPagar = funcao;
    }

    private void pesquisarPessoa(int op) {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        pesquisaPessoa = new PesquisaPessoa(mainFrame, this, op);
        GerenciadorClientesApp.getApplication().show(pesquisaPessoa);
        pesquisaPessoa.setSize(644, 350);
        this.setVisible(false);
    }
}

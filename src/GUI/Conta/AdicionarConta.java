package GUI.Conta;

import Fachada.Fachada;
import Util.Converte;
import Util.JCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author fagner
 */
public class AdicionarConta extends javax.swing.JDialog {

    private ListaContas listaConta;
    private JCalendar jcalendar;

    public AdicionarConta(java.awt.Frame parent, ListaContas listaConta) {
        super(parent);
        this.listaConta = listaConta;
        initComponents();
        calendario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfAgencia = new javax.swing.JTextField();
        tfBanco = new javax.swing.JTextField();
        tfNumero = new javax.swing.JTextField();
        painelData = new javax.swing.JPanel();
        tfValor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btSalvar1 = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btCancelar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Conta");

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(null);

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Voltar.png"))); // NOI18N
        jButton1.setMnemonic('v');
        jButton1.setText("Voltar");
        jButton1.setToolTipText("Valor (Alt + V)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(250, 300, 110, 44);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(27, 56, 710, 10);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Adicionar Conta");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(27, 23, 138, 21);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Nome:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 80, 45, 15);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Agência:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 80, 61, 15);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Número:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(300, 150, 60, 15);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Banco:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 150, 48, 15);
        jPanel1.add(tfNome);
        tfNome.setBounds(20, 100, 233, 34);
        jPanel1.add(tfAgencia);
        tfAgencia.setBounds(290, 100, 233, 34);
        jPanel1.add(tfBanco);
        tfBanco.setBounds(20, 170, 233, 34);
        jPanel1.add(tfNumero);
        tfNumero.setBounds(290, 170, 233, 34);

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
        painelData.setBounds(540, 100, 200, 160);

        tfValor.setText("0");
        jPanel1.add(tfValor);
        tfValor.setBounds(20, 240, 230, 36);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Data do Saldo de Abertura:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(540, 80, 210, 15);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Valor do Saldo de Abertura:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 220, 240, 15);

        btSalvar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/gravar.png"))); // NOI18N
        btSalvar1.setMnemonic('s');
        btSalvar1.setText("Salvar");
        btSalvar1.setToolTipText("Salvar (Alt+S)");
        btSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar1);
        btSalvar1.setBounds(380, 300, 110, 44);

        btNovo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Novo.png"))); // NOI18N
        btNovo.setMnemonic('n');
        btNovo.setText("Novo");
        btNovo.setToolTipText("Novo (Alt+N)");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo);
        btNovo.setBounds(510, 300, 110, 44);

        btCancelar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cancelar.png"))); // NOI18N
        btCancelar1.setMnemonic('c');
        btCancelar1.setText("Cancelar");
        btCancelar1.setToolTipText("Cancelar (Alt+C)");
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar1);
        btCancelar1.setBounds(640, 300, 110, 44);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-768)/2, (screenSize.height-398)/2, 768, 398);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    setVisible(false);
    listaConta.setVisible(true);
}//GEN-LAST:event_jButton1ActionPerformed

    private void btSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvar1ActionPerformed
        float valor = 0;
        try {
            valor = Converte.getInstance().converteTextoNumero(tfValor.getText());
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Formato de numero invalido.", "Atenção", 0);
            return;
        }
        if (!Fachada.getInstance().nomeExitente(tfNome.getText())) {
            Fachada.getInstance().criarConta(tfNome.getText(), tfBanco.getText(), tfAgencia.getText(), tfNumero.getText(), jcalendar.getCalendar(), valor);
            JOptionPane.showMessageDialog(null, "Conta Cadastrada.");
            listaConta.preecherJTableConta();
        } else {
            JOptionPane.showMessageDialog(null, "Existe uma conta com o mesmo nome.", "Atenção", 0);
        }
    }//GEN-LAST:event_btSalvar1ActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        tfAgencia.setText("");
        tfBanco.setText("");
        tfNome.setText("");
        tfNumero.setText("");
        tfValor.setText("0");
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja concluir?", "Cadastro de Fornecedor", JOptionPane.YES_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            btNovoActionPerformed(evt);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btCancelar1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel painelData;
    private javax.swing.JTextField tfAgencia;
    private javax.swing.JTextField tfBanco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo para adicionar calendario ao painel com nome de painelData.
     */
    private void calendario() {
        jcalendar = new JCalendar();
        jcalendar.setBounds(1, 1, painelData.getWidth(), painelData.getHeight());
        painelData.add(jcalendar);
        pack();
    }
}

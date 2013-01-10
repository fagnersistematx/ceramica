package GUI.Conta;

import Entidade.Conta.Conta;
import Entidade.Conta.Exception.ContaException;
import Fachada.Fachada;
import Util.Converte;
import Util.JCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author fagner
 */
public class EditarConta extends javax.swing.JDialog {

    private ListaContas listaConta;
    private JCalendar jcalendar;
    private Long id;
    private String nome;

    public EditarConta(java.awt.Frame parent, ListaContas listaConta, Long id) {
        super(parent);
        this.id = id;
        this.listaConta = listaConta;
        initComponents();
        calendario();
        mostrarDados(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
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
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Conta");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Voltar.png"))); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(380, 310, 110, 30);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar);
        btCancelar.setBounds(640, 310, 90, 30);
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

        jPanel1.add(painelData);
        painelData.setBounds(540, 100, 200, 160);

        tfValor.setText("0");
        jPanel1.add(tfValor);
        tfValor.setBounds(20, 240, 230, 36);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Data do Saldo de Abertura:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(540, 80, 180, 15);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Valor do Saldo de Abertura:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 220, 180, 15);

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar);
        btSalvar.setBounds(520, 310, 90, 30);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-768)/2, (screenSize.height-398)/2, 768, 398);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    setVisible(false);
    listaConta.setVisible(true);
}//GEN-LAST:event_jButton1ActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        float valor = 0;
        try {
            valor = Converte.getInstance().converteTextoNumero(tfValor.getText());
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Formato de numero invalido.", "Atenção", 0);
            return;
        }
        if (!Fachada.getInstance().nomeExitente(tfNome.getText()) || nome.equalsIgnoreCase(tfNome.getText())) {
            
            try {
                Fachada.getInstance().alterarConta(id, tfNome.getText(), tfBanco.getText(), tfAgencia.getText(), 
                        tfNumero.getText(), jcalendar.getCalendar(), valor);
                
                JOptionPane.showMessageDialog(null, "Conta atualizada.");
                listaConta.preecherJTableConta();
            } catch (ContaException ex) {
                JOptionPane.showMessageDialog(null, "Esta conta não pode ser atualizada.", "Atenção", 0);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Existe uma conta com o mesmo nome.", "Atenção", 0);
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja concluir?", "Adicionar Conta", JOptionPane.YES_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            listaConta.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btCancelarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
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

    private void mostrarDados(Long id) {
        Conta conta;
        try {
            conta = Fachada.getInstance().buscaConta(id);
        } catch (ContaException ex) {
            JOptionPane.showMessageDialog(null, "Esta conta não pode ser alterada.");
            return;
        }

        tfAgencia.setText(conta.getAgencia());
        tfBanco.setText(conta.getBanco());
        tfNome.setText(conta.getNome());
        tfNumero.setText(conta.getNumero());
        tfValor.setText("" + conta.getValor());
        jcalendar.setCalendar(conta.getData_saldo());
        nome = conta.getNome();

    }
}

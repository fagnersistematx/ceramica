package GUI.Conta;

import Entidade.Conta.Conta;
import Entidade.Conta.Exception.ContaException;
import Fachada.Fachada;
import gerenciadorclientes.GerenciadorClientesApp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fagner
 */
public class ListaContas extends javax.swing.JDialog {

    private JDialog adicionarConta;
    private DefaultTableModel modelo;
    private Long codigo;

    public ListaContas(java.awt.Frame parent) {
        super(parent);
        initComponents();
        preecherJTableConta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConta = new javax.swing.JTable();
        btNovaConta = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Contas");

        jPanel1.setBackground(java.awt.Color.white);

        jtConta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Saldo Atual", "Banco", "Agência", "Número"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtContaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtConta);

        btNovaConta.setText("Nova Conta");
        btNovaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaContaActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Lista de Contas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btNovaConta)
                            .addGap(39, 39, 39)
                            .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                        .addComponent(jSeparator1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovaConta)
                    .addComponent(btEditar)
                    .addComponent(btExcluir))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-754)/2, (screenSize.height-391)/2, 754, 391);
    }// </editor-fold>//GEN-END:initComponents

private void btNovaContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaContaActionPerformed
    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    adicionarConta = new AdicionarConta(mainFrame, this);
    GerenciadorClientesApp.getApplication().show(adicionarConta);
    adicionarConta.setSize(768, 398);
    setVisible(false);
}//GEN-LAST:event_btNovaContaActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        if (codigo != null) {
            JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
            adicionarConta = new EditarConta(mainFrame, this, codigo);
            GerenciadorClientesApp.getApplication().show(adicionarConta);
            adicionarConta.setSize(768, 398);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma conta.", "Atenção", 0);
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void jtContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtContaMouseClicked
        int linha = jtConta.getSelectedRow();
        codigo = (Long) jtConta.getValueAt(linha, 0);
    }//GEN-LAST:event_jtContaMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (codigo != null) {
            String nomeConta;
            try {
                nomeConta = Fachada.getInstance().buscaConta(codigo).getNome();
            } catch (ContaException ex) {
                JOptionPane.showMessageDialog(null, "Conta não encontrada.", "Atenção", 0);
                return;
            }
            
            int op = JOptionPane.showConfirmDialog(null, "Tem certeza que dezeja excluir a conta " + nomeConta, "Atenção", JOptionPane.YES_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                try {
                    Fachada.getInstance().removerConta(codigo);
                    preecherJTableConta();
                    JOptionPane.showMessageDialog(null, "Conta excluída.");
                } catch (ContaException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir esta conta pois a mesma já \n"
                            + "esta relacionada com fluxos de entrada e saída.", "Atenção", 0);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma conta.", "Atenção", 0);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovaConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtConta;
    // End of variables declaration//GEN-END:variables

    public void preecherJTableConta() {

        jtConta.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtConta.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtConta.getColumnModel().getColumn(2).setPreferredWidth(50);
        jtConta.getColumnModel().getColumn(3).setPreferredWidth(25);
        jtConta.getColumnModel().getColumn(4).setPreferredWidth(90);

        modelo = (DefaultTableModel) jtConta.getModel();
        modelo.setNumRows(0);

        List<Object> contas = new ArrayList<Object>();
        contas = Fachada.getInstance().listarContas();

        try {
            for (Object o : contas) {
                Conta c = (Conta) o;
                modelo.addRow(new Object[]{
                            c.getId(),
                            c.getNome(),
                            c.getValor(),
                            c.getBanco(),
                            c.getAgencia(),
                            c.getNumero()
                        });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não conseguiu carregar a tabela de clientes." + erro);
        }
    }
}

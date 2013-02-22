package GUI.Estoque;

import Entidade.Estoque.Exception.ProdutoException;
import Entidade.Estoque.Produto;
import Fachada.Fachada;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class PesquisaProduto extends javax.swing.JDialog {

    private Produto produto;
    private int tab = 1;
    private int op;
    private EntradaProdutos entradaProdutos;

    public PesquisaProduto(java.awt.Frame parent, EntradaProdutos entradaProdutos1, int op) {
        super(parent);
        this.entradaProdutos = entradaProdutos1;
        initComponents();
        this.op = op;
        preencherJTable("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProduto = new javax.swing.JTable();
        tfNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Produto");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jtProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "Código Interno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutoMouseClicked(evt);
            }
        });
        jtProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtProdutoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtProduto);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 120, 600, 186);

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNomeKeyPressed(evt);
            }
        });
        jPanel1.add(tfNome);
        tfNome.setBounds(20, 80, 441, 30);

        jLabel1.setFont(new java.awt.Font("Arial 12 Negrito", 1, 12)); // NOI18N
        jLabel1.setText("Nome");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 60, 40, 20);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Pesquisar Produto");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 20, 190, 20);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 50, 610, 10);

        btOk.setText("OK");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });
        jPanel1.add(btOk);
        btOk.setBounds(520, 80, 70, 30);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-644)/2, (screenSize.height-350)/2, 644, 350);
    }// </editor-fold>//GEN-END:initComponents

private void jtProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutoMouseClicked
    int linha = jtProduto.getSelectedRow();
    Long codigo = (Long) jtProduto.getValueAt(linha, 0);
    try {
        produto = Fachada.getInstance().buscaProduto(codigo);
    } catch (ProdutoException ex) {
    }
}//GEN-LAST:event_jtProdutoMouseClicked

private void jtProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtProdutoKeyPressed
    try {
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            jtProdutoMouseClicked(null);
        }
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (tab % 2 == 0) {
                jtProduto.transferFocus();
            }
            tab++;
        }
    } catch (Exception erro) {
    }
}//GEN-LAST:event_jtProdutoKeyPressed

private void tfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyPressed
    preencherJTable(tfNome.getText());
}//GEN-LAST:event_tfNomeKeyPressed

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        if (produto != null) {
            entradaProdutos.setProduto(produto);
            this.setVisible(false);
            entradaProdutos.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(null, "Selecione um produto.", "Atenção", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btOkActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        tfNomeKeyPressed(null);
    }//GEN-LAST:event_tfNomeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtProduto;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

    private void preencherJTable(String nome) {

        jtProduto.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtProduto.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtProduto.getColumnModel().getColumn(2).setPreferredWidth(50);

        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);

        List<Object> produtos;
        produtos = Fachada.getInstance().listarProdutos(nome);

        try {

            for (Object object : produtos) {

                Produto p = (Produto) object;

                modelo.addRow(new Object[]{
                            p.getId(),
                            p.getNome(),
                            p.getCodigo()
                        });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel carregar a tabela de produtos." + erro);
        }
    }
}

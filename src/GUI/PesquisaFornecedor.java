package GUI;

import Controler.FornecedorController;
import Entidade.Fornecedor;
import gerenciadorclientes.GerenciadorClientesApp;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class PesquisaFornecedor extends javax.swing.JDialog {

    private Long codigo;
    private int tab = 1;
    private FornecedorController fornecedorController;

    public PesquisaFornecedor(java.awt.Frame parent) {
        super(parent);
        initComponents();
        this.fornecedorController = new FornecedorController();
        preencherJTable(1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuario = new javax.swing.JTable();
        tfNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbQuantUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuExcluirFornecedor = new javax.swing.JMenu();
        MenuAtualizarUsuario = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Fornecedor");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jtUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Tel. Fixo", "Celular", "E-mail", "Site"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuarioMouseClicked(evt);
            }
        });
        jtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtUsuarioKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtUsuario);

        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNomeKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial 12 Negrito", 1, 12));
        jLabel1.setText("Nome");

        lbQuantUsuario.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbQuantUsuario.setText("<QUANT_FFORNECEDOR>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(lbQuantUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbQuantUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        menuExcluirFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/7763_32x32.png"))); // NOI18N
        menuExcluirFornecedor.setText("Fornecedor");
        menuExcluirFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExcluirFornecedorActionPerformed(evt);
            }
        });

        MenuAtualizarUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuAtualizarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/7758_32x32.png"))); // NOI18N
        MenuAtualizarUsuario.setText("Visualizar Dados do Fornecedor");
        MenuAtualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAtualizarUsuarioActionPerformed(evt);
            }
        });
        menuExcluirFornecedor.add(MenuAtualizarUsuario);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/7752_32x32.png"))); // NOI18N
        jMenuItem2.setText("Excluir Fornecedor");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuExcluirFornecedor.add(jMenuItem2);

        jMenuBar1.add(menuExcluirFornecedor);

        setJMenuBar(jMenuBar1);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-947)/2, (screenSize.height-458)/2, 947, 458);
    }// </editor-fold>//GEN-END:initComponents

private void jtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuarioMouseClicked
    int linha = jtUsuario.getSelectedRow();
    codigo = (Long) jtUsuario.getValueAt(linha, 0);
    setTitle("Pesquisa Fornecedor - " + fornecedorController.findPesquisa(codigo).getNome());
}//GEN-LAST:event_jtUsuarioMouseClicked

private void jtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtUsuarioKeyPressed
    try {
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            jtUsuarioMouseClicked(null);
        }
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            if (tab % 2 == 0) {
                jtUsuario.transferFocus();
            }
            tab++;
        }
    } catch (Exception erro) {
    }
}//GEN-LAST:event_jtUsuarioKeyPressed

private void tfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyPressed
    this.preencherJTable(2);
}//GEN-LAST:event_tfNomeKeyPressed

private void MenuAtualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAtualizarUsuarioActionPerformed
    try {
        if (codigo != null) {
            JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
            // atualizarFuncionario = new AtualizarFuncionario(mainFrame, this, codigo);
            //GerenciadorClientesApp.getApplication().show(atualizarFuncionario);
            //  atualizarFuncionario.setSize(839, 635);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um fornecedor.", "Atenção", 0);
        }
    } catch (Exception erro) {
        JOptionPane.showMessageDialog(null, "Selecione um fornecedor.", "Atenção", 0);
    }
}//GEN-LAST:event_MenuAtualizarUsuarioActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    try {
        if (codigo != null) {
            int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este fornecedor.", "Atenção", JOptionPane.YES_OPTION);
            if (op == JOptionPane.YES_OPTION) {
                if (fornecedorController.deletarFornecedor(codigo)) {
                    JOptionPane.showMessageDialog(null, "Fornecedor excluído.");
                    this.preencherJTable(1);
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível excluir este fornecedor.", "Atenção", 0);
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um fornecedor.", "Atenção", 0);
        }
    } catch (Exception erro) {
        JOptionPane.showMessageDialog(null, "Selecione um fornecedor.", "Atenção", 0);
    }
}//GEN-LAST:event_jMenuItem2ActionPerformed

private void menuExcluirFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExcluirFornecedorActionPerformed
    
            JOptionPane.showMessageDialog(null, "Selecione um fornecedor", "Atenção", 0);
      
}//GEN-LAST:event_menuExcluirFornecedorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuAtualizarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtUsuario;
    private javax.swing.JLabel lbQuantUsuario;
    private javax.swing.JMenu menuExcluirFornecedor;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

    private void preencherJTable(int op) {

        jtUsuario.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtUsuario.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtUsuario.getColumnModel().getColumn(2).setPreferredWidth(50);
        jtUsuario.getColumnModel().getColumn(3).setPreferredWidth(25);
        jtUsuario.getColumnModel().getColumn(4).setPreferredWidth(90);

        DefaultTableModel modelo = (DefaultTableModel) jtUsuario.getModel();
        modelo.setNumRows(0);

        List<Object> fornecedores = new ArrayList<Object>();
        int quant = 0;
        try {
            if (op == 1) {
                fornecedores = fornecedorController.listarFornecedor();
            } else if (op == 2) {
                fornecedores = fornecedorController.converte(tfNome.getText());
            }
            for (Object object : fornecedores) {
                Fornecedor f = (Fornecedor) object;
                quant++;
                modelo.addRow(new Object[]{
                            f.getId(),
                            f.getNome(),
                            f.getTel_fixo(),
                            f.getCel1() + " | " + f.getCel2(),
                            f.getEmail(),
                            f.getSite()
                        });
            }
            if (op == 1) {
                lbQuantUsuario.setText("Quantidade de Fornecedores: " + quant);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não conseguiu carregar a tabela de fornecedor." + erro);
        }
    }
}

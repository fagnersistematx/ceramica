package GUI.Estoque;

import Entidade.Estoque.Exception.ProdutoException;
import Entidade.Estoque.Produto;
import Fachada.Fachada;
import javax.swing.JOptionPane;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class AlterarProduto extends javax.swing.JDialog {

    private ListaProdutos listaProdutos;
    private Produto produto;
    private Long codigo;

    public AlterarProduto(java.awt.Frame parent, ListaProdutos listaProdutos, Long codigo) {
        super(parent);
        initComponents();
        this.codigo = codigo;
        this.listaProdutos = listaProdutos;
        this.mostraDadosProduto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btCancelar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar Dados do Produto");

        jPanel1.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel1.setText("Nome do Produto");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel4.setText("Código Interno do Produto");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Atualizar Dado do Produto");

        btCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cancelar.png"))); // NOI18N
        btCancelar.setMnemonic('c');
        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("Cancelar (Alt+C)");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/gravar.png"))); // NOI18N
        btSalvar.setMnemonic('s');
        btSalvar.setText("Atualizar");
        btSalvar.setToolTipText("Atualizar (Alt+S)");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btNovo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Novo.png"))); // NOI18N
        btNovo.setMnemonic('n');
        btNovo.setText("Limpar");
        btNovo.setToolTipText("Limpar (Alt+N)");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Voltar.png"))); // NOI18N
        btVoltar.setMnemonic('v');
        btVoltar.setText("Voltar");
        btVoltar.setToolTipText("Voltar (Alt+V)");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btCancelar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfProduto)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4)))
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(tfProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-517)/2, (screenSize.height-297)/2, 517, 297);
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja concluir?", "Atualizar dados do produto", JOptionPane.YES_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            btNovoActionPerformed(evt);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (tfProduto.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do produto.", "Atenção", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Fachada.getInstance().nomeExitenteProduto(tfProduto.getText(), produto.getNome())) {
            JOptionPane.showMessageDialog(null, "Já existe um produto com este nome.", "Atenção", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Fachada.getInstance().nomeExitenteCodigoProduto(tfCodigo.getText(), produto.getNome())) {
            JOptionPane.showMessageDialog(null, "Já existe um produto com este código.", "Atenção", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            produto.setNome(tfProduto.getText());
            produto.setCodigo(tfCodigo.getText());
            Fachada.getInstance().alterarProduto(produto);
            JOptionPane.showMessageDialog(null, "Dados do produto atualizado com sucesso.");
        } catch (ProdutoException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel atualizar os dados deste produto.", "Atenção", JOptionPane.ERROR_MESSAGE);
        }

        listaProdutos.preecherJTableProdutos();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        tfProduto.setText("");
        tfCodigo.setText("");
    }//GEN-LAST:event_btNovoActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.setVisible(false);
        this.listaProdutos.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfProduto;
    // End of variables declaration//GEN-END:variables

    public final void mostraDadosProduto() {

        try {
            produto = Fachada.getInstance().buscaProduto(codigo);
        } catch (ProdutoException ex) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Atenção", 0);
            return;
        }

        tfProduto.setText(produto.getNome());
        tfCodigo.setText(produto.getCodigo());
    }
}

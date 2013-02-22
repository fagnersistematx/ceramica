package GUI.Estoque;

import Entidade.Estoque.Lote;
import Entidade.Estoque.Produto;
import Entidade.Fornecedor;
import Fachada.Fachada;
import GUI.PesquisaPessoa;
import Util.Config;
import Util.Converte;
import Util.JCalendar;
import gerenciadorclientes.GerenciadorClientesApp;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class EntradaProdutos extends javax.swing.JDialog {

    private int codigo;
    private int tab;
    private JCalendar jcalendar;
    private JDialog pesquisaProduto;
    private Produto produto;
    private List<Lote> lotes;
    private Fornecedor fornecedor;
    private JDialog pesquisaPessoa;

    public EntradaProdutos(java.awt.Frame parent) {
        super(parent);
        initComponents();
        this.calendario();
        this.lotes = new ArrayList<Lote>();
        tfDesconto.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tfReceber4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfReceber2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfProduto = new javax.swing.JTextField();
        tfNumero = new javax.swing.JTextField();
        btPesquisarProduto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfQuantSaco = new javax.swing.JTextField();
        tfPrecoKG = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfValorUnidadeSaco = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutos = new javax.swing.JTable();
        btAddProduto = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btSalvar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        tfValorTotal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfValorFinal = new javax.swing.JTextField();
        btRemover = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        painelData = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfDesconto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfNumeroNotaFiscal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfObs = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tfFornecedor = new javax.swing.JTextField();
        btPesquisarProduto1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1358474969_Package-Add.png"))); // NOI18N
        jButton2.setText("Adicionar Produto");

        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1358474864_Package-Warning.png"))); // NOI18N
        jButton1.setText("Remover Produto");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel11.setText("Desconto");

        tfReceber4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        tfReceber4.setText("0");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel3.setText("Valor Total do Pedido");

        tfReceber2.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrada de Produtos");

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Fornecedor");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(300, 80, 180, 15);

        tfProduto.setEditable(false);
        jPanel1.add(tfProduto);
        tfProduto.setBounds(20, 100, 230, 30);
        jPanel1.add(tfNumero);
        tfNumero.setBounds(420, 180, 140, 30);

        btPesquisarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/2960_32x32.png"))); // NOI18N
        btPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisarProduto);
        btPesquisarProduto.setBounds(250, 90, 40, 40);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Produto");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 80, 120, 15);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Valor Unit. Sacos R$");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(150, 160, 170, 15);

        tfQuantSaco.setText("0");
        jPanel1.add(tfQuantSaco);
        tfQuantSaco.setBounds(20, 180, 120, 30);

        tfPrecoKG.setText("0");
        jPanel1.add(tfPrecoKG);
        tfPrecoKG.setBounds(300, 180, 110, 30);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Quant. de Sacos");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 160, 120, 15);

        tfValorUnidadeSaco.setText("0");
        jPanel1.add(tfValorUnidadeSaco);
        tfValorUnidadeSaco.setBounds(150, 180, 140, 30);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(10, 140, 570, 10);

        jtProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome do Produto", "Nome do Fornecedor", "Quantidades de Sacos", "Valor Unit. Sacos R$", "Preço por KG", "Total em R$"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutosMouseClicked(evt);
            }
        });
        jtProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtProdutosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtProdutos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 290, 1120, 280);

        btAddProduto.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btAddProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1358474969_Package-Add.png"))); // NOI18N
        btAddProduto.setText("Adicionar Produto");
        btAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(btAddProduto);
        btAddProduto.setBounds(20, 240, 170, 44);

        btLimpar.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1358474959_product.png"))); // NOI18N
        btLimpar.setText("Limpar Campos");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btLimpar);
        btLimpar.setBounds(210, 240, 170, 44);

        jToolBar1.setBackground(new java.awt.Color(204, 204, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setRollover(true);

        btSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
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
        jToolBar1.add(btNovo);

        btCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cancelar.png"))); // NOI18N
        btCancelar.setMnemonic('c');
        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("Cancelar (Alt+C)");
        btCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btCancelar.setPreferredSize(new java.awt.Dimension(200, 44));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btCancelar);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Valor Total do Pedido:");
        jLabel15.setMinimumSize(new java.awt.Dimension(187, 15));
        jLabel15.setPreferredSize(new java.awt.Dimension(187, 15));
        jToolBar1.add(jLabel15);

        tfValorTotal.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        tfValorTotal.setPreferredSize(new java.awt.Dimension(150, 35));
        tfValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorTotalActionPerformed(evt);
            }
        });
        jToolBar1.add(tfValorTotal);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("      Valor Final:");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel16.setPreferredSize(new java.awt.Dimension(130, 15));
        jToolBar1.add(jLabel16);

        tfValorFinal.setEditable(false);
        tfValorFinal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfValorFinal.setPreferredSize(new java.awt.Dimension(150, 35));
        jToolBar1.add(tfValorFinal);

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(10, 11, 1120, 40);

        btRemover.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1358474864_Package-Warning.png"))); // NOI18N
        btRemover.setText("Remover Produto");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });
        jPanel1.add(btRemover);
        btRemover.setBounds(400, 240, 170, 44);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nota", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel2.setLayout(null);

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

        jPanel2.add(painelData);
        painelData.setBounds(30, 40, 200, 160);

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel14.setText("Data da Entrada");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(40, 20, 95, 15);

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel13.setText("Desconto");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(440, 20, 70, 15);

        tfDesconto.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        tfDesconto.setText("0");
        tfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDescontoKeyPressed(evt);
            }
        });
        jPanel2.add(tfDesconto);
        tfDesconto.setBounds(430, 40, 100, 30);

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel12.setText("Número da Nota Físcal");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(260, 20, 150, 15);

        tfNumeroNotaFiscal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(tfNumeroNotaFiscal);
        tfNumeroNotaFiscal.setBounds(250, 40, 170, 30);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("OBS.");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(250, 80, 120, 15);

        tfObs.setColumns(20);
        tfObs.setRows(5);
        jScrollPane2.setViewportView(tfObs);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(250, 100, 280, 100);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(580, 60, 550, 220);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel17.setText("Preço por KG");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(300, 160, 120, 15);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setText("Lote/Número");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(420, 160, 120, 15);

        tfFornecedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(tfFornecedor);
        tfFornecedor.setBounds(300, 100, 220, 30);

        btPesquisarProduto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/2960_32x32.png"))); // NOI18N
        btPesquisarProduto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarProduto1ActionPerformed(evt);
            }
        });
        jPanel1.add(btPesquisarProduto1);
        btPesquisarProduto1.setBounds(520, 90, 40, 40);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(10, 220, 570, 10);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1140)/2, (screenSize.height-615)/2, 1140, 615);
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarProdutoActionPerformed

        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        pesquisaProduto = new PesquisaProduto(mainFrame, this, 1);
        GerenciadorClientesApp.getApplication().show(pesquisaProduto);
        pesquisaProduto.setSize(644, 350);
        this.setVisible(false);

    }//GEN-LAST:event_btPesquisarProdutoActionPerformed

    private void jtProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutosMouseClicked
        int linha = jtProdutos.getSelectedRow();
        codigo = Integer.parseInt(jtProdutos.getValueAt(linha, 0).toString());
    }//GEN-LAST:event_jtProdutosMouseClicked

    private void jtProdutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtProdutosKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                jtProdutosMouseClicked(null);
            }
            if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                if (tab % 2 == 0) {
                    jtProdutos.transferFocus();
                }
                tab++;
            }
        } catch (Exception erro) {
        }
    }//GEN-LAST:event_jtProdutosKeyPressed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (confirmaEntrada()) {
            float desconto = 0;
            float total = 0;
            try {
                desconto = Converte.getInstance().converteTextoNumero(tfDesconto.getText());
            } catch (NumberFormatException erro) {
                desconto = 0;
            }
            try {
                total = Converte.getInstance().converteTextoNumero(tfValorTotal.getText());
            } catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(null, "O Valor Total do Pedido é inválido por favor corrija.", "Atenção", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (Fachada.getInstance().criarNota(lotes, desconto, total, tfNumeroNotaFiscal.getText(), jcalendar.getCalendar(), tfObs.getText()).getId() != null) {
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
            }
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        btLimparActionPerformed(evt);
        tfDesconto.setText("0");
        tfNumeroNotaFiscal.setText("");
        tfValorTotal.setText("");
        tfValorFinal.setText("");
        tfObs.setText("");
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja concluir?", "Cadastro de Produtos", JOptionPane.YES_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            btNovoActionPerformed(evt);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddProdutoActionPerformed
        Lote lote = criarLote();
        if (lote == null) {
            return;
        }
        lotes.add(lote);
        preencherJTable();
    }//GEN-LAST:event_btAddProdutoActionPerformed

private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
    tfNumero.setText("");
    tfPrecoKG.setText("0");
    tfQuantSaco.setText("0");
    tfValorUnidadeSaco.setText("0");
    tfProduto.setText("");
    produto = null;
}//GEN-LAST:event_btLimparActionPerformed

private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
    int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este produto?", "Cadastro de Produtos", JOptionPane.YES_OPTION);

    if (op == JOptionPane.YES_OPTION) {
        lotes.remove(codigo);
        preencherJTable();
    }
}//GEN-LAST:event_btRemoverActionPerformed

private void tfValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorTotalActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_tfValorTotalActionPerformed

    private void tfDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            tfDesconto.transferFocus();
        }
        this.calcularDesconto();
    }//GEN-LAST:event_tfDescontoKeyPressed

    private void btPesquisarProduto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarProduto1ActionPerformed
       
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        pesquisaPessoa = new PesquisaPessoa(mainFrame, this, 0);
        GerenciadorClientesApp.getApplication().show(pesquisaPessoa);
        pesquisaPessoa.setSize(644, 350);
        this.setVisible(false);
    
    }//GEN-LAST:event_btPesquisarProduto1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddProduto;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisarProduto;
    private javax.swing.JButton btPesquisarProduto1;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable jtProdutos;
    private javax.swing.JPanel painelData;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextField tfFornecedor;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfNumeroNotaFiscal;
    private javax.swing.JTextArea tfObs;
    private javax.swing.JTextField tfPrecoKG;
    private javax.swing.JTextField tfProduto;
    private javax.swing.JTextField tfQuantSaco;
    private javax.swing.JTextField tfReceber2;
    private javax.swing.JTextField tfReceber4;
    private javax.swing.JTextField tfValorFinal;
    private javax.swing.JTextField tfValorTotal;
    private javax.swing.JTextField tfValorUnidadeSaco;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo para setar produto que será ou não adicionado
     *
     * @param produto está variavel vem da tela de pesquisa de produto.
     */
    public void setProduto(Produto produto) {
        tfProduto.setText(produto.getNome());
        this.produto = produto;
    }
    
    public void setFornecedor(Fornecedor fornecedor){
        tfFornecedor.setText(fornecedor.getNome());
        this.fornecedor = fornecedor;
    }

    /**
     * Metodo para criar uma lote.
     *
     * @return retorna um lote criado.
     */
    public Lote criarLote() {

        try {
            if (produto == null) {
                JOptionPane.showMessageDialog(null, "Selecione um produto.", "Atenção", JOptionPane.ERROR_MESSAGE);
                return null;
            }
             if (fornecedor == null) {
                JOptionPane.showMessageDialog(null, "Selecione um fornecedor.", "Atenção", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            float quant = Converte.getInstance().converteTextoNumero(tfQuantSaco.getText());
            float valorUnidade = Converte.getInstance().converteTextoNumero(tfValorUnidadeSaco.getText());
            float precoKG = Converte.getInstance().converteTextoNumero(tfPrecoKG.getText());
            Lote lote = new Lote(tfNumero.getText(), quant, valorUnidade, precoKG, produto, fornecedor, Config.getUsuario());
            return lote;
        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(null, "Valor inválido", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Metodo para preencher a tabela de produtos.
     */
    private void preencherJTable() {

        jtProdutos.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtProdutos.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtProdutos.getColumnModel().getColumn(2).setPreferredWidth(100);

        DefaultTableModel modelo = (DefaultTableModel) jtProdutos.getModel();
        modelo.setNumRows(0);

        float valorTotal = 0;

        try {

            for (int i = 0; i < lotes.size(); i++) {


                Lote l = lotes.get(i);

                valorTotal += (l.getQuant() * l.getValor());

                modelo.addRow(new Object[]{
                            i,
                            l.getProduto().getNome(),
                            l.getFornecedor().getNome(),
                            l.getQuant(),
                            l.getValor(),
                            l.getPreco(),
                            (l.getQuant() * l.getValor())
                        });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel carregar a tabela de produtos." + erro);
        }
        tfValorTotal.setText("" + valorTotal);
        float desconto = 0;
        try {
            desconto = Converte.getInstance().converteTextoNumero(tfDesconto.getText());
        } catch (NumberFormatException erro) {
            desconto = 0;
        }
        tfValorFinal.setText("" + (valorTotal - desconto));
    }

    /**
     * Metodo para obter o valor total de todos o produtos;
     *
     * @return o valor total de todos os produtos.
     */
    private float obterValorTotalDaNota() {
        float total = 0;
        for (Lote l : lotes) {
            total += (l.getQuant() * l.getValor());
        }
        return total = 0;
    }

    /**
     * Método para comfimar todos os requisitos de entrada.
     *
     * @return false se algo estiver faltando e true se todos os requisitos de
     * entrada estiver valido.
     */
    private boolean confirmaEntrada() {
        if (lotes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Adicione algum Produto.", "Atenção", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (tfNumeroNotaFiscal.getText().equalsIgnoreCase("")) {
            int op = JOptionPane.showConfirmDialog(null, "O número da notar está vazio.\nDeseja continuar?", "Cadastro de Produtos", JOptionPane.YES_OPTION);
            if (op == JOptionPane.NO_OPTION) {
                return false;
            }
        } else if (Fachada.getInstance().exitenteNota(tfNumeroNotaFiscal.getText())) {
            JOptionPane.showMessageDialog(null, "Já existe uma nota com este número.", "Atenção", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        float valorFinal = 0;
        try {
            valorFinal = Converte.getInstance().converteTextoNumero(tfValorFinal.getText());
        } catch (NumberFormatException erro) {
            valorFinal = 0;
        }
        if (valorFinal > obterValorTotalDaNota() || valorFinal < obterValorTotalDaNota()) {
            int op = JOptionPane.showConfirmDialog(null, "O valor final é diferente do valor real\nDeseja continuar?", "Cadastro de Produtos", JOptionPane.YES_OPTION);

            if (op == JOptionPane.YES_OPTION) {
                return true;
            }
        }
        return true;
    }

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

    private void calcularDesconto() {
        float desconto = 0;
        float total = 0;
        try {
            desconto = Converte.getInstance().converteTextoNumero(tfDesconto.getText());
            total = Converte.getInstance().converteTextoNumero(tfValorTotal.getText());
        } catch (NumberFormatException erro) {
            return;
        }
        tfValorFinal.setText("" + (total - desconto));
    }
}

package GUI;

import Entidade.Cliente;
import Entidade.Fornecedor;
import Entidade.Funcionario;
import Fachada.Fachada;
import GUI.Conta.TelaReceita;
import GUI.Estoque.EntradaProdutos;
import Util.DAO;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class PesquisaPessoa extends javax.swing.JDialog {

    private Long codigo;
    private int tab = 1;
    private int op;
    private JDialog telaVoltar;
    private String nome;
    private String funcao;
    
    /**
     * Construtor para a tela de receita.
     *
     * @param parent
     * @param telaVoltar
     * @param op para direcionar para uma tela especifica.
     * @param condicao serve para definir o tipo da lista de pessoas.
     */
    public PesquisaPessoa(java.awt.Frame parent, JDialog telaVoltar, int op) {
        super(parent);
        this.telaVoltar = telaVoltar;
        initComponents();
        this.op = op;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPessoa = new javax.swing.JTable();
        tfNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisar Pessoa");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jtPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nome", "Função"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        jScrollPane1.setBounds(20, 120, 600, 186);

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
        jLabel2.setText("Pesquisar Pessoa");
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

private void jtPessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPessoaMouseClicked
    int linha = jtPessoa.getSelectedRow();
    codigo = (Long) jtPessoa.getValueAt(linha, 0);
    nome = (String) jtPessoa.getValueAt(linha, 1);
    funcao = (String) jtPessoa.getValueAt(linha, 2);
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

private void tfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyPressed
    preencherJTable(tfNome.getText());
}//GEN-LAST:event_tfNomeKeyPressed

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        if (telaVoltar instanceof TelaReceita) {
            TelaReceita telaReceita = (TelaReceita) telaVoltar;
            if (op == 1) {
                telaReceita.receberDe(codigo, nome, funcao);
            } else {
                telaReceita.pagarPara(codigo, nome, funcao);
            }
        } else if (telaVoltar instanceof EntradaProdutos) {
            EntradaProdutos entradaProdutos = (EntradaProdutos) telaVoltar;
            Fornecedor fornecedor = (Fornecedor) Fachada.getInstance().pesquisarPessoa(codigo, "Fornecedor");
            entradaProdutos.setFornecedor(fornecedor);
        }
        this.setVisible(false);
        telaVoltar.setVisible(true);
    }//GEN-LAST:event_btOkActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jtPessoa;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

    private void preencherJTable(String nome) {

        jtPessoa.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtPessoa.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtPessoa.getColumnModel().getColumn(2).setPreferredWidth(50);

        DefaultTableModel modelo = (DefaultTableModel) jtPessoa.getModel();
        modelo.setNumRows(0);

        List<Object> fornecedores = new ArrayList<Object>();
        DAO dao = new DAO();
        if (telaVoltar instanceof EntradaProdutos) {
            fornecedores.addAll(dao.pesquisar("Fornecedor", "nome", nome));
        } else {
            fornecedores.addAll(dao.pesquisar("Cliente", "nome", nome));
            fornecedores.addAll(dao.pesquisar("Funcionario", "nome", nome));
            fornecedores.addAll(dao.pesquisar("Fornecedor", "nome", nome));
        }
        try {

            for (Object object : fornecedores) {

                Long id = null;
                String nomea = null;
                String tipo = null;

                if ((object instanceof Fornecedor)) {
                    Fornecedor f = (Fornecedor) object;
                    id = f.getId();
                    nomea = f.getNome();
                    tipo = "Fornecedor";
                } else if ((object instanceof Funcionario)) {
                    Funcionario f = (Funcionario) object;
                    id = f.getId();
                    nomea = f.getNome();
                    tipo = "Funcionário";
                } else if ((object instanceof Cliente)) {
                    Cliente c = (Cliente) object;
                    id = c.getId();
                    nomea = c.getNome();
                    tipo = "Cliente";
                }
                modelo.addRow(new Object[]{
                            id,
                            nomea,
                            tipo
                        });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não conseguiu carregar a tabela de pessoa." + erro);
        }
    }
}

package GUI.Conta;

import Entidade.Conta.Exception.PlanoContaException;
import Entidade.Conta.ItensPlanoConta;
import Entidade.Conta.PlanoConta;
import Fachada.Fachada;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author fagner
 */
public class AdicionarPlanoDeConta extends javax.swing.JDialog {

    private TelaReceita telaReceita;

    public AdicionarPlanoDeConta(java.awt.Frame parent, boolean tipo, TelaReceita telaReceita) {
        super(parent);
        this.telaReceita = telaReceita;
        initComponents();
        preencheComboBoxConta();
        tipo(tipo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        rbDespesa = new javax.swing.JRadioButton();
        rbReceita = new javax.swing.JRadioButton();
        rbSub = new javax.swing.JRadioButton();
        cbSub = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Plano de Contas");

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel2.setText("Nome:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 80, 60, 15);
        jPanel1.add(tfNome);
        tfNome.setBounds(30, 100, 260, 30);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Adicionar Plano de Contas");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 30, 260, 20);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 60, 450, 10);

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Voltar.png"))); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 300, 470, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 12))); // NOI18N

        buttonGroup1.add(rbDespesa);
        rbDespesa.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        rbDespesa.setSelected(true);
        rbDespesa.setText("Despesa");
        rbDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDespesaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbReceita);
        rbReceita.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        rbReceita.setText("Receita");
        rbReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbReceitaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbSub);
        rbSub.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        rbSub.setText("Sub-Categoria De:");
        rbSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSubActionPerformed(evt);
            }
        });

        cbSub.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbSub, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSub, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rbDespesa)
                .addGap(6, 6, 6)
                .addComponent(rbReceita)
                .addGap(6, 6, 6)
                .addComponent(rbSub)
                .addGap(6, 6, 6)
                .addComponent(cbSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 140, 260, 150);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-486)/2, (screenSize.height-387)/2, 486, 387);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (rbDespesa.isSelected() || rbReceita.isSelected()) {
            if (!Fachada.getInstance().nomeExitentePlanoConta(tfNome.getName())) {
                Fachada.getInstance().criarPlanoConta(tfNome.getText(), rbReceita.isSelected());
                JOptionPane.showMessageDialog(null, "Plano de conta Cadastrado.");
                preencheComboBoxConta();
            } else {
                JOptionPane.showMessageDialog(null, "Existe um Plano de Conta com o mesmo nome.", "Atenção", 0);
            }
        } else {
            PlanoConta planoConta = null;
            try {
                planoConta = Fachada.getInstance().buscaPlanoConta(cbSub.getSelectedItem().toString());
                if (planoConta == null) {
                    throw new PlanoContaException();
                }
            } catch (PlanoContaException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar.\nPlano de Conta não foi encontrado.", "Atenção", 0);
                return;
            }
            if (!Fachada.getInstance().nomeExitenteItensPlanoConta(tfNome.getName())) {
                try {
                    List<ItensPlanoConta> itensPlanoContas = planoConta.getItensPlanoContas();
                    if (itensPlanoContas == null) {
                        itensPlanoContas = new ArrayList<ItensPlanoConta>();
                    }
                    itensPlanoContas.add(new ItensPlanoConta(tfNome.getText()));
                    Fachada.getInstance().alterarPlanoConta(planoConta.getId(), planoConta.getNome(), planoConta.isTipo(), itensPlanoContas);
                } catch (PlanoContaException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar a sub-categoria.", "Atenção", 0);
                    return;
                }

                JOptionPane.showMessageDialog(null, "Sub-categoria Cadastrada.");

            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar.\nExiste uma sub-categoria do Plano de Conta "
                        + "selecionado com o mesmo nome.", "Atenção", 0);
                return;
            }            
        }
        telaReceita.menuComboBox();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void rbSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSubActionPerformed

        cbSub.setEnabled(true);

    }//GEN-LAST:event_rbSubActionPerformed

    private void rbDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDespesaActionPerformed
        cbSub.setEnabled(false);
    }//GEN-LAST:event_rbDespesaActionPerformed

    private void rbReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbReceitaActionPerformed
        cbSub.setEnabled(false);
    }//GEN-LAST:event_rbReceitaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        telaReceita.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbSub;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbDespesa;
    private javax.swing.JRadioButton rbReceita;
    private javax.swing.JRadioButton rbSub;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

    private void preencheComboBoxConta() {
        cbSub.removeAllItems();
        List<Object> contas = Fachada.getInstance().listarPlanoConta();
        for (Object o : contas) {
            PlanoConta c = (PlanoConta) o;
            cbSub.addItem(c.getNome());
        }
    }

    private void tipo(boolean tipo) {
        if (tipo) {
            rbReceita.setSelected(tipo);
        } else {
            rbDespesa.setSelected(!tipo);
        }
    }
}

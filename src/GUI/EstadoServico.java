package GUI;

import Controler.ControleCliente;
import Entidade.Cliente;
import Entidade.Maquina;
import Entidade.Servico;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fagner
 */
public class EstadoServico extends javax.swing.JDialog {

    private int op = 1;
    private ControleCliente controleCliente;

    public EstadoServico(java.awt.Frame parent) {
        super(parent);
        initComponents();
        this.controleCliente = new ControleCliente();
        preecherJTableCliente(op);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbConcluido = new javax.swing.JRadioButton();
        rbOutro = new javax.swing.JRadioButton();
        rbManutencao = new javax.swing.JRadioButton();
        rbAguandando = new javax.swing.JRadioButton();
        rbEspera = new javax.swing.JRadioButton();
        rbAtrazado = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtServico = new javax.swing.JTable();
        lbQuantidade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(gerenciadorclientes.GerenciadorClientesApp.class).getContext().getResourceMap(EstadoServico.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel2.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel2.border.titleFont"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        rbConcluido.setBackground(resourceMap.getColor("rbEspera.background")); // NOI18N
        buttonGroup1.add(rbConcluido);
        rbConcluido.setFont(resourceMap.getFont("rbEspera.font")); // NOI18N
        rbConcluido.setText(resourceMap.getString("rbConcluido.text")); // NOI18N
        rbConcluido.setName("rbConcluido"); // NOI18N
        rbConcluido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbConcluidoActionPerformed(evt);
            }
        });

        rbOutro.setBackground(resourceMap.getColor("rbEspera.background")); // NOI18N
        buttonGroup1.add(rbOutro);
        rbOutro.setFont(resourceMap.getFont("rbEspera.font")); // NOI18N
        rbOutro.setText(resourceMap.getString("rbOutro.text")); // NOI18N
        rbOutro.setName("rbOutro"); // NOI18N
        rbOutro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOutroActionPerformed(evt);
            }
        });

        rbManutencao.setBackground(resourceMap.getColor("rbManutencao.background")); // NOI18N
        buttonGroup1.add(rbManutencao);
        rbManutencao.setFont(resourceMap.getFont("rbManutencao.font")); // NOI18N
        rbManutencao.setText(resourceMap.getString("rbManutencao.text")); // NOI18N
        rbManutencao.setName("rbManutencao"); // NOI18N
        rbManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbManutencaoActionPerformed(evt);
            }
        });

        rbAguandando.setBackground(resourceMap.getColor("rbEspera.background")); // NOI18N
        buttonGroup1.add(rbAguandando);
        rbAguandando.setFont(resourceMap.getFont("rbEspera.font")); // NOI18N
        rbAguandando.setSelected(true);
        rbAguandando.setText(resourceMap.getString("rbAguandando.text")); // NOI18N
        rbAguandando.setName("rbAguandando"); // NOI18N
        rbAguandando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAguandandoActionPerformed(evt);
            }
        });

        rbEspera.setBackground(resourceMap.getColor("rbEspera.background")); // NOI18N
        buttonGroup1.add(rbEspera);
        rbEspera.setFont(resourceMap.getFont("rbEspera.font")); // NOI18N
        rbEspera.setText(resourceMap.getString("rbEspera.text")); // NOI18N
        rbEspera.setName("rbEspera"); // NOI18N
        rbEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEsperaActionPerformed(evt);
            }
        });

        rbAtrazado.setBackground(resourceMap.getColor("rbAtrazado.background")); // NOI18N
        buttonGroup1.add(rbAtrazado);
        rbAtrazado.setFont(resourceMap.getFont("rbAtrazado.font")); // NOI18N
        rbAtrazado.setText(resourceMap.getString("rbAtrazado.text")); // NOI18N
        rbAtrazado.setName("rbAtrazado"); // NOI18N
        rbAtrazado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAtrazadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbAguandando)
                .addGap(27, 27, 27)
                .addComponent(rbAtrazado)
                .addGap(32, 32, 32)
                .addComponent(rbConcluido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42)
                .addComponent(rbEspera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(rbManutencao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(rbOutro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAguandando)
                    .addComponent(rbAtrazado)
                    .addComponent(rbConcluido)
                    .addComponent(rbEspera)
                    .addComponent(rbManutencao)
                    .addComponent(rbOutro))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBackground(resourceMap.getColor("jPanel3.background")); // NOI18N
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel3.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel3.border.titleFont"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Cliente", "Máquina", "Responsável", "Data do serviço", "Data da Entrega", "Descrição do Problema", "OBS."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtServico.setName("jtServico"); // NOI18N
        jScrollPane1.setViewportView(jtServico);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lbQuantidade.setFont(resourceMap.getFont("lbQuantidade.font")); // NOI18N
        lbQuantidade.setText(resourceMap.getString("lbQuantidade.text")); // NOI18N
        lbQuantidade.setName("lbQuantidade"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1171, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lbQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lbQuantidade)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1207)/2, (screenSize.height-613)/2, 1207, 613);
    }// </editor-fold>//GEN-END:initComponents

private void rbAguandandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAguandandoActionPerformed
    op = 1;
    preecherJTableCliente(op);
}//GEN-LAST:event_rbAguandandoActionPerformed

private void rbAtrazadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAtrazadoActionPerformed
    op = 2;
    preecherJTableCliente(op);
}//GEN-LAST:event_rbAtrazadoActionPerformed

private void rbConcluidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbConcluidoActionPerformed
    op = 3;
    preecherJTableCliente(op);
}//GEN-LAST:event_rbConcluidoActionPerformed

private void rbEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEsperaActionPerformed
    op = 4;
    preecherJTableCliente(op);
}//GEN-LAST:event_rbEsperaActionPerformed

private void rbManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbManutencaoActionPerformed
    op = 5;
    preecherJTableCliente(op);
}//GEN-LAST:event_rbManutencaoActionPerformed

private void rbOutroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOutroActionPerformed
    op = 6;
    preecherJTableCliente(op);
}//GEN-LAST:event_rbOutroActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtServico;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JRadioButton rbAguandando;
    private javax.swing.JRadioButton rbAtrazado;
    private javax.swing.JRadioButton rbConcluido;
    private javax.swing.JRadioButton rbEspera;
    private javax.swing.JRadioButton rbManutencao;
    private javax.swing.JRadioButton rbOutro;
    // End of variables declaration//GEN-END:variables

    private void preecherJTableCliente(int op) {

        jtServico.getColumnModel().getColumn(0).setPreferredWidth(10);
        jtServico.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtServico.getColumnModel().getColumn(2).setPreferredWidth(100);
        jtServico.getColumnModel().getColumn(3).setPreferredWidth(100);
        jtServico.getColumnModel().getColumn(4).setPreferredWidth(20);
        jtServico.getColumnModel().getColumn(5).setPreferredWidth(20);
        jtServico.getColumnModel().getColumn(6).setPreferredWidth(40);
        jtServico.getColumnModel().getColumn(7).setPreferredWidth(30);

        DefaultTableModel modelo = (DefaultTableModel) jtServico.getModel();
        modelo.setNumRows(0);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

        List<Cliente> clientes = new ArrayList<Cliente>();
        int quant = 0;
        try {

            clientes = controleCliente.listaServico(op);

            for (Cliente c : clientes) {
                for (Maquina m : c.getMaquinas()) {
                    for (Servico s : m.getServicos()) {
                        boolean cond = false;
                        if (s.getEstado().equalsIgnoreCase("Aguardando peça") && op == 1) {
                            cond = true;
                        } else if (!s.getEstado().equalsIgnoreCase("Concluído") && op == 2 && s.getData_entraga_servico().before(Calendar.getInstance())) {
                            cond = true;
                        } else if (s.getEstado().equalsIgnoreCase("Concluído") && op == 3) {
                            cond = true;
                        } else if (s.getEstado().equalsIgnoreCase("Em espera") && op == 4) {
                            cond = true;
                        } else if (s.getEstado().equalsIgnoreCase("Em manutenção") && op == 5) {
                            cond = true;
                        } else if (!s.getEstado().equalsIgnoreCase("Em manutenção") && !s.getEstado().equalsIgnoreCase("Em espera")
                                && !s.getEstado().equalsIgnoreCase("Concluído") && !s.getEstado().equalsIgnoreCase("Aguardando peça") && op == 6) {
                            cond = true;
                        }

                        if (cond) {
                            quant++;
                            modelo.addRow(new Object[]{
                                        s.getId(),
                                        c.getNome(),
                                        m.getFabricante() + " / " + m.getModelo() + " / " + m.getNumero(),
                                        s.getResponsavel(),
                                        sdf.format(s.getData_servico().getTime()),
                                        sdf.format(s.getData_entraga_servico().getTime()),
                                        s.getDes(),
                                        s.getObs()
                                    });

                        }
                    }
                }

            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não conseguiu carregar a tabela de clientes." + erro);
        }
        lbQuantidade.setText("Quantidade: " + quant);
    }
}

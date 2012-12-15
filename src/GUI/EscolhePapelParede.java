/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EscolhePapelParede.java
 *
 * Created on 03/10/2012, 15:04:33
 */
package GUI;

import Controler.ControleConfiguracao;
import Entidade.Configuracao;
import gerenciadorclientes.GerenciadorClientesView;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Fagner
 */
public class EscolhePapelParede extends javax.swing.JDialog {

    private String arquivo;
    private GerenciadorClientesView clientesView;

    public EscolhePapelParede(java.awt.Frame parent,GerenciadorClientesView clientesView) {
        super(parent);        
        initComponents();
        this.clientesView = clientesView;
        jfSelecao.setVisible(false);
        try {
            tfCaminho.setText(ControleConfiguracao.getCongiguracao().getPath_papel());
        } catch (Exception erro) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tfCaminho = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        jfSelecao = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(gerenciadorclientes.GerenciadorClientesApp.class).getContext().getResourceMap(EscolhePapelParede.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(null);

        jToolBar1.setBackground(resourceMap.getColor("jToolBar1.background")); // NOI18N
        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        btSalvar.setFont(resourceMap.getFont("btSalvar.font")); // NOI18N
        btSalvar.setIcon(resourceMap.getIcon("btSalvar.icon")); // NOI18N
        btSalvar.setMnemonic('s');
        btSalvar.setText(resourceMap.getString("btSalvar.text")); // NOI18N
        btSalvar.setToolTipText(resourceMap.getString("btSalvar.toolTipText")); // NOI18N
        btSalvar.setFocusable(false);
        btSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalvar.setName("btSalvar"); // NOI18N
        btSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btSalvar);

        btCancelar.setFont(resourceMap.getFont("btCancelar.font")); // NOI18N
        btCancelar.setIcon(resourceMap.getIcon("btCancelar.icon")); // NOI18N
        btCancelar.setMnemonic('c');
        btCancelar.setText(resourceMap.getString("btCancelar.text")); // NOI18N
        btCancelar.setToolTipText(resourceMap.getString("btCancelar.toolTipText")); // NOI18N
        btCancelar.setFocusable(false);
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setName("btCancelar"); // NOI18N
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btCancelar);

        jPanel1.add(jToolBar1);
        jToolBar1.setBounds(10, 11, 600, 53);

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setName("jPanel2"); // NOI18N

        tfCaminho.setEditable(false);
        tfCaminho.setText(resourceMap.getString("tfCaminho.text")); // NOI18N
        tfCaminho.setName("tfCaminho"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        btPesquisar.setIcon(resourceMap.getIcon("btPesquisar.icon")); // NOI18N
        btPesquisar.setText(resourceMap.getString("btPesquisar.text")); // NOI18N
        btPesquisar.setName("btPesquisar"); // NOI18N
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 75, 600, 114);

        jfSelecao.setName("jfSelecao"); // NOI18N
        jPanel1.add(jfSelecao);
        jfSelecao.setBounds(10, 195, 614, 386);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-634)/2, (screenSize.height-234)/2, 634, 234);
    }// </editor-fold>//GEN-END:initComponents

private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
    try {
        arquivo = null;
        FileFilter ft = new FileFilter() {

            @Override
            public boolean accept(File f) {
                String file = f.getName();
                return file.endsWith(".jpg") | f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "jpg";
            }
        };
        jfSelecao.setFileFilter(ft);
        jfSelecao.setVisible(true);
        int result = jfSelecao.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            arquivo = jfSelecao.getSelectedFile().toString();
            tfCaminho.setText(arquivo);
        }
    } catch (Exception erro) {
    }
}//GEN-LAST:event_btPesquisarActionPerformed

private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
    salvar();
}//GEN-LAST:event_btSalvarActionPerformed

private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
    setVisible(false);
}//GEN-LAST:event_btCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JFileChooser jfSelecao;
    private javax.swing.JTextField tfCaminho;
    // End of variables declaration//GEN-END:variables

    private void salvar() {
        Configuracao c = new Configuracao();
        c = ControleConfiguracao.getCongiguracao();
        c.setPath_papel(converteBarra(tfCaminho.getText()));
        ControleConfiguracao.salvarCongiguracao(c);
        clientesView.imagemTela();
    }

    private String converteBarra(String arquivo) {
        char a = '\\';
        for (int i = 0; i < arquivo.length(); i++) {
            if (a == arquivo.charAt(i)) {
                arquivo = arquivo.replace("" + arquivo.charAt(i), "/");
            }
        }
        return arquivo;
    }
}

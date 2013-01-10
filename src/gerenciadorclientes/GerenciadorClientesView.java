/*
 * GerenciadorClientesView.java
 */
package gerenciadorclientes;

import Controler.ControleConfiguracao;
import GUI.Atualizar.AlterarLoginSenhaUsuario;
import GUI.BackupAutomatico;
import GUI.BackupManual;
import GUI.CadastrarFornecedorFisico;
import GUI.CadastrarFornecedorJuridico;
import GUI.CadastrarFuncionario;
import GUI.CadastroClienteFisico;
import GUI.CadastroClienteJuridico;
import GUI.ConfiguracaoFerramentas;
import GUI.Conta.ListaContas;
import GUI.Conta.TelaReceita;
import GUI.EscolhePapelParede;
import GUI.EstadoServico;
import GUI.HistóricoBackup;
import GUI.LoguinInicial;
import GUI.Pesquisa;
import GUI.PesquisaFornecedor;
import GUI.PesquisarFuncionario;
import GUI.RestauraBackup;
import GUI.TrocarUsuario;
import Util.ConfLook;
import Util.Config;
import java.awt.event.ComponentEvent;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * The application's main frame.
 */
public final class GerenciadorClientesView extends FrameView implements ComponentListener {

    ImageIcon img;
    int x = 50, y = 50;
    private JLabel lbImagem;

    public GerenciadorClientesView(SingleFrameApplication app) {
        super(app);
        getFrame().setTitle("GCS - Gerenciador de Cliente e Serviços");
        getFrame().setFocusCycleRoot(true);
        getFrame().setFocusTraversalKeysEnabled(true);
        getFrame().setFocusTraversalPolicyProvider(true);
        getFrame().setFocusableWindowState(true);
        getFrame().setLocationByPlatform(true);
        getFrame().setIconImage(ConfLook.icone());
        getFrame().setLocationRelativeTo(null);

        initComponents();

        try {
            tfUsuario.setText("Usúario: " + Config.getUsuario().getNome());
            Config.setTfUsuario(tfUsuario);
            Config.setMenus(MenuBackupAuto, MenuBackupHistorico, MenuBackupRestaurar, MenuUsuario, menuConfiguracao);
            if (Config.getUsuario().isTipo() == true) {
                MenuBackupAuto.setEnabled(false);
                MenuBackupHistorico.setEnabled(false);
                MenuBackupRestaurar.setEnabled(false);
                MenuUsuario.setEnabled(false);
                menuConfiguracao.setEnabled(false);
            }
        } catch (Exception erro) {
            System.out.println("Não mostra usuario. " + erro);
        }

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });

        getFrame().addComponentListener(this);
        lbImagem = new JLabel();
        lbImagem.setBounds(1, 1, 1200, 700);
        mainPanel.add(lbImagem);
        x = lbImagem.getHeight();
        imagemTela();

        //menuConfiguracao.setVisible(false);
        //jMenu2.setVisible(false);
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
            aboutBox = new GerenciadorClientesAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        GerenciadorClientesApp.getApplication().show(aboutBox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        MenuUsuario = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        menuFornecedorFisico = new javax.swing.JMenuItem();
        menuFornecedoJuridico = new javax.swing.JMenuItem();
        menuPesquisarFornecedor = new javax.swing.JMenuItem();
        menuListaContas = new javax.swing.JMenu();
        menuDespesa = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        MenuListaDeConta = new javax.swing.JMenuItem();
        MenuReceita = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuBackupAuto = new javax.swing.JMenuItem();
        jtBackupManual = new javax.swing.JMenuItem();
        MenuBackupHistorico = new javax.swing.JMenuItem();
        MenuBackupRestaurar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        menuConfiguracao = new javax.swing.JMenu();
        MenuFerramentas = new javax.swing.JMenuItem();
        MenuPapelParede = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        tfUsuario = new javax.swing.JLabel();

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.BorderLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(gerenciadorclientes.GerenciadorClientesApp.class).getContext().getResourceMap(GerenciadorClientesView.class);
        menuBar.setFont(resourceMap.getFont("menuBar.font")); // NOI18N
        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setIcon(resourceMap.getIcon("fileMenu.icon")); // NOI18N
        fileMenu.setMnemonic('a');
        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setIcon(resourceMap.getIcon("jMenuItem16.icon")); // NOI18N
        jMenuItem16.setText(resourceMap.getString("jMenuItem16.text")); // NOI18N
        jMenuItem16.setName("jMenuItem16"); // NOI18N
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem16);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setIcon(resourceMap.getIcon("jMenuItem15.icon")); // NOI18N
        jMenuItem15.setText(resourceMap.getString("jMenuItem15.text")); // NOI18N
        jMenuItem15.setName("jMenuItem15"); // NOI18N
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem15);

        jSeparator1.setName("jSeparator1"); // NOI18N
        fileMenu.add(jSeparator1);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(gerenciadorclientes.GerenciadorClientesApp.class).getContext().getActionMap(GerenciadorClientesView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setIcon(resourceMap.getIcon("exitMenuItem.icon")); // NOI18N
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setIcon(resourceMap.getIcon("jMenu1.icon")); // NOI18N
        jMenu1.setMnemonic('c');
        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        jMenu4.setIcon(resourceMap.getIcon("jMenu4.icon")); // NOI18N
        jMenu4.setText(resourceMap.getString("jMenu4.text")); // NOI18N
        jMenu4.setName("jMenu4"); // NOI18N

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText(resourceMap.getString("jMenuItem10.text")); // NOI18N
        jMenuItem10.setName("jMenuItem10"); // NOI18N
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setText(resourceMap.getString("jMenuItem11.text")); // NOI18N
        jMenuItem11.setName("jMenuItem11"); // NOI18N
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenu1.add(jMenu4);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(resourceMap.getIcon("jMenuItem4.icon")); // NOI18N
        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        menuBar.add(jMenu1);

        MenuUsuario.setIcon(resourceMap.getIcon("MenuUsuario.icon")); // NOI18N
        MenuUsuario.setMnemonic('u');
        MenuUsuario.setText(resourceMap.getString("MenuUsuario.text")); // NOI18N
        MenuUsuario.setName("MenuUsuario"); // NOI18N

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setIcon(resourceMap.getIcon("jMenuItem12.icon")); // NOI18N
        jMenuItem12.setText(resourceMap.getString("jMenuItem12.text")); // NOI18N
        jMenuItem12.setName("jMenuItem12"); // NOI18N
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        MenuUsuario.add(jMenuItem12);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(resourceMap.getIcon("jMenuItem3.icon")); // NOI18N
        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MenuUsuario.add(jMenuItem3);

        menuBar.add(MenuUsuario);

        jMenu5.setIcon(resourceMap.getIcon("jMenu5.icon")); // NOI18N
        jMenu5.setText(resourceMap.getString("jMenu5.text")); // NOI18N
        jMenu5.setName("jMenu5"); // NOI18N

        jMenu8.setIcon(resourceMap.getIcon("jMenu8.icon")); // NOI18N
        jMenu8.setText(resourceMap.getString("jMenu8.text")); // NOI18N
        jMenu8.setName("jMenu8"); // NOI18N

        menuFornecedorFisico.setText(resourceMap.getString("menuFornecedorFisico.text")); // NOI18N
        menuFornecedorFisico.setName("menuFornecedorFisico"); // NOI18N
        menuFornecedorFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFornecedorFisicoActionPerformed(evt);
            }
        });
        jMenu8.add(menuFornecedorFisico);

        menuFornecedoJuridico.setText(resourceMap.getString("menuFornecedoJuridico.text")); // NOI18N
        menuFornecedoJuridico.setName("menuFornecedoJuridico"); // NOI18N
        menuFornecedoJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFornecedoJuridicoActionPerformed(evt);
            }
        });
        jMenu8.add(menuFornecedoJuridico);

        jMenu5.add(jMenu8);

        menuPesquisarFornecedor.setIcon(resourceMap.getIcon("menuPesquisarFornecedor.icon")); // NOI18N
        menuPesquisarFornecedor.setText(resourceMap.getString("menuPesquisarFornecedor.text")); // NOI18N
        menuPesquisarFornecedor.setName("menuPesquisarFornecedor"); // NOI18N
        menuPesquisarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPesquisarFornecedorActionPerformed(evt);
            }
        });
        jMenu5.add(menuPesquisarFornecedor);

        menuBar.add(jMenu5);

        menuListaContas.setIcon(resourceMap.getIcon("menuListaContas.icon")); // NOI18N
        menuListaContas.setText(resourceMap.getString("menuListaContas.text")); // NOI18N
        menuListaContas.setName("menuListaContas"); // NOI18N
        menuListaContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListaContasActionPerformed(evt);
            }
        });

        menuDespesa.setIcon(resourceMap.getIcon("menuDespesa.icon")); // NOI18N
        menuDespesa.setText(resourceMap.getString("menuDespesa.text")); // NOI18N
        menuDespesa.setName("menuDespesa"); // NOI18N
        menuDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDespesaActionPerformed(evt);
            }
        });
        menuListaContas.add(menuDespesa);

        jMenu7.setText(resourceMap.getString("jMenu7.text")); // NOI18N
        jMenu7.setName("jMenu7"); // NOI18N

        jMenuItem20.setText(resourceMap.getString("jMenuItem20.text")); // NOI18N
        jMenuItem20.setName("jMenuItem20"); // NOI18N
        jMenu7.add(jMenuItem20);

        jMenuItem13.setText(resourceMap.getString("jMenuItem13.text")); // NOI18N
        jMenuItem13.setName("jMenuItem13"); // NOI18N
        jMenu7.add(jMenuItem13);

        jMenuItem21.setText(resourceMap.getString("jMenuItem21.text")); // NOI18N
        jMenuItem21.setName("jMenuItem21"); // NOI18N
        jMenu7.add(jMenuItem21);

        jMenuItem9.setText(resourceMap.getString("jMenuItem9.text")); // NOI18N
        jMenuItem9.setName("jMenuItem9"); // NOI18N
        jMenu7.add(jMenuItem9);

        jMenuItem24.setText(resourceMap.getString("jMenuItem24.text")); // NOI18N
        jMenuItem24.setName("jMenuItem24"); // NOI18N
        jMenu7.add(jMenuItem24);

        jMenuItem14.setText(resourceMap.getString("jMenuItem14.text")); // NOI18N
        jMenuItem14.setName("jMenuItem14"); // NOI18N
        jMenu7.add(jMenuItem14);

        menuListaContas.add(jMenu7);

        MenuListaDeConta.setIcon(resourceMap.getIcon("MenuListaDeConta.icon")); // NOI18N
        MenuListaDeConta.setText(resourceMap.getString("MenuListaDeConta.text")); // NOI18N
        MenuListaDeConta.setName("MenuListaDeConta"); // NOI18N
        MenuListaDeConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListaDeContaActionPerformed(evt);
            }
        });
        menuListaContas.add(MenuListaDeConta);

        MenuReceita.setIcon(resourceMap.getIcon("MenuReceita.icon")); // NOI18N
        MenuReceita.setText(resourceMap.getString("MenuReceita.text")); // NOI18N
        MenuReceita.setName("MenuReceita"); // NOI18N
        MenuReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuReceitaActionPerformed(evt);
            }
        });
        menuListaContas.add(MenuReceita);

        jMenuItem23.setIcon(resourceMap.getIcon("jMenuItem23.icon")); // NOI18N
        jMenuItem23.setText(resourceMap.getString("jMenuItem23.text")); // NOI18N
        jMenuItem23.setName("jMenuItem23"); // NOI18N
        menuListaContas.add(jMenuItem23);

        menuBar.add(menuListaContas);

        jMenu9.setText(resourceMap.getString("jMenu9.text")); // NOI18N
        jMenu9.setName("jMenu9"); // NOI18N
        menuBar.add(jMenu9);

        jMenu6.setIcon(resourceMap.getIcon("jMenu6.icon")); // NOI18N
        jMenu6.setMnemonic('f');
        jMenu6.setText(resourceMap.getString("jMenu6.text")); // NOI18N
        jMenu6.setName("jMenu6"); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(resourceMap.getIcon("jMenuItem1.icon")); // NOI18N
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem17.setIcon(resourceMap.getIcon("jMenuItem17.icon")); // NOI18N
        jMenuItem17.setText(resourceMap.getString("jMenuItem17.text")); // NOI18N
        jMenuItem17.setName("jMenuItem17"); // NOI18N
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem17);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem18.setIcon(resourceMap.getIcon("jMenuItem18.icon")); // NOI18N
        jMenuItem18.setText(resourceMap.getString("jMenuItem18.text")); // NOI18N
        jMenuItem18.setName("jMenuItem18"); // NOI18N
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem18);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem19.setIcon(resourceMap.getIcon("jMenuItem19.icon")); // NOI18N
        jMenuItem19.setText(resourceMap.getString("jMenuItem19.text")); // NOI18N
        jMenuItem19.setName("jMenuItem19"); // NOI18N
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem19);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setIcon(resourceMap.getIcon("jMenuItem2.icon")); // NOI18N
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setIcon(resourceMap.getIcon("jMenuItem7.icon")); // NOI18N
        jMenuItem7.setText(resourceMap.getString("jMenuItem7.text")); // NOI18N
        jMenuItem7.setName("jMenuItem7"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        menuBar.add(jMenu6);

        jMenu2.setIcon(resourceMap.getIcon("jMenu2.icon")); // NOI18N
        jMenu2.setMnemonic('b');
        jMenu2.setText(resourceMap.getString("jMenu2.text")); // NOI18N
        jMenu2.setName("jMenu2"); // NOI18N

        MenuBackupAuto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuBackupAuto.setIcon(resourceMap.getIcon("MenuBackupAuto.icon")); // NOI18N
        MenuBackupAuto.setText(resourceMap.getString("MenuBackupAuto.text")); // NOI18N
        MenuBackupAuto.setName("MenuBackupAuto"); // NOI18N
        MenuBackupAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBackupAutoActionPerformed(evt);
            }
        });
        jMenu2.add(MenuBackupAuto);

        jtBackupManual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jtBackupManual.setIcon(resourceMap.getIcon("jtBackupManual.icon")); // NOI18N
        jtBackupManual.setText(resourceMap.getString("jtBackupManual.text")); // NOI18N
        jtBackupManual.setName("jtBackupManual"); // NOI18N
        jtBackupManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBackupManualActionPerformed(evt);
            }
        });
        jMenu2.add(jtBackupManual);

        MenuBackupHistorico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuBackupHistorico.setIcon(resourceMap.getIcon("MenuBackupHistorico.icon")); // NOI18N
        MenuBackupHistorico.setText(resourceMap.getString("MenuBackupHistorico.text")); // NOI18N
        MenuBackupHistorico.setName("MenuBackupHistorico"); // NOI18N
        MenuBackupHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBackupHistoricoActionPerformed(evt);
            }
        });
        jMenu2.add(MenuBackupHistorico);

        MenuBackupRestaurar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuBackupRestaurar.setIcon(resourceMap.getIcon("MenuBackupRestaurar.icon")); // NOI18N
        MenuBackupRestaurar.setText(resourceMap.getString("MenuBackupRestaurar.text")); // NOI18N
        MenuBackupRestaurar.setName("MenuBackupRestaurar"); // NOI18N
        MenuBackupRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBackupRestaurarActionPerformed(evt);
            }
        });
        jMenu2.add(MenuBackupRestaurar);

        menuBar.add(jMenu2);

        jMenu3.setIcon(resourceMap.getIcon("jMenu3.icon")); // NOI18N
        jMenu3.setText(resourceMap.getString("jMenu3.text")); // NOI18N
        jMenu3.setName("jMenu3"); // NOI18N

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setIcon(resourceMap.getIcon("jMenuItem8.icon")); // NOI18N
        jMenuItem8.setText(resourceMap.getString("jMenuItem8.text")); // NOI18N
        jMenuItem8.setName("jMenuItem8"); // NOI18N
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        menuBar.add(jMenu3);

        menuConfiguracao.setIcon(resourceMap.getIcon("menuConfiguracao.icon")); // NOI18N
        menuConfiguracao.setMnemonic('o');
        menuConfiguracao.setText(resourceMap.getString("menuConfiguracao.text")); // NOI18N
        menuConfiguracao.setName("menuConfiguracao"); // NOI18N

        MenuFerramentas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        MenuFerramentas.setText(resourceMap.getString("MenuFerramentas.text")); // NOI18N
        MenuFerramentas.setName("MenuFerramentas"); // NOI18N
        MenuFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFerramentasActionPerformed(evt);
            }
        });
        menuConfiguracao.add(MenuFerramentas);

        MenuPapelParede.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        MenuPapelParede.setText(resourceMap.getString("MenuPapelParede.text")); // NOI18N
        MenuPapelParede.setName("MenuPapelParede"); // NOI18N
        MenuPapelParede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPapelParedeActionPerformed(evt);
            }
        });
        menuConfiguracao.add(MenuPapelParede);

        menuBar.add(menuConfiguracao);

        helpMenu.setMnemonic('j');
        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setText(resourceMap.getString("aboutMenuItem.text")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        tfUsuario.setDisplayedMnemonic('k');
        tfUsuario.setFont(resourceMap.getFont("tfUsuario.font")); // NOI18N
        tfUsuario.setIcon(resourceMap.getIcon("tfUsuario.icon")); // NOI18N
        tfUsuario.setText(resourceMap.getString("tfUsuario.text")); // NOI18N
        tfUsuario.setToolTipText(resourceMap.getString("tfUsuario.toolTipText")); // NOI18N
        tfUsuario.setName("tfUsuario"); // NOI18N
        tfUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfUsuarioMouseClicked(evt);
            }
        });
        tfUsuario.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tfUsuarioAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusMessageLabel)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1236, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addComponent(tfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusMessageLabel)
                            .addComponent(statusAnimationLabel))
                        .addGap(3, 3, 3))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

private void jtBackupManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBackupManualActionPerformed
    //if (backupManual == null) {
    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    backupManual = new BackupManual(mainFrame);
    backupManual.setLocationRelativeTo(mainFrame);
    //}
    GerenciadorClientesApp.getApplication().show(backupManual);
    backupManual.setSize(518, 192);
}//GEN-LAST:event_jtBackupManualActionPerformed

private void MenuBackupAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBackupAutoActionPerformed
    if (backupAutomatico == null) {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        backupAutomatico = new BackupAutomatico(mainFrame);
        backupAutomatico.setLocationRelativeTo(mainFrame);
    }
    GerenciadorClientesApp.getApplication().show(backupAutomatico);
    backupAutomatico.setSize(598, 258);

}//GEN-LAST:event_MenuBackupAutoActionPerformed

private void MenuBackupRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBackupRestaurarActionPerformed

    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    backupRestaurar = new RestauraBackup(mainFrame);
    backupRestaurar.setLocationRelativeTo(mainFrame);

    GerenciadorClientesApp.getApplication().show(backupRestaurar);
    backupRestaurar.setSize(533, 226);

}//GEN-LAST:event_MenuBackupRestaurarActionPerformed

private void MenuBackupHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBackupHistoricoActionPerformed
    if (backupHistorico == null) {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        backupHistorico = new HistóricoBackup(mainFrame);
        backupHistorico.setLocationRelativeTo(mainFrame);
    }
    GerenciadorClientesApp.getApplication().show(backupHistorico);
    backupHistorico.setSize(949, 335);
}//GEN-LAST:event_MenuBackupHistoricoActionPerformed

private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
    if (cadastroUsuario == null) {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        cadastroUsuario = new CadastrarFuncionario(mainFrame);
        cadastroUsuario.setLocationRelativeTo(mainFrame);
    }
    GerenciadorClientesApp.getApplication().show(cadastroUsuario);
    cadastroUsuario.setSize(400, 514);
}//GEN-LAST:event_jMenuItem12ActionPerformed

private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
    if (trocarUsuario == null) {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        trocarUsuario = new TrocarUsuario();
        trocarUsuario.setLocationRelativeTo(mainFrame);
    }
    GerenciadorClientesApp.getApplication().show(trocarUsuario);
    trocarUsuario.setSize(384, 267);
}//GEN-LAST:event_jMenuItem15ActionPerformed

private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
    JFrame tela = new LoguinInicial();
    tela.setVisible(true);
    getFrame().setVisible(false);

}//GEN-LAST:event_jMenuItem16ActionPerformed

private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
    if (pesquisarCliente == null) {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        pesquisarCliente = new Pesquisa(mainFrame);
        //cadastroUsuario.setLocationRelativeTo(mainFrame);
    }
    GerenciadorClientesApp.getApplication().show(pesquisarCliente);
    pesquisarCliente.setSize(914, 431);
}//GEN-LAST:event_jMenuItem4ActionPerformed

private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
    if (cadastroJuriico == null) {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        cadastroJuriico = new CadastroClienteJuridico(mainFrame);
        cadastroJuriico.setLocationRelativeTo(mainFrame);
    }
    GerenciadorClientesApp.getApplication().show(cadastroJuriico);
    cadastroJuriico.setSize(843, 601);
}//GEN-LAST:event_jMenuItem11ActionPerformed

private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
    if (cadastroCliente == null) {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        cadastroCliente = new CadastroClienteFisico(mainFrame);
        cadastroCliente.setLocationRelativeTo(mainFrame);
    }
    GerenciadorClientesApp.getApplication().show(cadastroCliente);
    cadastroCliente.setSize(845, 599);
}//GEN-LAST:event_jMenuItem10ActionPerformed

private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    try {
        Runtime.getRuntime().exec("" + ControleConfiguracao.getCongiguracao().getPath_word());

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, " Não foi possível abrir o Word. \n Verifique o caminho.", " Atenção ", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jMenuItem1ActionPerformed

private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
    try {
        Runtime.getRuntime().exec(ControleConfiguracao.getCongiguracao().getPath_pp());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, " Não foi possível abrir o PowerPoint. \n Verifique o caminho.", " Atenção ", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jMenuItem18ActionPerformed

private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
    try {
        Runtime.getRuntime().exec(ControleConfiguracao.getCongiguracao().getPath_excel());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, " Não foi possível abrir o Excel. \n Verifique o caminho.", " Atenção ", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jMenuItem17ActionPerformed

private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
    try {
        Runtime.getRuntime().exec(ControleConfiguracao.getCongiguracao().getPath_team());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, " Não foi possível abrir o Team Viewer. \n Verifique o caminho.", " Atenção ", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jMenuItem19ActionPerformed

private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    try {
        Runtime.getRuntime().exec(ControleConfiguracao.getCongiguracao().getPath_calc());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, " Não foi possível abrir a Calculadora. \n Verifique o caminho.", " Atenção ", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jMenuItem2ActionPerformed

private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    pesquisarUsuario = new PesquisarFuncionario(mainFrame);

    GerenciadorClientesApp.getApplication().show(pesquisarUsuario);
    pesquisarUsuario.setSize(957, 474);
}//GEN-LAST:event_jMenuItem3ActionPerformed

private void tfUsuarioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tfUsuarioAncestorAdded
// TODO add your handling code here:
}//GEN-LAST:event_tfUsuarioAncestorAdded

private void tfUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfUsuarioMouseClicked

    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    alterarLoginSenha = new AlterarLoginSenhaUsuario(mainFrame);
    alterarLoginSenha.setLocationRelativeTo(mainFrame);
    GerenciadorClientesApp.getApplication().show(alterarLoginSenha);
    alterarLoginSenha.setSize(334, 364);
}//GEN-LAST:event_tfUsuarioMouseClicked

private void MenuFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFerramentasActionPerformed
    if (ferramentas == null) {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        ferramentas = new ConfiguracaoFerramentas(mainFrame);
        ferramentas.setLocationRelativeTo(mainFrame);
    }
    GerenciadorClientesApp.getApplication().show(ferramentas);
    ferramentas.setSize(518, 333);
}//GEN-LAST:event_MenuFerramentasActionPerformed

private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
    try {
        Runtime.getRuntime().exec(ControleConfiguracao.getCongiguracao().getPath_favorito());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, " Favorito não encontrado. \n Verifique o caminho.", " Atenção ", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_jMenuItem7ActionPerformed

private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed

    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    servico = new EstadoServico(mainFrame);
    servico.setLocationRelativeTo(mainFrame);

    GerenciadorClientesApp.getApplication().show(servico);
    servico.setSize(1207, 613);
}//GEN-LAST:event_jMenuItem8ActionPerformed

private void MenuPapelParedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPapelParedeActionPerformed
    if (EscolhaPapelParede == null) {
        JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
        EscolhaPapelParede = new EscolhePapelParede(mainFrame, this);
        EscolhaPapelParede.setLocationRelativeTo(mainFrame);
    }
    GerenciadorClientesApp.getApplication().show(EscolhaPapelParede);
    EscolhaPapelParede.setSize(634, 234);
}//GEN-LAST:event_MenuPapelParedeActionPerformed

private void MenuReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuReceitaActionPerformed
    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    contaReceitaDespesaTransferencia = new TelaReceita(mainFrame, 0);
    contaReceitaDespesaTransferencia.setLocationRelativeTo(mainFrame);

    GerenciadorClientesApp.getApplication().show(contaReceitaDespesaTransferencia);
    contaReceitaDespesaTransferencia.setSize(665, 484);
}//GEN-LAST:event_MenuReceitaActionPerformed

private void menuDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDespesaActionPerformed
    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    contaReceitaDespesaTransferencia = new TelaReceita(mainFrame, 1);
    contaReceitaDespesaTransferencia.setLocationRelativeTo(mainFrame);

    GerenciadorClientesApp.getApplication().show(contaReceitaDespesaTransferencia);
    contaReceitaDespesaTransferencia.setSize(665, 484);
}//GEN-LAST:event_menuDespesaActionPerformed

private void menuListaContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListaContasActionPerformed
}//GEN-LAST:event_menuListaContasActionPerformed

private void MenuListaDeContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListaDeContaActionPerformed
    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    listaContas = new ListaContas(mainFrame);
    listaContas.setLocationRelativeTo(mainFrame);

    GerenciadorClientesApp.getApplication().show(listaContas);
    listaContas.setSize(754, 391);
}//GEN-LAST:event_MenuListaDeContaActionPerformed

private void menuFornecedorFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFornecedorFisicoActionPerformed
    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    fornecedorFisico = new CadastrarFornecedorFisico(mainFrame);
    fornecedorFisico.setLocationRelativeTo(mainFrame);

    GerenciadorClientesApp.getApplication().show(fornecedorFisico);
    fornecedorFisico.setSize(836, 619);
}//GEN-LAST:event_menuFornecedorFisicoActionPerformed

private void menuFornecedoJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFornecedoJuridicoActionPerformed
    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    fornecedorJuridico = new CadastrarFornecedorJuridico(mainFrame);
    fornecedorJuridico.setLocationRelativeTo(mainFrame);

    GerenciadorClientesApp.getApplication().show(fornecedorJuridico);
    fornecedorJuridico.setSize(836, 619);
}//GEN-LAST:event_menuFornecedoJuridicoActionPerformed

private void menuPesquisarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPesquisarFornecedorActionPerformed
    JFrame mainFrame = GerenciadorClientesApp.getApplication().getMainFrame();
    pesquisarFornecedor = new PesquisaFornecedor(mainFrame);
    pesquisarFornecedor.setLocationRelativeTo(mainFrame);

    GerenciadorClientesApp.getApplication().show(pesquisarFornecedor);
    pesquisarFornecedor.setSize(947, 458);
}//GEN-LAST:event_menuPesquisarFornecedorActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuBackupAuto;
    private javax.swing.JMenuItem MenuBackupHistorico;
    private javax.swing.JMenuItem MenuBackupRestaurar;
    private javax.swing.JMenuItem MenuFerramentas;
    private javax.swing.JMenuItem MenuListaDeConta;
    private javax.swing.JMenuItem MenuPapelParede;
    private javax.swing.JMenuItem MenuReceita;
    private javax.swing.JMenu MenuUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem jtBackupManual;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuConfiguracao;
    private javax.swing.JMenuItem menuDespesa;
    private javax.swing.JMenuItem menuFornecedoJuridico;
    private javax.swing.JMenuItem menuFornecedorFisico;
    private javax.swing.JMenu menuListaContas;
    private javax.swing.JMenuItem menuPesquisarFornecedor;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel tfUsuario;
    // End of variables declaration//GEN-END:variables
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;
    private JDialog backupHistorico;
    private JDialog backupRestaurar;
    private JDialog backupManual;
    private JDialog backupAutomatico;
    private JDialog cadastroJuriico;
    private JDialog cadastroCliente;
    private JDialog ferramentas;
    private JDialog servico;
    private JDialog EscolhaPapelParede;
    private JDialog cadastroUsuario;
    private JDialog pesquisarCliente;
    private JDialog trocarUsuario;
    private JDialog pesquisarUsuario;
    private JDialog alterarLoginSenha;
    private JDialog listaContas;
    private JDialog fornecedorFisico;
    private JDialog fornecedorJuridico;
    private JDialog pesquisarFornecedor;
    private JDialog contaReceitaDespesaTransferencia;

    public void componentResized(ComponentEvent e) {
        imagemTela();
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }

    public void imagemTela() {
        try {
            img = new ImageIcon(ControleConfiguracao.getCongiguracao().getPath_papel());
            img.setImage(img.getImage().getScaledInstance(lbImagem.getWidth(), lbImagem.getHeight(), 100));
            lbImagem.setIcon(img);
        } catch (Exception erro) {
            try {
                img = new ImageIcon(getClass().getResource("/Imagens/logo.jpg"));
                img.setImage(img.getImage().getScaledInstance(lbImagem.getWidth(), lbImagem.getHeight(), 100));
                lbImagem.setIcon(img);
            } catch (Exception erro2) {
            }
        }
    }
}

/*
 * GerenciadorClientesApp.java
 */
package gerenciadorclientes;

import GUI.LoguinInicial;
import Util.ThreadIniciadora;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class GerenciadorClientesApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {
        show(new GerenciadorClientesView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     *
     * @return the instance of GerenciadorClientesApp
     */
    public static GerenciadorClientesApp getApplication() {
        return Application.getInstance(GerenciadorClientesApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        conexaoBanco();
        JFrame tela = new LoguinInicial();
        tela.setVisible(true);

        ThreadIniciadora t = new ThreadIniciadora();
        t.start();
    }

    public static void gerenciador(String[] args) {
        launch(GerenciadorClientesApp.class, args);
    }

    private static void conexaoBanco() {

        Connection connection = null;
        String userName = "root";
        String password = "ch4v31r0";
        String url = "jdbc:mysql://localhost:3306/gcs";
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
        }

        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            String url2 = "jdbc:mysql://localhost:3306/";
            try {
                connection = DriverManager.getConnection(url2, userName, password);
                stmt = connection.createStatement();
                stmt.executeUpdate("CREATE DATABASE gcs");
            } catch (SQLException ex) {
            }
        }
    }
}

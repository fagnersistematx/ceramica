package Util;

import GUI.LoguinInicial;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Fagner
 */
public class ConfLook {

    private static ConfLook cl;
    private static Image imagem;

    private ConfLook() {
    }

    public void Look() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoguinInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoguinInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoguinInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoguinInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static Image icone(){        
        Toolkit tk = Toolkit.getDefaultToolkit();        
        imagem = tk.getImage(ConfLook.class.getResource("/Imagens/logo2.gif"));
        return imagem;     
    }  

    public static ConfLook getInstance() {
        if (cl == null) {
            cl = new ConfLook();
        }
        return cl;
    }
}

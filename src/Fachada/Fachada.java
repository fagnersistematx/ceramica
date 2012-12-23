
package Fachada;

import Controler.conta.ContaDespesaController;
import Controler.conta.ContaReceitaController;
import Controler.conta.LancamentoController;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class Fachada {
    
    private ContaDespesaController contaDespesaController;
    private ContaReceitaController contaReceitaController;
    private LancamentoController lancamentoController;
    private static Fachada fachada;
    
    private Fachada() {
        this.contaDespesaController = new ContaDespesaController();
        this.contaReceitaController = new ContaReceitaController();
        this.lancamentoController = new LancamentoController();
    }   
    
    public static Fachada getInstance(){
        if(fachada == null){
            fachada = new Fachada();
        }
        return fachada;
    }

}

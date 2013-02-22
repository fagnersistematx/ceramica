
package Entidade.Estoque.Exception;

/**
 *
 * @author Fagner Silva Martins fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class LoteException extends Exception {

    /**
     * Creates a new instance of <code>ProdutoException</code> without detail message.
     */
    public LoteException() {
    }


    /**
     * Constructs an instance of <code>ProdutoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public LoteException(String msg) {
        super(msg);
    }
}

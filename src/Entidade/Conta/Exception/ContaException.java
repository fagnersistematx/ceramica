
package Entidade.Conta.Exception;

/**
 *
 * @author Fagner Silva Martins fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class ContaException extends Exception {

    /**
     * Creates a new instance of <code>ContaException</code> without detail message.
     */
    public ContaException() {
    }


    /**
     * Constructs an instance of <code>ContaException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ContaException(String msg) {
        super(msg);
    }
}

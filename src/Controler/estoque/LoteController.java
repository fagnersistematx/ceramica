
package Controler.estoque;

import Entidade.Estoque.Exception.LoteException;
import Entidade.Estoque.Lote;
import Entidade.Estoque.Produto;
import Entidade.Fornecedor;
import Entidade.Funcionario;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class LoteController {
    
    private DAO dao;

    public LoteController() {
        dao = new DAO();
    }

    public Lote criarLote(String numero, float quant, float valor, float preco_saco, Produto produto, Fornecedor fornecedor, Funcionario funcionario) {
        Lote lote = new Lote(numero, quant, valor, preco_saco, produto, fornecedor, funcionario);
        dao.create(lote);
        return lote;
    }

    public Lote alterarLote(Lote lote) throws LoteException {

        try {
            dao.edit(lote);
            return lote;
        } catch (ClassNotFoundException ex) {
            throw new LoteException("Erro ao alterar lote " + ex.getMessage());
        } catch (NonexistentEntityException ex) {
            throw new LoteException("Erro ao alterar lote " + ex.getMessage());
        } catch (Exception ex) {
            throw new LoteException("Erro ao alterar lote " + ex.getMessage());
        }
    }

    public List<Object> listarLotes() {
        return dao.findObjectEntities(Lote.class);
    }

    public List<Object> listarLotes(String numero) {
        return dao.pesquisar("Lote", "numero", numero);
    }

    public Lote buscaLotes(Long id) throws LoteException {
        Lote lote = null;
        try {
            lote = (Lote) dao.findObject(id, Lote.class);
        } catch (Exception ex) {
            throw new LoteException("Erro ao buscar lote. " + ex.getMessage());
        }

        return lote;
    }

    public void removerLote(Long id) throws LoteException {
        try {
            dao.destroy(id, Lote.class);
        } catch (NonexistentEntityException ex) {
            throw new LoteException("Erro ao deletar lote. " + ex.getMessage());
        }
    }

    public int contLote() {
        return dao.getObjectCount(Lote.class);
    }

    public boolean nomeExitenteCodigoLote(String numero) {
        for (Object o : listarLotes()) {
            Lote lote = (Lote) o;
            if (lote.getNumero().equalsIgnoreCase(numero)) {
                return true;
            }
        }
        return false;
    }
}

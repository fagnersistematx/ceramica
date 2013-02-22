package Controler.estoque;

import Entidade.Estoque.Exception.NotaException;
import Entidade.Estoque.Lote;
import Entidade.Estoque.Nota;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class NotaController {

    private DAO dao;

    public NotaController() {
        dao = new DAO();
    }

    public Nota criarNota(List<Lote> lotes, float desconto, float total, String numero, Calendar data_entrada, String obs) {
        Nota nota = new Nota(lotes, desconto, total, numero, obs, data_entrada);
        dao.create(nota);
        return nota;
    }

    public Nota alterarNota(Nota nota) throws NotaException {

        try {
            dao.edit(nota);
            return nota;
        } catch (ClassNotFoundException ex) {
            throw new NotaException("Erro ao alterar nota" + ex.getMessage());
        } catch (NonexistentEntityException ex) {
            throw new NotaException("Erro ao alterar nota " + ex.getMessage());
        } catch (Exception ex) {
            throw new NotaException("Erro ao alterar nota " + ex.getMessage());
        }
    }

    public List<Object> listarNota() {
        return dao.findObjectEntities(Nota.class);
    }

    public List<Object> listarNota(String numero) {
        return dao.pesquisar("Nota", "numero", numero);
    }

    public Nota buscaNota(Long id) throws NotaException {
        Nota produto = null;
        try {
            produto = (Nota) dao.findObject(id, Nota.class);
        } catch (Exception ex) {
            throw new NotaException("Erro ao buscar Nota. " + ex.getMessage());
        }

        return produto;
    }

    public void removerNota(Long id) throws NotaException {
        try {
            dao.destroy(id, Nota.class);
        } catch (NonexistentEntityException ex) {
            throw new NotaException("Erro ao deletar Nota. " + ex.getMessage());
        }
    }

    public int contNota() {
        return dao.getObjectCount(Nota.class);
    }

    public boolean exitenteNota(String numero) {
        for (Object object : listarNota()) {
            Nota nota = (Nota) object;
            if (nota.getNumero().equalsIgnoreCase(numero) && !numero.equalsIgnoreCase("")) {
                return true;
            }
        }
        return false;
    }
}

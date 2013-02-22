package Controler.conta;

import Entidade.Conta.Exception.ItensPlanoContaException;
import Entidade.Conta.ItensPlanoConta;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class ItensPlanoContaController {

    private DAO dao;

    public ItensPlanoContaController() {
        dao = new DAO();
    }

    public ItensPlanoConta criarItensPlanoConta(String nome) {
        ItensPlanoConta itensPlanoConta = new ItensPlanoConta(nome);
        dao.create(itensPlanoConta);
        return itensPlanoConta;
    }

    public ItensPlanoConta alterarItensPlanoConta(Long id, String nome) throws ItensPlanoContaException {

        ItensPlanoConta itensPlanoConta;

        try {
            itensPlanoConta = (ItensPlanoConta) dao.findObject(id, ItensPlanoConta.class);
            itensPlanoConta.setNome(nome);
            dao.edit(itensPlanoConta);
        } catch (ClassNotFoundException ex) {
            throw new ItensPlanoContaException("Erro ao alterar ItensPlanoConta " + ex.getMessage());
        } catch (NonexistentEntityException ex) {
            throw new ItensPlanoContaException("Erro ao alterar ItensPlanoConta " + ex.getMessage());
        } catch (Exception ex) {
            throw new ItensPlanoContaException("Erro ao alterar ItensPlanoConta " + ex.getMessage());
        }

        return itensPlanoConta;
    }

    public List<Object> listarItensPlanoConta() {
        return dao.findObjectEntities(ItensPlanoConta.class);
    }

    public ItensPlanoConta buscaItensPlanoConta(Long id) throws ItensPlanoContaException {
        
        ItensPlanoConta itensPlanoConta;
        try {
            itensPlanoConta = (ItensPlanoConta) dao.findObject(id, ItensPlanoConta.class);
        } catch (Exception ex) {
            throw new ItensPlanoContaException("Erro ao buscar ItensPlanoConta. " + ex.getMessage());
        }

        return itensPlanoConta;
    }

    public void removerItensPlanoConta(Long id) throws ItensPlanoContaException {
        try {
            dao.destroy(id, ItensPlanoConta.class);
        } catch (NonexistentEntityException ex) {
            throw new ItensPlanoContaException("Erro ao deletar ItensPlanoConta. " + ex.getMessage());
        }
    }

    public int contItensPlanoConta() {
        return dao.getObjectCount(ItensPlanoConta.class);
    }

    public boolean nomeExitenteItensPlanoConta(String nome) {
        for (Object o : listarItensPlanoConta()) {
            ItensPlanoConta c = (ItensPlanoConta) o;
            if (c.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
    
    public ItensPlanoConta buscaItensPlanoConta(String nome){
        for (Object o : listarItensPlanoConta()) {
            ItensPlanoConta c = (ItensPlanoConta) o;
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
}

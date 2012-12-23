
package Controler.conta;

import Entidade.Conta.Despesa;
import Entidade.Conta.Exception.ContaDespesaException;
import Entidade.Conta.Lancamento;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class ContaDespesaController {
    private DAO dao;

    public ContaDespesaController(){
        dao = new DAO();
    }

    public Despesa criarContaDespesa(String nome, String obs, Calendar dataCriacao, String tipo, List<Lancamento> lancamentos) {
        Despesa despesa = new Despesa(nome, obs, dataCriacao, lancamentos, tipo);
        dao.create(despesa);
        return despesa;
    }

    public void alterarContaDespesa(Long id, String nome, String obs, Calendar dataCriacao, String tipo, List<Lancamento> lancamentos) throws ContaDespesaException {
        try {
            Despesa despesa = (Despesa) dao.findObject(id, Despesa.class);
            despesa.setCriacao(dataCriacao);
            despesa.setLancamentos(lancamentos);
            despesa.setNome(nome);
            despesa.setObs(obs);
            despesa.setTipo(tipo);
            dao.edit(despesa);
        } catch (ClassNotFoundException ex) {
            throw new ContaDespesaException("Erro ao alterar despesa. "+ex.getMessage());
        } catch (NonexistentEntityException ex) {
            throw new ContaDespesaException("Erro ao alterar despesa. "+ex.getMessage());
        } catch (Exception ex) {
            throw new ContaDespesaException("Erro ao alterar despesa. "+ex.getMessage());
        }


    }

    public Despesa busca(Long id) throws ContaDespesaException {
        Despesa despesa = null;
        try {
            despesa = (Despesa) dao.findObject(id, Despesa.class);        
        } catch (Exception ex) {
            throw new ContaDespesaException("Erro ao buscar despesa. "+ex.getMessage());
        }

        return despesa;
    }

    public void remover(Long id) throws ContaDespesaException {
        try {
            dao.destroy(id, Despesa.class);
        } catch (NonexistentEntityException ex) {
            throw new ContaDespesaException("Erro ao deletar despesa. "+ex.getMessage());
        }
    }

    public int cont() {
        return dao.getObjectCount(Despesa.class);
    }
}

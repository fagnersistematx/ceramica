package Controler.conta;

import Entidade.Conta.Exception.FluxoReceitaException;
import Entidade.Conta.Lancamento;
import Entidade.Conta.Receita;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins
 * @version 1.0
 */
public class ContaReceitaController {

    private DAO dao;

    public ContaReceitaController() {
        dao = new DAO();
    }

    public Receita criarContaReceita(String nome, String obs, Calendar dataCriacao, String tipo, List<Lancamento> lancamentos) {
        Receita receita = new Receita(nome, obs, dataCriacao, lancamentos, tipo);
        dao.create(receita);
        return receita;
    }

    public void alterarContaReceita(Long id, String nome, String obs, Calendar dataCriacao, String tipo, List<Lancamento> lancamentos) throws FluxoReceitaException {
        try {
            Receita receita = (Receita) dao.findObject(id, Receita.class);
            receita.setCriacao(dataCriacao);
            receita.setLancamentos(lancamentos);
            receita.setNome(nome);
            receita.setObs(obs);
            receita.setTipo(tipo);
            dao.edit(receita);
        } catch (ClassNotFoundException ex) {
            throw new FluxoReceitaException("Erro ao alterar receita. "+ex.getMessage());
        } catch (NonexistentEntityException ex) {
            throw new FluxoReceitaException("Erro ao alterar receita. "+ex.getMessage());
        } catch (Exception ex) {
            throw new FluxoReceitaException("Erro ao alterar receita. "+ex.getMessage());
        }


    }

    public Receita busca(Long id) throws FluxoReceitaException {
        Receita receita = null;
        try {
            receita = (Receita) dao.findObject(id, Receita.class);        
        } catch (Exception ex) {
            throw new FluxoReceitaException("Erro ao buscar receita. "+ex.getMessage());
        }

        return receita;
    }

    public void remover(Long id) throws FluxoReceitaException {
        try {
            dao.destroy(id, Receita.class);
        } catch (NonexistentEntityException ex) {
            throw new FluxoReceitaException("Erro ao deletar receita. "+ex.getMessage());
        }
    }

    public int cont() {
        return dao.getObjectCount(Receita.class);
    }
}

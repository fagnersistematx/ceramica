package Controler.conta;

import Entidade.Conta.Exception.LancamentoException;
import Entidade.Conta.Lancamento;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.Calendar;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class LancamentoController {

    private DAO dao;

    public LancamentoController() {
        this.dao = new DAO();
    }

    public Lancamento criarLancamento(float valor, Calendar dataVencimento, Calendar dataCriacao, String obs) throws LancamentoException {
        Lancamento lancamento = new Lancamento(valor, obs, dataCriacao, dataVencimento);
        try {
            dao.create(lancamento);
        } catch (Exception e) {
            throw new LancamentoException("Erro ao cadastar lançamento. " + e.getMessage());
        }
        return lancamento;
    }

    public void alterarLancamentoQuitado(Long id, float valor, Calendar dataVencimento, Calendar dataCriacao, String tipo, String obs, float juros, Calendar dataQuitacao) throws LancamentoException {
        Lancamento lancamento = this.busca(id);
        if (lancamento == null) {
            throw new LancamentoException("Erro ao editar lançamento quitado. Variavel lancamento é nula.");
        }

        lancamento.setCriacao(dataCriacao);
        lancamento.setJuros(juros);
        lancamento.setObs(obs);
        lancamento.setQuitacao(dataQuitacao);
        lancamento.setTipo_pag_conta(tipo);
        lancamento.setValor(valor);
        lancamento.setVencimento(dataVencimento);
        
        try {
            dao.edit(lancamento);
        } catch (NonexistentEntityException ex) {
            throw new LancamentoException("Erro ao editar lançamento quitado. " + ex.getMessage());
        } catch (Exception ex) {
            throw new LancamentoException("Erro ao editar lançamento quitado. " + ex.getMessage());
        }

    }

    public void alterarLancamentoNaoQuitado(Long id, float juros, Calendar dataQuitacao, String obs, String tipo) throws LancamentoException {
        Lancamento lancamento = (Lancamento) dao.findObject(id, Lancamento.class);
        if (lancamento == null) {
            throw new LancamentoException("Erro ao editar lançamento não quitado. Variavel lancamento é nula.");
        }
        
        lancamento.setJuros(juros);
        lancamento.setObs(obs);
        lancamento.setQuitacao(dataQuitacao);
        lancamento.setTipo_pag_conta(tipo);
        
        try {
            dao.edit(lancamento);
        } catch (NonexistentEntityException ex) {
            throw new LancamentoException("Erro ao editar lançamento não quitado. " + ex.getMessage());
        } catch (Exception ex) {
            throw new LancamentoException("Erro ao editar lançamento não quitado. " + ex.getMessage());
        }
    }

    public Lancamento busca(Long id) throws LancamentoException {
        Lancamento lancamento;
        try {
            lancamento = (Lancamento) dao.findObject(id, Lancamento.class);
        } catch (Exception ex) {
            throw new LancamentoException("Erro ao buscar lancamento. " + ex.getMessage());
        }
        return lancamento;
    }

    public void remover(Long id) throws LancamentoException {
        try {
            dao.destroy(id, Lancamento.class);
        } catch (NonexistentEntityException ex) {
            throw new LancamentoException("Erro ao excluir lancamento. " + ex.getMessage());
        }
    }

    public int cont() {
        return dao.getObjectCount(Lancamento.class);
    }
}

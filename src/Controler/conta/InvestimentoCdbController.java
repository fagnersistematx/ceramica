package Controler.conta;

import Entidade.Conta.Cdb;
import Entidade.Conta.Exception.InvestimentoCdbException;
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
public class InvestimentoCdbController {

    private DAO dao;

    public InvestimentoCdbController() {
        this.dao = new DAO();
    }

    public Cdb criarInvestimentoCDB(float contratacao, Calendar investimento, float iof, float cpmf, float saldo_original, float saldo_atualizado,
            String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {

        Cdb cdb = new Cdb(contratacao, investimento, iof, cpmf, saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);
        dao.create(cdb);
        return cdb;

    }

    public Cdb alterarInvestimentoCDB(Long id, float contratacao, Calendar investimento, float iof, float cpmf, float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoCdbException {

        Cdb cdb = buscarInvestimentoCDB(id);
        try {
            cdb.setTx_contratacao(contratacao);
            cdb.setIof(iof);
            cdb.setCpmf(cpmf);
            cdb.setSaldo_original(saldo_original);
            cdb.setSaldo_atualizado(saldo_atualizado);
            cdb.setNm_conta(nm_conta);
            cdb.setNome(nome);
            cdb.setObs(obs);
            cdb.setCriacao(criacao);
            cdb.setLancamentos(lancamentos);
            dao.edit(cdb);
        } catch (NonexistentEntityException ex) {
            throw new InvestimentoCdbException(ex.getMessage());
        } catch (Exception ex) {
            throw new InvestimentoCdbException(ex.getMessage());
        }
        return cdb;
    }

    public Cdb buscarInvestimentoCDB(Long id) throws InvestimentoCdbException {
        Cdb cdb;
        try {
            cdb = (Cdb) dao.findObject(id, Cdb.class);
        } catch (Exception ex) {
            throw new InvestimentoCdbException(ex.getMessage());
        }
        return cdb;
    }

    public void removerInvestimentoCDB(Long id) throws InvestimentoCdbException {
        try {
            dao.destroy(id, Cdb.class);
        } catch (NonexistentEntityException ex) {
            throw new InvestimentoCdbException(ex.getMessage());
        }
    }

    public int contInvestimentoCDB() {
        return dao.getObjectCount(Cdb.class);
    }
}

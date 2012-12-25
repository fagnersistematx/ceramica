package Controler.conta;

import Entidade.Conta.Acoes;
import Entidade.Conta.Exception.InvestimentoAcoesDaBolsaException;
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
public class InvestimentoAcoesBolsaController {

    private DAO dao;

    public InvestimentoAcoesBolsaController() {
        this.dao = new DAO();
    }

    public Acoes criarAcoesDaBolsa(float custodia, float emolumentos, float corretagem, float iof, float cpmf, float saldo_original,
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {

        Acoes acoes = new Acoes(custodia, emolumentos, corretagem, iof, cpmf, saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);
        dao.create(acoes);
        return acoes;
    }

    public Acoes editarAcoesDaBolsa(Long id, float custodia, float emolumentos, float corretagem, float iof, float cpmf, float saldo_original,
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoAcoesDaBolsaException {

        Acoes acoes = buscarAcoesDaBolsa(id);
        try {
            acoes.setTx_custodia(custodia);
            acoes.setTx_emolumentos(emolumentos);
            acoes.setTx_corretagem(corretagem);
            acoes.setIof(iof);
            acoes.setCpmf(cpmf);
            acoes.setSaldo_original(saldo_original);
            acoes.setSaldo_atualizado(saldo_atualizado);
            acoes.setNm_conta(nm_conta);
            acoes.setNome(nome);
            acoes.setObs(obs);
            acoes.setCriacao(criacao);
            acoes.setLancamentos(lancamentos);
            dao.edit(acoes);
        } catch (NonexistentEntityException ex) {
            throw new InvestimentoAcoesDaBolsaException(ex.getMessage());
        } catch (Exception ex) {
            throw new InvestimentoAcoesDaBolsaException(ex.getMessage());
        }
        return acoes;

    }

    public Acoes buscarAcoesDaBolsa(Long id) throws InvestimentoAcoesDaBolsaException {
        Acoes acoes;
        try {
            acoes = (Acoes) dao.findObject(id, Acoes.class);
        } catch (Exception ex) {
            throw new InvestimentoAcoesDaBolsaException(ex.getMessage());
        }
        return acoes;
    }

    public void removerAcoesDaBolsa(Long id) throws InvestimentoAcoesDaBolsaException {
        try {
            dao.destroy(id, Acoes.class);
        } catch (NonexistentEntityException ex) {
            throw new InvestimentoAcoesDaBolsaException(ex.getMessage());
        }
    }

    public int contAcoesDaBolsa() {
        return dao.getObjectCount(Acoes.class);
    }
}


package Controler.conta;

import Entidade.Conta.Exception.InvestimentoFundoException;
import Entidade.Conta.Fundo;
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
public class InvestimentoFundoController {

    private DAO dao;
    
    public InvestimentoFundoController() {
        this.dao = new DAO(); 
    }

    public Fundo criarInvestimentoFundo(float administracao, float performace, String tipo, float iof, float cpmf, float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {
        Fundo fundo = new Fundo(administracao, performace, tipo, iof, cpmf, saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);
        dao.create(fundo);
        return fundo;
    }

    public Fundo alterarInvestimentoFundo(Long id, float administracao, float performace, String tipo, float iof, float cpmf, 
            float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, 
            List<Lancamento> lancamentos) throws InvestimentoFundoException {
        
        Fundo fundo = buscarInvestimentoFundo(id);
        try {
            
            fundo.setTipo(tipo);
            fundo.setTx_administracao(administracao);
            fundo.setTx_performace(performace);
            fundo.setIof(iof);
            fundo.setCpmf(cpmf);
            fundo.setSaldo_original(saldo_original);
            fundo.setSaldo_atualizado(saldo_atualizado);
            fundo.setNm_conta(nm_conta);
            fundo.setNome(nome);
            fundo.setObs(obs);
            fundo.setCriacao(criacao);
            fundo.setLancamentos(lancamentos);
            
            dao.edit(fundo);
            
        } catch (NonexistentEntityException ex) {
            throw new InvestimentoFundoException(ex.getMessage());
        } catch (Exception ex) {
            throw new InvestimentoFundoException(ex.getMessage());
        }
        return fundo;
    }

    public Fundo buscarInvestimentoFundo(Long id) throws InvestimentoFundoException {
        
        Fundo fundo;
        
        try {
            fundo = (Fundo) dao.findObject(id, Fundo.class);
        } catch (Exception ex) {
            throw new InvestimentoFundoException(ex.getMessage());
        }
        return fundo;
    }

    public void removerInvestimentoFundo(Long id) throws InvestimentoFundoException {
        try {
            dao.destroy(id, Fundo.class);
        } catch (NonexistentEntityException ex) {
            throw new InvestimentoFundoException(ex.getMessage());
        }
    }

    public int contInvestimentoFundo() {
        return dao.getObjectCount(Fundo.class);
    }

}

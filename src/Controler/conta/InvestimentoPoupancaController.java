
package Controler.conta;

import Entidade.Conta.Exception.InvestimentoPoupancaException;
import Entidade.Conta.Lancamento;
import Entidade.Conta.Poupanca;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class InvestimentoPoupancaController {
    
    private DAO dao;

    public InvestimentoPoupancaController() {
        this.dao = new DAO();
    }

    public Poupanca criarInvestimentoPoupanca(float iof, float cpmf, float saldo_original, float saldo_atualizado, 
            String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {
        
        Poupanca poupanca = new Poupanca(iof, cpmf, saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);
        dao.create(poupanca);
        return poupanca;
        
    }

    public Poupanca alterarInvestimentoPoupanca(Long id, float iof, float cpmf, float saldo_original, 
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoPoupancaException {
       
        Poupanca poupanca = buscarInvestimentoPoupanca(id);
        
        try {
            
            poupanca.setIof(iof);
            poupanca.setCpmf(cpmf);
            poupanca.setSaldo_original(saldo_original);
            poupanca.setSaldo_atualizado(saldo_atualizado);
            poupanca.setNm_conta(nm_conta);
            poupanca.setNome(nome);
            poupanca.setObs(obs);
            poupanca.setCriacao(criacao);
            poupanca.setLancamentos(lancamentos);
            
            dao.edit(poupanca);
            
        } catch (NonexistentEntityException ex) {
            throw new InvestimentoPoupancaException(ex.getMessage());
        } catch (Exception ex) {
            throw new InvestimentoPoupancaException(ex.getMessage());
        }
        return poupanca;
    }

    public Poupanca buscarInvestimentoPoupanca(Long id) throws InvestimentoPoupancaException {
        Poupanca poupanca;
        
        try {
            poupanca = (Poupanca) dao.findObject(id, Poupanca.class);
        } catch (Exception ex) {
            throw new InvestimentoPoupancaException(ex.getMessage());
        }
        return poupanca;
    }

    public void removerInvestimentoPoupanca(Long id) throws InvestimentoPoupancaException {
        try {
            dao.destroy(id, Poupanca.class);
        } catch (NonexistentEntityException ex) {
            throw new InvestimentoPoupancaException(ex.getMessage());
        }
    }

    public int contInvestimentoPoupanca() {
        return dao.getObjectCount(Poupanca.class);
    }   
    
}

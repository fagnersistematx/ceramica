
package Controler.conta;

import Entidade.Conta.Exception.InvestimentoTituloException;
import Entidade.Conta.Lancamento;
import Entidade.Conta.Titulo;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class InvestimentoTituloController {
    
    private DAO dao;

    public InvestimentoTituloController() {
        this.dao = new DAO();
    }

    public Titulo criarInvestimentoTitulo(float cblc, float banco, String tipo, float iof, float cpmf, float saldo_original, 
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {
        
        Titulo titulo = new Titulo(cblc, banco, tipo, iof, cpmf, saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);
        dao.create(titulo);
        return titulo;
        
    }

    public Titulo alterarInvestimentoTitulo(Long id, float cblc, float banco, String tipo, float iof, float cpmf, float saldo_original, 
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoTituloException {
        
         Titulo titulo = buscarInvestimentoTitulo(id);
        
        try {
            
            titulo.setTipo(tipo);
            titulo.setTx_custodia_banco(banco);
            titulo.setTx_custodia_cblc(cblc);
            titulo.setIof(iof);
            titulo.setCpmf(cpmf);
            titulo.setSaldo_original(saldo_original);
            titulo.setSaldo_atualizado(saldo_atualizado);
            titulo.setNm_conta(nm_conta);
            titulo.setNome(nome);
            titulo.setObs(obs);
            titulo.setCriacao(criacao);
            titulo.setLancamentos(lancamentos);
            
            dao.edit(titulo);
            
        } catch (NonexistentEntityException ex) {
            throw new InvestimentoTituloException(ex.getMessage());
        } catch (Exception ex) {
            throw new InvestimentoTituloException(ex.getMessage());
        }
        return titulo;
    }

    public Titulo buscarInvestimentoTitulo(Long id) throws InvestimentoTituloException {
        
        Titulo titulo;
        
        try {
            titulo = (Titulo) dao.findObject(id, Titulo.class);
        } catch (Exception ex) {
            throw new InvestimentoTituloException(ex.getMessage());
        }
        return titulo;
    }

    public void removerInvestimentoTitulo(Long id) throws InvestimentoTituloException {
        try {
            dao.destroy(id, Titulo.class);
        } catch (NonexistentEntityException ex) {
            throw new InvestimentoTituloException(ex.getMessage());
        }
    }

    public int contInvestimentoTitulo() {
        return dao.getObjectCount(Titulo.class);
    }   

}

package Controler.conta;

import Entidade.Conta.Exception.ContaImpostoException;
import Entidade.Conta.Imposto;
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
public class ContaImpostoDeRendaController {

    private DAO dao;

    public ContaImpostoDeRendaController() {
        dao = new DAO();
    }

    public Imposto criarImpostoDeRenda(String nome, String obs, Calendar dataCriacao, List<Lancamento> lancamentos, float valor, float aliquota) {
        Imposto imposto = new Imposto(nome, obs, dataCriacao, lancamentos, valor, aliquota);
        dao.create(imposto);
        return imposto;
    }

    public Imposto editarImpostoDeRenda(Long id, String nome, String obs, Calendar dataCriacao, List<Lancamento> lancamentos, float valor, float aliquota) throws ContaImpostoException {
        Imposto imposto = buscarImposto(id);
        try {
            imposto.setCriacao(dataCriacao);
            imposto.setLancamentos(lancamentos);
            imposto.setNome(nome);
            imposto.setObs(obs);
            imposto.setValor(valor);
            imposto.setAliquota(valor);
            dao.edit(imposto);
        } catch (NonexistentEntityException ex) {
            throw new ContaImpostoException(ex.getMessage());
        } catch (Exception ex) {
            throw new ContaImpostoException(ex.getMessage());
        }
        return imposto;
    }

    public Imposto buscarImposto(Long id) throws ContaImpostoException {

        Imposto imposto;
        try {
            imposto = (Imposto) dao.findObject(id, Imposto.class);
        } catch (Exception ex) {
            throw new ContaImpostoException(ex.getMessage());
        }
        return imposto;
    }

    public void removerImposto(Long id) throws ContaImpostoException {
        try {
            dao.destroy(id, Imposto.class);
        } catch (NonexistentEntityException ex) {
            throw new ContaImpostoException(ex.getMessage());
        }
    }

    public int contImposto() {
        return dao.getObjectCount(Imposto.class);
    }
}

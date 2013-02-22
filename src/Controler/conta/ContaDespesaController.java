package Controler.conta;

import Entidade.Conta.Conta;
import Entidade.Conta.Despesa;
import Entidade.Conta.Exception.FluxoDespesaException;
import Entidade.Conta.ItensPlanoConta;
import Entidade.Pessoa;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class ContaDespesaController {

    private DAO dao;

    public ContaDespesaController() {
        dao = new DAO();
    }

    public Despesa criarContaDespesa(String nome, float valor, String obs, Calendar criacao, Calendar data_fluxo, 
            Pessoa pessoa, ItensPlanoConta itensPlanoConta, String nomeConta) {
       
       Despesa despesa = new Despesa(nome, valor, obs, criacao, data_fluxo, pessoa, itensPlanoConta);
       
        Conta conta = buscarConta(nomeConta);
        if (conta == null) {
            return null;
        }
        if (conta.getDespesas() == null) {
            conta.setDespesas(new ArrayList<Despesa>());
        }
        conta.getDespesas().add(despesa);
        try {
            dao.edit(conta);
        } catch (Exception ex) {
            return null;
        }
        
        return despesa;
       
    }

    public void alterarContaDespesa(Long id, String nome, float valor, String obs, Calendar criacao, Calendar data_fluxo, 
            Pessoa pessoa, ItensPlanoConta itensPlanoConta) throws FluxoDespesaException {
        try {
            Despesa despesa = (Despesa) dao.findObject(id, Despesa.class);
            despesa.setCriacao(criacao);
            despesa.setNome(nome);
            despesa.setObs(obs);
            despesa.setValor(valor);
            despesa.setItensPlanoConta(itensPlanoConta);
            despesa.setData_fluxo(data_fluxo);
            dao.edit(despesa);
        } catch (ClassNotFoundException ex) {
            throw new FluxoDespesaException("Erro ao alterar despesa. " + ex.getMessage());
        } catch (NonexistentEntityException ex) {
            throw new FluxoDespesaException("Erro ao alterar despesa. " + ex.getMessage());
        } catch (Exception ex) {
            throw new FluxoDespesaException("Erro ao alterar despesa. " + ex.getMessage());
        }


    }

    public Despesa busca(Long id) throws FluxoDespesaException {
        Despesa despesa = null;
        try {
            despesa = (Despesa) dao.findObject(id, Despesa.class);
        } catch (Exception ex) {
            throw new FluxoDespesaException("Erro ao buscar despesa. " + ex.getMessage());
        }

        return despesa;
    }

    public void remover(Long id) throws FluxoDespesaException {
        try {
            dao.destroy(id, Despesa.class);
        } catch (NonexistentEntityException ex) {
            throw new FluxoDespesaException("Erro ao deletar despesa. " + ex.getMessage());
        }
    }

    public int cont() {
        return dao.getObjectCount(Despesa.class);
    }

    private Conta buscarConta(String nome) {

        List<Object> objects = dao.findObjectEntities(Conta.class);
        for (Object object : objects) {
            Conta c = (Conta) object;
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }

        }
        return null;
    }
}

package Controler.conta;

import Entidade.Conta.Exception.PlanoContaException;
import Entidade.Conta.ItensPlanoConta;
import Entidade.Conta.PlanoConta;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class PlanoContaController {

    private DAO dao;

    public PlanoContaController() {
        dao = new DAO();
    }

    public PlanoConta criarPlanoConta(String nome,boolean tipo) {
        PlanoConta planoConta = new PlanoConta(nome,tipo);
        dao.create(planoConta);
        return planoConta;
    }

    public PlanoConta alterarPlanoConta(Long id, String nome, boolean  tipo,List<ItensPlanoConta> itensPlanoContas) throws PlanoContaException {

        PlanoConta planoConta;

        try {
            planoConta = (PlanoConta) dao.findObject(id, PlanoConta.class);
            planoConta.setNome(nome);
            planoConta.setTipo(tipo);
            planoConta.setItensPlanoContas(itensPlanoContas);
            dao.edit(planoConta);
        } catch (ClassNotFoundException ex) {
            throw new PlanoContaException("Erro ao alterar PlanoConta " + ex.getMessage());
        } catch (NonexistentEntityException ex) {
            throw new PlanoContaException("Erro ao alterar PlanoConta " + ex.getMessage());
        } catch (Exception ex) {
            throw new PlanoContaException("Erro ao alterar PlanoConta " + ex.getMessage());
        }

        return planoConta;
    }

    public List<Object> listarPlanoConta() {
        return dao.findObjectEntities(PlanoConta.class);
    }

    public PlanoConta buscaPlanoConta(Long id) throws PlanoContaException {
        
        PlanoConta planoConta;
        try {
            planoConta = (PlanoConta) dao.findObject(id, PlanoConta.class);
        } catch (Exception ex) {
            throw new PlanoContaException("Erro ao buscar PlanoConta. " + ex.getMessage());
        }

        return planoConta;
    }
    
    public PlanoConta buscaPlanoConta(String nome) throws PlanoContaException {
        
        PlanoConta planoConta = null;
        try {
            
        for (Object o : listarPlanoConta()) {
            PlanoConta c = (PlanoConta) o;
            if(c.getNome().equalsIgnoreCase(nome)){
                planoConta = c;
            }
        }
        } catch (Exception ex) {
            throw new PlanoContaException("Erro ao buscar PlanoConta. " + ex.getMessage());
        }

        return planoConta;
    }

    public void removerPlanoConta(Long id) throws PlanoContaException {
        try {
            dao.destroy(id, PlanoConta.class);
        } catch (NonexistentEntityException ex) {
            throw new PlanoContaException("Erro ao deletar PlanoConta. " + ex.getMessage());
        }
    }

    public int contPlanoConta() {
        return dao.getObjectCount(PlanoConta.class);
    }

    public boolean nomeExitentePlanoConta(String nome) {
        for (Object o : listarPlanoConta()) {
            PlanoConta c = (PlanoConta) o;
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println(nome+ " |  "+c.getNome());
                return true;
            }
        }
        return false;
    }    
   
}

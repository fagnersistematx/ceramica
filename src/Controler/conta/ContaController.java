package Controler.conta;

import Entidade.Conta.Conta;
import Entidade.Conta.Exception.ContaException;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class ContaController {

    private DAO dao;

    public ContaController() {
        dao = new DAO();
    }

    public Conta criarConta(String nome, String banco, String agencia, String numero, Calendar data_saldo, float valor) {
        Conta conta = new Conta(nome, banco, agencia, numero, data_saldo, valor);
        dao.create(conta);
        return conta;
    }

    public Conta alterarConta(Long id, String nome, String banco, String agencia, String numero, Calendar data_saldo, float valor) throws ContaException {

        Conta conta;

        try {
            conta = (Conta) dao.findObject(id, Conta.class);
            conta.setNome(nome);
            conta.setAgencia(agencia);
            conta.setBanco(banco);
            conta.setNumero(numero);
            conta.setData_saldo(data_saldo);
            conta.setValor(valor);
            dao.edit(conta);
        } catch (ClassNotFoundException ex) {
            throw new ContaException("Erro ao alterar conta " + ex.getMessage());
        } catch (NonexistentEntityException ex) {
            throw new ContaException("Erro ao alterar conta " + ex.getMessage());
        } catch (Exception ex) {
            throw new ContaException("Erro ao alterar conta " + ex.getMessage());
        }

        return conta;
    }

    public List<Object> listarContas() {
        return dao.findObjectEntities(Conta.class);
    }

    public Conta buscaConta(Long id) throws ContaException {
        Conta conta = null;
        try {
            conta = (Conta) dao.findObject(id, Conta.class);
        } catch (Exception ex) {
            throw new ContaException("Erro ao buscar conta. " + ex.getMessage());
        }

        return conta;
    }

    public void removerConta(Long id) throws ContaException {
        try {
            dao.destroy(id, Conta.class);
        } catch (NonexistentEntityException ex) {
            throw new ContaException("Erro ao deletar conta. " + ex.getMessage());
        }
    }

    public int contConta() {
        return dao.getObjectCount(Conta.class);
    }
    
    public boolean nomeExitente(String nome){
        for(Object o : listarContas()){
            Conta c = (Conta) o;
            if(c.getNome().equalsIgnoreCase(nome)){
                return true;
            }
        }
        return false;
    }
}

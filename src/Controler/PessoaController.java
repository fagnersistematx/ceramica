package Controler;

import Entidade.Cliente;
import Entidade.Fornecedor;
import Entidade.Funcionario;
import Entidade.Pessoa;
import Util.DAO;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class PessoaController {

    private DAO dao;

    public PessoaController() {
        dao = new DAO();
    }
    
    public Pessoa pesquisarPessoa(Long id, String funcao){
        
        if(funcao.equalsIgnoreCase("Funcionário")){
            return (Funcionario) dao.findObject(id, Funcionario.class);
        }
        
        if(funcao.equalsIgnoreCase("Fornecedor")){
            return (Fornecedor) dao.findObject(id, Fornecedor.class);
        }
        
        if(funcao.equalsIgnoreCase("Cliente")){
            return (Cliente) dao.findObject(id, Cliente.class);
        }
        
        return null;
    }
}

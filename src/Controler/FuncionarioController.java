/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Entidade.Endereco;
import Entidade.Funcionario;
import Util.Config;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fagner
 */
public class FuncionarioController {
    
    private DAO dao;
    
    public FuncionarioController() {
        dao = new DAO();
    }
    
    public boolean CadastrarFuncionario(String nome, String login, String senha, String email,
            String cpf_cnpj, String rg, String data_nas, String tel_fixo, String cel1, String cel2,
            String sexo, String estado_civil, String funcao, float salario, boolean tipo,
            String logradouro, String cidade, String bairro, String numero, String cep, String comp, String obs) {
        
        
        Endereco endereco = new Endereco(logradouro, cidade, bairro, numero, cep, comp, obs);
        
        try {
            
            if (verivicarExisteNomeUsuario(nome)) {
                JOptionPane.showMessageDialog(null, "O funcionário com o nome \"" + nome + "\" já existe.\n"
                        + "Não cadastrado.", "Atenção", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (verivicarExisteLoginUsuario(login)) {
                JOptionPane.showMessageDialog(null, "O funcionário com o login de Acesso \"" + login + "\" já existe.\n"
                        + "Não cadastrado.", "Atenção", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
            Funcionario funionario = new Funcionario(nome, login, senha, email, cpf_cnpj, rg, data_nas, tel_fixo,
                    cel1, cel2, sexo, estado_civil, funcao, salario, tipo, endereco);
            
            dao.create(funionario);
            return true;
            
        } catch (Exception erro) {
            System.out.println("" + erro);
            return false;
        }
    }
    
    public boolean atualizarFuncionario(Funcionario funcionario, String nome, String login, String senha, String email,
            String cpf_cnpj, String rg, String data_nas, String tel_fixo, String cel1, String cel2,
            String sexo, String estado_civil, String funcao, float salario, boolean tipo,
            String logradouro, String cidade, String bairro, String numero, String cep, String comp, String obs) {
        
        try {
            Endereco endereco = new Endereco(logradouro, cidade, bairro, numero, cep, comp, obs);
            
            funcionario.atualiarDadosFuncionario(nome, login, senha, email, cpf_cnpj, rg, data_nas, 
                    tel_fixo, cel1, cel2, sexo, estado_civil, funcao, salario, tipo, endereco);            
            
            dao.edit(funcionario);
            
            return true;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro au atualizar dados do Usuário.", "Atenção", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void deletarUsuario(Long id) {
        for (Funcionario u : converte()) {
            //System.out.print(u.getId() + " || " + id);
            if (u.getId().toString().equalsIgnoreCase(id.toString())) {
                if (Config.getUsuario().getId().toString().equalsIgnoreCase(u.getId().toString())) {
                    JOptionPane.showMessageDialog(null, "Este usuário não pode ser excluído, porque estar em uso.", "Atenção", 0);
                    break;
                }
              //  System.out.print(u.getId() + " Delete " + id);
                try {
                    dao.destroy(u.getId(), Funcionario.class);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
    }
    
    public Funcionario findPesquisa(Long id) {
        try {
            
            return (Funcionario) dao.findObject(id, Funcionario.class);
            
        } catch (Exception erro) {
            return new Funcionario();
        }
    }
    
    public void alterarSenhaLogin(String login, String senha) {
        try {
            
            Config.getUsuario().setSenha(senha);
            Config.getUsuario().setLogin(login);
            dao.edit(Config.getUsuario());
            
            JOptionPane.showMessageDialog(null, "Protocolo de acesso alterado com sucesso.");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar as alterações.", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Funcionario> converte() {
        List<Funcionario> usuarios = new ArrayList<Funcionario>();
        List<Object> objects = new ArrayList<Object>();
        objects = dao.findObjectEntities(Funcionario.class);
        Iterator i = objects.iterator();
        
        while (i.hasNext()) {
            try {
                Funcionario u = (Funcionario) i.next();
                usuarios.add(u);
            } catch (Exception eroo) {
            }
        }
        return usuarios;
    }
    
    public List<Funcionario> converte(String nome) {
        List<Funcionario> usuarios = new ArrayList<Funcionario>();
        List<Object> objects = new ArrayList<Object>();
        objects = dao.pesquisar("Funcionario", "nome", nome);
        Iterator i = objects.iterator();
        
        while (i.hasNext()) {
            try {
                Funcionario u = (Funcionario) i.next();
                usuarios.add(u);
            } catch (Exception eroo) {
            }
        }
        return usuarios;
    }
    
    private boolean verivicarExisteNomeUsuario(String nome) {
        for (Funcionario c : converte(nome)) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean verivicarExisteLoginUsuario(String login) {
        for (Funcionario c : converte()) {
            if (c.getLogin().equalsIgnoreCase(login)) {
                return true;
            }
        }
        return false;
    }
}

package Controler;

import Entidade.Endereco;
import Entidade.Fornecedor;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class FornecedorController {

    private DAO dao;

    public FornecedorController() {
        this.dao = new DAO();
    }

    public boolean cadastrarFornecedorFisico(String nome, String empresa, String site, String email,
            String cpf_cnpj, String rg, String data_nas, String tel_fixo, String cel1, String cel2,
            String sexo, String logradouro, String cidade, String bairro, String numero, String cep, String comp, String obs) {

        if (!existeFornecedor(nome)) {

            Endereco endereco = new Endereco(logradouro, cidade, bairro, numero, cep, comp, obs);

            try {
                Fornecedor fornecedor = new Fornecedor(nome, empresa, site, email, cpf_cnpj, rg, data_nas, tel_fixo, cel1, cel2, sexo, endereco);
                dao.create(fornecedor);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "O fornecedor com o nome \"" + nome + "\" já existe.\n"
                    + "Não cadastrado.", "Atenção", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean cadastrarFornecedorJuridico(String nome, String razao_social, String site, String email,
            String cpf_cnpj, String inscricao_estadual, String tel_fixo, String cel1, String cel2, String logradouro, String cidade, String bairro, String numero, String cep, String comp, String obs) {

        if (!existeFornecedor(nome)) {

            Endereco endereco = new Endereco(logradouro, cidade, bairro, numero, cep, comp, obs);

            try {
                Fornecedor fornecedor = new Fornecedor(nome, razao_social, site, email, cpf_cnpj, inscricao_estadual, tel_fixo, cel1, cel2, endereco);
                dao.create(fornecedor);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "O fornecedor com o nome \"" + nome + "\" já existe.\n"
                    + "Não cadastrado.", "Atenção", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean existeFornecedor(String nome) {
        for (Object o : dao.findObjectEntities(Fornecedor.class)) {
            Fornecedor f = (Fornecedor) o;
            if (f.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public boolean deletarFornecedor(Long codigo) {
        try {
            dao.destroy(codigo, Fornecedor.class);
            return true;
        } catch (NonexistentEntityException ex) {
            return false;
        }
    }

    public Fornecedor findPesquisa(Long codigo) {
        try {
            
            return (Fornecedor) dao.findObject(codigo, Fornecedor.class);
            
        } catch (Exception erro) {
            return new Fornecedor();
        }
    }
    
    public List<Object> listarFornecedor(){
        return dao.findObjectEntities(Fornecedor.class);
    }

    public List<Object> converte(String text) {
        return dao.pesquisar("Fornecedor", "nome", text);
    }
}

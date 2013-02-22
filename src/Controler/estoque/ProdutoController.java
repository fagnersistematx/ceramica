package Controler.estoque;

import Entidade.Estoque.Exception.ProdutoException;
import Entidade.Estoque.Produto;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class ProdutoController {

    private DAO dao;

    public ProdutoController() {
        dao = new DAO();
    }

    public Produto criarProduto(String nome, String codigo) {
        Produto produto = new Produto(nome, codigo);
        dao.create(produto);
        return produto;
    }

    public Produto alterarProduto(Produto produto) throws ProdutoException {

        try {
            dao.edit(produto);
            return produto;
        } catch (ClassNotFoundException ex) {
            throw new ProdutoException("Erro ao alterar produto" + ex.getMessage());
        } catch (NonexistentEntityException ex) {
            throw new ProdutoException("Erro ao alterar produto " + ex.getMessage());
        } catch (Exception ex) {
            throw new ProdutoException("Erro ao alterar produto " + ex.getMessage());
        }
    }

    public List<Object> listarProdutos() {
        return dao.findObjectEntities(Produto.class);
    }

    public List<Object> listarProdutos(String nome) {
        return dao.pesquisar("Produto", "nome", nome);
    }

    public Produto buscaProduto(Long id) throws ProdutoException {
        Produto produto = null;
        try {
            produto = (Produto) dao.findObject(id, Produto.class);
        } catch (Exception ex) {
            throw new ProdutoException("Erro ao buscar produto. " + ex.getMessage());
        }

        return produto;
    }

    public void removerProduto(Long id) throws ProdutoException {
        try {
            dao.destroy(id, Produto.class);
        } catch (NonexistentEntityException ex) {
            throw new ProdutoException("Erro ao deletar produto. " + ex.getMessage());
        }
    }

    public int contProduto() {
        return dao.getObjectCount(Produto.class);
    }

    public boolean nomeExitenteProduto(String nome, String nomeProduto) {
        for (Object o : listarProdutos()) {
            Produto produto = (Produto) o;
            if (produto.getNome().equalsIgnoreCase(nome) && !produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return true;
            }
        }
        return false;
    }

    public boolean nomeExitenteCodigoProduto(String codigo, String nomeProduto) {
        for (Object o : listarProdutos()) {
            Produto produto = (Produto) o;
            if (produto.getCodigo().equalsIgnoreCase(codigo) && !produto.getCodigo().equalsIgnoreCase("") && !produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return true;
            }
        }
        return false;
    }
}

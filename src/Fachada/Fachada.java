package Fachada;

import Controler.FornecedorController;
import Controler.PessoaController;
import Controler.conta.ContaController;
import Controler.conta.ContaDespesaController;
import Controler.conta.ContaReceitaController;
import Controler.conta.ItensPlanoContaController;
import Controler.conta.PlanoContaController;
import Controler.estoque.LoteController;
import Controler.estoque.NotaController;
import Controler.estoque.ProdutoController;
import Entidade.Conta.Conta;
import Entidade.Conta.Despesa;
import Entidade.Conta.Exception.ContaException;
import Entidade.Conta.Exception.FluxoDespesaException;
import Entidade.Conta.Exception.FluxoReceitaException;
import Entidade.Conta.Exception.ItensPlanoContaException;
import Entidade.Conta.Exception.PlanoContaException;
import Entidade.Conta.ItensPlanoConta;
import Entidade.Conta.PlanoConta;
import Entidade.Conta.Receita;
import Entidade.Estoque.Exception.LoteException;
import Entidade.Estoque.Exception.NotaException;
import Entidade.Estoque.Exception.ProdutoException;
import Entidade.Estoque.Lote;
import Entidade.Estoque.Nota;
import Entidade.Estoque.Produto;
import Entidade.Fornecedor;
import Entidade.Funcionario;
import Entidade.Pessoa;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class Fachada {

    private ContaDespesaController contaDespesaController;
    private ContaReceitaController contaReceitaController;
    private ContaController contaController;
    private PlanoContaController planoContaController;
    private ItensPlanoContaController itensPlanoContaController;
    private PessoaController pessoaController;
    private ProdutoController produtoController;
    private LoteController loteController;
    private NotaController notaController;
    private static Fachada fachada;

    private Fachada() {

        this.contaDespesaController = new ContaDespesaController();
        this.contaReceitaController = new ContaReceitaController();
        this.contaController = new ContaController();
        this.planoContaController = new PlanoContaController();
        this.itensPlanoContaController = new ItensPlanoContaController();
        this.pessoaController = new PessoaController();
        this.produtoController = new ProdutoController();
        this.loteController = new LoteController();
        this.notaController = new NotaController();

    }

    public static Fachada getInstance() {
        if (fachada == null) {
            fachada = new Fachada();
        }
        return fachada;
    }

    /**
     *
     * @param nome
     * @param obs
     * @param dataCriacao
     * @param tipo
     * @param lancamentos
     * @return
     */
    public Despesa criarFluxoDespesa(String nome, float valor, String obs, Calendar criacao, Calendar data_fluxo, Pessoa pessoa, ItensPlanoConta itensPlanoConta, String nomeConta) {

        return contaDespesaController.criarContaDespesa(nome, valor, obs, criacao, data_fluxo, pessoa, itensPlanoConta, nomeConta);

    }

    /**
     *
     * @param id
     * @param nome
     * @param obs
     * @param dataCriacao
     * @param tipo
     * @param lancamentos
     * @throws FluxoDespesaException
     */
    public void alterarContaDespesa(Long id, String nome, float valor, String obs, Calendar criacao, Calendar data_fluxo,
            Pessoa pessoa, ItensPlanoConta itensPlanoConta) throws FluxoDespesaException {

        contaDespesaController.alterarContaDespesa(id, nome, valor, obs, criacao, data_fluxo, pessoa, itensPlanoConta);

    }

    /**
     *
     * @param id
     * @return
     * @throws FluxoDespesaException
     */
    public Despesa buscaDespesa(Long id) throws FluxoDespesaException {
        return contaDespesaController.busca(id);
    }

    /**
     *
     * @param id
     * @throws FluxoDespesaException
     */
    public void removerDespesa(Long id) throws FluxoDespesaException {
        contaDespesaController.remover(id);
    }

    /**
     *
     * @return
     */
    public int contDespesa() {
        return contaDespesaController.cont();
    }

    /**
     *
     * @param nome
     * @param obs
     * @param dataCriacao
     * @param tipo
     * @param lancamentos
     * @return
     */
    public Receita criarContaReceita(String nome, String obs, Calendar dataCriacao, String tipolancamentos) {

        //return contaReceitaController.criarContaReceita(nome, obs, dataCriacao, obs, null);
        return null;
    }

    /**
     *
     * @param id
     * @param nome
     * @param obs
     * @param dataCriacao
     * @param tipo
     * @param lancamentos
     * @throws FluxoReceitaException
     */
    public void alterarContaReceita(Long id, String nome, String obs, Calendar dataCriacao,
            String tipo) throws FluxoReceitaException {

        contaReceitaController.alterarContaReceita(id, nome, obs, dataCriacao, tipo);

    }

    /**
     *
     * @param id
     * @return
     * @throws FluxoReceitaException
     */
    public Receita buscaContaReceita(Long id) throws FluxoReceitaException {

        return contaReceitaController.busca(id);

    }

    /**
     *
     * @param id
     * @throws FluxoReceitaException
     */
    public void removerContaReceita(Long id) throws FluxoReceitaException {
        contaReceitaController.remover(id);
    }

    /**
     *
     * @return
     */
    public int contContaReceita() {
        return contaReceitaController.cont();
    }

    /**
     *
     * @param nome
     * @param banco
     * @param agencia
     * @param numero
     * @param data_saldo
     * @param valor
     * @return
     */
    public Conta criarConta(String nome, String banco, String agencia, String numero, Calendar data_saldo, float valor) {

        return contaController.criarConta(nome, banco, agencia, numero, data_saldo, valor);

    }

    /**
     *
     * @param id
     * @param nome
     * @param banco
     * @param agencia
     * @param numero
     * @param data_saldo
     * @param valor
     * @return
     * @throws ContaException
     */
    public Conta alterarConta(Long id, String nome, String banco, String agencia, String numero, Calendar data_saldo, float valor) throws ContaException {

        return contaController.alterarConta(id, nome, banco, agencia, numero, data_saldo, valor);

    }

    /**
     *
     * @return
     */
    public List<Object> listarContas() {
        return contaController.listarContas();
    }

    /**
     *
     * @param id
     * @return
     * @throws ContaException
     */
    public Conta buscaConta(Long id) throws ContaException {

        return contaController.buscaConta(id);

    }

    /**
     *
     * @param id
     * @throws ContaException
     */
    public void removerConta(Long id) throws ContaException {
        contaController.removerConta(id);
    }

    /**
     *
     * @return
     */
    public int contConta() {
        return contaController.contConta();
    }

    /**
     *
     * @param nome
     * @return
     */
    public boolean nomeExitente(String nome) {
        return contaController.nomeExitente(nome);
    }

    /**
     *
     * @param nome
     * @return
     */
    public PlanoConta criarPlanoConta(String nome, boolean tipo) {
        return planoContaController.criarPlanoConta(nome, tipo);
    }

    /**
     *
     * @param id
     * @param nome
     * @return
     * @throws PlanoContaException
     */
    public PlanoConta alterarPlanoConta(Long id, String nome, boolean tipo, List<ItensPlanoConta> itensPlanoContas) throws PlanoContaException {
        return planoContaController.alterarPlanoConta(id, nome, tipo, itensPlanoContas);
    }

    /**
     *
     * @return
     */
    public List<Object> listarPlanoConta() {
        return planoContaController.listarPlanoConta();
    }

    /**
     *
     * @param id
     * @return
     * @throws PlanoContaException
     */
    public PlanoConta buscaPlanoConta(Long id) throws PlanoContaException {
        return planoContaController.buscaPlanoConta(id);
    }

    /**
     *
     * @param nome
     * @return
     * @throws PlanoContaException
     */
    public PlanoConta buscaPlanoConta(String nome) throws PlanoContaException {
        return planoContaController.buscaPlanoConta(nome);
    }

    /**
     *
     * @param id
     * @throws PlanoContaException
     */
    public void removerPlanoConta(Long id) throws PlanoContaException {
        planoContaController.removerPlanoConta(id);
    }

    /**
     *
     * @return
     */
    public int contPlanoConta() {
        return planoContaController.contPlanoConta();
    }

    /**
     *
     * @param nome
     * @return
     */
    public boolean nomeExitentePlanoConta(String nome) {
        return planoContaController.nomeExitentePlanoConta(nome);
    }

    /**
     *
     * @param nome
     * @return
     */
    public ItensPlanoConta criarItensPlanoConta(String nome) {
        return itensPlanoContaController.criarItensPlanoConta(nome);
    }

    /**
     *
     * @param id
     * @param nome
     * @return
     * @throws PlanoContaException
     */
    public ItensPlanoConta alterarItensPlanoConta(Long id, String nome) throws ItensPlanoContaException {
        return itensPlanoContaController.alterarItensPlanoConta(id, nome);
    }

    /**
     *
     * @return
     */
    public List<Object> listarItensPlanoConta() {
        return itensPlanoContaController.listarItensPlanoConta();
    }

    /**
     *
     * @param id
     * @return
     * @throws PlanoContaException
     */
    public ItensPlanoConta buscaItensPlanoConta(Long id) throws ItensPlanoContaException {
        return itensPlanoContaController.buscaItensPlanoConta(id);
    }

    /**
     *
     * @param nome
     * @return
     */
    public ItensPlanoConta buscaItensPlanoConta(String nome) {
        return itensPlanoContaController.buscaItensPlanoConta(nome);
    }

    /**
     *
     * @param id
     * @throws PlanoContaException
     */
    public void removerItensPlanoConta(Long id) throws ItensPlanoContaException {
        itensPlanoContaController.removerItensPlanoConta(id);
    }

    /**
     *
     * @return
     */
    public int contItensPlanoConta() {
        return itensPlanoContaController.contItensPlanoConta();
    }

    /**
     *
     * @param nome
     * @return
     */
    public boolean nomeExitenteItensPlanoConta(String nome) {
        return itensPlanoContaController.nomeExitenteItensPlanoConta(nome);
    }

    /**
     *
     * @param id
     * @param nome
     * @param funcao
     * @return
     */
    public Pessoa pesquisarPessoa(Long id, String funcao) {
        return pessoaController.pesquisarPessoa(id, funcao);
    }

    /**
     *
     * @param nome
     * @param codigo
     * @return
     */
    public Produto criarProduto(String nome, String codigo) {
        return produtoController.criarProduto(nome, codigo);
    }

    /**
     *
     * @param id
     * @param nome
     * @param codigo
     * @return
     * @throws ProdutoException
     */
    public Produto alterarProduto(Produto produto) throws ProdutoException {

        return produtoController.alterarProduto(produto);

    }

    /**
     *
     * @return
     */
    public List<Object> listarProdutos() {
        return produtoController.listarProdutos();
    }

    /**
     *
     * @param id
     * @return
     * @throws ProdutoException
     */
    public Produto buscaProduto(Long id) throws ProdutoException {

        return produtoController.buscaProduto(id);

    }

    /**
     *
     * @param id
     * @throws ProdutoException
     */
    public void removerProduto(Long id) throws ProdutoException {
        produtoController.removerProduto(id);
    }

    /**
     *
     * @return
     */
    public int contProduto() {
        return produtoController.contProduto();
    }

    /**
     *
     * @param nome
     * @return
     */
    public boolean nomeExitenteProduto(String nome, String nomeProduto) {

        return produtoController.nomeExitenteProduto(nome, nomeProduto);
    }

    /**
     *
     * @param codigo
     * @return
     */
    public boolean nomeExitenteCodigoProduto(String codigo, String nomeProduto) {
        return produtoController.nomeExitenteCodigoProduto(codigo, nomeProduto);
    }

    /**
     *
     * @param nome
     * @return
     */
    public List<Object> listarProdutos(String nome) {
        return produtoController.listarProdutos(nome);
    }

    /**
     *
     * @param numero
     * @param quant
     * @param valor
     * @param preco_saco
     * @param produto
     * @return
     */
    public Lote criarLote(String numero, float quant, float valor, float preco_saco, Produto produto, Fornecedor fornecedor, Funcionario funcionario) {
        return loteController.criarLote(numero, quant, valor, preco_saco, produto, fornecedor, funcionario);
    }

    /**
     *
     * @param lote
     * @return
     * @throws LoteException
     */
    public Lote alterarLote(Lote lote) throws LoteException {
        return loteController.alterarLote(lote);
    }

    /**
     *
     * @return
     */
    public List<Object> listarLotes() {
        return loteController.listarLotes();
    }

    /**
     *
     * @param numero
     * @return
     */
    public List<Object> listarLotes(String numero) {
        return listarLotes(numero);
    }

    /**
     *
     * @param id
     * @return
     * @throws LoteException
     */
    public Lote buscaLotes(Long id) throws LoteException {
        return loteController.buscaLotes(id);
    }

    /**
     *
     * @param id
     * @throws LoteException
     */
    public void removerLote(Long id) throws LoteException {
        loteController.removerLote(id);
    }

    /**
     *
     * @return
     */
    public int contLote() {
        return loteController.contLote();
    }

    /**
     *
     * @param numero
     * @return
     */
    public boolean nomeExitenteCodigoLote(String numero) {
        return loteController.nomeExitenteCodigoLote(numero);
    }

    /**
     *
     * @param lotes
     * @param desconto
     * @param total
     * @param numero
     * @param data_entrada
     * @return
     */
    public Nota criarNota(List<Lote> lotes, float desconto, float total, String numero, Calendar data_entrada, String obs) {
        return this.notaController.criarNota(lotes, desconto, total, numero, data_entrada, obs);
    }

    /**
     *
     * @param nota
     * @return
     * @throws NotaException
     */
    public Nota alterarNota(Nota nota) throws NotaException {
        return this.notaController.alterarNota(nota);
    }

    /**
     *
     * @return
     */
    public List<Object> listarNota() {
        return this.notaController.listarNota();
    }

    /**
     *
     * @param numero
     * @return
     */
    public List<Object> listarNota(String numero) {
        return this.listarLotes(numero);
    }

    /**
     *
     * @param id
     * @return
     * @throws NotaException
     */
    public Nota buscaNota(Long id) throws NotaException {
        return this.notaController.buscaNota(id);
    }

    /**
     *
     * @param id
     * @throws NotaException
     */
    public void removerNota(Long id) throws NotaException {
        this.notaController.removerNota(id);
    }

    /**
     *
     * @return
     */
    public int contNota() {
        return this.notaController.contNota();
    }

    /**
     *
     * @param numero
     * @param numeroNota
     * @return
     */
    public boolean exitenteNota(String numero) {
        return this.notaController.exitenteNota(numero);
    }
}

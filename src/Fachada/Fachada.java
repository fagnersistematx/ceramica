package Fachada;

import Controler.conta.ContaController;
import Controler.conta.ContaDespesaController;
import Controler.conta.ContaImpostoDeRendaController;
import Controler.conta.ContaReceitaController;
import Controler.conta.InvestimentoAcoesBolsaController;
import Controler.conta.InvestimentoCdbController;
import Controler.conta.InvestimentoFundoController;
import Controler.conta.InvestimentoPoupancaController;
import Controler.conta.InvestimentoTituloController;
import Controler.conta.ItensPlanoContaController;
import Controler.conta.LancamentoController;
import Controler.conta.PlanoContaController;
import Entidade.Conta.Acoes;
import Entidade.Conta.Cdb;
import Entidade.Conta.Conta;
import Entidade.Conta.Despesa;
import Entidade.Conta.Exception.ContaException;
import Entidade.Conta.Exception.ContaImpostoException;
import Entidade.Conta.Exception.FluxoDespesaException;
import Entidade.Conta.Exception.FluxoReceitaException;
import Entidade.Conta.Exception.InvestimentoAcoesDaBolsaException;
import Entidade.Conta.Exception.InvestimentoCdbException;
import Entidade.Conta.Exception.InvestimentoFundoException;
import Entidade.Conta.Exception.InvestimentoPoupancaException;
import Entidade.Conta.Exception.InvestimentoTituloException;
import Entidade.Conta.Exception.ItensPlanoContaException;
import Entidade.Conta.Exception.LancamentoException;
import Entidade.Conta.Exception.PlanoContaException;
import Entidade.Conta.Fundo;
import Entidade.Conta.Imposto;
import Entidade.Conta.ItensPlanoConta;
import Entidade.Conta.Lancamento;
import Entidade.Conta.PlanoConta;
import Entidade.Conta.Poupanca;
import Entidade.Conta.Receita;
import Entidade.Conta.Titulo;
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
    private LancamentoController lancamentoController;
    private ContaImpostoDeRendaController contaImpostoDeRendaController;
    private InvestimentoAcoesBolsaController investimentoAcoesBolsaController;
    private InvestimentoCdbController investimentoCdbController;
    private InvestimentoFundoController investimentoFundoController;
    private InvestimentoPoupancaController investimentoPoupancaController;
    private InvestimentoTituloController investimentoTituloController;
    private ContaController contaController;
    private PlanoContaController planoContaController;
    private ItensPlanoContaController itensPlanoContaController;
    private static Fachada fachada;

    private Fachada() {

        this.contaDespesaController = new ContaDespesaController();
        this.contaReceitaController = new ContaReceitaController();
        this.contaImpostoDeRendaController = new ContaImpostoDeRendaController();
        this.lancamentoController = new LancamentoController();
        this.investimentoAcoesBolsaController = new InvestimentoAcoesBolsaController();
        this.investimentoCdbController = new InvestimentoCdbController();
        this.investimentoFundoController = new InvestimentoFundoController();
        this.investimentoPoupancaController = new InvestimentoPoupancaController();
        this.investimentoTituloController = new InvestimentoTituloController();
        this.contaController = new ContaController();
        this.planoContaController = new PlanoContaController();
        this.itensPlanoContaController = new ItensPlanoContaController();

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
     * @param lancamentos
     * @param valor
     * @param aliquota
     * @return
     */
    public Imposto criarImpostoDeRenda(String nome, String obs, Calendar dataCriacao,
            List<Lancamento> lancamentos, float valor, float aliquota) {

        return contaImpostoDeRendaController.criarImpostoDeRenda(nome, obs, dataCriacao, lancamentos, valor, aliquota);

    }

    /**
     *
     * @param id
     * @param nome
     * @param obs
     * @param dataCriacao
     * @param lancamentos
     * @param valor
     * @param aliquota
     * @return
     * @throws ContaImpostoException
     */
    public Imposto editarImpostoDeRenda(Long id, String nome, String obs, Calendar dataCriacao,
            List<Lancamento> lancamentos, float valor, float aliquota) throws ContaImpostoException {

        return contaImpostoDeRendaController.editarImpostoDeRenda(id, nome, obs, dataCriacao, lancamentos, valor, aliquota);

    }

    /**
     *
     * @param id
     * @return
     * @throws ContaImpostoException
     */
    public Imposto buscarImposto(Long id) throws ContaImpostoException {

        return contaImpostoDeRendaController.buscarImposto(id);

    }

    /**
     *
     * @param id
     * @throws ContaImpostoException
     */
    public void removerImposto(Long id) throws ContaImpostoException {

        contaImpostoDeRendaController.removerImposto(id);

    }

    /**
     *
     * @return
     */
    public int contImposto() {
        return contaImpostoDeRendaController.contImposto();
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
    public Despesa criarContaDespesa(String nome, String obs, Calendar dataCriacao, String tipo, List<Lancamento> lancamentos) {

        return contaDespesaController.criarContaDespesa(nome, obs, dataCriacao, tipo, lancamentos);

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
    public void alterarContaDespesa(Long id, String nome, String obs, Calendar dataCriacao,
            String tipo, List<Lancamento> lancamentos) throws FluxoDespesaException {

        contaDespesaController.alterarContaDespesa(id, nome, obs, dataCriacao, tipo, lancamentos);

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
    public Receita criarContaReceita(String nome, String obs, Calendar dataCriacao, String tipo, List<Lancamento> lancamentos) {

        return contaReceitaController.criarContaReceita(nome, obs, dataCriacao, tipo, lancamentos);

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
            String tipo, List<Lancamento> lancamentos) throws FluxoReceitaException {

        contaReceitaController.alterarContaReceita(id, nome, obs, dataCriacao, tipo, lancamentos);

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
     * @param valor
     * @param dataVencimento
     * @param dataCriacao
     * @param obs
     * @return
     * @throws LancamentoException
     */
    public Lancamento criarLancamento(float valor, Calendar dataVencimento,
            Calendar dataCriacao, String obs) throws LancamentoException {

        return lancamentoController.criarLancamento(valor, dataVencimento, dataCriacao, obs);
    }

    /**
     *
     * @param id
     * @param valor
     * @param dataVencimento
     * @param dataCriacao
     * @param tipo
     * @param obs
     * @param juros
     * @param dataQuitacao
     * @throws LancamentoException
     */
    public void alterarLancamentoQuitado(Long id, float valor, Calendar dataVencimento, Calendar dataCriacao,
            String tipo, String obs, float juros, Calendar dataQuitacao) throws LancamentoException {

        lancamentoController.alterarLancamentoQuitado(id, valor, dataVencimento, dataCriacao, tipo, obs, juros, dataQuitacao);

    }

    /**
     *
     * @param id
     * @param juros
     * @param dataQuitacao
     * @param obs
     * @param tipo
     * @throws LancamentoException
     */
    public void alterarLancamentoNaoQuitado(Long id, float juros, Calendar dataQuitacao,
            String obs, String tipo) throws LancamentoException {
        lancamentoController.alterarLancamentoNaoQuitado(id, juros, dataQuitacao, obs, tipo);
    }

    /**
     *
     * @param id
     * @return
     * @throws LancamentoException
     */
    public Lancamento buscaLancacamento(Long id) throws LancamentoException {

        return lancamentoController.busca(id);

    }

    /**
     *
     * @param id
     * @throws LancamentoException
     */
    public void removerLancamento(Long id) throws LancamentoException {
        lancamentoController.remover(id);
    }

    /**
     *
     * @return
     */
    public int contLancamento() {
        return lancamentoController.cont();
    }

    /**
     *
     * @param custodia
     * @param emolumentos
     * @param corretagem
     * @param iof
     * @param cpmf
     * @param saldo_original
     * @param saldo_atualizado
     * @param nm_conta
     * @param nome
     * @param obs
     * @param criacao
     * @param lancamentos
     * @return
     */
    public Acoes criarAcoesDaBolsa(float custodia, float emolumentos, float corretagem, float iof, float cpmf,
            float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {

        return investimentoAcoesBolsaController.criarAcoesDaBolsa(custodia, emolumentos, corretagem, iof, cpmf,
                saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);

    }

    /**
     *
     * @param id
     * @param custodia
     * @param emolumentos
     * @param corretagem
     * @param iof
     * @param cpmf
     * @param saldo_original
     * @param saldo_atualizado
     * @param nm_conta
     * @param nome
     * @param obs
     * @param criacao
     * @param lancamentos
     * @return
     * @throws InvestimentoAcoesDaBolsaException
     */
    public Acoes editarAcoesDaBolsa(Long id, float custodia, float emolumentos, float corretagem, float iof, float cpmf, float saldo_original,
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoAcoesDaBolsaException {

        return investimentoAcoesBolsaController.editarAcoesDaBolsa(id, custodia, emolumentos, corretagem, iof,
                cpmf, saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);

    }

    /**
     *
     * @param id
     * @return
     * @throws InvestimentoAcoesDaBolsaException
     */
    public Acoes buscarAcoesDaBolsa(Long id) throws InvestimentoAcoesDaBolsaException {
        return investimentoAcoesBolsaController.buscarAcoesDaBolsa(id);
    }

    /**
     *
     * @param id
     * @throws InvestimentoAcoesDaBolsaException
     */
    public void removerAcoesDaBolsa(Long id) throws InvestimentoAcoesDaBolsaException {
        investimentoAcoesBolsaController.removerAcoesDaBolsa(id);
    }

    /**
     *
     * @return
     */
    public int contAcoesDaBolsa() {
        return investimentoAcoesBolsaController.contAcoesDaBolsa();
    }

    /**
     *
     * @param contratacao
     * @param investimento
     * @param iof
     * @param cpmf
     * @param saldo_original
     * @param saldo_atualizado
     * @param nm_conta
     * @param nome
     * @param obs
     * @param criacao
     * @param lancamentos
     * @return
     */
    public Cdb criarInvestimentoCDB(float contratacao, Calendar investimento, float iof, float cpmf, float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {

        return investimentoCdbController.criarInvestimentoCDB(contratacao, investimento, iof, cpmf, saldo_original,
                saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);

    }

    /**
     *
     * @param id
     * @param contratacao
     * @param investimento
     * @param iof
     * @param cpmf
     * @param saldo_original
     * @param saldo_atualizado
     * @param nm_conta
     * @param nome
     * @param obs
     * @param criacao
     * @param lancamentos
     * @return
     * @throws InvestimentoCdbException
     */
    public Cdb alterarInvestimentoCDB(Long id, float contratacao, Calendar investimento, float iof, float cpmf, float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoCdbException {

        return investimentoCdbController.alterarInvestimentoCDB(id, contratacao, investimento, iof, cpmf, saldo_original, saldo_atualizado, nm_conta,
                nome, obs, criacao, lancamentos);

    }

    /**
     *
     * @param id
     * @return
     * @throws InvestimentoCdbException
     */
    public Cdb buscarInvestimentoCDB(Long id) throws InvestimentoCdbException {
        return investimentoCdbController.buscarInvestimentoCDB(id);
    }

    /**
     *
     * @param id
     * @throws InvestimentoCdbException
     */
    public void removerInvestimentoCDB(Long id) throws InvestimentoCdbException {
        investimentoCdbController.removerInvestimentoCDB(id);
    }

    /**
     *
     * @return
     */
    public int contInvestimentoCDB() {
        return investimentoCdbController.contInvestimentoCDB();
    }

    /**
     *
     * @param administracao
     * @param performace
     * @param tipo
     * @param iof
     * @param cpmf
     * @param saldo_original
     * @param saldo_atualizado
     * @param nm_conta
     * @param nome
     * @param obs
     * @param criacao
     * @param lancamentos
     * @return
     */
    public Fundo criarInvestimentoFundo(float administracao, float performace, String tipo, float iof, float cpmf,
            float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {

        return investimentoFundoController.criarInvestimentoFundo(administracao, performace, tipo, iof, cpmf,
                saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);

    }

    /**
     *
     * @param id
     * @param administracao
     * @param performace
     * @param tipo
     * @param iof
     * @param cpmf
     * @param saldo_original
     * @param saldo_atualizado
     * @param nm_conta
     * @param nome
     * @param obs
     * @param criacao
     * @param lancamentos
     * @return
     * @throws InvestimentoFundoException
     */
    public Fundo alterarInvestimentoFundo(Long id, float administracao, float performace, String tipo, float iof, float cpmf, float saldo_original,
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoFundoException {

        return investimentoFundoController.alterarInvestimentoFundo(id, administracao, performace, tipo, iof, cpmf,
                saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);

    }

    /**
     *
     * @param id
     * @return
     * @throws InvestimentoFundoException
     */
    public Fundo buscarInvestimentoFundo(Long id) throws InvestimentoFundoException {
        return investimentoFundoController.buscarInvestimentoFundo(id);
    }

    /**
     *
     * @param id
     * @throws InvestimentoFundoException
     */
    public void removerInvestimentoFundo(Long id) throws InvestimentoFundoException {
        investimentoFundoController.removerInvestimentoFundo(id);
    }

    /**
     *
     * @return
     */
    public int contInvestimentoFundo() {
        return investimentoFundoController.contInvestimentoFundo();
    }

    /**
     *
     * @param iof
     * @param cpmf
     * @param saldo_original
     * @param saldo_atualizado
     * @param nm_conta
     * @param nome
     * @param obs
     * @param criacao
     * @param lancamentos
     * @return
     */
    public Poupanca criarInvestimentoPoupanca(float iof, float cpmf, float saldo_original, float saldo_atualizado, String nm_conta,
            String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {

        return investimentoPoupancaController.criarInvestimentoPoupanca(iof, cpmf, saldo_original, saldo_atualizado,
                nm_conta, nome, obs, criacao, lancamentos);

    }

    /**
     *
     * @param id
     * @param iof
     * @param cpmf
     * @param saldo_original
     * @param saldo_atualizado
     * @param nm_conta
     * @param nome
     * @param obs
     * @param criacao
     * @param lancamentos
     * @return
     * @throws InvestimentoPoupancaException
     */
    public Poupanca alterarInvestimentoPoupanca(Long id, float iof, float cpmf, float saldo_original, float saldo_atualizado, String nm_conta,
            String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoPoupancaException {

        return investimentoPoupancaController.alterarInvestimentoPoupanca(id, iof, cpmf, saldo_original, saldo_atualizado,
                nm_conta, nome, obs, criacao, lancamentos);

    }

    /**
     *
     * @param id
     * @return
     * @throws InvestimentoPoupancaException
     */
    public Poupanca buscarInvestimentoPoupanca(Long id) throws InvestimentoPoupancaException {
        return investimentoPoupancaController.buscarInvestimentoPoupanca(id);
    }

    /**
     *
     * @param id
     * @throws InvestimentoPoupancaException
     */
    public void removerInvestimentoPoupanca(Long id) throws InvestimentoPoupancaException {
        investimentoPoupancaController.removerInvestimentoPoupanca(id);
    }

    /**
     *
     * @return
     */
    public int contInvestimentoPoupanca() {
        return investimentoPoupancaController.contInvestimentoPoupanca();
    }

    /**
     *
     * @param cblc
     * @param banco
     * @param tipo
     * @param iof
     * @param cpmf
     * @param saldo_original
     * @param saldo_atualizado
     * @param nm_conta
     * @param nome
     * @param obs
     * @param criacao
     * @param lancamentos
     * @return
     */
    public Titulo criarInvestimentoTitulo(float cblc, float banco, String tipo, float iof, float cpmf, float saldo_original,
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {

        return investimentoTituloController.criarInvestimentoTitulo(cblc, banco, tipo, iof, cpmf, saldo_original,
                saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);

    }

    /**
     *
     * @param id
     * @param cblc
     * @param banco
     * @param tipo
     * @param iof
     * @param cpmf
     * @param saldo_original
     * @param saldo_atualizado
     * @param nm_conta
     * @param nome
     * @param obs
     * @param criacao
     * @param lancamentos
     * @return
     * @throws InvestimentoTituloException
     */
    public Titulo alterarInvestimentoTitulo(Long id, float cblc, float banco, String tipo, float iof, float cpmf,
            float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoTituloException {

        return investimentoTituloController.alterarInvestimentoTitulo(id, cblc, banco, tipo, iof, cpmf, saldo_original,
                saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);

    }

    /**
     *
     * @param id
     * @return
     * @throws InvestimentoTituloException
     */
    public Titulo buscarInvestimentoTitulo(Long id) throws InvestimentoTituloException {
        return investimentoTituloController.buscarInvestimentoTitulo(id);
    }

    /**
     *
     * @param id
     * @throws InvestimentoTituloException
     */
    public void removerInvestimentoTitulo(Long id) throws InvestimentoTituloException {
        investimentoTituloController.removerInvestimentoTitulo(id);
    }

    /**
     *
     * @return
     */
    public int contInvestimentoTitulo() {
        return investimentoTituloController.contInvestimentoTitulo();
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
    public PlanoConta alterarPlanoConta(Long id, String nome, boolean tipo,List<ItensPlanoConta> itensPlanoContas) throws PlanoContaException {
        return planoContaController.alterarPlanoConta(id, nome, tipo,itensPlanoContas);
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
}

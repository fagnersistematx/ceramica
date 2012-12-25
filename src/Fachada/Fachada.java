package Fachada;

import Controler.conta.InvestimentoTituloController;
import Controler.conta.ContaDespesaController;
import Controler.conta.ContaImpostoDeRendaController;
import Controler.conta.ContaReceitaController;
import Controler.conta.InvestimentoAcoesBolsaController;
import Controler.conta.InvestimentoCdbController;
import Controler.conta.InvestimentoFundoController;
import Controler.conta.InvestimentoPoupancaController;
import Controler.conta.LancamentoController;
import Entidade.Conta.Acoes;
import Entidade.Conta.Cdb;
import Entidade.Conta.Despesa;
import Entidade.Conta.Exception.ContaDespesaException;
import Entidade.Conta.Exception.ContaImpostoException;
import Entidade.Conta.Exception.ContaReceitaException;
import Entidade.Conta.Exception.InvestimentoAcoesDaBolsaException;
import Entidade.Conta.Exception.InvestimentoCdbException;
import Entidade.Conta.Exception.InvestimentoFundoException;
import Entidade.Conta.Exception.InvestimentoPoupancaException;
import Entidade.Conta.Exception.InvestimentoTituloException;
import Entidade.Conta.Exception.LancamentoException;
import Entidade.Conta.Fundo;
import Entidade.Conta.Imposto;
import Entidade.Conta.Lancamento;
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

    }

    public static Fachada getInstance() {
        if (fachada == null) {
            fachada = new Fachada();
        }
        return fachada;
    }

    public Imposto criarImpostoDeRenda(String nome, String obs, Calendar dataCriacao,
            List<Lancamento> lancamentos, float valor, float aliquota) {

        return contaImpostoDeRendaController.criarImpostoDeRenda(nome, obs, dataCriacao, lancamentos, valor, aliquota);

    }

    public Imposto editarImpostoDeRenda(Long id, String nome, String obs, Calendar dataCriacao,
            List<Lancamento> lancamentos, float valor, float aliquota) throws ContaImpostoException {

        return contaImpostoDeRendaController.editarImpostoDeRenda(id, nome, obs, dataCriacao, lancamentos, valor, aliquota);

    }

    public Imposto buscarImposto(Long id) throws ContaImpostoException {

        return contaImpostoDeRendaController.buscarImposto(id);

    }

    public void removerImposto(Long id) throws ContaImpostoException {

        contaImpostoDeRendaController.removerImposto(id);

    }

    public int contImposto() {
        return contaImpostoDeRendaController.contImposto();
    }

    public Despesa criarContaDespesa(String nome, String obs, Calendar dataCriacao, String tipo, List<Lancamento> lancamentos) {

        return contaDespesaController.criarContaDespesa(nome, obs, dataCriacao, tipo, lancamentos);

    }

    public void alterarContaDespesa(Long id, String nome, String obs, Calendar dataCriacao,
            String tipo, List<Lancamento> lancamentos) throws ContaDespesaException {

        contaDespesaController.alterarContaDespesa(id, nome, obs, dataCriacao, tipo, lancamentos);

    }

    public Despesa buscaDespesa(Long id) throws ContaDespesaException {
        return contaDespesaController.busca(id);
    }

    public void removerDespesa(Long id) throws ContaDespesaException {
        contaDespesaController.remover(id);
    }

    public int contDespesa() {
        return contaDespesaController.cont();
    }

    public Receita criarContaReceita(String nome, String obs, Calendar dataCriacao, String tipo, List<Lancamento> lancamentos) {

        return contaReceitaController.criarContaReceita(nome, obs, dataCriacao, tipo, lancamentos);
        
    }

    public void alterarContaReceita(Long id, String nome, String obs, Calendar dataCriacao,
            String tipo, List<Lancamento> lancamentos) throws ContaReceitaException {

        contaReceitaController.alterarContaReceita(id, nome, obs, dataCriacao, tipo, lancamentos);

    }

    public Receita buscaContaReceita(Long id) throws ContaReceitaException {

        return contaReceitaController.busca(id);

    }

    public void removerContaReceita(Long id) throws ContaReceitaException {
        contaReceitaController.remover(id);
    }

    public int contContaReceita() {
        return contaReceitaController.cont();
    }

    public Lancamento criarLancamento(float valor, Calendar dataVencimento,
            Calendar dataCriacao, String obs) throws LancamentoException {

        return lancamentoController.criarLancamento(valor, dataVencimento, dataCriacao, obs);
    }

    public void alterarLancamentoQuitado(Long id, float valor, Calendar dataVencimento, Calendar dataCriacao,
            String tipo, String obs, float juros, Calendar dataQuitacao) throws LancamentoException {

        lancamentoController.alterarLancamentoQuitado(id, valor, dataVencimento, dataCriacao, tipo, obs, juros, dataQuitacao);

    }

    public void alterarLancamentoNaoQuitado(Long id, float juros, Calendar dataQuitacao,
            String obs, String tipo) throws LancamentoException {
        lancamentoController.alterarLancamentoNaoQuitado(id, juros, dataQuitacao, obs, tipo);
    }

    public Lancamento buscaLancacamento(Long id) throws LancamentoException {

        return lancamentoController.busca(id);

    }

    public void removerLancamento(Long id) throws LancamentoException {
        lancamentoController.remover(id);
    }

    public int contLancamento() {
        return lancamentoController.cont();
    }

    public Acoes criarAcoesDaBolsa(float custodia, float emolumentos, float corretagem, float iof, float cpmf,
            float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {

        return investimentoAcoesBolsaController.criarAcoesDaBolsa(custodia, emolumentos, corretagem, iof, cpmf,
                saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);
        
    }

    public Acoes editarAcoesDaBolsa(Long id, float custodia, float emolumentos, float corretagem, float iof, float cpmf, float saldo_original,
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoAcoesDaBolsaException {

        return investimentoAcoesBolsaController.editarAcoesDaBolsa(id, custodia, emolumentos, corretagem, iof,
                cpmf, saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);
        
    }

    public Acoes buscarAcoesDaBolsa(Long id) throws InvestimentoAcoesDaBolsaException {
        return investimentoAcoesBolsaController.buscarAcoesDaBolsa(id);
    }

    public void removerAcoesDaBolsa(Long id) throws InvestimentoAcoesDaBolsaException {
        investimentoAcoesBolsaController.removerAcoesDaBolsa(id);
    }

    public int contAcoesDaBolsa() {
        return investimentoAcoesBolsaController.contAcoesDaBolsa();
    }

    public Cdb criarInvestimentoCDB(float contratacao, Calendar investimento, float iof, float cpmf, float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {

        return investimentoCdbController.criarInvestimentoCDB(contratacao, investimento, iof, cpmf, saldo_original,
                saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);

    }

    public Cdb alterarInvestimentoCDB(Long id, float contratacao, Calendar investimento, float iof, float cpmf, float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoCdbException {

        return investimentoCdbController.alterarInvestimentoCDB(id, contratacao, investimento, iof, cpmf, saldo_original, saldo_atualizado, nm_conta,
                nome, obs, criacao, lancamentos);

    }

    public Cdb buscarInvestimentoCDB(Long id) throws InvestimentoCdbException {
        return investimentoCdbController.buscarInvestimentoCDB(id);
    }

    public void removerInvestimentoCDB(Long id) throws InvestimentoCdbException {
        investimentoCdbController.removerInvestimentoCDB(id);
    }

    public int contInvestimentoCDB() {
        return investimentoCdbController.contInvestimentoCDB();
    }

    public Fundo criarInvestimentoFundo(float administracao, float performace, String tipo, float iof, float cpmf,
            float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {

        return investimentoFundoController.criarInvestimentoFundo(administracao, performace, tipo, iof, cpmf,
                saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);
        
    }

    public Fundo alterarInvestimentoFundo(Long id, float administracao, float performace, String tipo, float iof, float cpmf, float saldo_original,
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoFundoException {

        return investimentoFundoController.alterarInvestimentoFundo(id, administracao, performace, tipo, iof, cpmf,
                saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);
        
    }

    public Fundo buscarInvestimentoFundo(Long id) throws InvestimentoFundoException {
        return investimentoFundoController.buscarInvestimentoFundo(id);
    }

    public void removerInvestimentoFundo(Long id) throws InvestimentoFundoException {
        investimentoFundoController.removerInvestimentoFundo(id);
    }

    public int contInvestimentoFundo() {
        return investimentoFundoController.contInvestimentoFundo();
    }

    public Poupanca criarInvestimentoPoupanca(float iof, float cpmf, float saldo_original, float saldo_atualizado, String nm_conta,
            String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {

        return investimentoPoupancaController.criarInvestimentoPoupanca(iof, cpmf, saldo_original, saldo_atualizado,
                nm_conta, nome, obs, criacao, lancamentos);

    }

    public Poupanca alterarInvestimentoPoupanca(Long id, float iof, float cpmf, float saldo_original, float saldo_atualizado, String nm_conta,
            String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoPoupancaException {

        return investimentoPoupancaController.alterarInvestimentoPoupanca(id, iof, cpmf, saldo_original, saldo_atualizado,
                nm_conta, nome, obs, criacao, lancamentos);

    }

    public Poupanca buscarInvestimentoPoupanca(Long id) throws InvestimentoPoupancaException {
        return investimentoPoupancaController.buscarInvestimentoPoupanca(id);
    }

    public void removerInvestimentoPoupanca(Long id) throws InvestimentoPoupancaException {
        investimentoPoupancaController.removerInvestimentoPoupanca(id);
    }

    public int contInvestimentoPoupanca() {
        return investimentoPoupancaController.contInvestimentoPoupanca();
    }

    public Titulo criarInvestimentoTitulo(float cblc, float banco, String tipo, float iof, float cpmf, float saldo_original,
            float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) {

        return investimentoTituloController.criarInvestimentoTitulo(cblc, banco, tipo, iof, cpmf, saldo_original,
                saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);
        
    }

    public Titulo alterarInvestimentoTitulo(Long id, float cblc, float banco, String tipo, float iof, float cpmf,
            float saldo_original, float saldo_atualizado, String nm_conta, String nome, String obs, Calendar criacao, List<Lancamento> lancamentos) throws InvestimentoTituloException {

        return investimentoTituloController.alterarInvestimentoTitulo(id, cblc, banco, tipo, iof, cpmf, saldo_original,
                saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);
        
    }

    public Titulo buscarInvestimentoTitulo(Long id) throws InvestimentoTituloException {
        return investimentoTituloController.buscarInvestimentoTitulo(id);
    }

    public void removerInvestimentoTitulo(Long id) throws InvestimentoTituloException {
        investimentoTituloController.removerInvestimentoTitulo(id);
    }

    public int contInvestimentoTitulo() {
        return investimentoTituloController.contInvestimentoTitulo();
    }
}

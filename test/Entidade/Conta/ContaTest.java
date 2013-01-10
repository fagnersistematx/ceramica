package Entidade.Conta;

import Entidade.Conta.Exception.FluxoDespesaException;
import Entidade.Conta.Exception.ContaException;
import Entidade.Conta.Exception.ContaImpostoException;
import Entidade.Conta.Exception.FluxoReceitaException;
import Entidade.Conta.Exception.InvestimentoAcoesDaBolsaException;
import Entidade.Conta.Exception.InvestimentoCdbException;
import Entidade.Conta.Exception.InvestimentoFundoException;
import Entidade.Conta.Exception.InvestimentoPoupancaException;
import Entidade.Conta.Exception.InvestimentoTituloException;
import Entidade.Conta.Exception.ItensPlanoContaException;
import Entidade.Conta.Exception.LancamentoException;
import Entidade.Conta.Exception.PlanoContaException;
import Fachada.Fachada;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fagner
 */
public class ContaTest {

    private Fachada fachada;

    public ContaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        fachada = Fachada.getInstance();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testContaReceita() {

        String nome = "Receita";
        String obs = "OBS";
        Calendar dataCriacao = Calendar.getInstance();
        List<Lancamento> lancamentos = new ArrayList<Lancamento>();
        String tipo = "salario";

        Receita receita;

        receita = fachada.criarContaReceita(nome, obs, dataCriacao, tipo, lancamentos);

        String nomeA = "ReceitaA";
        String obsA = "OBSA";
        Calendar dataCriacaoA = Calendar.getInstance();
        dataCriacaoA.add(1, 1);
        List<Lancamento> lancamentosA = new ArrayList<Lancamento>();
        String tipoA = "salarioA";

        try {
            fachada.alterarContaReceita(receita.getId(), nomeA, obsA, dataCriacaoA, tipoA, lancamentosA);
        } catch (FluxoReceitaException ex) {
            fail("" + ex);
        }

        try {
            receita = fachada.buscaContaReceita(receita.getId());
        } catch (FluxoReceitaException ex) {
            fail("" + ex);
        }

        assertEquals(receita.getNome(), nomeA);
        assertEquals(receita.getObs(), obsA);
        assertEquals(receita.getTipo(), tipoA);
        try {
            fachada.removerContaReceita(receita.getId());
        } catch (FluxoReceitaException ex) {
            fail("" + ex);
        }
        assertEquals(fachada.contContaReceita(), 0);

    }

    @Test
    public void testContaDespesa() {

        String nome = "Despesa";
        String obs = "OBS";
        Calendar dataCriacao = Calendar.getInstance();
        List<Lancamento> lancamentos = new ArrayList<Lancamento>();
        String tipo = "salario";

        Despesa despesa;

        despesa = fachada.criarContaDespesa(nome, obs, dataCriacao, tipo, lancamentos);

        String nomeA = "DespesaA";
        String obsA = "OBSA";
        Calendar dataCriacaoA = Calendar.getInstance();
        dataCriacaoA.add(1, 1);
        List<Lancamento> lancamentosA = new ArrayList<Lancamento>();
        String tipoA = "salarioA";

        try {
            fachada.alterarContaDespesa(despesa.getId(), nomeA, obsA, dataCriacaoA, tipoA, lancamentosA);
        } catch (FluxoDespesaException ex) {
            fail("" + ex);
        }

        try {
            despesa = fachada.buscaDespesa(despesa.getId());
        } catch (FluxoDespesaException ex) {
            fail("" + ex);
        }

        assertEquals(despesa.getNome(), nomeA);
        assertEquals(despesa.getObs(), obsA);
        assertEquals(despesa.getTipo(), tipoA);
        try {
            fachada.removerDespesa(despesa.getId());
        } catch (FluxoDespesaException ex) {
            fail("" + ex);
        }
        assertEquals(fachada.contDespesa(), 0);

    }

    @Test
    public void testLancamento() {

        String obs = "OBS";
        Calendar dataCriacao = Calendar.getInstance();
        Calendar dataVencimento = Calendar.getInstance();
        float valor = 10;

        String obsA = "OBSA";
        String tipoA = "tipo PagamentoA";
        Calendar dataCriacaoA = Calendar.getInstance();
        Calendar dataVencimentoA = Calendar.getInstance();
        Calendar dataQuitacaoA = Calendar.getInstance();
        float valorA = 11;
        float jurosA = 11;

        Lancamento lancamento = null;

        try {
            lancamento = fachada.criarLancamento(valor, dataVencimento, dataCriacao, obs);
        } catch (LancamentoException ex) {
            fail("criar lancamento" + ex);
        }

        try {
            fachada.alterarLancamentoQuitado(lancamento.getId(), valorA, dataVencimentoA, dataCriacaoA, tipoA, obsA, jurosA, dataQuitacaoA);
        } catch (LancamentoException ex) {
            fail("alterar lancamento quitado" + ex);
        }

        try {
            fachada.alterarLancamentoNaoQuitado(lancamento.getId(), jurosA, dataQuitacaoA, obsA, tipoA);
        } catch (LancamentoException ex) {
            fail("alterar lancamento não quitado" + ex);
        }

        try {
            lancamento = fachada.buscaLancacamento(lancamento.getId());
        } catch (LancamentoException ex) {
            fail("buscar lancamento" + ex);
        }

        assertEquals(lancamento.getJuros(), jurosA, 0);
        assertEquals(lancamento.getValor(), valorA, 0);
        assertEquals(lancamento.getObs(), obsA);
        assertEquals(lancamento.getTipo_pag_conta(), tipoA);

        try {
            fachada.removerLancamento(lancamento.getId());
        } catch (LancamentoException ex) {
            fail("remover lancamento" + ex);
        }

        assertEquals(fachada.contLancamento(), 0);

    }

    @Test
    public void testeImposto() {

        String nome = "imposto";
        String obs = "OBS";
        Calendar dataCriacao = Calendar.getInstance();
        List<Lancamento> lancamentos = new ArrayList<Lancamento>();
        float valor = 12;
        float aliquota = 12;

        Imposto imposto;

        imposto = fachada.criarImpostoDeRenda(nome, obs, dataCriacao, lancamentos, valor, aliquota);

        String nomeA = "ReceitaA";
        String obsA = "OBSA";
        Calendar dataCriacaoA = Calendar.getInstance();
        List<Lancamento> lancamentosA = new ArrayList<Lancamento>();
        float valorA = 14;
        float aliquotaA = 14;
        try {
            fachada.editarImpostoDeRenda(imposto.getId(), nomeA, obsA, dataCriacaoA, lancamentosA, valorA, aliquotaA);
        } catch (ContaImpostoException ex) {
            fail(ex.getMessage());
        }
        try {
            imposto = fachada.buscarImposto(imposto.getId());
        } catch (ContaImpostoException ex) {
            fail(ex.getMessage());
        }
        assertEquals(imposto.getNome(), nomeA);
        assertEquals(imposto.getObs(), obsA);
        assertEquals(imposto.getValor(), valorA, 0);
        assertEquals(imposto.getAliquota(), aliquotaA, 0);
        try {
            fachada.removerImposto(imposto.getId());
        } catch (ContaImpostoException ex) {
            fail(ex.getMessage());
        }

        assertEquals(fachada.contImposto(), 0);
    }

    @Test
    public void testeContaInvestimentoAcao() {

        float custodia = 100;
        float emolumentos = 100;
        float corretagem = 100;
        float iof = 100;
        float cpmf = 100;
        float saldo_original = 100;
        float saldo_atualizado = 100;
        String nm_conta = "12345";
        String nome = "nome conta";
        String obs = "obs";
        List<Lancamento> lancamentos = null;

        Calendar criacao = Calendar.getInstance();
        float custodiaA = 200;
        float emolumentosA = 200;
        float corretagemA = 200;
        float iofA = 200;
        float cpmfA = 200;
        float saldo_originalA = 200;
        float saldo_atualizadoA = 200;
        String nm_contaA = "12345A";
        String nomeA = "nome contaA";
        String obsA = "obsA";
        List<Lancamento> lancamentosA = null;
        Calendar criacaoA = Calendar.getInstance();

        Acoes acoes;

        acoes = fachada.criarAcoesDaBolsa(custodia, emolumentos, corretagem, iof, cpmf, saldo_original, saldo_atualizado,
                nm_conta, nome, obs, criacao, lancamentos);

        try {
            fachada.editarAcoesDaBolsa(acoes.getId(), custodiaA, emolumentosA, corretagemA, iofA,
                    cpmfA, saldo_originalA, saldo_atualizadoA, nm_contaA, nomeA, obsA, criacaoA, lancamentosA);
        } catch (InvestimentoAcoesDaBolsaException ex) {
            fail(ex.getMessage());
        }
        try {
            acoes = fachada.buscarAcoesDaBolsa(acoes.getId());
        } catch (InvestimentoAcoesDaBolsaException ex) {
            fail(ex.getMessage());
        }

        assertEquals(acoes.getNome(), nomeA);
        assertEquals(acoes.getObs(), obsA);
        assertEquals(acoes.getNm_conta(), nm_contaA);
        assertEquals(acoes.getTx_corretagem(), corretagemA, 0);
        assertEquals(acoes.getTx_emolumentos(), emolumentosA, 0);
        assertEquals(acoes.getTx_custodia(), custodiaA, 0);
        assertEquals(acoes.getIof(), iofA, 0);
        assertEquals(acoes.getCpmf(), cpmfA, 0);
        assertEquals(acoes.getSaldo_atualizado(), saldo_atualizadoA, 0);
        assertEquals(acoes.getSaldo_original(), saldo_originalA, 0);

        try {
            fachada.removerAcoesDaBolsa(acoes.getId());
        } catch (InvestimentoAcoesDaBolsaException ex) {
            fail(ex.getMessage());
        }

        assertEquals(fachada.contAcoesDaBolsa(), 0);
    }

    @Test
    public void testeContaInvestimentoCdb() {

        float contratacao = 100;
        float iof = 100;
        float cpmf = 100;
        float saldo_original = 100;
        float saldo_atualizado = 100;
        String nm_conta = "12345";
        String nome = "nome conta";
        String obs = "obs";
        List<Lancamento> lancamentos = null;
        Calendar criacao = Calendar.getInstance();
        Calendar investimento = Calendar.getInstance();

        float contratacaoA = 200;
        float iofA = 200;
        float cpmfA = 200;
        float saldo_originalA = 200;
        float saldo_atualizadoA = 200;
        String nm_contaA = "12345A";
        String nomeA = "nome contaA";
        String obsA = "obsA";
        List<Lancamento> lancamentosA = null;
        Calendar criacaoA = Calendar.getInstance();
        Calendar investimentoA = Calendar.getInstance();

        Cdb cdb;

        cdb = fachada.criarInvestimentoCDB(contratacao, investimento, iof, cpmf, saldo_original, saldo_atualizado,
                nm_conta, nome, obs, criacao, lancamentos);

        try {
            fachada.alterarInvestimentoCDB(cdb.getId(), contratacaoA, investimentoA, iofA, cpmfA, saldo_originalA,
                    saldo_atualizadoA, nm_contaA, nomeA, obsA, criacaoA, lancamentosA);
        } catch (InvestimentoCdbException ex) {
            fail(ex.getMessage());
        }
        try {
            cdb = fachada.buscarInvestimentoCDB(cdb.getId());
        } catch (InvestimentoCdbException ex) {
            fail(ex.getMessage());
        }

        assertEquals(cdb.getNome(), nomeA);
        assertEquals(cdb.getObs(), obsA);
        assertEquals(cdb.getNm_conta(), nm_contaA);
        assertEquals(cdb.getTx_contratacao(), contratacaoA, 0);
        assertEquals(cdb.getIof(), iofA, 0);
        assertEquals(cdb.getCpmf(), cpmfA, 0);
        assertEquals(cdb.getSaldo_atualizado(), saldo_atualizadoA, 0);
        assertEquals(cdb.getSaldo_original(), saldo_originalA, 0);

        try {
            fachada.removerInvestimentoCDB(cdb.getId());
        } catch (InvestimentoCdbException ex) {
            fail(ex.getMessage());
        }

        assertEquals(fachada.contInvestimentoCDB(), 0);
    }

    @Test
    public void testeContaInvestimentoFundo() {

        float iof = 100;
        float cpmf = 100;
        float saldo_original = 100;
        float saldo_atualizado = 100;
        float administracao = 100;
        float performace = 100;
        String tipo = "tipo";
        String nm_conta = "12345";
        String nome = "nome conta";
        String obs = "obs";
        List<Lancamento> lancamentos = null;
        Calendar criacao = Calendar.getInstance();

        float iofA = 200;
        float cpmfA = 200;
        float saldo_originalA = 200;
        float saldo_atualizadoA = 200;
        float administracaoA = 200;
        float performaceA = 200;
        String tipoA = "tipoA";
        String nm_contaA = "12345A";
        String nomeA = "nome contaA";
        String obsA = "obsA";
        List<Lancamento> lancamentosA = null;
        Calendar criacaoA = Calendar.getInstance();

        Fundo fundo;

        fundo = fachada.criarInvestimentoFundo(administracao, performace, tipo, iof, cpmf, saldo_original, saldo_atualizado,
                nm_conta, nome, obs, criacao, lancamentos);

        try {
            fachada.alterarInvestimentoFundo(fundo.getId(), administracaoA, performaceA, tipoA, iofA, cpmfA, saldo_originalA,
                    saldo_atualizadoA, nm_contaA, nomeA, obsA, criacaoA, lancamentosA);
        } catch (InvestimentoFundoException ex) {
            fail(ex.getMessage());
        }
        try {
            fundo = fachada.buscarInvestimentoFundo(fundo.getId());
        } catch (InvestimentoFundoException ex) {
            fail(ex.getMessage());
        }

        assertEquals(fundo.getNome(), nomeA);
        assertEquals(fundo.getObs(), obsA);
        assertEquals(fundo.getTipo(), tipoA);
        assertEquals(fundo.getNm_conta(), nm_contaA);
        assertEquals(fundo.getTx_administracao(), administracaoA, 0);
        assertEquals(fundo.getTx_performace(), performaceA, 0);
        assertEquals(fundo.getIof(), iofA, 0);
        assertEquals(fundo.getCpmf(), cpmfA, 0);
        assertEquals(fundo.getSaldo_atualizado(), saldo_atualizadoA, 0);
        assertEquals(fundo.getSaldo_original(), saldo_originalA, 0);

        try {
            fachada.removerInvestimentoFundo(fundo.getId());
        } catch (InvestimentoFundoException ex) {
            fail(ex.getMessage());
        }

        assertEquals(fachada.contInvestimentoFundo(), 0);
    }

    @Test
    public void testeContaInvestimentoPoupanca() {

        float iof = 100;
        float cpmf = 100;
        float saldo_original = 100;
        float saldo_atualizado = 100;
        String nm_conta = "12345";
        String nome = "nome conta";
        String obs = "obs";
        List<Lancamento> lancamentos = null;
        Calendar criacao = Calendar.getInstance();

        float iofA = 200;
        float cpmfA = 200;
        float saldo_originalA = 200;
        float saldo_atualizadoA = 200;
        String nm_contaA = "12345A";
        String nomeA = "nome contaA";
        String obsA = "obsA";
        List<Lancamento> lancamentosA = null;
        Calendar criacaoA = Calendar.getInstance();

        Poupanca poupanca;

        poupanca = fachada.criarInvestimentoPoupanca(iof, cpmf, saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);

        try {
            fachada.alterarInvestimentoPoupanca(poupanca.getId(), iofA, cpmfA, saldo_originalA, saldo_atualizadoA, nm_contaA, nomeA,
                    obsA, criacaoA, lancamentosA);
        } catch (InvestimentoPoupancaException ex) {
            fail(ex.getMessage());
        }
        try {
            poupanca = fachada.buscarInvestimentoPoupanca(poupanca.getId());
        } catch (InvestimentoPoupancaException ex) {
            fail(ex.getMessage());
        }

        assertEquals(poupanca.getNome(), nomeA);
        assertEquals(poupanca.getObs(), obsA);
        assertEquals(poupanca.getNm_conta(), nm_contaA);
        assertEquals(poupanca.getIof(), iofA, 0);
        assertEquals(poupanca.getCpmf(), cpmfA, 0);
        assertEquals(poupanca.getSaldo_atualizado(), saldo_atualizadoA, 0);
        assertEquals(poupanca.getSaldo_original(), saldo_originalA, 0);

        try {
            fachada.removerInvestimentoPoupanca(poupanca.getId());
        } catch (InvestimentoPoupancaException ex) {
            fail(ex.getMessage());
        }

        assertEquals(fachada.contInvestimentoPoupanca(), 0);
    }

    @Test
    public void testeContaInvestimentoTitulo() {

        float iof = 100;
        float cpmf = 100;
        float saldo_original = 100;
        float saldo_atualizado = 100;
        String nm_conta = "12345";
        String nome = "nome conta";
        String obs = "obs";
        float cblc = 100;
        float banco = 100;
        String tipo = "tipo";
        List<Lancamento> lancamentos = null;
        Calendar criacao = Calendar.getInstance();

        float iofA = 200;
        float cpmfA = 200;
        float saldo_originalA = 200;
        float saldo_atualizadoA = 200;
        String nm_contaA = "12345A";
        String nomeA = "nome contaA";
        String obsA = "obsA";
        float cblcA = 200;
        float bancoA = 200;
        String tipoA = "tipoA";
        List<Lancamento> lancamentosA = null;
        Calendar criacaoA = Calendar.getInstance();

        Titulo titulo;

        titulo = fachada.criarInvestimentoTitulo(cblc, banco, tipo, iof, cpmf, saldo_original, saldo_atualizado, nm_conta, nome, obs, criacao, lancamentos);

        try {
            fachada.alterarInvestimentoTitulo(titulo.getId(), cblcA, bancoA, tipoA, iofA, cpmfA, saldo_originalA, saldo_atualizadoA, nm_contaA,
                    nomeA, obsA, criacaoA, lancamentosA);
        } catch (InvestimentoTituloException ex) {
            fail(ex.getMessage());
        }
        try {
            titulo = fachada.buscarInvestimentoTitulo(titulo.getId());
        } catch (InvestimentoTituloException ex) {
            fail(ex.getMessage());
        }

        assertEquals(titulo.getTipo(), tipoA);
        assertEquals(titulo.getNome(), nomeA);
        assertEquals(titulo.getObs(), obsA);
        assertEquals(titulo.getNm_conta(), nm_contaA);
        assertEquals(titulo.getIof(), iofA, 0);
        assertEquals(titulo.getCpmf(), cpmfA, 0);
        assertEquals(titulo.getSaldo_atualizado(), saldo_atualizadoA, 0);
        assertEquals(titulo.getSaldo_original(), saldo_originalA, 0);
        assertEquals(titulo.getTx_custodia_banco(), bancoA, 0);
        assertEquals(titulo.getTx_custodia_cblc(), cblcA, 0);

        try {
            fachada.removerInvestimentoTitulo(titulo.getId());
        } catch (InvestimentoTituloException ex) {
            fail(ex.getMessage());
        }

        assertEquals(fachada.contInvestimentoTitulo(), 0);
    }

    @Test
    public void testeConta() {

        float valor = 100;
        String numero = "12345";
        String nome = "nome conta";
        String agencia = "obs";
        String banco = "tipo";
        Calendar criacao = Calendar.getInstance();

        float valorA = 200;
        String numeroA = "12345A";
        String nomeA = "nome contaA";
        String agenciaA = "obsA";
        String bancoA = "tipoA";
        Calendar criacaoA = Calendar.getInstance();

        Conta conta;

        conta = fachada.criarConta(nome, banco, agencia, numero, criacao, valor);

        try {
            fachada.alterarConta(conta.getId(), nomeA, bancoA, agenciaA, numeroA, criacaoA, valorA);
        } catch (ContaException ex) {
            fail(ex.getMessage());
        }
        try {
            conta = fachada.buscaConta(conta.getId());
        } catch (ContaException ex) {
            fail(ex.getMessage());
        }

        assertEquals(conta.getBanco(), bancoA);
        assertEquals(conta.getNome(), nomeA);
        assertEquals(conta.getAgencia(), agenciaA);
        assertEquals(conta.getNumero(), numeroA);
        assertEquals(conta.getValor(), valorA, 0);

        try {
            fachada.removerConta(conta.getId());
        } catch (ContaException ex) {
            fail(ex.getMessage());
        }

        //assertEquals(fachada.contConta(), 0);
    }

    @Test
    public void testePlanoConta() {

        String nome = "nome conta";
        String nomeA = "nome contaA";
        boolean tipo = true;
        boolean tipoA = false;
        ItensPlanoConta ipc = new ItensPlanoConta("teste");
        List<ItensPlanoConta> itensPlanoContas = new ArrayList<ItensPlanoConta>();

        itensPlanoContas.add(ipc);

        PlanoConta planoConta = new PlanoConta();


        planoConta = fachada.criarPlanoConta(nome,tipo);
        planoConta.setItensPlanoContas(itensPlanoContas);

        try {
            fachada.alterarPlanoConta(planoConta.getId(), nomeA,tipoA,itensPlanoContas);
        } catch (PlanoContaException ex) {
            fail(ex.getMessage());
        }
        try {
            planoConta = fachada.buscaPlanoConta(planoConta.getId());
        } catch (PlanoContaException ex) {
            fail(ex.getMessage());
        }

        assertEquals(planoConta.getNome(), nomeA);
        assertFalse(tipoA);

        try {
            fachada.removerPlanoConta(planoConta.getId());
        } catch (PlanoContaException ex) {
            fail(ex.getMessage());
        }

        assertEquals(fachada.contPlanoConta(), 0);
    }
    
    @Test
    public void testeItensPlanoConta() {

        String nome = "nome conta";
        String nomeA = "nome contaA";
        

        ItensPlanoConta itensPlanoConta;


        itensPlanoConta = fachada.criarItensPlanoConta(nome);       

        try {
            fachada.alterarItensPlanoConta(itensPlanoConta.getId(), nomeA);
        } catch (ItensPlanoContaException ex) {
            fail(ex.getMessage());
        }
        try {
            itensPlanoConta = fachada.buscaItensPlanoConta(itensPlanoConta.getId());
        } catch (ItensPlanoContaException ex) {
            fail(ex.getMessage());
        }

        assertEquals(itensPlanoConta.getNome(), nomeA);

        try {
            fachada.removerItensPlanoConta(itensPlanoConta.getId());
        } catch (ItensPlanoContaException ex) {
            fail(ex.getMessage());
        }

        assertEquals(fachada.contItensPlanoConta(), 0);
    }
}

package Entidade.Conta;

import Controler.conta.ContaDespesaController;
import Controler.conta.ContaReceitaController;
import Controler.conta.LancamentoController;
import Entidade.Conta.Exception.ContaDespesaException;
import Entidade.Conta.Exception.ContaReceitaException;
import Entidade.Conta.Exception.LancamentoException;
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

    private ContaReceitaController crc;
    private ContaDespesaController cdc;
    private LancamentoController lc;

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

        crc = new ContaReceitaController();
        lc = new LancamentoController();
        cdc = new ContaDespesaController();

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

        receita = crc.criarContaReceita(nome, obs, dataCriacao, tipo, lancamentos);

        String nomeA = "ReceitaA";
        String obsA = "OBSA";
        Calendar dataCriacaoA = Calendar.getInstance();
        dataCriacaoA.add(1, 1);
        List<Lancamento> lancamentosA = new ArrayList<Lancamento>();
        String tipoA = "salarioA";

        try {
            crc.alterarContaReceita(receita.getId(), nomeA, obsA, dataCriacaoA, tipoA, lancamentosA);
        } catch (ContaReceitaException ex) {
            fail("" + ex);
        }

        try {
            receita = crc.busca(receita.getId());
        } catch (ContaReceitaException ex) {
            fail("" + ex);
        }

        assertEquals(receita.getNome(), nomeA);
        assertEquals(receita.getObs(), obsA);
        assertEquals(receita.getTipo(), tipoA);
        try {
            crc.remover(receita.getId());
        } catch (ContaReceitaException ex) {
            fail("" + ex);
        }
        assertEquals(crc.cont(), 0);

    }
    
    @Test
    public void testContaDespesa() {

        String nome = "Despesa";
        String obs = "OBS";
        Calendar dataCriacao = Calendar.getInstance();
        List<Lancamento> lancamentos = new ArrayList<Lancamento>();
        String tipo = "salario";

        Despesa despesa;

        despesa = cdc.criarContaDespesa(nome, obs, dataCriacao, tipo, lancamentos);

        String nomeA = "DespesaA";
        String obsA = "OBSA";
        Calendar dataCriacaoA = Calendar.getInstance();
        dataCriacaoA.add(1, 1);
        List<Lancamento> lancamentosA = new ArrayList<Lancamento>();
        String tipoA = "salarioA";

        try {
            cdc.alterarContaDespesa(despesa.getId(), nomeA, obsA, dataCriacaoA, tipoA, lancamentosA);
        } catch (ContaDespesaException ex) {
            fail("" + ex);
        }

        try {
            despesa = cdc.busca(despesa.getId());
        } catch (ContaDespesaException ex) {
            fail("" + ex);
        }

        assertEquals(despesa.getNome(), nomeA);
        assertEquals(despesa.getObs(), obsA);
        assertEquals(despesa.getTipo(), tipoA);
        try {
            cdc.remover(despesa.getId());
        } catch (ContaDespesaException ex) {
            fail("" + ex);
        }
        assertEquals(cdc.cont(), 0);

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
            lancamento = lc.criarLancamento(valor, dataVencimento, dataCriacao, obs);
        } catch (LancamentoException ex) {
            fail("" + ex);
        }

        try {
            lc.alterarLancamentoQuitado(lancamento.getId(), valorA, dataVencimentoA, dataCriacaoA, tipoA, obsA, jurosA, dataQuitacaoA);
        } catch (LancamentoException ex) {
            fail("" + ex);
        }

        try {
            lc.alterarLancamentoNaoQuitado(lancamento.getId(), jurosA, dataQuitacaoA, obsA, tipoA);
        } catch (LancamentoException ex) {
            fail("" + ex);
        }

        try {
            lancamento = lc.busca(lancamento.getId());
        } catch (LancamentoException ex) {
            fail("" + ex);
        }

        assertEquals(lancamento.getJuros(), jurosA, 0);
        assertEquals(lancamento.getValor(), valorA, 0);
        assertEquals(lancamento.getObs(), obsA);
        assertEquals(lancamento.getTipo_pag_conta(), tipoA);

        try {
            lc.remover(lancamento.getId());
        } catch (LancamentoException ex) {
            fail("" + ex);
        }

        assertEquals(lc.cont(), 0);

    }
}

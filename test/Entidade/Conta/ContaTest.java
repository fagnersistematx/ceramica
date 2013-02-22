package Entidade.Conta;

import Entidade.Conta.Exception.ContaException;
import Entidade.Conta.Exception.FluxoDespesaException;
import Entidade.Conta.Exception.FluxoReceitaException;
import Entidade.Conta.Exception.ItensPlanoContaException;
import Entidade.Conta.Exception.PlanoContaException;
import Entidade.Estoque.Exception.LoteException;
import Entidade.Estoque.Exception.NotaException;
import Entidade.Estoque.Exception.ProdutoException;
import Entidade.Estoque.Lote;
import Entidade.Estoque.Nota;
import Entidade.Estoque.Produto;
import Entidade.Fornecedor;
import Entidade.Pessoa;
import Fachada.Fachada;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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

    @Ignore
    public void testContaReceita() {

        String nome = "Receita";
        String obs = "OBS";
        Calendar dataCriacao = Calendar.getInstance();
        String tipo = "salario";

        Receita receita = new Receita();

        receita = fachada.criarContaReceita(nome, obs, dataCriacao, tipo);

        String nomeA = "ReceitaA";
        String obsA = "OBSA";
        Calendar dataCriacaoA = Calendar.getInstance();
        dataCriacaoA.add(1, 1);
        String tipoA = "salarioA";

        System.out.println(" " + nomeA + " " + obsA + " " + dataCriacaoA + " " + tipoA);
        try {

            fachada.alterarContaReceita(receita.getId(), nomeA, obsA, dataCriacaoA, tipoA);
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
        //  assertEquals(fachada.contContaReceita(), 0);

    }

    @Ignore
    public void testContaDespesa() {

        String nome = "Despesa";
        String obs = "OBS";
        Calendar dataCriacao = Calendar.getInstance();
        String nomeConta = "salario";
        Pessoa pessoa = new Fornecedor();
        Calendar data_fluxo = Calendar.getInstance();
        ItensPlanoConta planoConta = new ItensPlanoConta();
        float valor = 0;

        Despesa despesa = null;

        despesa = fachada.criarFluxoDespesa(nome, valor, obs, dataCriacao, data_fluxo, pessoa, planoConta, nomeConta);

        String nomeA = "DespesaA";
        String obsA = "OBSA";
        Calendar dataCriacaoA = Calendar.getInstance();
        dataCriacaoA.add(1, 1);
        String tipoA = "salarioA";

        try {
            fachada.alterarContaDespesa(despesa.getId(), nomeA, valor, obsA, dataCriacaoA, data_fluxo, pessoa, planoConta);
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
        //assertEquals(despesa.getTipo(), tipoA);
        try {
            fachada.removerDespesa(despesa.getId());
        } catch (FluxoDespesaException ex) {
            fail("" + ex);
        }
        //assertEquals(fachada.contDespesa(), 0);

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


        planoConta = fachada.criarPlanoConta(nome, tipo);
        planoConta.setItensPlanoContas(itensPlanoContas);

        try {
            fachada.alterarPlanoConta(planoConta.getId(), nomeA, tipoA, itensPlanoContas);
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

        //assertEquals(fachada.contPlanoConta(), 0);
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

        //assertEquals(fachada.contItensPlanoConta(), 0);
    }

    @Test
    public void testeProduto() {

        String nome = "produto";
        String nomeA = "produtoA";
        String codigo = "codigo";
        String codigoA = "codigo";

        Produto produto;

        produto = fachada.criarProduto(nome, codigo);

        try {
            produto.setNome(nomeA);
            produto.setCodigo(codigoA);
            fachada.alterarProduto(produto);
        } catch (ProdutoException ex) {
            fail(ex.getMessage());
        }
        try {
            produto = fachada.buscaProduto(produto.getId());
        } catch (ProdutoException ex) {
            fail(ex.getMessage());
        }

        assertEquals(produto.getNome(), nomeA);
        assertEquals(produto.getCodigo(), codigoA);

        try {
            fachada.removerProduto(produto.getId());
        } catch (ProdutoException ex) {
            fail(ex.getMessage());
        }

        ///assertEquals(fachada.contPlanoConta(), 0);
    }

    @Test
    public void testeLote() {

        String numero = "numero";
        float quant = 0;
        float valorUnit = 0;
        float preco = 0;
        String numeroA = "numeroA10";
        float quantA = 1;
        float valorUnitA = 1;
        float precoA = 1;
        Produto produto = fachada.criarProduto("Teste lote", "Teste lote");

        Lote lote;
        Long idFornecedor = Long.parseLong("1");
        Fornecedor fornecedor = (Fornecedor) fachada.pesquisarPessoa(idFornecedor,"Fornecedor");

        lote = fachada.criarLote(numero, quant, valorUnit, preco, produto, fornecedor,null);
        System.out.println(lote.toString());
        System.err.println(lote.toString());
        try {
            lote.setNumero(numeroA);
            lote.setPreco(precoA);
            lote.setQuant(quantA);
            lote.setValor(valorUnitA);
            fachada.alterarLote(lote);
        } catch (LoteException ex) {
            fail(ex.getMessage());
        }
        try {
            lote = fachada.buscaLotes(lote.getId());
        } catch (LoteException ex) {
            fail(ex.getMessage());
        }

        assertEquals(lote.getNumero(), numeroA);
        assertEquals(lote.getValor(), valorUnitA, 0);
        assertEquals(lote.getPreco(), precoA, 0);
        assertEquals(lote.getQuant(), quantA, 0);

        try {
            fachada.removerLote(lote.getId());
        } catch (LoteException ex) {
            fail(ex.getMessage());
        }

        ///assertEquals(fachada.contPlanoConta(), 0);
    }

    @Test
    public void testeNota() throws ProdutoException {

        String numero = "numero";
        float desconto = 10;
        float total = 20;
        String obs = "obs";
        Calendar data = Calendar.getInstance();
        String numeroA = "numeroA55";
        float descontoA = 100;
        float totalA = 200;
        String obsA = "obsA";
        Long id = Long.parseLong("15");
        Long idFornecedor = Long.parseLong("1");
        Fornecedor fornecedor = (Fornecedor) fachada.pesquisarPessoa(idFornecedor, "Fornecedor");
        Produto produto = fachada.buscaProduto(id);//new Produto("Teste2 lote", "Teste lote");
        Lote lote = new Lote("teste55", totalA, totalA, total, produto, fornecedor,null);
        List<Lote> lotes = new ArrayList<Lote>();
        lotes.add(lote);


        Nota nota = fachada.criarNota(lotes, desconto, total, numero, data, obs);

        try {
            nota.setNumero(numeroA);
            nota.setDesconto(descontoA);
            nota.setObs(obsA);
            nota.setTotal(totalA);
            fachada.alterarNota(nota);
        } catch (NotaException ex) {
            fail(ex.getMessage());
        }
        try {
            nota = fachada.buscaNota(nota.getId());
            System.out.println(nota.toString());
            System.err.println(nota.toString());
        } catch (NotaException ex) {
            fail(ex.getMessage());
        }

        assertEquals(nota.getNumero(), numeroA);
        assertEquals(nota.getDesconto(), descontoA, 0);
        assertEquals(nota.getTotal(), totalA, 0);
        assertEquals(nota.getObs(), obsA);

        try {
            fachada.removerNota(nota.getId());
        } catch (NotaException ex) {
            fail(ex.getMessage());
        }

        ///assertEquals(fachada.contPlanoConta(), 0);
    }
}

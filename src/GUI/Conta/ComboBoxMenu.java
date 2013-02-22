package GUI.Conta;

import Entidade.Conta.ItensPlanoConta;
import Entidade.Conta.PlanoConta;
import Util.DAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author FM
 */
public class ComboBoxMenu {

    private DAO dao;
    private ComboMenuBar comboMenu;

    public ComboBoxMenu(boolean tipo) {

        this.dao = new DAO();

        List<Object> planoConta = new ArrayList<Object>();

        planoConta = dao.findObjectEntities(PlanoConta.class);

        String[] menuStr = new String[planoConta.size()];



        /*String[] menuStr = {"Escritório", "Financeiro", "Impostos", "Manutenção",
         "Pessoal",
         "Serviços Públicos", "Suprimentos", "Transporte", "Vendas", "Viagem",
         "Outros"};
            

         String[] itensEscritorio = {"Aluguel", "Equipamentos", "Jornais/Revistas",
         "Móveis"};
         String[] itensFinaceiro = {"Cobrança", "Contabilidade", "Juros", "Saque",
         "Tarifa Bancária", "Transferência"};
         String[] itensImpostos = {"COFINS", "CPMF", "CSLL", "ICMS", "INSS", "IOF",
         "IPTU", "IRPJ", "ISS", "Importação", "PIS"};
         String[] itensManutencao = {"Jardinagem", "Limpeza", "Pintura", "Reparos",
         "Outras Despesas"};
         String[] itensPessoal = {"13o. Salário", "Cesta Básica", "FGTS", "Férias",
         "Horas Extras", "Plano de Saúde", "Salário", "Vale Transporte"};

         String[] itensServicosPublicos = {"Eletricidade", "Gás", "Internet", "Segurança",
         "Telefone Celular", "Telefone Fixo", "Água e Esgoto"};

         String[] itensSuplimentos = {"Despensa", "Impressora/Fax", "Limpeza/Higiene", "Papelaria"};

         String[] itensTransporte = {"Combustível", "Estacionamento", "Manutenção", "Multa"};

         String[] itensVenda = {"Comissão"};

         String[] itensViajens = {"Aluguel de Carro", "Combustível", "Hospedagem",
         "Ligações Telefônicas", "Passagens", "Restaurantes"};

         String[] itensOutro = {"Outro"};
         
         */

        JMenu[] menus = new JMenu[planoConta.size()];

        int cont = 0;
        for (Object o : planoConta) {
            PlanoConta p = (PlanoConta) o;
            if (p.isTipo() == tipo) {
                JMenu j = new JMenu(p.getNome());
                j.setText(p.getNome());
                j.setName(p.getNome());
                menus[cont] = j;
                for (ItensPlanoConta i : p.getItensPlanoContas()) {
                    menus[cont].add(new JMenuItem(i.getNome()));
                }
                ++cont;
            }
        }

        JMenu menu = ComboMenuBar.createMenu("");

        for (int i = 0; i < cont; i++) {

            menu.add(menus[i]);

        }


        comboMenu = new ComboMenuBar(menu);

    }

    public ComboMenuBar getComboMenu() {
        return comboMenu;
    }   
}

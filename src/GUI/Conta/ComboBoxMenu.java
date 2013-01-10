package GUI.Conta;

import Entidade.Conta.ItensPlanoConta;
import Entidade.Conta.PlanoConta;
import Util.DAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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

         //Excritorio
         JMenuItem[] menuItemsExcritorio = new JMenuItem[4];
         menuItemsExcritorio[0] = new JMenuItem(itensEscritorio[0]);
         menuItemsExcritorio[1] = new JMenuItem(itensEscritorio[1]);
         menuItemsExcritorio[2] = new JMenuItem(itensEscritorio[2]);
         menuItemsExcritorio[3] = new JMenuItem(itensEscritorio[3]);

         //Finaceiro
         JMenuItem[] menuItemsFinaceiro = new JMenuItem[6];
         menuItemsFinaceiro[0] = new JMenuItem(itensFinaceiro[0]);
         menuItemsFinaceiro[1] = new JMenuItem(itensFinaceiro[1]);
         menuItemsFinaceiro[2] = new JMenuItem(itensFinaceiro[2]);
         menuItemsFinaceiro[3] = new JMenuItem(itensFinaceiro[3]);
         menuItemsFinaceiro[4] = new JMenuItem(itensFinaceiro[4]);
         menuItemsFinaceiro[5] = new JMenuItem(itensFinaceiro[5]);

         //Impostos
         JMenuItem[] menuItemsImpostos = new JMenuItem[11];
         menuItemsImpostos[0] = new JMenuItem(itensImpostos[0]);
         menuItemsImpostos[1] = new JMenuItem(itensImpostos[1]);
         menuItemsImpostos[2] = new JMenuItem(itensImpostos[2]);
         menuItemsImpostos[3] = new JMenuItem(itensImpostos[3]);
         menuItemsImpostos[4] = new JMenuItem(itensImpostos[4]);
         menuItemsImpostos[5] = new JMenuItem(itensImpostos[5]);
         menuItemsImpostos[6] = new JMenuItem(itensImpostos[6]);
         menuItemsImpostos[7] = new JMenuItem(itensImpostos[7]);
         menuItemsImpostos[8] = new JMenuItem(itensImpostos[8]);
         menuItemsImpostos[9] = new JMenuItem(itensImpostos[9]);
         menuItemsImpostos[10] = new JMenuItem(itensImpostos[10]);

         //Manutenção
         JMenuItem[] menuItemsManutencao = new JMenuItem[11];
         menuItemsManutencao[0] = new JMenuItem(itensManutencao[0]);
         menuItemsManutencao[1] = new JMenuItem(itensManutencao[1]);
         menuItemsManutencao[2] = new JMenuItem(itensManutencao[2]);
         menuItemsManutencao[3] = new JMenuItem(itensManutencao[3]);
         menuItemsManutencao[4] = new JMenuItem(itensManutencao[4]);

         //Pessoal
         JMenuItem[] menuItemsPessoal = new JMenuItem[8];
         menuItemsPessoal[0] = new JMenuItem(itensPessoal[0]);
         menuItemsPessoal[1] = new JMenuItem(itensPessoal[1]);
         menuItemsPessoal[2] = new JMenuItem(itensPessoal[2]);
         menuItemsPessoal[3] = new JMenuItem(itensPessoal[3]);
         menuItemsPessoal[4] = new JMenuItem(itensPessoal[4]);
         menuItemsPessoal[5] = new JMenuItem(itensPessoal[5]);
         menuItemsPessoal[6] = new JMenuItem(itensPessoal[6]);
         menuItemsPessoal[7] = new JMenuItem(itensPessoal[7]);

         //Serviço Público
         JMenuItem[] menuServicosPublicos = new JMenuItem[7];
         menuServicosPublicos[0] = new JMenuItem(itensServicosPublicos[0]);
         menuServicosPublicos[1] = new JMenuItem(itensServicosPublicos[1]);
         menuServicosPublicos[2] = new JMenuItem(itensServicosPublicos[2]);
         menuServicosPublicos[3] = new JMenuItem(itensServicosPublicos[3]);
         menuServicosPublicos[4] = new JMenuItem(itensServicosPublicos[4]);
         menuServicosPublicos[5] = new JMenuItem(itensServicosPublicos[5]);
         menuServicosPublicos[6] = new JMenuItem(itensServicosPublicos[6]);

         //Suplimentos
         JMenuItem[] menuSuplimentos = new JMenuItem[4];
         menuSuplimentos[0] = new JMenuItem(itensSuplimentos[0]);
         menuSuplimentos[1] = new JMenuItem(itensSuplimentos[1]);
         menuSuplimentos[2] = new JMenuItem(itensSuplimentos[2]);
         menuSuplimentos[3] = new JMenuItem(itensSuplimentos[3]);

         //Transporte
         JMenuItem[] menuTransporte = new JMenuItem[4];
         menuTransporte[0] = new JMenuItem(itensTransporte[0]);
         menuTransporte[1] = new JMenuItem(itensTransporte[1]);
         menuTransporte[2] = new JMenuItem(itensTransporte[2]);
         menuTransporte[3] = new JMenuItem(itensTransporte[3]);

         //Venda
         JMenuItem[] menuVenda = new JMenuItem[1];
         menuVenda[0] = new JMenuItem(itensVenda[0]);

         //Viagens
         JMenuItem[] menuViagens = new JMenuItem[6];
         menuViagens[0] = new JMenuItem(itensViajens[0]);
         menuViagens[1] = new JMenuItem(itensViajens[1]);
         menuViagens[2] = new JMenuItem(itensViajens[2]);
         menuViagens[3] = new JMenuItem(itensViajens[3]);
         menuViagens[4] = new JMenuItem(itensViajens[4]);
         menuViagens[5] = new JMenuItem(itensViajens[5]);

         //Outro
         JMenuItem[] menuOutro = new JMenuItem[1];
         menuOutro[0] = new JMenuItem(itensOutro[0]);

         */

        JMenu[] menus = new JMenu[planoConta.size()];

        int cont = 0;
        for (Object o : planoConta) {
            PlanoConta p = (PlanoConta) o;
            if (p.isTipo() == tipo) {
                menus[cont] = new JMenu(p.getNome());
                for (ItensPlanoConta i : p.getItensPlanoContas()) {
                    menus[cont].add(new JMenuItem(i.getNome()));
                }
                ++cont;
            }
        }
        /*
         menus[0] = new JMenu(menuStr[0]);
         menus[1] = new JMenu(menuStr[1]);
         menus[2] = new JMenu(menuStr[2]);
         menus[3] = new JMenu(menuStr[3]);
         menus[4] = new JMenu(menuStr[4]);
         menus[5] = new JMenu(menuStr[5]);
         menus[6] = new JMenu(menuStr[6]);
         menus[7] = new JMenu(menuStr[7]);
         menus[8] = new JMenu(menuStr[8]);
         menus[9] = new JMenu(menuStr[9]);
         menus[10] = new JMenu(menuStr[10]);

         menus[0].add(menuItemsExcritorio[0]);
         menus[0].add(menuItemsExcritorio[1]);
         menus[0].add(menuItemsExcritorio[2]);
         menus[0].add(menuItemsExcritorio[3]);

         menus[1].add(menuItemsFinaceiro[0]);
         menus[1].add(menuItemsFinaceiro[1]);
         menus[1].add(menuItemsFinaceiro[2]);
         menus[1].add(menuItemsFinaceiro[3]);
         menus[1].add(menuItemsFinaceiro[4]);
         menus[1].add(menuItemsFinaceiro[5]);

         menus[2].add(menuItemsImpostos[0]);
         menus[2].add(menuItemsImpostos[1]);
         menus[2].add(menuItemsImpostos[2]);
         menus[2].add(menuItemsImpostos[3]);
         menus[2].add(menuItemsImpostos[4]);
         menus[2].add(menuItemsImpostos[5]);
         menus[2].add(menuItemsImpostos[6]);
         menus[2].add(menuItemsImpostos[7]);
         menus[2].add(menuItemsImpostos[8]);
         menus[2].add(menuItemsImpostos[9]);
         menus[2].add(menuItemsImpostos[10]);

         menus[3].add(menuItemsManutencao[0]);
         menus[3].add(menuItemsManutencao[1]);
         menus[3].add(menuItemsManutencao[2]);
         menus[3].add(menuItemsManutencao[3]);
         menus[3].add(menuItemsManutencao[4]);

         menus[4].add(menuItemsPessoal[0]);
         menus[4].add(menuItemsPessoal[1]);
         menus[4].add(menuItemsPessoal[2]);
         menus[4].add(menuItemsPessoal[3]);
         menus[4].add(menuItemsPessoal[4]);
         menus[4].add(menuItemsPessoal[5]);
         menus[4].add(menuItemsPessoal[6]);
         menus[4].add(menuItemsPessoal[7]);

         menus[5].add(menuServicosPublicos[0]);
         menus[5].add(menuServicosPublicos[1]);
         menus[5].add(menuServicosPublicos[2]);
         menus[5].add(menuServicosPublicos[3]);
         menus[5].add(menuServicosPublicos[4]);
         menus[5].add(menuServicosPublicos[5]);
         menus[5].add(menuServicosPublicos[6]);

         menus[6].add(menuSuplimentos[0]);
         menus[6].add(menuSuplimentos[1]);
         menus[6].add(menuSuplimentos[2]);
         menus[6].add(menuSuplimentos[3]);

         menus[7].add(menuTransporte[0]);
         menus[7].add(menuTransporte[1]);
         menus[7].add(menuTransporte[2]);
         menus[7].add(menuTransporte[3]);

         menus[8].add(menuTransporte[0]);

         menus[9].add(menuViagens[0]);
         menus[9].add(menuViagens[1]);
         menus[9].add(menuViagens[2]);
         menus[9].add(menuViagens[3]);
         menus[9].add(menuViagens[4]);
         menus[9].add(menuViagens[5]);

         menus[10].add(menuOutro[0]);
         */

        JMenu menu = ComboMenuBar.createMenu("");

        for (int i = 0; i < cont; i++) {

            menu.add(menus[i]);

        }
        /*menu.add(menus[0]);
         menu.add(menus[1]);
         menu.add(menus[2]);
         menu.add(menus[3]);
         menu.add(menus[4]);
         menu.add(menus[5]);
         menu.add(menus[6]);
         menu.add(menus[7]);
         menu.add(menus[8]);
         menu.add(menus[9]);
         menu.addSeparator();
         menu.add(menus[10]);
         */

        comboMenu = new ComboMenuBar(menu);

    }

    public ComboMenuBar getComboMenu() {
        return comboMenu;
    }

    public ComboMenuBar getComboMenuCalendario() {
        JPanel p = new JPanel();
        p.setBounds(15, 15, 15, 15);
        p.setBackground(Color.red);
        p.setForeground(Color.red);
        comboMenu = new ComboMenuBar(p);
        return comboMenu;
    }
}

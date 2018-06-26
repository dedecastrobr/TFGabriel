package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tools.DBConnection;
import tools.Menu;

public class VendasSuplementos {
	

	public static List<String> opsMenuPrincipal = Arrays.asList("Clientes","Produtos","Pedidos","Estoque");
	public static List<String> opsMenuClientes = Arrays.asList("Cadastrar","Pesquisar");
	public static List<String> opsMenuProdutos = Arrays.asList("Cadastrar","Pesquisar");
	public static List<String> opsMenuPedidos = Arrays.asList("Cadastrar","Pesquisar");
	public static List<String> opsMenuEstoque = Arrays.asList("Atualizar","Relatório de Estoque");

	public static void main(String[] args) {

		DBConnection conn = new DBConnection();
		System.out.println("Bem vindo à Venda de Suplementos");
		Menu menu = new Menu("Menu Principal", opsMenuPrincipal);
		menu.show();
		int op = menu.getOption();
		do {
			switch (op) {
			case 0:
				Menu menuClientes = new Menu("Clientes", opsMenuClientes);
				menuClientes.show();
				int opClientes = menuClientes.getOption();
				break;
			case 1:
				Menu menuProdutos = new Menu("Produtos", opsMenuProdutos);
			default:
				System.out.println("Opção inválida!");
				break;
			}
			op = menu.getOption();
		} while (op != 99);

	}
	

}

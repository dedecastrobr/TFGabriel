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
				do {
					switch(opClientes) {
					case 0:
						break;
					case 1:
						break;
					default:
						break;
					}
					opClientes = menuClientes.getOption();
				}while (opClientes != 99);
				break;
			case 1:
				Menu menuProdutos = new Menu("Produtos", opsMenuProdutos);
				menuProdutos.show();
				int opProdutos = menuProdutos.getOption();
				do {
					switch(opProdutos) {
					case 0:
						break;
					case 1:
						break;
					default:
						break;
					}
					opProdutos = menuProdutos.getOption();
				}while (opProdutos != 99);
				break;
			case 2:
				Menu menuPedidos = new Menu("Pedidos", opsMenuPedidos);
				menuPedidos.show();
				int opPedidos = menuPedidos.getOption();
				do {
					switch(opPedidos) {
					case 0:
						break;
					case 1:
						break;
					default:
						break;
					}
					opPedidos = menuPedidos.getOption();
				}while (opPedidos !=99);
				break;
			case 3:
				Menu menuEstoque = new Menu("Estoque", opsMenuEstoque);
				menuEstoque.show();
				int opEstoque = menuEstoque.getOption();
				do {
					switch(opEstoque) {
					case 0:
						break;
					case 1:
						break;
					default:
						break;
					}
					opEstoque = menuEstoque.getOption();
				}while (opEstoque != 99);
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
			op = menu.getOption();
		} while (op != 99);

	}
	

}

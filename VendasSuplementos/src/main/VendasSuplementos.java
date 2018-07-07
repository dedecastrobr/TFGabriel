package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import tools.Menu;
import java.util.ArrayList;
import java.util.Arrays;

import tools.DBConnection;
import java.util.Scanner;
import java.util.InputMismatchException;
import main.Pedidos; 
import java.sql.PreparedStatement;

import tools.DBConnection;
import tools.Menu;

public class VendasSuplementos {
	
	
	public static List<String> opsMenuPrincipal = Arrays.asList("Clientes","Produtos","Pedidos","Estoque");
	public static List<String> opsMenuClientes = Arrays.asList("Cadastrar","Pesquisar","Listar");
	public static List<String> opsMenuProdutos = Arrays.asList("Cadastrar","Pesquisar");
	public static List<String> opsMenuPedidos = Arrays.asList("Cadastrar","Pesquisar");
	public static List<String> opsMenuEstoque = Arrays.asList("Atualizar","Relatório de Estoque");
	public static List<String> opsMenuPesquisa = Arrays.asList("Pesquisar por Código", "Pesquisar por Nome");


	public static void main(String[] args) {

		
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
						cadastroClientes();
						break;
					case 1:
						Menu menuPesquisa = new Menu("Pesquisar Cliente", opsMenuPesquisa);
						menuPesquisa.show();
						
						break;
					case 2:
						listarClientes();
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
	/*public static void pesqCliCodigo(){
		long pesquisa = 0;
		try{
			System.out.println("Código do Cliente: ");
			pesquisa = Menu.scan.nextLong();
			Menu.scan.nextLine();
			DBConnection conn = new DBConnection();				
			conn.executeSQLCliente("SELECT * FROM Clientes WHERE idCliente LIKE '%"+pesquisa+"%'");
		}catch(InputMismatchException e){
			System.out.println("ERRO: Digite somente números!");
			Menu.scan.nextLine();
		}
	}

	public static void pesqCliNome(){
		String pesquisa = "";
		System.out.println("Nome do Cliente: ");
		pesquisa = Menu.scan.nextLine();
		DBConnection conn = new DBConnection();
		conn.executeSQLCliente("SELECT * FROM Clientes WHERE Nome LIKE '%"+pesquisa+"%'");
}*/
	public static void atualizaEstoque(){
		Menu menuPesquisa = new Menu("Pesquisar Produto", opsMenuPesquisa);
		menuPesquisa.show();
		int opPesqProdutos = menuPesquisa.getOption();
		do{
			switch(opPesqProdutos){
			case 0:
				long pesquisaProdCod = 0;
				try{
		    		System.out.println("Código do Produto: ");
		        	pesquisaProdCod = Menu.scan.nextLong();
		        	Menu.scan.nextLine();
		        	DBConnection conn = new DBConnection();				
					conn.executeSQLProdEst("SELECT * FROM Produtos WHERE CodProduto LIKE '%"+pesquisaProdCod+"%'");
				}catch(InputMismatchException e){
					System.out.println("---------------------------------");
					System.out.println("ERRO: Digite somente números!");
					System.out.println("---------------------------------");
					Menu.scan.nextLine();
				}					
				break;
			case 1:
				String pesquisaProdNome = "";
				System.out.println("Nome do Produto: ");
				pesquisaProdNome = Menu.scan.nextLine();
				DBConnection conn = new DBConnection();
				conn.executeSQLProdEst("SELECT * FROM Produtos WHERE Descricao LIKE '%"+pesquisaProdNome+"%'");
				break;
			case 99:
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
			menuPesquisa.show();
			opPesqProdutos = menuPesquisa.getOption();
		}while(opPesqProdutos != 99);
	}
	public static void cadastroClientes(){
		Cliente clientes = new Cliente();
		if(clientes != null && clientes.getTelefoneCliente() != 0){
			clientes.criaCliente();
			clientes.mostraCliente();
			System.out.println("---------------------------------");
		}else{
			System.out.println("---------------------------------");
			System.out.println("Falha no cadastro do cliente!");
			System.out.println("---------------------------------");
		}
	}
	public static void listarClientes(){
		DBConnection conn = new DBConnection();
		conn.executeSQL("SELECT * FROM Clientes");
	}
	
	public static void listarProdutos(){
		DBConnection conn = new DBConnection();
		conn.executeSQL("SELECT * FROM Produtos");
	}


}

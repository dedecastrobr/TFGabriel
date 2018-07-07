package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import tools.Menu;
import java.util.ArrayList;
import tools.DBConnection;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Pedidos{
	private Double valorTotal = 0.00;
	private  int idPedido = 0;
	
	private Scanner scan = Menu.scan;

	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	private ArrayList<Produtos> listaProdutos = new ArrayList<Produtos>();

	
	
	public Double getvalorTotal() {
		return valorTotal;
	}

	public void settvalorTotal(Double v) {
		this.valorTotal = v;
	}

	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}


	public List<Produtos> getListaProdutos() {
		return listaProdutos;
	}
	
	public Pedidos(Double vTotal,Cliente cli, Produtos prod){
		this.valorTotal = vTotal;
	}
	
	public void Pedido(Cliente cli, Produtos prod){
		try{
			System.out.println("Valor Total do Pedido: ");
			this.valorTotal = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("Somente numeros!");
			scan.nextLine();
		}
	}
	
	public void criaPedido(Cliente cli, Produtos prod){
		Connection conn = (new DBConnection()).getConn();
		Statement stmt = null;
		
		String sql = "INSERT INTO Clientes_has_Demandas (Clientes_idCliente,Demandas_idDemandas) VALUES ('" + this.idPedido + "', '" + prod.getIdProduto() + "')";
		System.out.println(sql);
		try {
			stmt = conn.createStatement();
			if(stmt.execute(sql)) {
				System.out.println("Falha na insercao");
			}else {
				int count = stmt.getUpdateCount();
				if (count >= 1) {
					System.out.println("Cliente inserido no pedido com sucesso!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePedidos(){
		try{
			System.out.println("Novo Preco Total do Pedido: ");
			this.valorTotal = scan.nextDouble();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("ERRO: Somente numeros!");
			scan.nextLine();
		}
		

	}
    
	public void mostraPedido(Cliente cli, Produtos prod){
		System.out.println("Pedido:");
	//	System.out.println("Realizado por: " + cli.getNomeCliente());
		System.out.println("Descricao: " + prod.getDescricaoProd());
		System.out.println("Preco: " + prod.getPrecoProd());
		System.out.println("Preco Total: " + this.valorTotal);
	}
}
	
	
	
	

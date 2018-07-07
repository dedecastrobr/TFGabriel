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
import main.Pedidos; 

public class Produtos{
	private String nome = "";
	private String descricao = "";
	private Double valor = 0.00;
	private int qntEstoque = 0;
	private Pedidos pedidoProduto = null;
	private int idProduto = 0;

	private Scanner scan = Menu.scan;
	public String getDescricaoProd(){
		return descricao;
	}
	
	public Double getPrecoProd(){
		return valor;
	}
	
	
	public int getQtdEstoque(){
		return qntEstoque;
	}
	
	public Pedidos getpedidoProduto() {
		return pedidoProduto;
	}
	public int getIdProduto(){
		return idProduto;
	}
	

	public void setDescricaoProd(String descricaoProd){
		this.descricao = descricaoProd;
	}
	
	public void setPrecoProd(Double precoProd){
		this.valor = precoProd;
	}
	

	public void setQtdEstoque(int qtdEstoque){
		this.qntEstoque = qtdEstoque;
	}
	

	public void setPedidoProduto(Pedidos pedidoProduto) {
		this.pedidoProduto = pedidoProduto;
	}
	
	public void Produtop(String descricaoProd, Double precoProd, int qtdEstoque,Pedidos pedido){
		this.descricao = descricaoProd;
		this.valor = precoProd;
		this.qntEstoque = qtdEstoque;
		this.pedidoProduto = pedido;
	}
	
	public void Produto(String descricaoProd, Double precoProd, int qtdEstoque){
		this.descricao = descricaoProd;
		this.qntEstoque = qtdEstoque;
		this.valor = precoProd;
	}
	
	public Produtos(){
		System.out.println("Descricao do Produto: ");
		this.descricao = scan.nextLine();
		
			try{
				System.out.println("Preco do Produto: ");
				this.valor = scan.nextDouble();
				scan.nextLine();
			}catch(InputMismatchException e){
				System.out.println("ERRO:Somente numeros!");
				scan.nextLine();
			}		
		
			try{
				System.out.println("Quantidade em Estoque: ");
				this.qntEstoque = scan.nextInt();
				scan.nextLine();
			}catch(InputMismatchException e){
				System.out.println("ERRO:Somente n�meros!");
				scan.nextLine();
			}
		
	}
	
	public void mostraProduto(){
		System.out.println("Produto:");
		System.out.println("Nome: "+this.nome);
		System.out.println("Descricao: "+this.descricao);
		System.out.println("Valor: "+ this.valor);
		System.out.println("Quantidade em estoque: "+this.qntEstoque);
		
	}
}
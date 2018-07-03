package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tools.Menu;
import tools.DBConnection;

public class Produtos{
	private String Nome = "";
	private String Descricao = "";
	private float Valor = 0;
	private int qntEstoque = 0;
	
	public Produtos() {
		
	}

	
	
	
	public void mostraProduto(){
		System.out.println("Produto:");
		System.out.println("Nome: "+this.Nome);
		System.out.println("Descricao: "+this.Descricao);
		System.out.println("Valor: "+ this.Valor);
		System.out.println("Quantidade em estoque: "+this.qntEstoque);
		
	}
}
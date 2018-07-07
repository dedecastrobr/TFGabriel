package main;

import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tools.Menu;
import tools.DBConnection;

public class Cliente{
	private String nCliente = "";
	private int telCliente;
	private String dnCliente ="";
	
	public String getNomeCliente(){
		return nCliente;
	}
	public int getTelefoneCliente() {
		return telCliente;
	}
	public String getdnCliente() {
		return dnCliente;
	}
	
	public void setNomeCli(String n) {
		this.nCliente = n;
	}
	public void setTelCli(int t) {
		this.telCliente = t;
	}
	public void setdnCli(String d) {
		this.dnCliente = d;
	}
	
	
	
	public Cliente() {
		System.out.println("Digite o nome do cliente: ");
		this.nCliente = Menu.scan.nextLine();
		System.out.println("Digite o Telefone do cliente: ");
		this.telCliente = Menu.scan.nextInt();
		Menu.scan.nextLine();
		System.out.println("Digite a data de nascimento do cliente");
		this.dnCliente = Menu.scan.nextLine();
		

	}
	public void criaCliente() {
		Connection conn = (new DBConnection().getConn());
		Statement stmt = null;
		String sql = "insert into Clientes(Nome,NumTelefone,DataNasc) values('"+this.nCliente+"','"+this.telCliente+"','"+this.dnCliente+"')";
		System.out.println(sql);
		try {
			stmt = conn.createStatement();
			if(stmt.execute(sql)) {
				System.out.println("Erro ao cadastrar Cliente!");
			}else {
				int count = stmt.getUpdateCount();
				if (count >= 1) {
					System.out.println("Cliente cadastrado com sucesso!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void mostraCliente(){
		System.out.println("Cliente:");
		System.out.println("Telefone: " + this.telCliente);
		System.out.println("Nome: " + this.nCliente);
		System.out.println("Data de nascimento: " +this.dnCliente);
	}
	
	
}

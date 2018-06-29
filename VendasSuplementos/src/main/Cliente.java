package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tools.Menu;
import tools.DBConnection;

public class Cliente{
	private int idCliente;
	private String nCliente = "";
	private String cpfCliente = "";
	private String endCliente = "";
	private String emCliente = "";
	private int telCliente;
	private String datanascCli ="";
	
	public Cliente() {
		System.out.println("Digite o nome do cliente: ");
		this.nCliente = Menu.scan.nextLine();
		System.out.println("Digite o CPF do cliente: ");
		this.cpfCliente = Menu.scan.nextLine();
		System.out.println("Digite o endereço do cliente: ");
		this.endCliente = Menu.scan.nextLine();
		System.out.println("Digite o e-mail do cliente: ");
		this.emCliente = Menu.scan.nextLine();

	}
	public void criaCliente() {
		Connection conn = (new DBConnection().getConn());
		Statement stmt = null;
		String sql = "Insert into Clientes(Nome,CPFCliente,EndCliente,EmailCliente,NumTelefone,DataNasc) values('"+this.nCliente+"','"+this.cpfCliente+"','"+this.endCliente+"','"+this.emCliente+"','"+this.telCliente+"','"+this.datanascCli+"')";
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
}

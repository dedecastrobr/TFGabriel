package tools;

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


public class DBConnection {
	private Connection conn = null;
	String bd = "TrabalhoLPBD";
	String url = "jdbc:mysql://localhost/"+bd+"?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";
	private Scanner scan = Menu.scan;
	
	public static List<String> opsMenuRmAl = Arrays.asList("Remover", "Alterar");

	private String newNomeCliente = "";
	private String newEnderecoCliente = "";
	private String newEmailCliente = "";
	private long newTelefoneCliente = 0;
		
	private int newCodigoProd = 0;
	private String newDescricaoProd = ""; 
	private Double newPrecoProd = 0.00;
	private int newPaginaProd = 0;
	private String newPontosProd = ""; 
		
	public String getNewNomeCliente(){
		return newNomeCliente;
	}
		
	public String getNewEnderecoCliente(){
		return newEnderecoCliente;
	}
			
	public String getNewEmailCliente(){
		return newEmailCliente;
	}
			
	public long getNewTelefoneCliente(){
		return newTelefoneCliente;
	}
		
	public int getNewCodigoProd(){
		return newCodigoProd;
	}
		
	public String getNewDescricaoProd(){
		return newDescricaoProd;
	}
		
	public Double getNewPrecoProd(){
		return newPrecoProd;
	}
		
	public int getNewPaginaProd(){
		return newPaginaProd;
	}
		
	public String getNewPontosProd(){
		return newPontosProd;
	}
		
		
	public void setNewNomeCliente(String newNomeCliente){
		this.newNomeCliente = newNomeCliente;
	}
		
	public void setNewEnderecoCliente(String newEnderecoCliente){
		this.newEnderecoCliente = newEnderecoCliente;
	}
			
	public void setNewEmailCliente(String newEmailCliente){
		this.newEmailCliente = newEmailCliente;
	}
			
	public void setNewTelefoneCliente(long newTelefoneCliente){
		this.newTelefoneCliente = newTelefoneCliente;
	}
		
		
	public void setNewCodigoProd(int newCodigoProd){
		this.newCodigoProd = newCodigoProd;
	}
		
	public void setNewDescricaoProd(String newDescricaoProd){
		this.newDescricaoProd = newDescricaoProd;
	}
		
	public void setNewPrecoProd(Double newPrecoProd){
		this.newPrecoProd = newPrecoProd;
	}
		
	public void setNewPaginaProd(int newPaginaProd){
		this.newPaginaProd = newPaginaProd;
	}
		
	public void setNewPontosProd(String newPontosProd){
		this.newPontosProd = newPontosProd;
	}

	public DBConnection() {

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost/TrabalhoLPBD?user=root&password=root");

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public Connection getConn() {
		return conn;
	}

	public void executeSQL(String sql) {

		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.createStatement();
			if (stmt.execute(sql)) {
				rs = stmt.getResultSet();
				while (rs.next()) {
					System.out.println(rs.getString(2));
				}
			} else {
				int count = stmt.getUpdateCount();
				if (count == 1) {
					System.out.println("Registro Inserido com sucesso!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean checkValue(String Value) {
		try {
			int x = Integer.parseInt(Value);
			return true;
			
		}catch(Exception e) {
			return false;
		}
		
	}
	/*public void executeSQLCliente(String sqlCli) {
		Statement stmtCli = null;
		ResultSet rsCli = null;
		try {
			stmtCli = conn.createStatement();
			if (stmtCli.execute(sqlCli)) {
				rsCli = stmtCli.getResultSet();
				while (rsCli.next()) {
					System.out.println("------------------------------------------------");
					System.out.println("idCliente: " + rsCli.getInt(1) + "\nNome: " + rsCli.getString(3) + " \nTelefone: " + rsCli.getInt(2) + "\nEndereço: " + rsCli.getString(4) + "\nEmail: " + rsCli.getString(5));
					System.out.println("------------------------------------------------");
				}
					Menu menuRemovAlter = new Menu("Remover ou Alterar", opsMenuRmAl);
					menuRemovAlter.show();					
					int opRemAlt = menuRemovAlter.getOption();
					do{
						switch(opRemAlt){
						case 0:
							int pesquisa = 0;
							try{
					    		System.out.println("Código do cliente a ser removido: ");
					        	pesquisa = scan.nextInt();
					        	scan.nextLine();
					        	try(Connection conn = DriverManager.getConnection(url, user, password)){
					        		String sqlCliRem = "SELECT * FROM Clientes WHERE idCliente = '"+pesquisa+"'";
					        		Statement stmtRemoveCli = conn.createStatement();
					        		ResultSet rsCli2 = stmtRemoveCli.executeQuery(sqlCliRem);
					        		while(rsCli2.next()){
					        			System.out.println("------------------------------------------------");
										System.out.println("idCliente: " + rsCli2.getInt(1) + "\nNome: " + rsCli2.getString(3) + " \nTelefone: " + rsCli2.getInt(2) + "\nEndereço: " + rsCli2.getString(4) + "\nEmail: " + rsCli2.getString(5));
										System.out.println("------------------------------------------------");
										System.out.println("Tem certeza de que deseja remover o cliente? (S/N):");
										String opSimNao = scan.nextLine();
										switch(opSimNao.charAt(0)){
										case 'S': case 's':
											try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
												String sqlCli2 = "DELETE FROM Clientes WHERE idCliente = ?";									
												PreparedStatement stmtDeleteCli = conn.prepareStatement(sqlCli2);
												stmtDeleteCli.setInt(1, rsCli2.getInt(1));									
												int rowsDeleted = stmtDeleteCli.executeUpdate();
												if (rowsDeleted > 0) {
													System.out.println("Cliente removido com sucesso!");
												}else{
													System.out.println("ERRO: Falha na remoção do cliente!");
												}									
											} catch (SQLException e) {
												e.printStackTrace();
											}
											break;
										case 'N': case 'n':
											break;
										case 99:
											break;
										default:
											System.out.println("Opção inválida!");
											break;
										}
					        		}
					        	}catch(InputMismatchException e){
					        		e.printStackTrace();
					        	}
							}catch(InputMismatchException e){
								System.out.println("---------------------------------");
								System.out.println("ERRO: Digite somente números!");
								System.out.println("---------------------------------");
								scan.nextLine();
							}
							break;
						case 1:
							int buscaCli = 0;
							try{
					    		System.out.println("Código do cliente a ser alterado: ");
					        	buscaCli = scan.nextInt();
					        	scan.nextLine();
					        	try(Connection conn = DriverManager.getConnection(url, user, password)){
					        		String sqlCliAlter = "SELECT * FROM Clientes WHERE idCliente = '"+buscaCli+"'";
					        		Statement stmtAltCli = conn.createStatement();
					        		ResultSet rsCli3 = stmtAltCli.executeQuery(sqlCliAlter);
					        		while(rsCli3.next()){
					        			System.out.println("------------------------------------------------");
										System.out.println("idCliente: " + rsCli3.getInt(1) + "\nNome: " + rsCli3.getString(3) + " \nTelefone: " + rsCli3.getInt(2) + "\nEndereço: " + rsCli3.getString(4) + "\nEmail: " + rsCli3.getString(5));
										
										atlCliente();
										
										System.out.println("idCliente: " + rsCli3.getInt(1) + "\nNome: " + getNewNomeCliente() + " \nTelefone: " + getNewTelefoneCliente() + "\nEndereço: " + getNewEnderecoCliente() + "\nEmail: " + getNewEmailCliente());
										System.out.println("Confirma os novos dados do cliente? (S/N):");
										String opSimNao = scan.nextLine();
										switch(opSimNao.charAt(0)){
										case 'S': case 's':
											try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
												String sqlCli3 = "UPDATE Clientes SET idCliente = '" + rsCli3.getInt(1) + "', NumTelefone = '" + getNewTelefoneCliente() + "', Nome = '" + getNewNomeCliente() + "', Endereco = '" + getNewEnderecoCliente() + "', Email = '" + getNewEmailCliente() + "' WHERE idCliente = '" + buscaCli + "'";                         
												PreparedStatement stmtUpdate = conn2.prepareStatement(sqlCli3);
												int rowsUpdatedCli = stmtUpdate.executeUpdate();
												if (rowsUpdatedCli > 0) {
													System.out.println("Dados do cliente alterados com sucesso!");
												}else{
													System.out.println("ERRO: Falha na alteração dos dados do cliente!");
												}									
											} catch (SQLException e) {
												e.printStackTrace();
											}
											break;
										case 'N': case 'n':
											break;
										case 99:
											break;
										default:
											System.out.println("Opção inválida!");
											break;
										}
					        		}
					        	}catch(InputMismatchException e){
					        		e.printStackTrace();
					        	}
							}catch(InputMismatchException e){
								System.out.println("ERRO: Somente números!");
								scan.nextLine();
							}
							break;
						case 99:
							break;
						default:
							System.out.println("Opção inválida!");
							break;
						}
						menuRemovAlter.show();
						opRemAlt = menuRemovAlter.getOption();
					}while(opRemAlt != 99);
				
			} else {
				int count = stmtCli.getUpdateCount();
				if (count >= 1) {
					System.out.println(rsCli);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	public void atlCliente(){
		System.out.println("Novo Nome: ");
		this.newNomeCliente = scan.nextLine();
		
		System.out.println("Novo Endereço: ");
		this.newEnderecoCliente = scan.nextLine();
		
		System.out.println("Novo Email: ");
		this.newEmailCliente = scan.nextLine();
		
		try{
			System.out.println("Novo Telefone: ");
			this.newTelefoneCliente = scan.nextLong();
			scan.nextLine();
		}catch(InputMismatchException e){
			System.out.println("ERRO: Digite somente números!");
			scan.nextLine();
		}
	}
	public void executeSQLProdEst(String sqlProdEst){
		Statement stmtProdEst = null;
		ResultSet rsProdEst = null;
		try {
			stmtProdEst = conn.createStatement();
			if (stmtProdEst.execute(sqlProdEst)) {
				rsProdEst = stmtProdEst.getResultSet();
				while (rsProdEst.next()) {
					System.out.println("------------------------------------------------");
					System.out.println("idProduto: " + rsProdEst.getInt(1) + " \nCodProduto: " + rsProdEst.getInt(2) + "\nDescrição: " + rsProdEst.getString(3) + "\nPreço: " + rsProdEst.getDouble(4) + "\nPágina: " + rsProdEst.getInt(5) + "\nQtdEstoque: " + rsProdEst.getInt(6) + "\nPontos: " + rsProdEst.getString(7));
					System.out.println("------------------------------------------------");
				}
				int pesquisa = 0;
				try{
		    		System.out.println("Código do produto a ter seu estoque atualizado: ");
		        	pesquisa = scan.nextInt();
		        	scan.nextLine();
		        	try(Connection conn = DriverManager.getConnection(url, user, password)){
		        		String sqlProdEst2 = "SELECT * FROM Produtos WHERE CodProduto = '"+pesquisa+"'";
		        		Statement stmtProdEst2 = conn.createStatement();
		        		ResultSet rsProdEst2 = stmtProdEst2.executeQuery(sqlProdEst2);
		        		while(rsProdEst2.next()){
		        			System.out.println("------------------------------------------------");
							System.out.println("idProduto: " + rsProdEst2.getInt(1) + "\nCodProduto: " + rsProdEst2.getInt(2) + " \nDescrição: " + rsProdEst2.getString(3) + "\nPreço: " + rsProdEst2.getDouble(4) + "\nPágina: " + rsProdEst2.getInt(5) + "\nQtdEstoque: " + rsProdEst2.getInt(6) + "\nPontos: " + rsProdEst2.getString(7));
							System.out.println("------------------------------------------------");
							int pesquisaQtd = 0;
							try{
								System.out.println("Nova Quantidade em Estoque: ");
								pesquisaQtd = scan.nextInt();
								scan.nextLine();
								try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
									String sqlProdEst3 = "UPDATE Produtos SET QtdEstoque = '" + pesquisaQtd + "' WHERE CodProduto = '" + pesquisa + "'";									
									PreparedStatement stmtUpdateEst = conn2.prepareStatement(sqlProdEst3);
									int rowsUpdated = stmtUpdateEst.executeUpdate();
									if (rowsUpdated > 0) {
										System.out.println("Estoque atualizado com sucesso!");
									}else{
										System.out.println("ERRO: Falha na atualização do estoque!");
									}
								}catch(InputMismatchException e){
									System.out.println("ERRO: Digite somente números!");
									scan.nextLine();
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
		        		}
		        	}catch(InputMismatchException e){
		        		e.printStackTrace();
		        	}
				}catch(InputMismatchException e){
					System.out.println("ERRO: Digite somente números!");
					scan.nextLine();
				}
			}else {
				int count = stmtProdEst.getUpdateCount();
				if (count >= 1) {
					System.out.println(rsProdEst);
				}
			}
		}catch (SQLException e) {
			System.out.println("ERRO: Produto não encontrado!");
		}
	}
}
	


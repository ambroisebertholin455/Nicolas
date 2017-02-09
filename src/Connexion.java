import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	//Classe permettant de faire la connection
	private Connection con;
	//Classe permettant d'executer les requetes
	private  Statement st;
	//Classe permettant d'avoir les resultats des Requetes
	private ResultSet rs;
	
	 
	public Connexion(){
		
		 try{
			 
				Class.forName("com.mysql.jdbc.Driver");
				//declaration d'un url de connexion
				String url="jdbc:mysql://localhost:3306/inscription";
				//etablissement de la connexion
				con=DriverManager.getConnection(url,"root","");
				//creation d'une instance d'execution de requete
				st=con.createStatement();
				System.out.println("Tout est ok");
			}catch(SQLException | ClassNotFoundException e){
				//JOptionPane.showMessageDialog(null,"Code introuvable!");
			}
	}
	
	
	
	
	
	
	
	//Creation des Accesseurs et des Mutateurs
	public Connection getConnection(){
		return this.con;
	}
	public void setConnection(Connection con){
		this.con=con;
	}

	public Statement getStatement(){
		return this.st;
	}
	public void setStatement(Statement st){
		this.st=st;
	}

	public ResultSet getResultSet(){
		return this.rs;
	}
	public void setResultSet(ResultSet rs){
		this.rs=rs;
	}
	
		
	}




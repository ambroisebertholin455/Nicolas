import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBase {
	
	private static DataBase data = new DataBase();
	private static Connection con;
	private Statement state;
	private ResultSet rs;

	
	
	DataBase()
	{

		try{
			System.out.println("Ouverture d'une session");
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1/inscription?user=root&password=";
			con = DriverManager.getConnection(url,"root","");			
			state = con.createStatement();
			System.out.println("Connection: OK");
		}catch(ClassNotFoundException cl){
			System.out.println("Erreur class non retrouve: "+ cl.getMessage());
		}
		catch(SQLException sq){
			System.out.println("Erreur sql: "+sq.getMessage());
		}
	}
	
	public static DataBase getInstance(){
		//un petit test pour bien gerer notre singleton
		if(con == null){
			data =  new DataBase();
			System.out.println("Instantiation de l'objet dataBase\n");
		}else
			System.out.println("Objet deja instancier alor est retourne:\n");
			
		
		return data;//apres les teste on retourne le resultat approprier	
	}
	
	
	
	
	public void inscription(String nom, String prenom,String datN, String lieuN, String nif,String dateI, String noD, String stat,  String adresse, String telephone, String ref, String pays, String dis, String grp)
	{
		try {
			
			String requete = "insert into guest(nom, prenom,date_naissance, lieu_naissance, nif_cin, Date_inscription, no_ordre_bacc, statut_matrimonial,  adresse, telephone, reference_etrange, pays, dicipline_choisie, groupe) values(?,?,?,?)";
			check();
			PreparedStatement prepare = con.prepareStatement(requete);
			prepare.setString(1, nom );
			prepare.setString(2, prenom );
			prepare.setString(3, datN);
			prepare.setString(4, lieuN);
			prepare.setString(5, nif);
			prepare.setString(6, dateI);
			prepare.setString(7, noD);
			prepare.setString(8, stat);			
			prepare.setString(9, adresse );
			prepare.setString(10, telephone );
			prepare.setString(11, ref);
			prepare.setString(12, pays);
			prepare.setString(13, dis);
			prepare.setString(14, grp);
			
			prepare.executeUpdate();
			
			prepare.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inserer_utilisateur(String nom, String prenom, String adresse, String telephone, String password)
	{
	try {
			
			String requete = "insert into user(nom, prenom, adresse, telephone, password) values(?, ?, ?, ?, ?)";
			check();
			PreparedStatement prepare = con.prepareStatement(requete);
			prepare.setString(1, nom );
			prepare.setString(2, prenom );
			prepare.setString(3, adresse );
			prepare.setString(4, telephone );
			prepare.setString(1, password );
			prepare.executeUpdate();
			
			prepare.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void check()
	{
		try{
				if(state != null )
							state.close();
						
						state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_UPDATABLE);
						
			}catch (SQLException e) {
			
				e.printStackTrace();
				
			}		
			
	}
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Statement getSt() {
		return state;
	}

	public void setSt(Statement st) {
		this.state = st;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

}

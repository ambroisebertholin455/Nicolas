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
			
			String requete = "insert into inscription(nom, prenom,date_naissance, lieu_naissance, nif_cin, Date_inscription, no_ordre_bacc, statut_matrimonial,  adresse, telephone, reference_etrange, pays, dicipline_choisie, groupe, code_inscription) " +
					"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			prepare.setString(15, code());
			prepare.executeUpdate();
			
			prepare.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dossier(String let, String rel, String cop, String at )
	{
		try {
			
			String requete = "insert into dossier(lettre_transfer, releve_note_ut_sortante, copie_diplome, attestation_ut_sort, code_inscription, id) values(?,?,?,?,?,?)";
			check();
			PreparedStatement prepare = con.prepareStatement(requete);
			prepare.setString(1, let );
			prepare.setString(2, rel);
			prepare.setString(3, cop);
			prepare.setString(4, at);
			prepare.setString(5, lastId());
			prepare.setString(6, code());
			
			prepare.executeUpdate();			
			prepare.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void lien(String n, String pn, String lien)
	{
		try {
			System.out.println(lastId());
			String requete = "insert into lien_parente (nom, prenom, lien_parente, code_inscription, id) values(?,?,?,?,?)";
			check();
			PreparedStatement prepare = con.prepareStatement(requete);
			prepare.setString(1, n );
			prepare.setString(2, pn);
			prepare.setString(3, lien);
			prepare.setString(4, lastId());
			prepare.setString(5, code());
			
			prepare.executeUpdate();			
			prepare.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void piece(String pic, String rel, String pic1, String cer, String pi)
	{
		try {
			
			String requete = "insert into pieces(PHOTOCOPIE_CERTIFICAT_BACC, RELEVE_NOTE_BACC, PHOTOCOPIE_ACTE_NAISSACEE, CERTIFICAT_VIE_MOEURS, PHOTO_EDENTITE, CODE_INSCRIPTION, id) values(?,?,?,?,?,?,?)";
			check();
			PreparedStatement prepare = con.prepareStatement(requete);
			prepare.setString(1, pic );
			prepare.setString(2, rel);
			prepare.setString(3, pic1);
			prepare.setString(4, cer);
			prepare.setString(5, pi);
			prepare.setString(6, lastId());
			prepare.setString(7, code());
			
			prepare.executeUpdate();			
			prepare.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void primaire(String db, String fi, String et1, String et2, String et3)
	{
		try {
			
			String requete = "insert into enseignement_primaire(date_debut, date_fin, etablissemnt_a, etablissemnt_b, etablissemnt_c, code_inscription, id) values(?,?,?,?,?,?,?)";
			check();
			PreparedStatement prepare = con.prepareStatement(requete);
			prepare.setString(1, db);
			prepare.setString(2, fi);
			prepare.setString(3, et1);
			prepare.setString(4, et2);
			prepare.setString(5, et3);
			prepare.setString(6, lastId());
			prepare.setString(7, code());
			
			prepare.executeUpdate();			
			prepare.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void secondaire(String db, String fi, String et1, String et2, String et3)
	{
		try {
			
			String requete = "insert into enseignement_secondaire(date_debut, date_fin, etablissemnt_a, etablissemnt_b, etablissemnt_c, code_inscription, id) values(?,?,?,?,?,?,?)";
			
			check();
			PreparedStatement prepare = con.prepareStatement(requete);
			prepare.setString(1, db);
			prepare.setString(2, fi);
			prepare.setString(3, et1);
			prepare.setString(4, et2);
			prepare.setString(5, et3);
			prepare.setString(6, lastId());
			prepare.setString(7, code());
			
			prepare.executeUpdate();			
			prepare.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void universitaire(String db, String fi, String et1, String et2, String et3)
	{
		try {
			
			String requete = "insert into enseignement_universitaire(date_debut, date_fin, etablissemnt_a, etablissemnt_b, etablissemnt_c, code_inscription, id) values(?,?,?,?,?,?,?)";
			
			check();
			PreparedStatement prepare = con.prepareStatement(requete);
			prepare.setString(1, db);
			prepare.setString(2, fi);
			prepare.setString(3, et1);
			prepare.setString(4, et2);
			prepare.setString(5, et3);
			prepare.setString(6, lastId());
			prepare.setString(7, code());
			
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
	
	public String  lastId()
	{
		String code = "null";
		String requete ="";
		Statement state;
		try
		{
			 	state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		
		
		
			 requete = " select code_inscription as code from inscription";
		
			 ResultSet rs = state.executeQuery(requete);
			
			 if(rs.last())
				 code = rs.getString("code") ;
			
		}catch(SQLException sql){
			
			System.out.println("Last ID non retrouver: echeck\n"+sql.getMessage());
		}
		
		return code;
	}
	
	public static String code()
	{
		String C1 ="TVA";
		int min = 10, max = 90;
		int code,  sce = 0;
		code = (int)(int)(Math.random() * max + min);
		C1 += code;
    	C1 += "MS-";
    	code = (int)(int)(Math.random() * max + min);
    	C1 += code;
		
    	return C1;
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

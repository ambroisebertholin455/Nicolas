
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Enregistrement_Utilisateur extends JInternalFrame implements ActionListener

{
   private JButton btlist;
   
    
 
  private JComboBox cbsexe_utilisateur; 
  
     private JComboBox cbType_utilisateur;
     
     private JLabel identite;
 
  private JTextField Pcode;
 
  private JButton boutOk;
  private JButton boutAnn;
  private JPanel panel, panel2, panel3,panelbout, panBout,panW,panE , pins;
  private JLabel leLabelImage;
  private ImageIcon lImage ;
  
  private JTable table;
    private Object obj[][];
    private String titreTableau[];
    private Connexion con;
    private Statement st,st2;
    private ResultSet rs,rs2;
    boolean test=false;
  public Enregistrement_Utilisateur() {
      super("LISTE DES INSCRIT A L'UNIVERSITE INUKA");
       this.setSize(1300,500);
     setVisible(true);
  

      setResizable(true);
      setVisible(true);
      setDefaultCloseOperation ( DISPOSE_ON_CLOSE);
      //ImageIcon image = new ImageIcon("form.png");
      
        
      panel2=new JPanel(new BorderLayout());
      panE=new JPanel(new FlowLayout());
         panel=new JPanel(new GridLayout(14,3,10,10));
         panBout=new JPanel(new FlowLayout());
     
      
        JLabel   lins=new JLabel("Formulaire d'inscription");
     lins.setHorizontalAlignment(SwingConstants.CENTER);
     Font font=new Font("TimesRoman",Font.BOLD+Font.ITALIC,18);
     lins.setFont(font);

      
      
      
                      //les textes a afficher
      
      btlist=new JButton("Lister");
      
      
      
     titreTableau=new String[]{"Code","Code_Session","Nom","Prenom","Sexe","Date_naissance","Nom_Session","Telephone","Type","Adresse"};
    obj=new Object[35][10];
     table=new JTable(obj,titreTableau);
     JScrollPane sc=new JScrollPane(table);
    table.getTableHeader().setBackground(Color.white);
    table.setBackground(Color.white);


                           sc.setBorder(BorderFactory.createLineBorder(Color.gray,1));
                            panel.setBorder(BorderFactory.createLineBorder(Color.gray,1));
                             panBout.setBorder(BorderFactory.createLineBorder(Color.gray,1));

                                   // ajout des composantes aux conteneurs
     
  btlist.addActionListener(this);
  //btupdate.addActionListener(this);
     
       
     
    
           
            
                                        identite=new JLabel();
                                        identite.setForeground(Color.black);
                                       
                                        Font fon=new Font("calibri",Font.ITALIC,19);
                                        identite.setFont(fon);
                                        
                                       // ImageIcon img = new ImageIcon("ji.gif");
                                       // identite.setIcon(img);
                                        //getContentPane().add(identite);
                                       //  panE.add(identite);
      
		JLabel lblNewLabel = new JLabel("");

		lblNewLabel.setBounds(0, -50, 50, 10);
		panel2.add(lblNewLabel);
                                          //ajout des conteneurs sur le conteneur principal
                                      // panel.setBackground(Color.gray); 
    panBout.setBackground(Color.black);                                                   
    panel2.add(panE,BorderLayout.SOUTH);                                                     
 //  panel2.add(panel,BorderLayout.WEST);
panel2.add(panBout,BorderLayout.WEST);
panel2.add(sc,BorderLayout.CENTER);


 panE.add(btlist);
getContentPane().add(panel2);                                                      
       setClosable(true);
  setResizable(true);
  setIconifiable(true);
  setMaximizable(true);
  //pack();
    }
    
    
    
    
   @Override
public void actionPerformed(ActionEvent event){
if(event.getSource()==btlist)
lister();
}

public void lister(){

       
try{
    con=new Connexion();
st=con.getStatement();
String req="select * FROM utilisateur";
rs=st.executeQuery(req);

int i=0;
obj=new Object[20][10];
while(rs.next()){
 obj[i][0]=rs.getString("CODE_UTILISATEUR");
 obj[i][1]=rs.getString("CODE_SESSION");
 obj[i][2]=rs.getString("NOM_UTILISATEUR");
  obj[i][3]=rs.getString("PRENOM_UTILISATEUR");
   obj[i][4]=rs.getString("SEXE");
  
   obj[i][5]=rs.getString("DATE_NAISSANCE");
   obj[i][6]=rs.getString("NOM_SESSION");
    obj[i][7]=rs.getString("TELEPHONE");
   obj[i][8]=rs.getString("TYPE_UTILISATEUR");
     obj[i][9]=rs.getString("ADRESSE");
     

  
    
i++;
}
table.setModel(new javax.swing.table.DefaultTableModel(obj,titreTableau));
}catch(SQLException e){
JOptionPane.showMessageDialog(null,"Erreur sql!"+e);
}
}


public static void main(String []argv){
	Enregistrement_Utilisateur form= new Enregistrement_Utilisateur();
form.setVisible(true);
}


}
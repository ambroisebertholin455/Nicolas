
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulaire extends JInternalFrame implements ActionListener{
	
    	  private DataBase data = new DataBase(); 
          private JButton btsave,btnew,btlist;
		  private JLabel nom, releve,leLabelImage,etabliAP,etabliBP,etabliCP,etabliAS,etabliBS,etabliCS,etabliAU,etabliBU,etabliCU,
		  ensPrimairedebut,ensPrimairefin,ensSecondairedebut,ensSecondairefin,ensUniversitairedebut,ensUniversitairefin,imagelb,lettre,dateNaissance,photDi,releveB, photoC,photoAct,certificatB, photocopie, attes, prenom,NoDordre,discipline,lieu,statut,telephone,grou,refer,Adresse_utilisateur,nif, dateInscription,refefe;
		  private ImageIcon IconePhoto;
		  private JTextField txNom,txLieu,txPaysreference, txDordre,txInscription,txtel,txrefer,txprenom,txnif,txAdresse,txNaissance,
		  txensPrimairedebut,txensPrimairefin,txensSecondairedebut,txensSecondairefin,txensUniversitairedebut,txensUniversitairefin,
		  txEtabliAP,txEtabliBP,txEtabliCP,txEtabliAS,txEtabliBS,txEtabliCS,txEtabliAU,txEtabliBU,txEtabliCU;
		  private JComboBox cbstatut,reference,groupe,cbdiscipline,lettreCombo,photCombo,releveCombo,photoCombo,
		  certificatCombo,actCombo,attesCombo,phoCombo,releCombo; 
		  private JButton boutOk,boutAnn;
		  private JPanel panel, panel2, panBout,panE;
		  private ImageIcon lImage ;
		  private Connexion con;
		  private Statement st,st2;
		  private ResultSet rs,rs2;

    
  public Formulaire() {
	  
	  
      super("FORMULAIRE D'INSCRIPTION A L'INUKA");
       this.setSize(1300,500);
     setVisible(true);
      setResizable(true);
      //setVisible(true);
      setDefaultCloseOperation ( DISPOSE_ON_CLOSE);
      //ImageIcon image = new ImageIcon("form.png");
      
        
         panel2=new JPanel(new BorderLayout());
         panE=new JPanel(new FlowLayout());
         panel=new JPanel(new GridLayout(22,2,5,5));
         panBout=new JPanel(new FlowLayout());
   
                      //les textes a afficher
      nom=new JLabel(" Nom");
      photoC=new JLabel(" Photocopie du certificat");
      attes=new JLabel("Attestation de l'universite sortante");
      prenom= new JLabel("Pr�nom");
      statut= new JLabel(" Statut Matrimonial");
      photocopie= new JLabel("Photocopiede l'acte de naissance");
      ensPrimairedebut=new JLabel("Date du debut d'enseignement Primaire");
      ensPrimairefin=new JLabel("Date finale d'enseignement Primaire");
      ensSecondairedebut=new JLabel("Date du debut d'enseignement Secondaire");
      ensSecondairefin=new JLabel("Date finale d'enseignement Primaire");
      ensUniversitairedebut=new JLabel("Date du debut d'enseignement Universitaire");
      ensUniversitairefin=new JLabel("Date finale d'enseignement Universitaire");
      etabliAP=new JLabel("Etablissement 1 Primaire");
      etabliBP=new JLabel("Etablissement 2 Primaire");
      etabliCP=new JLabel("Etablissement 3 Primaire");
      etabliAS=new JLabel("Etablissement 1 Secondaire");
      etabliBS=new JLabel("Etablissement 2 Secondaire");
      etabliCS=new JLabel("Etablissement 3 Secondaire");
      etabliAU=new JLabel("Etablissement 1 Universitaire");
      etabliBU=new JLabel("Etablissement 2 Universitaire");
      etabliCU=new JLabel("Etablissement 3 Universitaire");
      lieu= new JLabel("Lieu de Naissance");
      discipline= new JLabel("Discipline Choisie");
      lettre= new JLabel("Lettre Attestation");
      releve= new JLabel("Releve de Note de l'universite sortante");
      releveB= new JLabel("Releve de Note du bacc2");
      refer= new JLabel("Pays de la personne de reference");
     telephone= new JLabel("Telephone");
     dateNaissance= new JLabel("Date de Naissance");
      dateInscription=new JLabel("Date Inscription");
      NoDordre=new JLabel("No D'ordre BaccII");
      Adresse_utilisateur=new JLabel("Adresse");
      nif=new JLabel("NIF OU CIN");
      grou=new JLabel("Groupe");
      refefe=new JLabel("Reference a l'etranger");
      photoAct=new JLabel("Photocopie de l'acte de Naissance");
     certificatB=new JLabel("Certificat de bonnes vies et moeurs");
     photDi=new JLabel("Trois photos d'identite");
      
                      // les zones de texte
      txNom=new JTextField("Votre Nom");
     txNom.setBounds(50,50,40,40);
      txprenom= new JTextField("Votre prenom");
      txrefer= new JTextField("Personne de reference");
      txtel= new JTextField("Votre telephone");
      txDordre= new JTextField("Votre Numero D'ordre");
      txLieu= new JTextField("Votre Lieu de Naissance");
     

     
      
      txPaysreference= new JTextField("Pays");
       txNaissance= new JTextField("Date de naissance");
     
      txInscription= new JTextField("Date inscription");
      txAdresse= new JTextField("Votre adresse");
      txnif= new JTextField("Votre NIF OU CIN");
      txensPrimairedebut= new JTextField("Date du debut d'enseignement primaire");
      txensPrimairefin = new JTextField("Date fin d'enseignement primaire");
      txensSecondairedebut= new JTextField("Date du debut d'enseignement Secondaire");
      txensSecondairefin = new JTextField("Date finale d'enseignement secondaire");
      txensUniversitairedebut= new JTextField("Date du debut d'enseignement universitaire");
      txensUniversitairefin = new JTextField("Date finale d'enseignement universitaire");
      
      txEtabliAP = new JTextField("Etablissement 1 Primaire");
      txEtabliBP = new JTextField("Etablissement 2 Primaire");
      txEtabliCP = new JTextField("Etablissement 3 Primaire");
      txEtabliAS = new JTextField("Etablissement 1 Secondaire");
      txEtabliBS= new JTextField("Etablissement 2 Secondaire");
      txEtabliCS = new JTextField("Etablissement 3 Secondaire");
      txEtabliAU = new JTextField("Etablissement 1 Universitaire");
      txEtabliBU = new JTextField("Etablissement 2 Universitaire");
      txEtabliCU = new JTextField("Etablissement 3 Universitaire");


      
                //Combobox
       cbstatut= new JComboBox();
        String sexe[]={"Celibat","Marie(e)","Divorce(e)"};
       cbstatut=new JComboBox(sexe);
        
          cbdiscipline= new JComboBox();
        String type[]={"Sciences de Gestion","Sciences Informatiques","Sciences Comptables","Sciences Economiques","Genie Civil","Genie Electronique"};
     cbdiscipline=new JComboBox(type);
     
     groupe= new JComboBox();
     String gro[]={"Matin","Median","Soir"};
    groupe=new JComboBox(gro);
    
    lettreCombo= new JComboBox();
    String lette[]={"Oui","Non"};
    lettreCombo=new JComboBox(lette);
    
    releveCombo= new JComboBox();
    String rel[]={"Oui","Non"};
     releveCombo=new JComboBox(rel);
   
     photoCombo= new JComboBox();
     String pho[]={"Oui","Non"};
   	 photoCombo=new JComboBox(pho);
   
	  attesCombo= new JComboBox();
	  String cert[]={"Oui","Non"};
	 attesCombo=new JComboBox(cert);
	 
	 phoCombo= new JComboBox();
	 String ph[]={"Oui","Non"};
	phoCombo=new JComboBox(ph);
	 
	releCombo= new JComboBox();
	String rele[]={"Oui","Non"};
	releCombo=new JComboBox(rele);
	
	actCombo= new JComboBox();
	String ac[]={"Oui","Non"};
	actCombo=new JComboBox(ac);
	
	certificatCombo= new JComboBox();
	String cer[]={"Oui","Non"};
	certificatCombo=new JComboBox(cer);
	
	photCombo= new JComboBox();
	String phot[]={"Oui","Non"};
	photCombo=new JComboBox(phot);
 
  
     
     reference= new JComboBox();
     String refe[]={"Pere","Mere","Oncle","Tante","Soeur","Beau-Pere","Cousin","Cousine","Aucun"};
    reference=new JComboBox(refe);
       
         
         
                       //les boutons
      btsave=new JButton("Enregistrer");
      btnew=new JButton("Nouveau");
      btlist=new JButton("Lister");
      
      
      
		     
	   panel.add(nom);
	   panel.add(txNom);
	   panel.add(prenom);
	   panel.add(txprenom);
	   panel.add(statut);
	   panel.add(cbstatut);
	   panel.add(lieu);
	   panel.add(txLieu);
	   panel.add(Adresse_utilisateur);
	   panel.add(txAdresse);
	   panel.add(dateNaissance);
	   panel.add(txNaissance);
		     
	    panel.add(nif);
	    panel.add(txnif);
	      
	    panel.add(dateInscription);
	    panel.add(txInscription);
			  
	       panel.add(NoDordre);
	       panel.add(txDordre);
	       panel.add(discipline);
	       panel.add(cbdiscipline);
	       
	       panel.add(grou);
	       panel.add(groupe);
	       panel.add(refefe);
	       panel.add(reference);
	      
	       
	      panel.add(refer);
	      panel.add(txPaysreference );
	      
	       panel.add(telephone);
	       panel.add(txtel);
	       
	     
	     panel.add(lettre);
	     panel.add(lettreCombo);
	     panel.add(releve);
	     panel.add(releveCombo);
	     panel.add(photocopie);
	     panel.add(photoCombo);
	     panel.add(attes);
	     panel.add(attesCombo);
	     panel.add(photoC);
	     panel.add(phoCombo);
	     panel.add(releveB);
	     panel.add(releCombo);
	     panel.add(photoAct);
	     panel.add(actCombo);
	     panel.add(certificatB);
	     panel.add(certificatCombo);
	     panel.add(photDi);
	     panel.add(photCombo);
	     panel.add(ensPrimairedebut);
	     panel.add(txensPrimairedebut);
	     panel.add(ensPrimairefin);
	     panel.add(txensPrimairefin);
	     panel.add(etabliAP);
	     panel.add(txEtabliAP);
	     panel.add(etabliBP);
	     panel.add(txEtabliBP);
	     panel.add(etabliCP);
	     panel.add(txEtabliCP);
	    
    
	    
	    panel.add(ensSecondairedebut);
	    panel.add(txensSecondairedebut);
	    panel.add(ensSecondairefin);
	    panel.add(txensSecondairefin);
	    panel.add(etabliAS);
	    panel.add(txEtabliAS);
	    panel.add(etabliBS);
	    panel.add(txEtabliBS);
	    panel.add(etabliCS);
	    panel.add(txEtabliCS);
	    
	    
	    panel.add(ensUniversitairedebut);
	    panel.add(txensUniversitairedebut);
	    panel.add(ensUniversitairefin);
	    panel.add(txensUniversitairefin);
	    panel.add(etabliAU);
	    panel.add(txEtabliAU);
	    panel.add(etabliBU);
	    panel.add(txEtabliBU);
	    panel.add(etabliCU);
	    panel.add(txEtabliCU);
	    
    
     
    	//  affich();
 
	    panBout.setBackground(Color.black);                                                   
	    panel2.add(panE,BorderLayout.SOUTH);                                                     
	    panel2.add(panel,BorderLayout.WEST);
	    //panel2.add(panBout,BorderLayout.WEST);
	    //panel2.add(sc,BorderLayout.EAST);
	    panE.add(btsave);
	
	    //panE.add(btlist);
	    panE.add(btnew);
	    getContentPane().add(panel2);  

       setClosable(true);
	  setResizable(true);
	  setIconifiable(true);
	  setMaximizable(true);
	  btsave.addActionListener(this);
	  btnew.addActionListener(this);
	  btlist.addActionListener(this);
  
    }
  
  private void affich(){
	   imagelb=new JLabel();
	   IconePhoto=new ImageIcon("image/inscri.png");
	   this.imagelb.setBounds(1150,0,350,400);
	   this.imagelb.setIcon(IconePhoto);
	   this.add(imagelb);
	  
	
	   
  }
    
  public void actionPerformed(ActionEvent event){
		if(event.getSource()==btnew )
		nettoyer();
		if(event.getSource()==btsave )
		enregistrer();
		if(event.getSource()==btlist)
		new Enregistrement_Utilisateur();
  }
   
   public void enregistrer(){
//	   JOptionPane.showMessageDialog(null,"Succes!");	  
//	   JOptionPane.showMessageDialog(null,"Erreur sql!");
	   //data.inscription(note(txNom), note(txprenom), note(txNaissance),note(txLieu), note(txnif), note(txInscription), note(txDordre), text(cbstatut), note(txAdresse), note(txtel), text(reference) , note(txPaysreference), text(cbdiscipline), text(groupe));
       //data.dossier(text(lettreCombo), text(releveCombo),  ,releve(attesCombo));	 
	  // data.piece();
	   //data.primaire(note(txensPrimairedebut), note(txensPrimairefin), note(txEtabliAP), note(txEtabliBP), note(txEtabliCP));
		//data.secondaire(note(txensSecondairedebut), note(txensSecondairefin), note(txEtabliAS), note(txEtabliBS), note(txEtabliCS));
		//data.universitaire(note(txensUniversitairedebut), note(txensUniversitairefin), note(txEtabliAU), note(txEtabliBU), note(txEtabliCU));

	   
	   }

public void nettoyer(){
	
	    this.txrefer.setText("");
		this.txNom.setText("");
		this.txPaysreference.setText("");
		this.txnif.setText("");
		this.txInscription.setText("");
		this.txDordre.setText("");
		this.txtel.setText("");
		this.txAdresse.setText("");
		this.txprenom.setText("");
		this.txLieu.setText("");
		this.txNaissance.setText("");
		this.txEtabliAP.setText("");
		this.txEtabliAS.setText("");
		this.txEtabliAU.setText("");
		this.txEtabliBP.setText("");
		this.txEtabliBS.setText("");
		this.txEtabliBU.setText("");
		this.txEtabliCP.setText("");
		this.txEtabliCS.setText("");
		this.txEtabliCU.setText("");
		this.txensPrimairedebut.setText("");
		this.txensPrimairefin.setText("");
		this.txensSecondairedebut.setText("");
		this.txensSecondairefin.setText("");
		this.txensUniversitairedebut.setText("");
		this.txensUniversitairefin.setText(""); 
                    
}
	public String note(JTextField text)
	{
		String texte = text.getText().toString();
		//String lo = text.toString();
		System.out.println(texte);
		return texte;
	}
	
	public String text(JComboBox box)
	{
		String text=""+ box.getSelectedItem();
		System.out.println(text);
		
		return text;
		
	}


}
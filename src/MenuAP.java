import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
public class MenuAP extends JFrame implements ActionListener{

 private JMenuBar menBar;
 private JMenu menUtilisateur,menEnregistrement,menMembre,menTransaction,menAide,menQuitter;
 private JMenuItem menInscrire,menaide,menquit,menAfficher,menEnregistrer;
 private JDesktopPane bureau;
 private JLabel imagelbl;
 private ImageIcon IconePhoto;
 
 
   public MenuAP()
   {
       super("BIENVENUE DANS GESTI-NUKA ");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       bureau=new JDesktopPane();
    setSize(1500,700);
       setVisible(true);
       //creation de JMenuBar
       menBar=new JMenuBar();
       menUtilisateur=new JMenu ("Etudiant");
        menUtilisateur.setMnemonic('E');
       
       menMembre=new JMenu ("Membre");
       menMembre.setMnemonic('M');
     menMembre.setEnabled(false);
        
       menTransaction=new JMenu ("Transaction");
       menTransaction.setMnemonic('T');
     menTransaction.setEnabled(false);
       
       menAide=new JMenu ("Aide");
       menAide.setMnemonic('A');
       
       
       menQuitter=new JMenu ("Quitter");
       menQuitter.setMnemonic('Q');
       
       
       //creation de JMenuItem trouvant dans le menu Utilisateur
        
       menEnregistrement=new JMenu ("Enregistrer");
       
       menAfficher=new JMenuItem ("Afficher");
       //creation de JMenuItem trouvant dans le menu membre
         menEnregistrer=new JMenuItem("Enregistrer");
          menquit=new JMenuItem ("Quitter");
          
          
            menInscrire=new JMenuItem ("Inscrire");
           //ajout de menu  dans JMenuBar 
                     menBar.add(menUtilisateur);
                   
                     menBar.add(menQuitter);
                     
                     
             //ajout de JMenuItem  dans le menubar Utilisateur 
             
                      menUtilisateur.add(menEnregistrement);
                       menUtilisateur.add(new JSeparator());
                      menUtilisateur.add(menAfficher);
                                   
              
                     
              //ajout de JMenuItem  dans le menubar Membre
               menEnregistrement.add(menInscrire);
                      menMembre.add(menEnregistrer);
                      menQuitter.add(menquit);
                      
                //ajout de JMenuItem  dans le menubar Transaction
                  menBar.setBackground(Color.gray);
                 menUtilisateur.setForeground(Color.white); 
                  
                           menQuitter.setForeground(Color.white); 
                  setJMenuBar(menBar);
                 
                   menInscrire.addActionListener(this);
                 menAfficher.addActionListener(this);
                
                 menEnregistrer.addActionListener(this);
                  menquit.addActionListener(this);
                 
                  menEnregistrer.addActionListener(this);
                  
                  affichage();
                  
                 //getContentPane().add(men,BorderLayout.CENTER);
              }    
   
   private void affichage(){
	   imagelbl=new JLabel();
	   IconePhoto=new ImageIcon("image/GESTINUKA.png");
	   this.imagelbl.setBounds(100,100,100,100);
	   this.imagelbl.setIcon(IconePhoto);
	   this.add(imagelbl);
	   
   }
      
        
        public void actionPerformed(ActionEvent event)
       {
        	if(event.getSource().equals(menInscrire)) {
                getContentPane().removeAll();
                     setContentPane(bureau);
                  
                 Formulaire fr=new Formulaire();
                 
                  bureau.add(fr);
            }
                
        	
      
              	if(event.getSource().equals(menAfficher)) {
                      getContentPane().removeAll();
                           setContentPane(bureau);
                        
                       Enregistrement_Utilisateur enregis=new Enregistrement_Utilisateur();
                       
                        bureau.add(enregis);
                  }
                      
        	
        	
         
         
        
         if(event.getSource().equals(menquit))
       {
           getContentPane().removeAll();
         if(JOptionPane.showConfirmDialog(this,"Voulez-vous quitter le programme ?") == JOptionPane.YES_OPTION)
        System.exit(0); 
        
       }
       
       
          
      
       
        if(event.getSource().equals(menEnregistrer))
       {
           getContentPane().removeAll();
           setVisible(true);
           setContentPane(bureau);
           
           
            
              
       }
       
         
        }
        
        
   
   
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Style;
import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;


/**
 *
 * @author USER
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
	private static javax.swing.JTextPane jTextPane1;
	public static String balise = " ";
	public static int var =0;
	public static ArrayList<String> balises  = new ArrayList<String>();
	public static String filename;
    public Interface() throws Exception {
        initComponents();
        ActionMap am = jTextPane1.getActionMap();
        am.put(DefaultEditorKit.insertBreakAction, new Indentation());
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws Exception 
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws Exception {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xml/nouveauFich.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xml/importerUnFich.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					jLabel3MouseClicked(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xml/Sauv.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/xml/fermer.png"))); // NOI18N

        //jTextArea1.setBounds( 50, 50, 100, 50)  ;
        jScrollPane2.setViewportView(jTextPane1);

        jTabbedPane1.addTab("tab1", jScrollPane2);

        jMenu1.setText("Fichier");
        jMenu1.setToolTipText("");

        
        
        jMenuItem1.setText("Nouveau Fichier");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Importer un fichier");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jMenuItem2ActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Enregistrer");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jMenuItem3ActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Enregistrer sous");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jMenuItem4ActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Fermer");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Quitter");
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edition");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);
        panel = new navigateur(chemin);
      
  		
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addGap(18)
        					.addComponent(jLabel2)
        					.addGap(18)
        					.addComponent(jLabel3)
        					.addGap(18)
        					.addComponent(jLabel4))
        				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel5)
        				.addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jLabel1)
        					.addComponent(jLabel2)
        					.addComponent(jLabel3)
        					.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);
        
        
        
        
        
    	
jTextPane1.addKeyListener(new KeyListener(){//verification des caracteres entrés en temps réel
        	
        	public void keyTyped(KeyEvent e) {
        	
               
        		int ascii =(int)e.getKeyChar();
        		
        		int temp=jTextPane1.getCaretPosition()-1;
        		
        		if(jTextPane1.getText().length()==0) balises.clear(); ;
        		
	        		if(ascii <122 && ascii > 48)
	        		{
	        			int position =jTextPane1.getCaretPosition();
	        			
	        			if(e.getKeyChar()=='<')
	        			{
	        				
	        				var-=1;
	        			}
	        			if(e.getKeyChar()=='>' && var==-1)
	        			{
	        				
	        				
	        				System.out.print("Val : "+var+"\n");
		        			if(jTextPane1.getText().charAt(jTextPane1.getCaretPosition()-1)!='/')
		        			{
		        				var+=1;
		        				int p  =jTextPane1.getCaretPosition();
		        				while(jTextPane1.getText().charAt(temp)!='<')
		        				{
		        					if(jTextPane1.getText().charAt(temp)==' ')
		        						balise="";
		        					balise+=jTextPane1.getText().charAt(temp);
		        					temp--;
		        				}	
		        				
		        			StringBuilder lettersBuff = new StringBuilder(balise);
		        			balise = lettersBuff.reverse().toString();
		        			e.consume();
		        			String text=jTextPane1.getText();;
		        			
			        			if( balise!="")
		        				{
		        					
		        					text = jTextPane1.getText();
		        					
		        					
		        					text = text.substring(0,p)+"></"+balise+">"+text.substring(p);
		        						
		        					
		        					jTextPane1.setText(text);
		        					jTextPane1.setCaretPosition(p+1);
		        					//jTextPane1.setText(jTextPane1.getText()+"\t");
		        					
		        					var++;
		        					e.consume();
		        					balise="";
		        				}
			        			
		        			}
		        			else
		        			{
		        				balise="";
		        				var=0;
		        			}
		        		}
	        			
	        			
	        			
	        			
	        		 }
	        		
	        		
	        			
        				
        					
        			
        		
               
				
        	}
			
			public void keyPressed(KeyEvent a) {
				
				
				
				/*
				if (jTextPane1.getCaretPosition()==jTextPane1.getText().length())
	               
							if( a.getKeyCode() == KeyEvent.VK_BACK_SPACE )//si on utilise la touche effacer
							{
								if(balise.length()!=0)
								{
								balise=	balise.substring(0,balise.length()-1) ;//on efface le dernier caractere dans le stokage
								
							
								}	
							}
				*/
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	
    	  
    	});
      
        
        
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        //Souvgarder
          String ch;
         ch=jTextPane1.getText();
         if (i==0) 
        {
           chemin=ouvrirFich();
           if (!"".equals(chemin)) {
                sauvgarder (chemin,ch);
                 i++;
           }
        }
        else {
            sauvgarder (chemin,ch);
        }
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) throws Exception {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
       
       
        chemin= ouvrirFich();
        if (!"".equals(chemin)) {
            String s=importer(chemin);
             jTextPane1.setText(s);
             ((navigateur) panel).initialiser(chemin);
             panel.revalidate();
             panel.repaint();
             jTabbedPane1.setTitleAt(0, filename);
             jTabbedPane1.repaint();
             }
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
       
       chemin=ouvrirFich();
        if (!"".equals(chemin)) {
            String s=importer(chemin);
             jTextPane1.setText(s);
             ((navigateur) panel).initialiser(chemin);
             panel.revalidate();
             panel.repaint();
             jTabbedPane1.setTitleAt(0, filename);
             jTabbedPane1.repaint();
        }
        
                        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        String ch;
         ch=jTextPane1.getText();
         if (i==0) 
        {
           chemin=ouvrirFich();
           if (!"".equals(chemin)) {
                sauvgarder (chemin,ch);
                 i++;
           }
        }
        else {
            sauvgarder (chemin,ch);
        }
         ((navigateur) panel).initialiser(chemin);
         panel.revalidate();
         panel.repaint();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        
           chemin=ouvrirFich();
           if (!"".equals(chemin)) {
                String ch;
                 ch=jTextPane1.getText();
                sauvgarder (chemin,ch);
                 i++;
           } 
           ((navigateur) panel).initialiser(chemin);
           panel.revalidate();
           panel.repaint();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        
    }

    
    public static void refreshTexte(String chemin)
    {
    	String s=importer(chemin);
        jTextPane1.setText(s);
    }
  
   
    public String ouvrirFich()
    {
     String path;
        path = "";
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files","xml");
        chooser.setFileFilter(filter);
        chooser.setVisible(true);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) 
        {
            File file = chooser.getSelectedFile();
            path=file.getPath();
        }
        filename=chooser.getName(chooser.getSelectedFile());
        return (path);
    }
       public void sauvgarder(String f, String ch)
    {
       
      
	//on va chercher le chemin et le nom du fichier et on me tout ca dans un String
	String adressedufichier = f;

	//on met try si jamais il y a une exception
	try
	{
		
		FileWriter fw = new FileWriter(adressedufichier, false);
		
		// le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
		BufferedWriter output = new BufferedWriter(fw);
		
		//on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
		String Newligne=System.getProperty("line.separator"); 
              
		output.write(ch+Newligne);
		//on peut utiliser plusieurs fois methode write
		
		output.flush();
		//ensuite flush envoie dans le fichier, ne pas oublier cette methode pour le BufferedWriter
		
		output.close();
		//et on le ferme
		
                
	}
	catch(IOException ioe){
		System.out.print("Erreur : ");
                
		}

}
      public static String importer (String chemin)
      {
          String ch,s ="";
          
           try {
 
        BufferedReader in ;
        in= new BufferedReader(new FileReader(chemin));
        do {
          ch = in.readLine();
          if (ch != null) {
           String Newligne=System.getProperty("line.separator"); 
           s+=ch+ Newligne;   
          }
        }
        while (ch != null);
      }
          
      catch (IOException ex) {
        System.out.println(ex.toString());
      }
           return s;
   
      }
  
      
      
     
     
		
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
   
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
    private String chemin="";
    private int i=0;
    private JPanel panel;
}
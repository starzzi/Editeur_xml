package xml;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class navigateur extends JPanel implements MouseListener {
	
	
	private static JTree xmlTree = new JTree();
	private static  Element racine;
	private static Element copie;
	private static Element amodif;
	private static Document xmlDoc;
	private static TreePath tp;
	public static JPopupMenu menu = new JPopupMenu();
	static DefaultMutableTreeNode tn;
	
	private static DefaultMutableTreeNode noeud;
	private static DefaultMutableTreeNode noeud2;
	private static DefaultMutableTreeNode parent;
	private static List<Element> liste ;
	private static ArrayList<Integer> index= new ArrayList<Integer>();
	private static String chemin;
	private static int collerEnabled;
	
	private static JMenuItem choix1 = new JMenuItem("supprimer");
	private static JMenuItem choix2 = new JMenuItem("renommer");
	private static JMenuItem choix3 = new JMenuItem("copier");
	private static JMenuItem choix4 = new JMenuItem("ajouter element");
	private static JMenuItem choix5 = new JMenuItem("coller");
	private static JMenuItem choix6 = new JMenuItem("couper");

	/**
	 * Create the panel.
	 */
	public navigateur(String chemin2) throws Exception {
		xmlTree.repaint();
		initPopup();
		initialiser(chemin2);
		gestionPopup();

	}
	
	public void initialiser(String chemin2) throws Exception
	{
		if (chemin2!=""){
			collerEnabled=0;
					
					chemin=chemin2;
					Document doc = declareDocument();
					this.xmlDoc = doc;
					this.racine = this.xmlDoc.getRootElement();
			        tn= new DefaultMutableTreeNode("XML");
			    	xmlTree.setName("XML Tree");
					JScrollPane scrollPane = new JScrollPane(xmlTree);
					add(scrollPane, BorderLayout.CENTER);
					rechercheElement(xmlDoc.getRootElement(), tn);
					((DefaultTreeModel)xmlTree.getModel()).setRoot(tn);
					xmlTree.addMouseListener(this);
					
					
					xmlTree.setVisible(true);
					xmlTree.setDragEnabled(false);
					xmlTree.setEditable(true);
					xmlTree.expandRow(1);
			    	}

	}
	
	private static void elementAModif()
	{
		int i=0;
		
		tp = xmlTree.getSelectionPath();
		if(tp != null)
		{
			noeud = (DefaultMutableTreeNode) (tp.getLastPathComponent());
			noeud2= noeud;
			parent= (DefaultMutableTreeNode) noeud2.getParent();
			index.clear();
			do
			{
				parent=(DefaultMutableTreeNode) noeud2.getParent();
				index.add(parent.getIndex(noeud2));
			   	noeud2= parent;					   
			}while(!parent.isRoot());
			amodif=racine;
			for(i=index.size()-2;i>=0;i--)
			{
				liste=amodif.getChildren();
				int nbatt= amodif.getAttributes().size();
				amodif=liste.get(index.get(i)-nbatt);
		 	}
		}
	}
	
	private static void refreshAll()
	{
		tn= new DefaultMutableTreeNode("XML");
	    rechercheElement(xmlDoc.getRootElement(), tn);
	    ((DefaultTreeModel)xmlTree.getModel()).setRoot(tn);
	    xmlTree.repaint();
	    enregistrer(xmlDoc,chemin);
	    xmlTree.expandRow(1);
	    Interface.refreshTexte(chemin);
	}
	
	private static void initPopup()
	{
		 choix1 = new JMenuItem("supprimer");
		 choix2 = new JMenuItem("renommer");
		 choix3 = new JMenuItem("copier");
		 choix4 = new JMenuItem("ajouter element");
		 choix5 = new JMenuItem("coller");
		 choix6 = new JMenuItem("couper");
		 
		 menu.add(choix1);
		    menu.add(choix2);
		   	menu.add(choix3);
		   	menu.add(choix4);
		   	menu.add(choix5);
		   	menu.add(choix6);
	}
	
	private static void gestionPopup()
	{
		
		
		
		choix1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane jop = new JOptionPane();            
				int option = jop.showConfirmDialog(null, "Voulez-vous vraiment supprimer ce noeud et tous ses fils  ?", "Suppression de noeud", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            	if(option == JOptionPane.OK_OPTION)
            	{
					elementAModif();
					amodif.detach();
					refreshAll();
            	}
			}
		});
				
		choix2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane jop = new JOptionPane();
			    String nom = jop.showInputDialog(null, "Veuillez saisir le nouveau nom", JOptionPane.QUESTION_MESSAGE);
			    elementAModif();
				amodif.setName(nom);
				refreshAll();
			}
		});
		
		choix3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				collerEnabled=1;
				elementAModif();
				copie=amodif;
			}
		});
				
		choix4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane jop = new JOptionPane();
			    String nom = jop.showInputDialog(null, "Veuillez saisir le nom du nouvel element", JOptionPane.QUESTION_MESSAGE);
			   	elementAModif();
				Element nouveau = new Element(nom);
				amodif.addContent(nouveau);
				refreshAll();
				
			}
		});
		
		choix5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(collerEnabled==1)
				{
					elementAModif();
					amodif.addContent(copie.clone());
					refreshAll();
					collerEnabled=0;
				}
				else
				{
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null, "Rien ne peut etre coller, veuilez copier/couper un noeud avant", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		choix6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				collerEnabled=1;
				elementAModif();
				copie=amodif;
				amodif.detach();
				refreshAll();
			}
		});
				
		
   	}
	
	
	private static Document declareDocument() throws Exception
	{
		File xml=new File(chemin);
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(xml);
		return doc;
	}
	
	 private static void rechercheElement(Element el, DefaultMutableTreeNode dmtn)
	 {
		 DefaultMutableTreeNode noeudCourant = new DefaultMutableTreeNode(el.getName());
		 String texte = el.getTextNormalize();
		 
		 if((texte != null) && (!texte.equals("")))
		 {
			 noeudCourant.add(new DefaultMutableTreeNode("#"+texte));
		 }
		 rechercheAttributs(el, noeudCourant);
		 Iterator children = el.getChildren().iterator();

		 while(children.hasNext())
		 {
			 rechercheElement((Element)children.next(), noeudCourant);
		 }
		 dmtn.add(noeudCourant);
	 }

	 private static void rechercheAttributs(Element el, DefaultMutableTreeNode dmtn) 
	 {
		 Iterator atts = el.getAttributes().iterator();

		 while(atts.hasNext())
		 {
			 Attribute att = (Attribute) atts.next();
			 DefaultMutableTreeNode attNoeud = new DefaultMutableTreeNode("@"+att.getName());
			 attNoeud.add(new DefaultMutableTreeNode(att.getValue()));
			 dmtn.add(attNoeud);
		 }
	 }
	 
	 static void enregistrer(Document document,String fichier)
	 {
	    try
	    {
	       XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	       sortie.output(document, new FileOutputStream(fichier));
	    }
	    catch (java.io.IOException e){}
	 }

		@Override
	public void mouseReleased(MouseEvent e)
    {
        if(e.getButton()==MouseEvent.BUTTON1)
        {
        }
	    else if(e.getButton()==MouseEvent.BUTTON2)
	    {
	    }
	    else if(e.getButton()==MouseEvent.BUTTON3)
	    {
	    	tp = xmlTree.getPathForLocation(e.getX(), e.getY());
	    	if (tp != null)
	    	{
	    		xmlTree.setSelectionPath(tp);
	    		String nom = new String();
	    		nom = xmlTree.getLastSelectedPathComponent().toString();
	    		if((!nom.startsWith("#"))&& (!nom.startsWith("@")))
	    		{
	    			menu.show(e.getComponent(), e.getX(), e.getY());
	    		}
	    	}
	    }
    } 
	 
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

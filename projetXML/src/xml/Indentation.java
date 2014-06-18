package xml;

import java.awt.event.ActionEvent;


import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;



@SuppressWarnings("serial")
public class Indentation extends TextAction{
	 
	public Indentation()
     {
          super(DefaultEditorKit.insertBreakAction);
     }

     /**
      * The operation to perform when this action is triggered.
      *
      * @param e the action event
      */
     public void actionPerformed(ActionEvent e)
     {
    	 JTextComponent ZoneText = getTextComponent(e);

         try
         {
             //  Determine la ligne courante
        	 Document doc = (Document) ZoneText.getDocument();
        	 Element rootElement = doc.getDefaultRootElement();
             int SelecDebut = ZoneText.getSelectionStart();
             int ligne = rootElement.getElementIndex( SelecDebut );
             int debut = rootElement.getElement(ligne).getStartOffset();
             int fin = rootElement.getElement(ligne).getEndOffset();
             int length = fin - debut;
             String text = doc.getText(debut, length);
             int i = 0;

             for (i = 0; i < length;i++)
               	{
            	 	char c = text.charAt(i);
                    if (c != ' ' && c != '\t')
                         break;
               	}

             if (SelecDebut - debut > i)
               	{
            	 	ZoneText.replaceSelection("\n" + text.substring(0, i)+"      \n"+ text.substring(0, i) );
            	 	ZoneText.setCaretPosition(rootElement.getElement(rootElement.getElementIndex(ZoneText.getSelectionStart()) - 1).getEndOffset() - 1);
               	}
             else           	   
                ZoneText.replaceSelection("\n");
          }
          catch(BadLocationException ble) {}
     }
}



package xml;

import java.awt.event.ActionEvent;

import javax.swing.UIManager;
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
          JTextComponent target = getTextComponent(e);

          if (target == null) return;

          if ((! target.isEditable()) || (! target.isEnabled()))
          {
               UIManager.getLookAndFeel().provideErrorFeedback(target);
               return;
          }

          try
          {
               //  Determine which line we are on

               Document doc = (Document) target.getDocument();
               Element rootElement = doc.getDefaultRootElement();
               int selectionStart = target.getSelectionStart();
               int line = rootElement.getElementIndex( selectionStart );

               //  Get the text for this line

               int start = rootElement.getElement(line).getStartOffset();
               int end = rootElement.getElement(line).getEndOffset();
               int length = end - start;
               String text = doc.getText(start, length);
               int offset = 0;

               //  Get the number of white spaces characters at the start of the line

               for (offset = 0; offset < length; offset++)
               {
                    char c = text.charAt(offset);

                    if (c != ' ' && c != '\t')
                         break;
               }

               //  When splitting the text include white space at start of line
               //  else do default processing

               if (selectionStart - start > offset)
               {
                    target.replaceSelection("\n" + text.substring(0, offset)+"      \n"+ text.substring(0, offset) );
                     target.setCaretPosition(rootElement.getElement(rootElement.getElementIndex(target.getSelectionStart()) - 1).getEndOffset() - 1);
               }
                     else
                    target.replaceSelection("\n");
          }
          catch(BadLocationException ble) {}
     }
}



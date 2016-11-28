package invoker;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import receiver.java.model.Buffer;
import receiver.java.model.MoteurEditionImplementation;
import command.*;
import client.Editeur;


public class notepad extends JFrame implements Observer{   
	
	private Editeur e;
	private MoteurEditionImplementation mei;
	
	//command
	private command copierC;
	private command couperC;
	private command collerC;
	private command selectionC;
	private command insererC;
	private command supprimerC;
	
	//swing interface
	private JButton copier;
	private JButton couper;
	private JButton coller;
  //private JButton selection;
	private JTextArea textArea;
	
	//Int debut fin de la selection
	int[] debutfin = new int[2];
	
	//Recup valeur du textarea
	private String contentTextField = "";
	
  public notepad(Editeur editeur) {
	  
	  	copierC = new copier(editeur);
		couperC = new couper(editeur,this);
		collerC = new coller(editeur);
		selectionC = new Selectionner(editeur, this);
		supprimerC = new supprimer_texte(editeur,this);
		insererC = new inserer_texte(editeur,this);
		
	  
	  	e = editeur;
	  
	  	this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Editeur de texte");

		// Creation du JPanel principal
		JPanel mainPanel = new JPanel();
		// Creation du BorderLayout
		mainPanel.setLayout(new BorderLayout());
		// Ajout du JPanel a la JFrame
		this.add(mainPanel);

		// Initialisation des boutons
		copier = new JButton("Copier");
		couper = new JButton("Couper");
		coller = new JButton("Coller");

		// Desactivation boutons
		coller.setEnabled(false);
		
		JPanel upperPanel = new JPanel();
		upperPanel.add(copier);
		upperPanel.add(couper);
		upperPanel.add(coller);
		mainPanel.add(upperPanel, BorderLayout.NORTH);

		// Creation du JTextArea
		textArea = new JTextArea();
		Font f = new Font("Times New Roman", Font.PLAIN, 18);
		textArea.setFont(f);
		mainPanel.add(textArea, BorderLayout.CENTER);
		textArea.getDocument().addDocumentListener(new MyDocumentListener());
	    textArea.getDocument().putProperty("name", "Text Area");
		
		//ajout des listener
		commandButton cb = new commandButton();
		commandSelection cS = new commandSelection();
	//	commandInserer cI = new commandInserer();
	//	textArea.addKeyListener(cI);
		textArea.addCaretListener(cS);
		copier.addActionListener(cb);
		coller.addActionListener(cb);
		couper.addActionListener(cb);

		this.setVisible(true);
	  
  }
  
  	private class MyDocumentListener implements DocumentListener {
  		
	    final String newline = "\n";
	
	    public void insertUpdate(DocumentEvent e) {
	       updateLog(e, "inserted into");
	        
	        try{
				
	       // 	insererC.execute();
			}
			catch(RuntimeException r){
						
			}	
	     
	    }
	    public void removeUpdate(DocumentEvent e) {
	    	
	    	updateLog(e, "removed from");
	    	
	    	
	    	try{
				
	    		supprimerC.execute();
	    		
	 			}
	 			catch(RuntimeException r){
	 						
	 			}	
   	
	      
	    }
	    public void changedUpdate(DocumentEvent e) {
	        //Plain text components don't fire these events.
	    }
	
	    public void updateLog(DocumentEvent e, String action) {
	        Document doc = (Document)e.getDocument();
	        int changeLength = e.getLength();
	       
		    //le contenue de textArea
	       
	        System.out.println(textArea.getText());
	       
	          //Les informations sur le contenue de textArea
	       /*    
	          System.out.println(
	              changeLength + " character"
	            + ((changeLength == 1) ? " " : "s ")
	            + action + " " + doc.getProperty("name") + "."
	            + newline
	            + "  Text length = " + doc.getLength() + newline);
	        */
	          contentTextField = textArea.getText();   
	          try{
					
		        	insererC.execute();
		        	
		      //  	System.out.println(contentTextField);
				}
				catch(RuntimeException r){
							
				}	
	          
	          try{
					
		        	supprimerC.execute();
		        	
		        	
		      //  	System.out.println(contentTextField);
				}
				catch(RuntimeException r){
							
				}	
		     
	          
	
      }
  }
  	
  	public String getContentTextField(){
  		return contentTextField;
  	}
  	
	/*
	//This listens for and reports caret movements.
  	private class CaretListenerLabel extends JTextArea implements CaretListener {	 
  		//Might not be invoked from the event dispatch thread.
  		public void caretUpdate(CaretEvent e) {
  			displaySelectionInfo(e.getDot(), e.getMark());
  		}

	     //This method can be invoked from any thread.  It 
	     //invokes the setText and modelToView methods, which 
	     //must run on the event dispatch thread. We use
	     //invokeLater to schedule the code for execution
	     //on the event dispatch thread.
	     public void displaySelectionInfo(final int dot,
	                                         final int mark) {
	         SwingUtilities.invokeLater(new Runnable() {
	        	 final String newline = "\n";
	        	 public void run() {
	                 if (dot == mark) {  // no selection
	                     try {
	                         Rectangle caretCoords =  textArea.modelToView(dot);   
	                         //Convert it to view coordinates.
	                         
	                         System.out.println("caret: text position: " + dot
	                                 + ", view location = ["
	                                 + caretCoords.x + ", "
	                                 + caretCoords.y + "]"
	                                 + newline);
	                     } catch (BadLocationException ble) {
	                    	 System.out.println("caret: text position: " + dot + newline);
	                     }
	                 } else if (dot < mark) {
	                	 System.out.println("selection from: " + dot
	                             + " to " + mark + newline);
	                 } else {
	                	 System.out.println("selection from: " + mark
	                             + " to " + dot + newline);
	                 }
	             }
	         });
	     }
  	}
  	*/
  	public int[] getSelectionDebutFin(){
  		return debutfin;
  	}
	
  	//Permet de récupérer les entier de la selection et de lancer la command selectionC
  	
  	/*
  	private class commandInserer implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			if (!e.isActionKey()) {
				if ((int) e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					supprimerC.execute();
				
				} 
				 else if ((int) e.getKeyChar() == KeyEvent.VK_DELETE) {
					e.consume();
				
				}
				
				}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyTyped(KeyEvent e) {
			if ((int) e.getKeyChar() != KeyEvent.VK_BACK_SPACE 
					&& (int) e.getKeyChar() != KeyEvent.VK_DELETE) {
			//	newChar = e.getKeyChar();
			//	inserer_texte.execute();
			}	
		}
  	}
  	
  	*/
  	
  	private class commandSelection implements CaretListener {
		public void caretUpdate(CaretEvent e) {
		    //String newline = "\n";
			int newDebut = Math.min(e.getDot(), e.getMark());
			int newFin = Math.max(e.getDot(), e.getMark());
			 
			if (newDebut == newFin) {  // no selection
				  
                  try {
                      Rectangle caretCoords = textArea.modelToView(newDebut);
                      //Convert it to view coordinates.
                     /* System.out.println("Position du texte: " + newDebut
                              + ", Les coordonnées de l'emplacement = ["
                              + caretCoords.x + ", "
                              + caretCoords.y + "]"
                              + newline);*/
                  } catch (BadLocationException ble) {
                	 // System.out.println("Position du texte : " + newDebut + newline);
                  }
              }
			  
			if (newDebut != newFin) {

					try{
						debutfin[0] = newDebut;
						debutfin[1] = newFin;
						selectionC.execute();
					}
					catch(RuntimeException r){
								
					}	
				
				}
			}
	}
	

  	//Lance les command collerC copierC et couperC
	private class commandButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				if (e.getSource() == copier) {
					coller.setEnabled(true);
					copierC.execute();
				} else if (e.getSource() == couper) {
					couperC.execute();
					textArea.setText(contentTextField);
					coller.setEnabled(true);
				} else if (e.getSource() == coller)
					collerC.execute();
			}
	  }
	  	  
	  public void update(String contenu) {
			textArea.setText(contenu);
	  }
	  
	}

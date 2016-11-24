package invoker;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import receiver.java.model.MoteurEditionImplementation;
import command.*;
import client.Editeur;

public class notepad extends JFrame implements Observer{   
	
	private Editeur e;
	
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
	private JTextArea textArea;
	
  public notepad(Editeur editeur) {
	  
	  	e = editeur;
	  
	  	this.setSize(650, 650);
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
		
		//ajout des listener
		commandButton cb = new commandButton();
		copier.addActionListener(cb);
		coller.addActionListener(cb);
		couper.addActionListener(cb);

		this.setVisible(true);
	  
  }
  
  private class commandButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == copier) {
				coller.setEnabled(true);
				copierC.execute();
			} else if (e.getSource() == couper) {
				couperC.execute();
				coller.setEnabled(true);
			} else if (e.getSource() == coller)
				collerC.execute();
		}
  }
  
    
	  
  public void update(String contenu) {
		textArea.setText(contenu);
  }
  
}

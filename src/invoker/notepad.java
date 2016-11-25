package invoker;
import javax.swing.*
;import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

	private JButton selection;

	private JTextArea textArea;

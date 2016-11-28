package command;
import receiver.java.model.MoteurEditionImplementation;
import client.Editeur;
import invoker.notepad;

public class inserer_texte implements command{
	
	private Editeur editeur;
	private notepad notepad;

	   public inserer_texte(Editeur e, notepad n){
	      editeur = e;
	      notepad = n;
	   }

	   public void execute() {
	      editeur.getMei().inserer_texte(notepad.getContentTextField());
	   }

}
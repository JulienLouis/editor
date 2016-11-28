package command;
import client.Editeur;
import invoker.notepad;
import receiver.java.model.MoteurEditionImplementation;

public class couper implements command{
	
	private Editeur editeur;
	private notepad notepad;

	   public couper(Editeur e, notepad n){
	      editeur = e;
	      notepad = n;
	   }

	   public void execute() {
	      editeur.getMei().couper();
	      notepad.update(editeur.getMei().buf.getTexte().toString());
	   }

}

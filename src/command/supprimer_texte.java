package command;
import invoker.notepad;
import client.Editeur;
import receiver.java.model.MoteurEditionImplementation;

public class supprimer_texte implements command{
	
	private Editeur editeur;
	private notepad notepad;

	public supprimer_texte(Editeur e,notepad n){
		editeur = e;
		notepad = n;
	}

	public void execute() {
		editeur.getMei().supprimer_texte();
		notepad.update(editeur.getMei().buf.getTexte().toString());	
	}

}
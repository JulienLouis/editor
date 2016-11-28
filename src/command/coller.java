package command;
import invoker.notepad;
import client.Editeur;
import receiver.java.model.MoteurEditionImplementation;

public class coller implements command{
	
	private Editeur editeur;
	private notepad notepad;


	public coller(Editeur e, notepad n){
		editeur = e;
		notepad = n;
	}

	public void execute() {
		editeur.getMei().coller();
		//notepad.update(editeur.getMei().buf.getTexte().toString());
	}
}

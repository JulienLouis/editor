package command;
import client.Editeur;
import receiver.java.model.MoteurEditionImplementation;

public class supprimer_texte implements command{
	
	private Editeur editeur;

	public supprimer_texte(Editeur e){
		editeur = e;
	}

	public void execute() {
		editeur.getMei().supprimer_texte();
	}

}
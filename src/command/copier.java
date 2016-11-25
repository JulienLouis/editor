package command;
import client.Editeur;
import receiver.java.model.MoteurEditionImplementation;

public class copier implements command{
	
	private Editeur editeur;

	public copier(Editeur e){
		editeur = e;
	}

	public void execute() {
		editeur.getMei().copier();
	}

}

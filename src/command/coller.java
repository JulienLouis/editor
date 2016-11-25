package command;
import client.Editeur;
import receiver.java.model.MoteurEditionImplementation;

public class coller implements command{
	
	private Editeur editeur;

	public coller(Editeur e){
		editeur = e;
	}

	public void execute() {
		editeur.getMei().coller();
	}
}

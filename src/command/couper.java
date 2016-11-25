package command;
import client.Editeur;
import receiver.java.model.MoteurEditionImplementation;

public class couper implements command{
	
	private Editeur editeur;

	   public couper(Editeur e){
	      editeur = e;
	   }

	   public void execute() {
	      editeur.getMei().couper();
	   }

}

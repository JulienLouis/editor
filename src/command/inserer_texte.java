package command;
import receiver.java.model.MoteurEditionImplementation;

public class inserer_texte implements command{
	
	private MoteurEditionImplementation moteurEI;

	   public inserer_texte(MoteurEditionImplementation moteur){
	      this.moteurEI = moteur;
	   }

	   public void execute() {
	      moteurEI.inserer_texte("kjfnvjnb");
	   }

}
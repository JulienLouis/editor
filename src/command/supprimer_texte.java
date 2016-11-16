package command;
import receiver.java.model.MoteurEditionImplementation;

public class supprimer_texte implements command{
	
	private MoteurEditionImplementation moteurEI;

	   public supprimer_texte(MoteurEditionImplementation moteur){
	      this.moteurEI = moteur;
	   }

	   public void execute() {
	      moteurEI.supprimer_texte();
	   }

}
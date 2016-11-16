package command;
import receiver.java.model.MoteurEditionImplementation;

public class copier implements command{
	
	private MoteurEditionImplementation moteurEI;

	   public copier(MoteurEditionImplementation moteur){
	      this.moteurEI = moteur;
	   }

	   public void execute() {
	      moteurEI.copier();
	   }

}

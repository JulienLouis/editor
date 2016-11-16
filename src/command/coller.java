package command;
import receiver.java.model.MoteurEditionImplementation;

public class coller implements command{
	
	private MoteurEditionImplementation moteurEI;

	   public coller(MoteurEditionImplementation moteur){
	      this.moteurEI = moteur;
	   }

	   public void execute() {
	      moteurEI.coller();
	   }

}

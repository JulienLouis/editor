package command;
import receiver.java.model.MoteurEditionImplementation;

public class couper implements command{
	
	private MoteurEditionImplementation moteurEI;

	   public couper(MoteurEditionImplementation moteur){
	      this.moteurEI = moteur;
	   }

	   public void execute() {
	      moteurEI.couper();
	   }

}

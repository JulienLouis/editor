package receiver.java.model;

import invoker.Observer;

public interface Subject {
	
	 public void attach(Observer observer);
	 
	 public void remove(Observer o);
	 
	 public void notifyObserver();
	
}

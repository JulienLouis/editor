package client;

import receiver.java.model.*;
import command.*;
import invoker.*;

public class Editeur {
	
	private MoteurEditionImplementation mei = new MoteurEditionImplementation();
	
	private Observer notepad;
	
	public Editeur() {
		mei = new MoteurEditionImplementation();
		notepad = new notepad(this);
	}
	
	/**
	 * {@link Editeur#moteur}
	 */
	public MoteurEditionImplementation getMei() {
		return mei;
	}
	
	public void main(String[] args) {
		Editeur editeur = new Editeur();
		Observer notepad = editeur.notepad;
		
		////editeur.getMei().register(notepad); ????
	}
	
	
}

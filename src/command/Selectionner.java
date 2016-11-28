package command;

import client.Editeur;
import invoker.notepad;


public class Selectionner implements command{
	
	private Editeur editeur;
	private notepad notepad;
	
	public Selectionner(Editeur newEditeur,  notepad newNotepad) {
		editeur = newEditeur;
		notepad = newNotepad;
	}
	
	public void execute() { 
		int[] debutFin = notepad.getSelectionDebutFin();
		// System.out.println(debutFin+" la selection dans command");
		editeur.getMei().selectionner(debutFin[0], debutFin[1]);
	}

}

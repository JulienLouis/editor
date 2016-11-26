package receiver.java.model;
import static org.junit.Assert.*;
import invoker.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

import receiver.java.model.*;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class MoteurEditionImplementation implements MoteurImplementation, Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	public Selection select = new Selection();
	public Buffer buf = new Buffer();
	public PressePapier pp = new PressePapier();

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * 
	 * @generated
	 * @ordered
	 */
	
	
	public void couper(){
		int d = select.getDebut();
		int f = select.getFin();
		//select.defBornes(d,f);		//Permet de connaitre les bornes de la selection
		if (d != f){	//Permet de ne pas supprimer le pp si rien n'est selectionnï¿½
			pp.contenu_presse_papier = "";
		}
		for (int i = d; i < f; i++){		//ajoute le contenu de la selection dans le presse papier
			pp.contenu_presse_papier = pp.contenu_presse_papier + buf.zone_texte.charAt(i);
		}
		supprimer_texte();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void copier(){
		int d = select.getDebut();
		int f = select.getFin();
			if (d != f){	//Permet de ne pas supprimer le pp si rien n'est selectionnï¿½
				pp.contenu_presse_papier = "";
				
			}
			for (int i = d; i < f; i++){		//ajoute le contenu de la selection dans le presse papier
				pp.contenu_presse_papier = pp.contenu_presse_papier + select.getSelection().charAt(i);
			}	
	
		System.out.println(pp.contenu_presse_papier);
		System.out.println("test");
	}
	
		
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void coller() {
		int d = select.getDebut();
		int f = select.getFin();//Determine ou est coller la selection
		buf.zone_texte = buf.zone_texte.replace(d, f, pp.contenu_presse_papier);	//colle la selection entre les bornes de la selection
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Set<Selection> selection;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Set<PressePapier> pressePapier;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Set<Buffer> buffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void selectionner(int d, int f){
		String newline = "\n";
		
		if(f ==d){ //No selection
			System.out.println("Il n'y a pas de selection" + newline);
		}
		else if(d < f){
			System.out.println("Selection de "+ d + " jusqu'a " + f + newline);
		}
		else{
			System.out.println("Selection de "+ f + " jusqu'a " + d + newline);
		}
		
			String stringSelectionnee = buf.zone_texte.substring(d, f);
			select.setSelection(stringSelectionnee);
			select.setDebut(d);
			select.setFin(f);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void inserer_texte(String text){
		int d = select.getDebut();
		int f = select.getFin();//Determine ou est inserer le texte
		buf.zone_texte =  buf.zone_texte.replace(d, f,text);
	}
	
	public void supprimer_texte(){
		int d = select.getDebut();
		int f = select.getFin();//Determine la selection supprimï¿½e
		buf.zone_texte.delete(d, f);
	}
	
	
	//Méthode de Subject
	 public void attach(Observer observer){
	      observers.add(observer);		
	   }
	   
	   public void remove(Observer o) {
			int observerIndex = observers.indexOf(o);
			observers.remove(observerIndex);
	   }

	   public void notifyObserver() {
			for (Observer o : observers) {
				o.update(buf.zone_texte.toString());
			}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public MoteurEditionImplementation(){
		super();
	}

}


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
	 * @ordered)
	 */
	
	
	public void couper(){
		System.out.println("selection : "+select.getSelection());
		pp.setPP(select.getSelection());
		/*int d = select.getDebut();
		int f = select.getFin();
		String content = "";
		//select.defBornes(d,f);		//Permet de connaitre les bornes de la selection
		if (d != f){	//Permet de ne pas supprimer le pp si rien n'est selectionnï¿½
			pp.setPP("");
		}
		for (int i = d+1; i+d < f; i++){		//ajoute le contenu de la selection dans le presse papier
			content = content + select.getSelection().charAt(i);
			pp.setPP(content);			
		}*/
		supprimer_texte();
		notifyObserver();
		System.out.println("couper "+pp.getPP());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void copier(){
		System.out.println(select.getDebut());
		System.out.println(select.getFin());
		System.out.println(select.getSelection());
		pp.setPP(select.getSelection());
	/*	int d = select.getDebut();
		int f = select.getFin();
		System.out.println(d + " " + f);
		String content = "";
		if (d != f){	//Permet de ne pas supprimer le pp si rien n'est selectionnï¿½
			pp.setPP("");
		}
		for (int i = d; i+d < f-1; i++){		//ajoute le contenu de la selection dans le presse papier
			content = content + select.getSelection().charAt(i);
			System.out.println("dans le for : "+content);
			pp.setPP(content);	
		}	
	*/
			System.out.println("copier "+pp.getPP());
		//System.out.println("test");
	}
	
		
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void coller() {
		System.out.println("coller : " + pp.getPP());
		System.out.println(select.getDebut());
		System.out.println(select.getFin());
		System.out.println(select.getSelection());
		int d = select.getDebut();
		int f = select.getFin();//Determine ou est coller la selection
		buf.insert(d, f, pp.getPP());	//colle la selection entre les bornes de la selection
		System.out.println("Buffer : "+buf.getTexte());
		notifyObserver();
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
		
		
			//System.out.println("Selection de "+ f + " jusqu'a " + d + newline);
			//System.out.println("d = "+d+" f = "+f);
			System.out.println("buffer "+buf.getTexte());
			System.out.println("on s�lectionne au "+ d +" "+ f);
			select.setDebut(d);
			select.setFin(f);
			String stringSelectionnee = buf.zone_texte.substring(d, f);
			select.setSelection(stringSelectionnee);
			
		
		
			
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
		buf.setTexte(text);
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


package receiver.java.model;
import static org.junit.Assert.*;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import receiver.java.model.*;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class MoteurEditionImplementation implements MoteurImplementation
{
	
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
		if (d != f){	//Permet de ne pas supprimer le pp si rien n'est selectionné
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
		if (d != f){	//Permet de ne pas supprimer le pp si rien n'est selectionné
			pp.contenu_presse_papier = "";
		}
		for (int i = d; i < f; i++){		//ajoute le contenu de la selection dans le presse papier
			pp.contenu_presse_papier = pp.contenu_presse_papier + buf.zone_texte.charAt(i);
		}	
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
		int f = select.getFin();//Determine la selection supprimée
		buf.zone_texte.delete(d, f);
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


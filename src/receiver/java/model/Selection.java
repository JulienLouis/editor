package receiver.java.model;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Selection
{

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int debut;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int fin;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private String contenuSelection;
	
	public Set<MoteurEditionImplementation> moteurEditionImplementation;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Selection(){
		super();
	}
	
	public int getDebut(){
		return debut;
	}
	
	public int getFin(){
		return fin;
	}
	
	public void setDebut(int d){
		debut = d;
	}
	
	public void setFin(int f){
		fin = f;
	}
	
	public String getSelection(){
		return contenuSelection;
	}
	
	public void setSelection(String s){
		contenuSelection = s;
	}
	
	/*public void defBornes(int d, int f){
		debut = d;
		fin = f;
	}*/
	
	

}


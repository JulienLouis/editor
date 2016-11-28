package receiver.java.model;

import java.util.Set;
import java.util.HashSet;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public class Buffer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public StringBuffer zone_texte;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public Set<MoteurEditionImplementation> moteurEditionImplementation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Buffer() {
		setTexte("");
	}

	public void setTexte(String texte) {
		zone_texte = new StringBuffer(texte);
	}

	public StringBuffer getTexte() {
		return zone_texte;
	}
	
	public void insert(int start, int end, String string) {
		zone_texte.delete(start, end);
		zone_texte.insert(start, string); 
}

}

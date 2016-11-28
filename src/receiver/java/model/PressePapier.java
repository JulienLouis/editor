package receiver.java.model;
import java.util.Set;
import java.util.HashSet;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class PressePapier
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private String contenu_presse_papier;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Set<MoteurEditionImplementation> moteurEditionImplementation;
	
	public void setPP(String newPP){
		contenu_presse_papier = newPP;
	}
	
	public String getPP(){
		return contenu_presse_papier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public PressePapier(){
		super();
	}

}


package editor;
import java.util.Set;
import java.util.HashSet;
import receiver.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestMoteurEditionImplementation {
	

	@Test
	public void test() {
		MoteurEditionImpl moteur = new MoteurEditionImpl();
		moteur.getBuffer().setContenu("coincoin");
		moteur.getPressePapier().setContenu("");
		moteur.selectionner(8, 8);
		moteur.saisir(" toucan");//cas à la fin de la chaine
		assertEquals("L'insertion en fin de chaine n'est pas la bonne ou pas au bon endroit", moteur.getBuffer().getContenu().substring(8, moteur.getBuffer().getContenu().length()), " toucan");
		moteur.selectionner(8, 8);
		moteur.saisir(" dindon");//cas au milieu de la chaine
		assertEquals("L'insertion en milieu de chaine n'est pas la bonne ou pas au bon endroit", moteur.getBuffer().getContenu().substring(8, 15), " dindon");
		moteur.selectionner(0, 8);
		moteur.saisir("canard");//cas au début de la chaine et en remplaçant du texte
		assertEquals("L'insertion en fin de chaine n'est pas la bonne ou pas au bon endroit", moteur.getBuffer().getContenu().substring(0, 8), "canard d");
		moteur.selectionner(6, 13);
		moteur.copier();	//Seul cas de la copie
		assertEquals("La copie du texte n'est pas dans le presse papier", moteur.getPressePapier().getContenu(), " dindon");
		moteur.selectionner(moteur.getBuffer().getContenu().length(), moteur.getBuffer().getContenu().length());
		moteur.coller();	//colle à la fin de la chaine
		assertEquals("Le collage en fin de chaine n'est pas le bon ou pas au bon endroit", moteur.getBuffer().getContenu().substring(20, moteur.getBuffer().getContenu().length()), " dindon");
		moteur.selectionner(13, moteur.getBuffer().getContenu().length());
		moteur.couper();
		assertEquals("Le contenu du presse papier ne correspond pas à la coupe", moteur.getPressePapier().getContenu(), " toucan dindon");
		assertEquals("Le texte n'a pas été coupé", moteur.getBuffer().getContenu().toString(), "canard dindon");
		moteur.selectionner(6, 13);
		moteur.coller();	//Collage en remplaçant une partie du texte
		assertEquals("Le texte coller en remplaçant une autre chaine fonctionne",moteur.getBuffer().getContenu().toString(), "canard toucan dindon");	
	}	
}

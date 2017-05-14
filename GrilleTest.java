package activite_2;

import activite_2.GrilleImpl;
import activite_2.Grille;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author ESSO Dissirama
 */
public class GrilleTest {

    /**
     * Constante exprimant un caractère vide.
     */
    static final char VIDE = Grille.EMPTY;

    /**
     * Notre grille de test.
     */
    static final char[][] TEST_GRILLE
            = {
                {VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, VIDE},
                {VIDE, VIDE, VIDE, VIDE, VIDE, '3', VIDE, '8', '5'},
                {VIDE, VIDE, '1', VIDE, '2', VIDE, VIDE, VIDE, VIDE},
                {VIDE, VIDE, VIDE, '5', VIDE, '7', VIDE, VIDE, VIDE},
                {VIDE, VIDE, '4', VIDE, VIDE, VIDE, '1', VIDE, VIDE},
                {VIDE, '9', VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, VIDE},
                {'5', VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, '7', '3'},
                {VIDE, VIDE, '2', VIDE, '1', VIDE, VIDE, VIDE, VIDE},
                {VIDE, VIDE, VIDE, VIDE, '4', VIDE, VIDE, VIDE, '9'}
            };

    /**
     * Test de la méthode getDimension, de la class GrilleImpl.
     */
    @Test
    public final void testGetDimension() {
        System.out.print("Test de la méthode getDimension");
        Grille instance = new GrilleImpl(TEST_GRILLE);
        int resultat = instance.getDimension();
        assertEquals(9, resultat);
        System.out.println("... OK");
    }

    /**
     * Test de la méthode setValue, of class Grille.
     */
    @Test
    public final void testSetValue() {
        System.out.print("Test de la méthode setValue");
        Grille instance = new GrilleImpl(TEST_GRILLE);
        instance.setValue(7, 2, '7');
        System.out.println("... OK");
    }

    /**
     * Test de la méthode getValue, de la class GrilleImpl.
     */
    @Test
    public final void testGetValue() {
        System.out.print("Test de la méthode getValue");
        Grille instance = new GrilleImpl(TEST_GRILLE);
        char resultat = instance.getValue(6, 7);
        if (resultat != '7') {
            fail("testGetValue: Valeurs différentes");
        }
        System.out.println("... OK");
    }

    /**
     * Test de la méthode complete, de la class GrilleImpl.
     */
    @Test
    public final void testComplete() {
        System.out.print("Test de la méthode complete");
        Grille instance = new GrilleImpl(TEST_GRILLE);
        boolean resultat = instance.complete();
        assertEquals(false, resultat);
        System.out.println("... OK");

    }

    /**
     * Test de la méthode possible, de la class GrilleImpl.
     */
    @Test
    public final void testPossible() {
        System.out.print("Test de la méthode possible");
        Grille instance = new GrilleImpl(TEST_GRILLE);
        boolean resultat = instance.possible(7, 8, '7');
        assertEquals(true, resultat);
        System.out.println("... OK");
    }

    /**
     * Méthode main d'exécution.
     *
     * @param args Arguments à passer
     */
    public static void main(final String[] args) {
        GrilleTest test = new GrilleTest();
        test.testGetDimension();
        test.testGetValue();
        test.testSetValue();
        test.testComplete();
        test.testPossible();
    }

}

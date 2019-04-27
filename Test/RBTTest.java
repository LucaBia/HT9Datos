import ht9.RedBlackBST;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RBTTest {
    @Test
    public void buscarTest(){
        RedBlackBST instancia = new RedBlackBST();
        String palabra= "Africaa";
        boolean expected = false;
        boolean resultado = instancia.contains(palabra);
        assertEquals(expected, resultado);

    }

}

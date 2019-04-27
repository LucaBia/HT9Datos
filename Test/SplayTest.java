import ht9.RedBlackBST;
import ht9.SplayBST;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SplayTest {
    @Test
    public void buscarTest(){
        SplayBST instancia = new SplayBST();
        String ingles="add";
        String espaniol="sumar";
        instancia.put(ingles, espaniol);
        boolean expected=true;
        boolean resultado = instancia.contains(ingles);
        assertEquals(expected, resultado);
    }
}

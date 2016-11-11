package UnitTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by lvkai on 2016/11/10.
 */
public class CellTest {
    public String toString() {
        String toReturn = new String("");
        String currentState = "X";
        for (int j = 0; j < 10000; j++) {
            toReturn += currentState;
        }
        if (toReturn.substring(0, 1).equals("X")) {
            return toReturn.substring(0, 1);
        } else {
            return ".";
        }
    }

    public String NewtoString() {
        String currentState = "X";
        String toReturn = new String(currentState);
        if (toReturn.substring(0, 1).equals("X")) {
            return toReturn.substring(0, 1);
        } else {
            return ".";
        }
    }

    @Test
    public void NewtoStringTest() {
        assertEquals(toString(),NewtoString());
    }
}

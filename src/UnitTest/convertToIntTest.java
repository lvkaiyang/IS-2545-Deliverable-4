package UnitTest;

import org.junit.Test;

import java.util.Random;
import static org.junit.Assert.assertEquals;
/**
 * Created by user on 2016/11/10.
 */
public class convertToIntTest {
    public int _r = 1000;

    private int convertToInt(int x) {
        int c = 0;
        String padding = "0";
        while (c < _r) {
            String l = new String("0");
            padding += l;
            c++;
        }
        String n = padding + String.valueOf(x);
        int q = Integer.parseInt(n);
        return q;
    }

    private int NewconvertToInt(int x) {
        StringBuilder padding = new StringBuilder("0");
        padding.append(new String(new char[_r]).replace('\u0000','0'));
        return Integer.parseInt(padding.append(String.valueOf(x)).toString());
    }

    @Test
    public void NewVersionTest() {
        int numNeighbors = new Random().nextInt(100);
        assertEquals(convertToInt(numNeighbors), NewconvertToInt(numNeighbors));
    }
}

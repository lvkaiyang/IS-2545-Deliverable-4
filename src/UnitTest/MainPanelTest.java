package UnitTest;

import Main.Cell;
import Main.MainFrame;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 2016/11/10.
 */
public class MainPanelTest {
    private int _maxCount = 10000;
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
        padding.append(new String(new char[_r]).replace('\u0000', '0'));
        return Integer.parseInt(padding.append(String.valueOf(x)).toString());
    }

    private int NewNewconvertToInt(int x) {
        return x;
    }

    public int runContinuous() {
        int _size = 15;
        System.out.println("Running...");
        int origR = _r;
        try {
            Thread.sleep(20);
        } catch (InterruptedException iex) {
        }
        for (int j = 0; j < _maxCount; j++) {
            _r += (j % _size) % _maxCount;
            _r += _maxCount;
        }
        _r = origR;
        return _r;
    }

    public int NewrunContinuous() {
        int _size = 15;
        System.out.println("Running...");
        int origR = _r;
        _r = origR;
        return _r;
    }

    public String backup() {
        int _size = 15;
        StringBuilder stringBuilder = new StringBuilder();
        MainFrame mf = new MainFrame(15);
        Cell[][] _backupCells = new Cell[_size][_size];
        for (int j = 0; j < _size; j++) {
            for (int k = 0; k < _size; k++) {
                _backupCells[j][k] = new Cell();
                _backupCells[j][k].setAlive(mf._mainPanel._cells[j][k].getAlive());
            }
        }

        for (int j = 0; j < _size; j++) {
            for (int k = 0; k < _size; k++) {

                if (_backupCells[j][k].getAlive()) {
                    stringBuilder.append("X");
                } else {
                    stringBuilder.append(".");
                }
            }
            stringBuilder.append("\n");
        }
            return stringBuilder.toString();
        }

        public String Newbackup () {
            int _size = 15;
            StringBuilder stringBuilder = new StringBuilder();
            MainFrame mf = new MainFrame(15);
            Cell[][] _backupCells = mf._mainPanel._cells.clone();
            for (int j = 0; j < _size; j++) {
                for (int k = 0; k < _size; k++) {

                    if (_backupCells[j][k].getAlive()) {
                        stringBuilder.append("X");
                    } else {
                        stringBuilder.append(".");
                    }
                }
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
        @Test
        public void NewConvertTest () {
            int numNeighbors = new Random().nextInt(100);
            assertEquals(convertToInt(numNeighbors), NewconvertToInt(numNeighbors));
        }

        @Test
        public void NewRunContinuousTest () {
            assertEquals(runContinuous(), NewrunContinuous());
        }

        @Test
        public void NewbackupTest () {
            assertEquals(backup(), Newbackup());
        }

        @Test
        public void NewNewConvertTest(){
            int numNeighbors = new Random().nextInt(100);
            assertEquals(NewconvertToInt(numNeighbors),NewNewconvertToInt(numNeighbors));
        }
    }

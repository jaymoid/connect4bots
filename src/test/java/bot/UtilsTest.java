/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author james
 */
public class UtilsTest {

    public UtilsTest() {
    }

    /**
     * Test of prettyPrintBoard method, of class Utils.
     */
    @Test
    public void testPrettyPrintBoard() {
        int[][] board = {
            {1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 0},
            {2, 1, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {1, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        };
        
        String nl = System.lineSeparator();
        String expectedResult = 
                "[0] [0] [0] [0] [0] [0] [0] " + nl +
                "[0] [0] [0] [0] [0] [0] [0] " + nl +
                "[0] [0] [0] [1] [0] [0] [0] " + nl +
                "[0] [0] [0] [2] [0] [0] [0] " + nl +
                "[1] [0] [0] [1] [0] [2] [0] " + nl +
                "[1] [0] [2] [2] [0] [1] [0] " + nl;
        
        String result = Utils.prettyPrintBoard(board);
        System.out.println(result);
        assertEquals(expectedResult, result);
    }

}

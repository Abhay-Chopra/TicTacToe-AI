import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the TicTacToe file (JUnit5/Jupiter)
 * @author Abhay Chopra
 * @version Testing 1.0
 * Tutorial 06 (W/ Amir)
 *
 */
class TicTacToeTest {
    @Test
    void testCreateBoard() {
        int[][] expectedBoard = {{0, 0, 0},{0, 0, 0},{0, 0, 0}};
        int rows = 3;
        int columns = 3;
        int[][] actualBoard = TicTacToe.createBoard(rows, columns);
        Assertions.assertArrayEquals(expectedBoard, actualBoard,
                "An empty 2D array with 3 rows and columns should be: " + Arrays.deepToString(expectedBoard));
    }

    @Test
    void testRowsIn() {
        int[][] testBoard = {{0, 0, 0},
                             {0, 0, 0},
                             {0, 0, 0}};
        int expectedRows = 3;
        int actualNumberRows = TicTacToe.rowsIn(testBoard);
        assertEquals(expectedRows, actualNumberRows,
                "Number of rows in the array {{0, 0, 0},{0, 0, 0},{0, 0, 0}} should be: 3");
    }
    @Test
    void testRowsInEmpty(){
        int[][] emptyBoard = {};
        int expectedRows = 0;
        int actualNumberRows = TicTacToe.rowsIn(emptyBoard);
        assertEquals(expectedRows, actualNumberRows,
                "In an empty array, number of rows should be: 0");
    }

    @Test
    void columnsIn() {
    }

    @Test
    void canPlay() {
    }

    @Test
    void play() {
    }

    @Test
    void full() {
    }

    @Test
    void winInRow() {
    }

    @Test
    void winInColumn() {
    }

    @Test
    void winInDiagonalBS() {
    }

    @Test
    void winInDiagonalFS() {
    }

    @Test
    void hint() {
    }

    @Test
    void factorial() {
    }
}
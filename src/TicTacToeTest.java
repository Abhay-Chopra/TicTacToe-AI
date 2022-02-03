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
    /**
     * Uses code from Assignment 1 AI() from Jonathan Hudson CPSC 233 W22
     * Deep copy function:- confirm game board wasn't changed
     * @param givenArray this is a 2D integer array
     * @return copiedArray
     */
    int[][] deepCopy(int[][] givenArray){
        int[][] copiedArray = new int[givenArray.length][];
        for (int i = 0; i < copiedArray.length; i++) {
            copiedArray[i] = Arrays.copyOf(givenArray[i], givenArray[i].length);
        }
        return copiedArray;
    }
    // Tests for createBoard() function
    @Test
    void testCreateBoard3x3() {
        int rows = 3;
        int columns = 3;
        int[][] expectedBoard = new int[rows][columns];
        int[][] actualBoard = TicTacToe.createBoard(rows, columns);
        Assertions.assertArrayEquals(expectedBoard, actualBoard,
                "An empty 2D array with 3 rows and 3 columns should be: " + Arrays.deepToString(expectedBoard));
    }
    @Test
    void testCreateBoard4x3(){
        int rows = 4;
        int columns = 3;
        int[][] expectedBoard = new int[rows][columns];
        int[][] actualBoard = TicTacToe.createBoard(rows, columns);
        Assertions.assertArrayEquals(expectedBoard, actualBoard,
                "An empty 2D array with 4 rows and 4 columns should be: " + Arrays.deepToString(expectedBoard));
    }
    @Test
    void testCreateBoard4x4(){
        int rows = 4;
        int columns = 4;
        int[][] expectedBoard = new int[rows][columns];
        int[][] actualBoard = TicTacToe.createBoard(rows, columns);
        Assertions.assertArrayEquals(expectedBoard, actualBoard,
                "An empty 2D array with 4 rows and 4 columns should be: " + Arrays.deepToString(expectedBoard));
    }
    @Test
    void testCreateBoard3x5(){
        int rows = 3;
        int columns = 5;
        int[][] expectedBoard = new int[rows][columns];
        int[][] actualBoard = TicTacToe.createBoard(rows, columns);
        Assertions.assertArrayEquals(expectedBoard, actualBoard,
                "An empty 2D array with 4 rows and 4 columns should be: " + Arrays.deepToString(expectedBoard));
    }
    @Test
    void testCreateBoard5x5(){
        int rows = 5;
        int columns = 5;
        int[][] expectedBoard = new int[rows][columns];
        int[][] actualBoard = TicTacToe.createBoard(rows, columns);
        Assertions.assertArrayEquals(expectedBoard, actualBoard,
                "An empty 2D array with 4 rows and 4 columns should be: " + Arrays.deepToString(expectedBoard));
    }

    // Tests for rowsIn()
    @Test
    void testRowsIn3x3() {
        int expectedRows = 3;
        int numberColumns = 3;
        int[][] board = new int[expectedRows][numberColumns];
        int[][] copiedBoard = deepCopy(board);
        int actualNumberRows = TicTacToe.rowsIn(board);
        assertEquals(expectedRows, actualNumberRows,
                "Number of rows in the array " + Arrays.deepToString(board) + " should be: " + expectedRows);
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by rowsIn()");
    }
    @Test
    void testRowsIn3x4(){
        int expectedRows = 3;
        int numberColumns = 4;
        int[][] board = new int[expectedRows][numberColumns];
        int[][] copiedBoard = deepCopy(board);
        int actualNumberRows = TicTacToe.rowsIn(board);
        assertEquals(expectedRows, actualNumberRows,
                "Number of rows in the array " + Arrays.deepToString(board) + " should be: " + expectedRows);
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by rowsIn()");
    }
    @Test
    void testRowsIn4x3(){
        int expectedRows = 4;
        int numberColumns = 3;
        int[][] board = new int[expectedRows][numberColumns];
        int[][] copiedBoard = deepCopy(board);
        int actualNumberRows = TicTacToe.rowsIn(board);
        assertEquals(expectedRows, actualNumberRows,
                "Number of rows in the array " + Arrays.deepToString(board) + " should be: " + expectedRows);
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by rowsIn()");
    }
    @Test
    void testRowsIn5x4(){
        int expectedRows = 5;
        int numberColumns = 4;
        int[][] board = new int[expectedRows][numberColumns];
        int[][] copiedBoard = deepCopy(board);
        int actualNumberRows = TicTacToe.rowsIn(board);
        assertEquals(expectedRows, actualNumberRows,
                "Number of rows in the array " + Arrays.deepToString(board) + " should be: " + expectedRows);
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by rowsIn()");
    }
    @Test
    void testRowsIn5x5(){
        int expectedRows = 5;
        int numberColumns = 5;
        int[][] board = new int[expectedRows][numberColumns];
        int[][] copiedBoard = deepCopy(board);
        int actualNumberRows = TicTacToe.rowsIn(board);
        assertEquals(expectedRows, actualNumberRows,
                "Number of rows in the array " + Arrays.deepToString(board) + " should be: " + expectedRows);
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by rowsIn()");
    }

    // Tests for columnIn()
    @Test
    void columnsIn() {
    }


    // Tests for canPlay()
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
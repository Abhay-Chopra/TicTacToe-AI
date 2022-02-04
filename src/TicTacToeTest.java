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
        // changing number of columns (function usability should be the same as last test case)
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
        // changing number of rows, ie, function should return different value
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
    void testRowsInRandomizedPiece(){
        int expectedRows = 3;
        int numberColumns = 3;
        int[][] board = new int[expectedRows][numberColumns];
        // placing a piece at a location to test if game piece placement effects function usability
        board[expectedRows - 1][numberColumns - 1] = TicTacToe.O;
        int[][] copiedBoard = deepCopy(board);
        int actualNumberRows = TicTacToe.rowsIn(board);
        assertEquals(expectedRows, actualNumberRows,
                "Number of rows in the array " + Arrays.deepToString(board) + " should be: " + expectedRows);
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by rowsIn()");
    }
    @Test
    void testRowsIn5x5(){
        // changing number of rows and number of columns to check if function usability holds
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
    void testColumnsIn3x3() {
        int numberRows = 3;
        int expectedColumns = 3;
        int[][] board = new int[numberRows][expectedColumns];
        int[][] copiedBoard = deepCopy(board);
        int actualNumberColumns = TicTacToe.columnsIn(board);
        assertEquals(expectedColumns, actualNumberColumns,
                "Number of columns in the array " + Arrays.deepToString(board) + " should be: " + actualNumberColumns);
        // confirming that the board wasn't changed
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by columnsIn()");
    }
    @Test
    void testColumnsIn4x3() {
        // changing number of rows (compared to previous test case) to see if this affects function
        int numberRows = 4;
        int expectedColumns = 3;
        int[][] board = new int[numberRows][expectedColumns];
        int[][] copiedBoard = deepCopy(board);
        int actualNumberColumns = TicTacToe.columnsIn(board);
        assertEquals(expectedColumns, actualNumberColumns,
                "Number of columns in the array " + Arrays.deepToString(board) + " should be: " + actualNumberColumns);
        // confirming that the board wasn't changed
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by columnsIn()");
    }
    @Test
    void testColumnsInRandomizedPiece() {
        int numberRows = 3;
        int expectedColumns = 3;
        int[][] board = new int[numberRows][expectedColumns];
        // changing random piece to see if piece placement disrupts function usability
        board[numberRows - 1][expectedColumns - 1] = TicTacToe.X;
        int[][] copiedBoard = deepCopy(board);
        int actualNumberColumns = TicTacToe.columnsIn(board);
        assertEquals(expectedColumns, actualNumberColumns,
                "Number of columns in the array " + Arrays.deepToString(board) + " should be: " + actualNumberColumns);
        // confirming that the board wasn't changed
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by columnsIn()");
    }
    @Test
    void testColumnsIn3x4() {
        int numberRows = 3;
        // changing number of columns, ie, function should also have different return value (compared to previous cases)
        int expectedColumns = 4;
        int[][] board = new int[numberRows][expectedColumns];
        int[][] copiedBoard = deepCopy(board);
        int actualNumberColumns = TicTacToe.columnsIn(board);
        assertEquals(expectedColumns, actualNumberColumns,
                "Number of columns in the array " + Arrays.deepToString(board) + " should be: " + actualNumberColumns);
        // confirming that the board wasn't changed
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by columnsIn()");
    }
    @Test
    void testColumnsIn5x5() {
        // changing both the number of rows and columns to see if this effects function usability
        int numberRows = 5;
        int expectedColumns = 5;
        int[][] board = new int[numberRows][expectedColumns];
        int[][] copiedBoard = deepCopy(board);
        int actualNumberColumns = TicTacToe.columnsIn(board);
        assertEquals(expectedColumns, actualNumberColumns,
                "Number of columns in the array " + Arrays.deepToString(board) + " should be: " + actualNumberColumns);
        // confirming that the board wasn't changed
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by columnsIn()");
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
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
        // getting a copy of our board
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
        // getting a copy of our board
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
        // getting a copy of our board
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
        // getting a copy of our board
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
        // getting a copy of our board
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
        // getting a copy of our board
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
        // getting a copy of our board
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
        // getting a copy of our board
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
        // getting a copy of our board
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
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);
        int actualNumberColumns = TicTacToe.columnsIn(board);
        assertEquals(expectedColumns, actualNumberColumns,
                "Number of columns in the array " + Arrays.deepToString(board) + " should be: " + actualNumberColumns);
        // confirming that the board wasn't changed
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by columnsIn()");
    }

    // Tests for canPlay()
    @Test
    void testCanPlayEmptyBoard() {
        int rows = 3;
        int columns = 3;
        // creating an empty 3x3 game board
        int[][] board = new int[rows][columns];
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);
        // boolean should be true no matter what position we provide to function
        boolean expectedPlayState = true;
        // checking bottom right corner of board to see if it is a playable location
        boolean actualPlayState = TicTacToe.canPlay(board, rows - 1, columns - 1);
        assertEquals(expectedPlayState, actualPlayState, "The current location is playable" +
                "the function should return true ");
        // confirming that the board itself was not modified
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by canPlay()");
    }
    @Test
    void testCanPlayFullBoard(){
        int rows = 3;
        int columns = 3;
        // creating an empty board
        int[][] board = new int[rows][columns];
        // looping through board to fill each location with a game piece
        for(int currentRow = 0; currentRow < rows; currentRow++){
            for(int currentColumn = 0; currentColumn < columns; currentColumn++){
                board[currentRow][currentColumn] = TicTacToe.O;
            }
        }
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);
        // confirming that canPlay function will return false for a full board
        boolean expectedPlayState = false;
        // checking top left corner of board (location doesn't matter; should return false as board full)
        boolean actualPlayState = TicTacToe.canPlay(board, 0, 0);
        assertEquals(expectedPlayState, actualPlayState, "The current location was unplayable, the function " +
                "should return false");
        // confirming that the board itself was not modified
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by canPlay()");
    }
    @Test
    void testCanPlayFullLocation() {
        // this test case is similar to last case, but just confirms that the last case didn't access a random index
        int rows = 3;
        int columns = 3;
        // creating an empty 3x3 game board
        int[][] board = new int[rows][columns];
        // placing a piece at some location
        int currentRow = 2;
        int currentColumn = 2;
        board[currentRow][currentColumn] = TicTacToe.O;
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);
        // boolean should be false as to be tested location is non-playable, ie, full
        boolean expectedPlayState = false;
        // checking if current location is playable
        boolean actualPlayState = TicTacToe.canPlay(board, currentRow, currentColumn);
        assertEquals(expectedPlayState, actualPlayState, "The current location was unplayable, the function " +
                        "should return false");
        // confirming that the board itself was not modified
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by canPlay()");
    }

    // tests for play() function
    @Test
    void testPlay3x3() {
        // testing for whether a piece can be played in a 3x3 board
        int rows = 3;
        int columns = 3;
        int[][] board = new int[rows][columns];
        // creating a copy of the board
        int[][] copiedBoard = deepCopy(board);
        // variables for where piece will be played & which piece to place
        int pieceInRow = 2;
        int pieceInColumn = 2;
        int gamePiece = TicTacToe.O;
        // placing a piece in deep copied array
        copiedBoard[pieceInRow][pieceInColumn] = gamePiece;
        // placing piece using the function (that is being tested)
        TicTacToe.play(board, pieceInRow, pieceInColumn, gamePiece);
        Assertions.assertArrayEquals(copiedBoard, board, "play() should have placed a game piece at row " + pieceInRow +
                ", column " + pieceInColumn + ". Additionally, all other locations should have remained the same.");
    }
    @Test
    void testPlay4x5(){
        // testing for whether changing the number of rows and/or columns affects function usability
        int rows = 4;
        int columns = 5;
        int[][] board = new int[rows][columns];
        // creating a copy of the board
        int[][] copiedBoard = deepCopy(board);
        // variables for where piece will be played & which piece to place
        int pieceInRow = 3;
        int pieceInColumn = 4;
        int gamePiece = TicTacToe.O;
        // placing a piece in deep copied array
        copiedBoard[pieceInRow][pieceInColumn] = gamePiece;
        // placing piece using the function (that is being tested)
        TicTacToe.play(board, pieceInRow, pieceInColumn, gamePiece);
        Assertions.assertArrayEquals(copiedBoard, board, "play() should have placed a game piece at row " + pieceInRow +
                ", column " + pieceInColumn + ". Additionally, all other locations should have remained the same.");
    }
    @Test
    void testPlayTopLeft(){
        // testing for whether changing the piece placement location affects function usability
        int rows = 3;
        int columns = 3;
        int[][] board = new int[rows][columns];
        // creating a copy of the board
        int[][] copiedBoard = deepCopy(board);
        // variables for where piece will be played & which piece to place
        int pieceInRow = 0;
        int pieceInColumn = 0;
        int gamePiece = TicTacToe.O;
        // placing a piece in deep copied array
        copiedBoard[pieceInRow][pieceInColumn] = gamePiece;
        // placing piece using the function (that is being tested)
        TicTacToe.play(board, pieceInRow, pieceInColumn, gamePiece);
        Assertions.assertArrayEquals(copiedBoard, board, "play() should have placed a game piece at row " + pieceInRow +
                ", column " + pieceInColumn + ". Additionally, all other locations should have remained the same.");
    }
    @Test
    void testPlayChangingGamePiece(){
        // testing for whether changing the game piece affects function usability
        int rows = 3;
        int columns = 3;
        int[][] board = new int[rows][columns];
        // creating a copy of the board
        int[][] copiedBoard = deepCopy(board);
        // variables for where piece will be played & which piece to place
        int pieceInRow = 2;
        int pieceInColumn = 2;
        int gamePiece = TicTacToe.X;
        // placing a piece in deep copied array
        copiedBoard[pieceInRow][pieceInColumn] = gamePiece;
        // placing piece using the function (that is being tested)
        TicTacToe.play(board, pieceInRow, pieceInColumn, gamePiece);
        Assertions.assertArrayEquals(copiedBoard, board, "play() should have placed the game piece \"X\" at row " + pieceInRow +
                ", column " + pieceInColumn + ". Additionally, all other locations should have remained the same.");
    }

    // tests for full() function
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
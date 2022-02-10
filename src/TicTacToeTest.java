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

    // creating board function (note this is independent of our source code createBoard())
    int[][] createTestBoard(int rows, int columns){
        return new int[rows][columns];
    }

    int[][] fullBoard;
    @BeforeEach
    void setFullBoard(){
        fullBoard = new int[][]{{TicTacToe.O, TicTacToe.O, TicTacToe.O},
                {TicTacToe.O, TicTacToe.O, TicTacToe.O},
                {TicTacToe.O, TicTacToe.O, TicTacToe.O}};
    }

    // Tests for createBoard() function
    @Test
    void testCreateBoard3x3() {
        int[][] expectedBoard = createTestBoard(3, 3);
        int[][] actualBoard = TicTacToe.createBoard(3, 3);
        assertArrayEquals(expectedBoard, actualBoard,
                "An empty 2D array with 3 rows and 3 columns should be: " + Arrays.deepToString(expectedBoard));
    }
    @Test
    void testCreateBoard4x3(){
        int[][] expectedBoard = createTestBoard(4, 3);
        int[][] actualBoard = TicTacToe.createBoard(4, 3);
        assertArrayEquals(expectedBoard, actualBoard,
                "An empty 2D array with 4 rows and 4 columns should be: " + Arrays.deepToString(expectedBoard));
    }
    @Test
    void testCreateBoard4x4(){
        int[][] expectedBoard = createTestBoard(4, 4);
        int[][] actualBoard = TicTacToe.createBoard(4, 4);
        assertArrayEquals(expectedBoard, actualBoard,
                "An empty 2D array with 4 rows and 4 columns should be: " + Arrays.deepToString(expectedBoard));
    }
    @Test
    void testCreateBoard3x5(){
        int[][] expectedBoard = createTestBoard(3, 5);
        int[][] actualBoard = TicTacToe.createBoard(3, 5);
        assertArrayEquals(expectedBoard, actualBoard,
                "An empty 2D array with 4 rows and 4 columns should be: " + Arrays.deepToString(expectedBoard));
    }

    @Test
    void testCreateBoard5x5(){
        int[][] expectedBoard = createTestBoard(5, 5);
        int[][] actualBoard = TicTacToe.createBoard(5, 5);
        assertArrayEquals(expectedBoard, actualBoard,
                "An empty 2D array with 4 rows and 4 columns should be: " + Arrays.deepToString(expectedBoard));
    }
    // Tests for rowsIn()
    @Test
    void testRowsIn3x3() {
        int[][] board = createTestBoard(3, 3);
        // copy of board
        int[][] copiedBoard = deepCopy(board);

        assertEquals(copiedBoard.length, TicTacToe.rowsIn(board),
                "Number of rows in the array " + Arrays.deepToString(board) + " should be: 3");
        // checking whether function modified our board
        assertArrayEquals(copiedBoard, board, "The array was modified by rowsIn()");
    }
    // test case: confirming that changing #of columns doesn't change function utility
    @Test
    void testRowsIn3x4(){
        int[][] board = createTestBoard(3, 4);
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertEquals(copiedBoard.length, TicTacToe.rowsIn(board),
                "Number of rows in the array " + Arrays.deepToString(board) + " should be: 3");
        // confirming that function doesn't modify board
        assertArrayEquals(copiedBoard, board, "The array was modified by rowsIn()");
    }
    // test case: changing number of rows, ie, function should return different value (from last case)
    @Test
    void testRowsIn4x3(){
        int[][] board = createTestBoard(4, 3);
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertEquals(copiedBoard.length, TicTacToe.rowsIn(board),
                "Number of rows in the array " + Arrays.deepToString(board) + " should be: 4");
        // confirming that function doesn't modify board
        assertArrayEquals(copiedBoard, board, "The array was modified by rowsIn()");
    }
    // test case: placing a piece at a location to test if game piece placement effects function usability
    @Test
    void testRowsInRandomizedPiece(){
        int[][] board = createTestBoard(3, 3);
        // placing a piece
        board[2][2] = TicTacToe.O;
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertEquals(copiedBoard.length, TicTacToe.rowsIn(board),
                "Number of rows in the array " + Arrays.deepToString(board) + " should be: 3");
        // confirming that function doesn't modify board
        assertArrayEquals(copiedBoard, board, "The array was modified by rowsIn()");
    }
    // test case: changing both number of rows and number of columns to check function utility

    @Test
    void testRowsIn5x5(){
        int[][] board = createTestBoard(5, 5);
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertEquals(copiedBoard.length, TicTacToe.rowsIn(board),
                "Number of rows in the array " + Arrays.deepToString(board) + " should be: 5");
        // confirming that function doesn't modify board
        assertArrayEquals(copiedBoard, board, "The array was modified by rowsIn()");
    }
    // Tests for columnIn()
    @Test
    void testColumnsIn3x3() {
        int[][] board = createTestBoard(3, 3);
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertEquals(copiedBoard[0].length, TicTacToe.columnsIn(board),
                "Number of columns in the array " + Arrays.deepToString(board) + " should be: 3");
        // confirming that function doesn't modify board
        assertArrayEquals(copiedBoard, board, "The array was modified by columnsIn()");
    }
    // test case: changing number of rows (compared to previous test case) to see if this affects function
    @Test
    void testColumnsIn4x3() {
        int[][] board = createTestBoard(4, 3);
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertEquals(copiedBoard[0].length, TicTacToe.columnsIn(board),
                "Number of columns in the array " + Arrays.deepToString(board) + " should be: 3");
        // confirming that the board wasn't changed
        assertArrayEquals(copiedBoard, board, "The array was modified by columnsIn()");
    }
    // test case: confirming that piece placement doesn't disrupt function usability
    @Test
    void testColumnsIn() {
        int[][] board = createTestBoard(3,3);
        // playing a piece
        board[2][2] = TicTacToe.X;
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertEquals(copiedBoard[0].length, TicTacToe.columnsIn(board),
                "Number of columns in the array " + Arrays.deepToString(board) + " should be: 3");
        // confirming that the board wasn't changed
        assertArrayEquals(copiedBoard, board, "The array was modified by columnsIn()");
    }
    // test case: changing the number of columns (should affect function values)
    @Test
    void testColumnsIn3x4() {
        int[][] board = createTestBoard(3, 4);
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertEquals(copiedBoard[0].length, TicTacToe.columnsIn(board),
                "Number of columns in the array " + Arrays.deepToString(board) + " should be: 4");
        // confirming that the board wasn't changed
        assertArrayEquals(copiedBoard, board, "The array was modified by columnsIn()");
    }
    // test case: changing both the number of rows and columns to see if this effects function usability

    @Test
    void testColumnsIn5x5() {
        int[][] board = createTestBoard(5, 5);
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertEquals(copiedBoard[0].length, TicTacToe.columnsIn(board),
                "Number of columns in the array " + Arrays.deepToString(board) + " should be: 5");
        // confirming that the board wasn't changed
        assertArrayEquals(copiedBoard, board, "The array was modified by columnsIn()");
    }
    // Tests for canPlay()
    // test case: testing canPlay() given empty board
    @Test
    void testCanPlayEmptyBoard() {
        int[][] board = createTestBoard(3, 3);
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        // boolean should be true no matter what position we provide to canPlay()
        assertTrue(TicTacToe.canPlay(board, 2, 2), "An empty board is playable at all locations");
        // confirming that the board itself was not modified
        assertArrayEquals(copiedBoard, board, "The array was modified by canPlay()");
    }
    // test case: testing canPlay() given full board
    @Test
    void testCanPlayFullBoard(){
        int[][] board = fullBoard;
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertFalse(TicTacToe.canPlay(board, 0, 0), "There are no playable locations in a full board");
        // confirming that the board itself was not modified
        assertArrayEquals(copiedBoard, board, "The array was modified by canPlay()");
    }
    // this test case is similar to last case, but just confirms that the last case didn't access a random index
    @Test
    void testCanPlayFullLocation() {
        int[][] board = createTestBoard(3,3);
        // placing a piece at some location
        board[2][2] = TicTacToe.O;
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertFalse(TicTacToe.canPlay(board, 2, 2));
        // confirming that the board itself was not modified
        assertArrayEquals(copiedBoard, board, "The array was modified by canPlay()");
    }

    // tests for play() function
    // test case for a base 3x3 board, confirming piece placement works
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
        assertArrayEquals(copiedBoard, board, "play() should have placed a game piece at row " + pieceInRow +
                ", column " + pieceInColumn + ". Additionally, all other locations should have remained the same.");
    }
    // testing for whether changing the number of rows and/or columns affects function usability
    @Test
    void testPlay4x5(){
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
    // testing for whether changing the piece placement location affects function usability
    @Test
    void testPlayTopLeft(){
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
    // testing for whether changing the game piece affects function usability
    @Test
    void testPlayChangingGamePiece(){
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
    // test case for full() function when given an empty array
    @Test
    void testEmptyBoard() {
        // creating an empty 3x3 game board
        int rows = 3;
        int columns = 3;
        int[][] board = new int[rows][columns];
        // creating a copy of the game board
        int[][] copiedBoard = deepCopy(board);
        // checking whether board is full (using full() function)
        boolean actualStatus = TicTacToe.full(board);
        boolean expectedStatus = false;
        assertEquals(expectedStatus, actualStatus, "The full() function should return false when given" +
                "an empty array: " + Arrays.deepToString(copiedBoard));
        // confirming that the board itself was not modified
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by full()");
    }
    // test case for full() function when given a full array
    @Test
    void testFullBoard() {
        // creating an empty 3x3 game board
        int rows = 3;
        int columns = 3;
        int[][] board = new int[rows][columns];
        // looping through board to fill each location with a game piece, ie, a full board
        for(int currentRow = 0; currentRow < rows; currentRow++){
            for(int currentColumn = 0; currentColumn < columns; currentColumn++){
                board[currentRow][currentColumn] = TicTacToe.X;
            }
        }
        // creating a copy of the game board
        int[][] copiedBoard = deepCopy(board);
        // checking whether board is full (using full() function)
        boolean actualStatus = TicTacToe.full(board);
        boolean expectedStatus = true;
        assertEquals(expectedStatus, actualStatus, "The full() function should return true when given" +
                " the (full) array: " + Arrays.deepToString(copiedBoard));
        // confirming that the board itself was not modified
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by full()");
    }
    // test case confirms that varying board size doesn't affect function usability
    @Test
    void testFull5x5(){
        // creating an empty 5x5 game board
        int rows = 5;
        int columns = 5;
        int[][] board = new int[rows][columns];
        // creating a copy of the game board
        int[][] copiedBoard = deepCopy(board);
        // checking whether board is full (using full() function)
        boolean actualStatus = TicTacToe.full(board);
        boolean expectedStatus = false;
        assertEquals(expectedStatus, actualStatus, "The full() function should return false when given" +
                " the array: " + Arrays.deepToString(copiedBoard));
        // confirming that the board itself was not modified
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by full()");
    }
    // test case confirms that all locations in the board are being checked and not only one
    @Test
    void testFullLocation() {
        // creating an empty 3x3 game board
        int rows = 3;
        int columns = 3;
        int[][] board = new int[rows][columns];
        board[0][0] = TicTacToe.O;
        // creating a copy of the game board
        int[][] copiedBoard = deepCopy(board);
        // checking whether board is full (using full() function)
        boolean actualStatus = TicTacToe.full(board);
        boolean expectedStatus = false;
        assertEquals(expectedStatus, actualStatus, "The full() function should return false when given" +
                " the array: " + Arrays.deepToString(copiedBoard));
        // confirming that the board itself was not modified
        Assertions.assertArrayEquals(copiedBoard, board, "The array was modified by full()");
    }

    // test for winInRow() function
    // test case for when there is a win in the first row
    @Test
    void winInRow() {
    }

    @Test
    void winInColumn() {
    }
    // test case for there isn't a win in column but #of pieces >= 3, ie, C0:"X"|C1:"X"|C2:"O"|C3:"X"
    @Test
    void testNoWinInFullColumn() {

    }

    // test for winInDiagonalBS() function
    @Test
    void winInDiagonalBS() {
    }

    // test for winInDiagonalFS() function
    @Test
    void winInDiagonalFS() {
    }

    // test for hint() function
    @Test
    void hint() {
    }

    // test for factorial() function
    @Test
    void factorial() {
    }
}
import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the TicTacToe file (JUnit5/Jupiter)
 * @author Abhay Chopra
 * @version Testing 1.0
 * Tutorial 06 (W/ Amir)
 * February 11th, 2021
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

    int[][] full4x4Board;
    @BeforeEach
    void setFullBoard(){
        full4x4Board = new int[][] {{TicTacToe.O, TicTacToe.O, TicTacToe.O},
                                    {TicTacToe.O, TicTacToe.O, TicTacToe.O},
                                    {TicTacToe.O, TicTacToe.O, TicTacToe.O}};
    }
    int[][] board3x3;
    @BeforeEach
    void setEmptyBoard(){
        board3x3 = new int[][]{{TicTacToe.EMPTY, TicTacToe.EMPTY, TicTacToe.EMPTY},
                               {TicTacToe.X, TicTacToe.X, TicTacToe.EMPTY},
                               {TicTacToe.X, TicTacToe.X, TicTacToe.X}};
    }
    int[][] board5x4;
    @BeforeEach
    void setBoard5x4(){
        board5x4 = new int[][]{{TicTacToe.X, TicTacToe.O, TicTacToe.X, TicTacToe.EMPTY},
                               {TicTacToe.O, TicTacToe.O, TicTacToe.X, TicTacToe.O},
                               {TicTacToe.X, TicTacToe.EMPTY, TicTacToe.O, TicTacToe.EMPTY},
                               {TicTacToe.X, TicTacToe.EMPTY, TicTacToe.X, TicTacToe.EMPTY},
                               {TicTacToe.EMPTY, TicTacToe.EMPTY, TicTacToe.EMPTY, TicTacToe.EMPTY},};
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
        int[][] board = full4x4Board;
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
        int[][] board = createTestBoard(3, 3);
        // creating a copy of the board
        int[][] copiedBoard = deepCopy(board);

        // expected vs actual, ie, putting piece on copiedBoard vs playing a piece on Actual board
        copiedBoard[2][2] = TicTacToe.O;
        TicTacToe.play(board, 2, 2, TicTacToe.O);
        assertArrayEquals(copiedBoard, board, "play() should have placed a game piece at row 2, column 2");
    }
    // testing for whether changing the number of rows and/or columns affects function usability
    @Test
    void testPlay4x5(){
        int[][] board = createTestBoard(4, 5);
        // creating a copy of the board
        int[][] copiedBoard = deepCopy(board);

        // expected vs actual, ie, putting piece on copiedBoard vs playing a piece on Actual board
        copiedBoard[3][4] = TicTacToe.O;
        TicTacToe.play(board, 3, 4, TicTacToe.O);
        assertArrayEquals(copiedBoard, board, "play() should have placed a game piece at row 3, column 4");
    }
    // testing for whether changing the piece placement location affects function usability
    @Test
    void testPlayTopLeft(){
        int[][] board = createTestBoard(3, 3);
        // creating a copy of the board
        int[][] copiedBoard = deepCopy(board);

        // expected vs actual, ie, putting piece on copiedBoard vs playing a piece on Actual board
        copiedBoard[0][0] = TicTacToe.O;
        TicTacToe.play(board, 0, 0, TicTacToe.O);
        assertArrayEquals(copiedBoard, board, "play() should have placed a game piece at row 0, column 0");
    }
    // testing for whether changing the game piece affects function usability
    @Test
    void testPlayChangingGamePiece(){
        int[][] board = createTestBoard(3, 3);
        // creating a copy of the board
        int[][] copiedBoard = deepCopy(board);

        // placing a piece in deep copied array
        copiedBoard[0][0] = TicTacToe.X;
        // placing piece using the function (that is being tested)
        TicTacToe.play(board, 0, 0, TicTacToe.X);
        assertArrayEquals(copiedBoard, board, "play() should have placed the game piece \"X\" at row 0, column 0");
    }

    // tests for full() function
    // test case for full() function when given an empty array
    @Test
    void testEmptyBoard() {
        int[][] board = createTestBoard(3, 3);
        // creating a copy of the game board
        int[][] copiedBoard = deepCopy(board);

        assertFalse(TicTacToe.full(board), "The full() function should return false when given an empty array");
        // confirming that the board itself was not modified
        assertArrayEquals(copiedBoard, board, "The array was modified by full()");
    }
    // test case for full() function when given a full array
    @Test
    void testFullBoard() {
        int[][] board = full4x4Board;
        // creating a copy of the game board
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.full(board), "Full() return true when given a full array");
        // confirming that the board itself was not modified
        assertArrayEquals(copiedBoard, board, "The array was modified by full()");
    }
    // test case confirms that varying board size doesn't affect function usability
    @Test
    void testFull5x5(){
        int[][] board = createTestBoard(5, 5);
        // creating a copy of the game board
        int[][] copiedBoard = deepCopy(board);

        assertFalse(TicTacToe.full(board));
        // confirming that the board itself was not modified
        assertArrayEquals(copiedBoard, board, "The array was modified by full()");
    }
    // test case confirms that all locations in the board are being checked and not only one
    @Test
    void testFullLocation() {
        int[][] board = createTestBoard(3, 3);
        // placing a game piece, ie, game board is not full
        board[0][0] = TicTacToe.O;
        // creating a copy of the game board
        int[][] copiedBoard = deepCopy(board);

        assertFalse(TicTacToe.full(board));
        // confirming that the board itself was not modified
        assertArrayEquals(copiedBoard, board, "The array was modified by full()");
    }

    // test for winInRow() function
    // test case for when there is a win in the last row
    @Test
    void testWinInLastRow() {
        int[][] board = board3x3;
        // creating a deep copy of the board
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.winInRow(board, 2, TicTacToe.X), "3 consecutive pieces in the same row constitutes a win");
        // confirming our board wasn't changed
        assertArrayEquals(copiedBoard, board, "The board was modified by winInRow()");
    }
    // test case for when there isn't a win in a row, ie, "|X|X|Empty|"
    @Test
    void testNoWinInRow() {
        int[][] board = board3x3;
        // creating a deep copy of the board
        int[][] copiedBoard = deepCopy(board);

        assertFalse(TicTacToe.winInRow(board, 1, TicTacToe.X));
        // confirming our board wasn't changed
        assertArrayEquals(copiedBoard, board, "The board was modified by winInRow()");
    }
    // test case for when there is a win in the second last row, ie, index 1
    @Test
    void testWinInSecondLastRow() {
        int[][] board = board3x3;
        // placing a piece at position 1,2 , ie, second last row is a winning row
        board[1][2] = TicTacToe.X;
        // creating a deep copy of the board
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.winInRow(board, 1, TicTacToe.X), "3 consecutive pieces in the same row constitutes a win");
        // confirming our board wasn't changed
        assertArrayEquals(copiedBoard, board, "The board was modified by winInRow()");
    }
    // test case to check whether changing number of rows and/or columns effects functionality
    @Test
    void testWinInRow5x4() {
        int[][] board = board5x4;
        board[3][1] = TicTacToe.X;
        // creating a deep copy of the board
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.winInRow(board, 3, TicTacToe.X), "3 consecutive pieces in the same row constitutes a win");
        // confirming our board wasn't changed
        assertArrayEquals(copiedBoard, board, "The board was modified by winInRow()");
    }
    // test case for when there isn't a win in row but there #of pieces is >= 3, ie,  "|O|O|X|O|"
    @Test
    void testNoWinInRowFull(){
        int[][] board = board5x4;
        // creating a deep copy of the board
        int[][] copiedBoard = deepCopy(board);
        // checking whether player with piece "O" has won

        assertFalse(TicTacToe.winInRow(board, 1, TicTacToe.O), "There is no winning position in \"|O|O|X|O|\"");
        // confirming our board wasn't changed
        assertArrayEquals(copiedBoard, board, "The board was modified by winInRow()");
    }

    // tests for winInColumn() function
    // test case for when there is a win in the first column
    @Test
    void testWinInFirstColumn() {
        int[][] board = board3x3;
        board[0][0] = TicTacToe.X;
        // creating a deep copy of the board
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.winInColumn(board, 0, TicTacToe.X), "3 consecutive pieces in one column constitute a win");
        // confirming our board wasn't changed
        assertArrayEquals(copiedBoard, board, "The board was modified by winInColumn()");

    }
    // test case for when there is a win in the second last column, ie, the winning column changed
    @Test
    void testWinInSecondLastColumn() {
        int[][] board = board3x3;
        board[0][1] = TicTacToe.X;
        // creating a deep copy of the board
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.winInColumn(board, 1, TicTacToe.X), "3 consecutive pieces in one column constitute a win");
        // confirming our board wasn't changed
        assertArrayEquals(copiedBoard, board, "The board was modified by winInColumn()");
    }
    // test case to confirm that changing board size (changing #of rows and columns) doesn't affect functionality
    @Test
    void winInColumn5x4() {
        int[][] board = board5x4;
        board[4][0] = TicTacToe.X;
        // creating a deep copy of the board
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.winInColumn(board, 0, TicTacToe.X));
        // confirming our board wasn't changed
        assertArrayEquals(copiedBoard, board, "The board was modified by winInColumn()");
    }
    // test case for when there isn't a win in column, ie, C0:"Empty"|C1:"X"|C3:"X"
    @Test
    void testNoWinInColumn() {
        int[][] board = board3x3;
        // creating a deep copy of the board
        int[][] copiedBoard = deepCopy(board);

        assertFalse(TicTacToe.winInColumn(board, 1, TicTacToe.X), "Only 2 consecutive pieces in the same column");
        // confirming our board wasn't changed
        assertArrayEquals(copiedBoard, board, "The board was modified by winInColumn()");
    }
    // test case for there isn't a win in column but #of pieces >= 3, ie, C0:"X"|C1:"X"|C2:"O"|C3:"X"
    @Test
    void testNoWinInFullColumn() {
        int[][] board = board5x4;
        // creating a deep copy of the board
        int[][] copiedBoard = deepCopy(board);

        assertFalse(TicTacToe.winInColumn(board,0,TicTacToe.X));
        // confirming our board wasn't changed
        assertArrayEquals(copiedBoard, board, "The board was modified by winInColumn()");
    }

    // test for winInDiagonalBS() function
    // testcase: testing for a win in the backslash row for a 3x3 board
    @Test
    void winInDiagonalBS() {
        int[][] board = board3x3;
        // playing a game piece onto default board, ie, a win in a diagonal BS is now present
        board[0][0] = TicTacToe.X;
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.winInDiagonalBS(board, TicTacToe.X), "Three pieces consecutively in BS is a win ");
        // confirming our board wasn't changed
        assertArrayEquals(copiedBoard, board, "The board was modified by winInDiagonalBS()");

    }
    // test case: changing board size and potential win location to see how it effects functionality
    @Test
    void winInDiagonalBS5x4() {
        int[][] board = board5x4;
        board[3][3] = TicTacToe.O;
        // getting copy of board
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.winInDiagonalBS(board, TicTacToe.O), "Three pieces consecutively in BS is a win ");
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board, "The board was modified by winInDiagonalBS()");
    }
    // testing for different piece and the winning diagonal has a different location
    @Test
    void winInDiagonalBSLocation() {
        int[][] board = board5x4;
        // adding pieces to the board
        board[3][1] = TicTacToe.X;
        board[4][2] = TicTacToe.X;
        // getting a copy of the board
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.winInDiagonalBS(board, TicTacToe.X), "Three pieces consecutively in BS is a win ");
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board, "The board was modified by winInDiagonalBS()");
    }
    // test case when there is no win in the diagonal BS (note: this is a 3x3 board)
    @Test
    void noWinInDiagonalBS() {
        int[][] board = board3x3;
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertFalse(TicTacToe.winInDiagonalBS(board, TicTacToe.X));
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board, "The board was modified by winInDiagonalBS()");
    }
    // test case when there is no win in the diagonal BS, and number of pieces in some diagonal is >=3, ie, a piece has
    // blocked the player's win
    @Test
    void noWinInDiagonalBSFull() {
        int[][] board = board5x4;
        board[3][3] = TicTacToe.X;
        int[][] copiedBoard = deepCopy(board);

        assertFalse(TicTacToe.winInDiagonalBS(board, TicTacToe.O));
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board, "The board was modified by winInDiagonalBS()");
    }

    // test for winInDiagonalFS() function
    // testcase: testing for a win in the forward slash row for a 3x3 board
    @Test
    void winInDiagonalFS() {
        int[][] board = board3x3;
        // playing a piece onto the board, ie, there is a winning FS diagonal now
        board[0][2] = TicTacToe.X;
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.winInDiagonalFS(board, TicTacToe.X), "Three pieces consecutively in FS is a win ");
        // confirming our board wasn't changed
        assertArrayEquals(copiedBoard, board, "The board was modified by winInDiagonalFS()");
    }
    // test case: changing board size and potential win location to see how it effects functionality
    @Test
    void winInDiagonalFS5x4() {
        int[][] board = board5x4;
        board[3][1] = TicTacToe.O;
        // getting copy of board
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.winInDiagonalFS(board, TicTacToe.O), "Three pieces consecutively in FS is a win ");
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board, "The board was modified by winInDiagonalFS()");
    }
    //  testing for different piece and the winning diagonal has a different location
    @Test
    void winInDiagonalFSChanged() {
        int[][] board = board5x4;
        // adding pieces to the board
        board[2][3] = TicTacToe.X;
        board[4][1] = TicTacToe.X;
        // getting a copy of the board
        int[][] copiedBoard = deepCopy(board);

        assertTrue(TicTacToe.winInDiagonalFS(board, TicTacToe.X), "Three pieces consecutively in FS is a win ");
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board, "The board was modified by winInDiagonalFS()");
    }
    // test case when there is no win in the diagonal FS (note: this is a 3x3 board)
    @Test
    void noWinInDiagonalFS() {
        int[][] board = board3x3;
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertFalse(TicTacToe.winInDiagonalFS(board, TicTacToe.X));
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board, "The board was modified by winInDiagonalFS()");
    }
    // test case: when number of pieces in some diagonal >= 3, ie, players piece was blocked
    @Test
    void noWinInDiagonalFSFull() {
        int[][] board = board5x4;
        // blocking some diagonal FS
        board[2][1] = TicTacToe.O;
        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);

        assertFalse(TicTacToe.winInDiagonalFS(board, TicTacToe.X));
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board, "The board was modified by winInDiagonalBS()");
    }

    // test for hint() function
    // hint for a winning position of a diagonal BS for one player
    @Test
    void hintInDiagonalBS() {
        int[][] board = createTestBoard(3, 3);
        // creating a near winning condition for player with piece "X", in diagonal BS
        board[0][0] = TicTacToe.X;
        board[1][1] = TicTacToe.X;

        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);
        int[] expectedReturn = new int[]{2,2};
        assertArrayEquals(expectedReturn, TicTacToe.hint(board, TicTacToe.X));
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board);
    }
    // hint for a winning position of a diagonal FS for one player
    @Test
    void hintInDiagonalFS() {
        int[][] board = createTestBoard(4, 4);
        // creating a near winning condition for player with piece "X", in diagonal FS
        board[1][1] = TicTacToe.X;
        board[2][0] = TicTacToe.X;

        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);
        int[] expectedReturn = new int[]{0,2};
        assertArrayEquals(expectedReturn, TicTacToe.hint(board, TicTacToe.X));
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board);
    }
    // hint for a winning position of a win in column for one player
    @Test
    void hintInColumn() {
        int[][] board = createTestBoard(4,5);
        board[0][0] = TicTacToe.O;
        board[1][0] = TicTacToe.O;

        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);
        int[] expectedReturn = new int[]{2,0};
        assertArrayEquals(expectedReturn, TicTacToe.hint(board, TicTacToe.O));
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board);
    }
    // hint for a winning position of a win in column for one player
    @Test
    void hintInRow() {
        int[][] board = createTestBoard(4,3);
        board[1][0] = TicTacToe.O;
        board[1][1] = TicTacToe.O;

        // getting a copy of our board
        int[][] copiedBoard = deepCopy(board);
        int[] expectedReturn = new int[]{1,2};
        assertArrayEquals(expectedReturn, TicTacToe.hint(board, TicTacToe.O));
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board);
    }
    // test case when start of game, ie, empty board | testing to get default return value
    @Test
    void noHint() {
        // creating an empty 3x3 board
        int[][] board = createTestBoard(3, 3);
        int[][] copiedBoard = deepCopy(board);

        // expected return of hint functions, ie, the defaults (as no hint present)
        int[] expectedDefaultReturn = new int[]{-1, -1};
        assertArrayEquals(expectedDefaultReturn, TicTacToe.hint(board, TicTacToe.X));
        // confirming our board wasn't modified
        assertArrayEquals(copiedBoard, board);
    }

    // tests for factorial() function
    // test case where given integer to the factorial function is 0
    @Test
    void factorial0() {
        assertEquals(BigInteger.valueOf(1), TicTacToe.factorial(0), "The factorial of 0 is 1");
    }
    // case where given integer is greater than 0
    @Test
    void factorialGreater0(){
        assertEquals(BigInteger.valueOf(6), TicTacToe.factorial(3), "The factorial of 3 is 6");
    }
    // test case where integer is significantly greater than 0
    @Test
    void factorialTest(){
        assertEquals(BigInteger.valueOf(3628800), TicTacToe.factorial(10), "The factorial of 10 is 3,628,800");
    }
}
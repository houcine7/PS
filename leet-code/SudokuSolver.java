import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuSolver {

    // implement the solution with recursion
    public void solveSudoku1(char[][] board) {
        //
        int row = 0;
        int col = 0;
        solveSudokuRec(board, row, col);
        System.out.println(board);
    }

    private boolean solveSudokuRec(char[][] board, int row, int col) {

        if (row == 8 && col == 9)
            return true;

        if (col == 9) {
            row++;
            col = 0;
        }

        if (board[row][col] != '.')
            return solveSudokuRec(board, row, col + 1);

        String str = "123456789";
        for (char c : str.toCharArray()) {
            if (isValideInsert(board, row, col, c)) {
                board[row][col] = c;

                if (solveSudokuRec(board, row, col + 1)) {
                    return true;
                }
            }
            board[row][col] = '.';
        }

        return false;
    }

    // a method to check if it is valid to put a number in certain position
    public boolean isValideInsert(char[][] board, int row, int col, char number) {

        // check if the col contains the number
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number)
                return false;
        }

        // check if the row contains the number
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == number)
                return false;
        }

        // check if the number already exists in the cell

        int startRowCell = row - row % 3;
        int startColCell = col - col % 3;
        for (int i = startRowCell; i < startRowCell + 3; i++) {
            for (int j = startColCell; j < startColCell + 3; j++) {
                //
                if (board[i][j] == number)
                    return false;
            }
        }

        return true;
    }

    // to check if the board is a valid one :
    public boolean isSudukoValid2(char[][] suduko) {

        Set<String> mySet = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char currentNumber = suduko[row][col];

                if (currentNumber != '.') {
                    if (!mySet.add(currentNumber + " in row " + row) ||
                            !mySet.add(currentNumber + " in column " + col) ||
                            !mySet.add(currentNumber + " in cell " + row / 3 + "," + col / 3))
                        return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[] row1 = new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' };
        char[] row2 = new char[] { '6', '.', '.', '1', '.', '5', '.', '.', '.' };
        char[] row3 = new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' };
        char[] row4 = new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' };
        char[] row5 = new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' };
        char[] row6 = new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' };
        char[] row7 = new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' };
        char[] row8 = new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' };
        char[] row9 = new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' };

        SudokuSolver solver = new SudokuSolver();

        solver.solveSudoku1(new char[][] { row1, row2, row3, row4, row5, row6, row7, row8, row9 });

        System.out.println((2 % 3));
    }

}

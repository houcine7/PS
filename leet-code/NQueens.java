import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NQueens {

    static List<List<String>> nQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }

        backTracking(board, 0, result);
        return result;
    }

    static void backTracking(char[][] board, int row, List<List<String>> result) {

        if (row == board.length - 1) {
            System.out.println(boardToList(board).toString());
            result.add(boardToList(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backTracking(board, row + 1, result);
                board[row][col] = '.';
            }
        }

    }

    static List<String> boardToList(char[][] board) {
        List<String> str = new ArrayList<>();
        System.out.println("eheeee");
        for (char[] row : board) {
            StringBuilder sb = new StringBuilder();
            sb.append(row);
            str.add(sb.toString());
        }

        return str;
    }

    static boolean isValid(char[][] board, int row, int col) {

        // is row and column safe
        for (int i = 0; i < row; i++) {

            if (board[i][col] == 'Q')
                return false;
        }

        int maxLeft = Math.min(row, col);

        for (int i = 0; i <= maxLeft; i++) {
            if (board[row - i][col - i] == 'Q')
                return false;
        }

        int maxRight = Math.min(row, board.length - 1 - col);

        for (int i = 0; i <= maxRight; i++) {
            if (board[row - i][col + i] == 'Q')
                return false;
        }

        return true;

    }

    public static void main(String[] args) {
        ArrayList<String> ls = new ArrayList<>();
        Collections.addAll(ls, ".Q..", "...Q", "Q...", "..Q.");
        System.out.println(nQueens(4).toString());
    }
}

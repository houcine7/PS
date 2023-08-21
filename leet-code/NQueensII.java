import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class NQueensII {

    public static int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        AtomicInteger counter = new AtomicInteger(0);
        backTracking(board, 0, counter);
        return counter.get();
    }

    static void backTracking(char[][] board, int row, AtomicInteger count) {

        if (board.length == row) {
            count.incrementAndGet();
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                System.out.println(Arrays.deepToString(board));
                backTracking(board, row + 1, count);
                board[row][i] = '.';
            }
        }

    }

    static boolean isSafe(char[][] board, int row, int col) {
        // check row
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
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
        System.out.println(totalNQueens(9));
    }

}

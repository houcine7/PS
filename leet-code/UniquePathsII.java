import java.util.Arrays;

public class UniquePathsII {

    static int uniquePathsII(int[][] obstacleGrid) {

        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return 0;

        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {

                if ((i == 0 || j == 0) && obstacleGrid[i][j] != 1) {
                    if ((i - 1 >= 0 && obstacleGrid[i - 1][j] != 1) || (j - 1 >= 0 && obstacleGrid[i][j - 1] != 1))
                        obstacleGrid[i][j] = -1;
                }

                else if (obstacleGrid[i][j] != 1) {

                    int count = 0;
                    count += obstacleGrid[i - 1][j] != 1 ? obstacleGrid[i - 1][j] : 0;
                    count += obstacleGrid[i][j - 1] != 1 ? obstacleGrid[i][j - 1] : 0;

                    System.out.println(count + " FOR " + i + "AND " + j);
                    obstacleGrid[i][j] = count;
                }
            }

            System.out.println(Arrays.deepToString(obstacleGrid));
        }

        return -1 * obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    static int uniquePaths(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];

        // first row filling
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1)
                dp[i][0] = 1;
            else
                break; // we can no more achieve any next case in this level
        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] != 1)
                dp[0][i] = 1;
            else
                break;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        // dp[0][0] = 1;
        // for (int x = 0; x < n; x++) {
        // for (int y = 0; y < m; y++) {
        // if (x == 0 && y == 0)
        // continue;

        // if (obstacleGrid[x][y] == 1)
        // dp[x][y] = 0;
        // else {
        // int temp = 0;

        // temp += x - 1 >= 0 ? dp[x - 1][y] : 0;
        // temp += y - 1 >= 0 ? dp[x][y - 1] : 0;

        // System.out.println(temp);
        // dp[x][y] = temp;
        // System.out.println(Arrays.deepToString(
        // dp));
        // }
        // }
        // }

        return dp[n - 1][m - 1];

    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[0][0] = 0;
        arr[0][1] = 0;
        arr[0][2] = 0;

        arr[1][0] = 0;
        arr[1][1] = 1;
        arr[1][2] = 0;

        arr[2][0] = 0;
        arr[2][1] = 0;
        arr[2][2] = 0;

        System.out.println(uniquePaths(arr));
    }

}

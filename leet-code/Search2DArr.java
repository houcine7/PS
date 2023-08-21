class Search2DArr {

    public static boolean searchMatrix(int[][] matrix, int target) {

        // if (target < matrix[0][0])
        // return false;
        // if (target > matrix[matrix.length - 1])

        int k = 0, l = matrix.length - 1;
        int possibleRow = Integer.MAX_VALUE;
        while (k <= l) {
            int mid = (k + l) / 2;
            if (matrix[mid][matrix[mid].length - 1] > target) {
                l = mid - 1;
                possibleRow = mid;
            } else if (matrix[mid][matrix[mid].length - 1] < target) {
                k = mid + 1;
            } else {
                return true;
            }
        }

        if (possibleRow == Integer.MAX_VALUE)
            return false;
        System.out.println(possibleRow);

        int i = 0, j = matrix[possibleRow].length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            System.out.println("s" + mid);

            System.out.println("VALUE:" + matrix[possibleRow][mid]);
            if (matrix[possibleRow][mid] == target)
                return true;
            else if (matrix[possibleRow][mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] test = new int[][] {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 },
        };

        System.out.println(searchMatrix(test, 3));

    }

}
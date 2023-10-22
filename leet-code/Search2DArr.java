class Search2DArr {

   //100% beats 
    public static boolean searchMatrix1(int[][] matrix ,int target){
        int possibleRow = -1;
        int len = matrix[0].length;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][len-1] >= target){
                possibleRow = i;
                break;
            }
        }

    if(possibleRow ==-1)
        return false;

    int i=0, j= len-1;
     while (i <= j) {
            int mid = i + (j-i) / 2;
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

        System.out.println(searchMatrix1(test, 3));

    }

}

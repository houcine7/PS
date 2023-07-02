public class Suduko {

    public boolean isSudukoValid(char[][] suduko) {
        // validate the row

        for (char[] row : suduko) {
            String holder = "";
            for (char c : row) {
                if (c != '.' && holder.contains(c + ""))
                    return false;
                else {
                    holder += c;
                }
            }
        }
        //
        // System.out.println("ROWS ARE VALID");

        // validate column :
        for (int j = 0; j < 9; j++) {
            String holder = "";
            for (int i = 0; i < 9; i++) {
                if (suduko[i][j] != '.' && holder.contains(suduko[i][j] + ""))
                    return false;
                else
                    holder += suduko[i][j];

            }
        }

        for (int i = 0; i < 9; i = i + 3) {
            //
            for (int j = 0; j < 9; j = j + 3) {
                // System.out.println("THIS IS I: " + i + " THIS IS J:" + j);
                String holder = "";

                for (int k = i; k < i + 3; k++) {
                    for (int p = j; p < j + 3; p++) {
                        if (suduko[k][p] != '.' && holder.contains(suduko[k][p] + ""))
                            return false;
                        else
                            holder += suduko[k][p] + "";
                    }

                }
                // System.out.println(holder);

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

        Suduko sdk = new Suduko();

        System.out.println(sdk.isSudukoValid(new char[][] { row1, row2, row3, row4, row5, row6, row7, row8, row9 }));
    }

}

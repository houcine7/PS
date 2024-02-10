import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiplication {

    public static void main(String[] args) throws IOException {
        // read in std input with buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {

            line = br.readLine();
            String[] numbers = line.split(" ");
            double a = Long.parseLong(numbers[0]);
            double b = Long.parseLong(numbers[1]);
            double expected = Long.parseLong(numbers[2]);

            if ((a == 0 || b == 0) && expected == 0) {
                System.out.println("Yes");
                return;
            }

            if (a == 0 || b == 0) {
                System.out.println("No");
                return;
            }

            if ((a / expected) * b >= 1) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        } catch (Exception e) {
            System.out.println("No");
        } finally {
            br.close();
        }

    }
}
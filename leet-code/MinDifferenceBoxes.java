import java.util.List;

public class MinDifferenceBoxes {

    public static long findMinOperation(List<Integer> boxes) {
        long total = 0;

        for (int box : boxes) {
            total += box;
        }
        long avg = total / boxes.size();

        long minOperations = 0;
        for (int box : boxes) {
            if (box < avg) {
                minOperations += avg - box;
            }
        }

        return minOperations;
    }

    public static void main(String[] args) {
        System.out.println(findMinOperation(List.of(5, 5, 8, 7)));
    }
}

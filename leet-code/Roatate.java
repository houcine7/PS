import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Roatate {

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {

        for (int i = 0; i < d; i++) {
            int j = 0;
            while (j < arr.size() - 1) {
                int temp = arr.get(j);
                arr.set(j, arr.get(j + 1));
                arr.set(j + 1, temp);
                System.out.println(arr);
                j++;
            }
        }
        return arr;
    }

    public static List<Integer> rotateLeft1(int d, List<Integer> arr) {
        List<Integer> result = new ArrayList<>();

        for (int i = d; i < arr.size(); i++) {
            //
            result.add(arr.get(i));
        }

        for (int i = 0; i < d; i++) {
            result.add(arr.get(i));
        }

        return result;

    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            for (String str : stringList) {

                if (queries.get(i).equals(str)) {
                    int prev = i < result.size() ? result.get(i) : 0;
                    if (prev != 0)
                        result.set(i, prev + 1);
                    else
                        result.add(i, 1);

                }
            }
            if (result.size() != 1 + i) {
                result.add(0);
            }
        }
        return result;

    }

    public static long arrayMnip(List<List<Integer>> queries, int n) {
        int[] arr = new int[n + 1];
        for (List<Integer> q : queries) {
            int start = q.get(0) - 1, end = q.get(1), k = q.get(2);
            arr[start] += k;
            arr[end] -= k;
        }


        long max=-1;
        long running=0;
        for(int num :arr ){
            running+=num ;
            max =Math.max(running,max)
        }

        Arrays.toString(arr);

        return max;
    }

    public static void main(String[] args) {
        // List<Integer> test = new ArrayList<>();
        // test.add(1);
        // test.add(2);
        // test.add(3);
        // test.add(4);
        // test.add(5);
        // System.out.println(rotateLeft1(4, new ArrayList<>(test)));

        // List<String> qStrings = new ArrayList<>();
        // List<String> stringList = new ArrayList<>();

        // qStrings.add("aba");
        // qStrings.add("xzxb");
        // qStrings.add("ab");

        // stringList.add("aba");
        // stringList.add("baba");
        // stringList.add("aba");
        // stringList.add("xzxb");

        List<List<Integer>> test = new ArrayList<>();

        // System.out.println(matchingStrings(stringList, qStrings));

    }

}

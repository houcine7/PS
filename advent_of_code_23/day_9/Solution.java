package day_9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("./input.txt"));
            List<String> lines = bf.lines().toList();

            int counter = 0;
            for (String ln : lines) {

                String[] nbs = ln.split(" ");
                Stack<Integer> st = new Stack<>();

                List<String> nb_list = Arrays.asList(nbs);
                // boolean allSame = true;
                // int tmp = Integer.parseInt(nbs[1]) - Integer.parseInt(nbs[0]);
                // int i = 1;
                while (!nb_list.isEmpty()) {
                    List<String> temp = new ArrayList<>();
                    Set<Integer> unique = new HashSet<>();
                    for (int j = 1; j < nb_list.size(); j++) {
                        int sub = Integer.parseInt(nb_list.get(j)) - Integer.parseInt(nb_list.get(j - 1));
                        // System.out.println("this is sub: " + sub);
                        unique.add(sub);
                        temp.add("" + sub);
                    }
                    st.add(Integer.parseInt(temp.get(0)));
                    if (unique.size() <= 1) {
                        break;
                    }

                    nb_list = temp;
                }
                int last = st.pop();
                int result = last;
                while (!st.isEmpty()) {
                    int holder = st.pop();
                    result = holder - result;
                    last = holder;
                }

                // System.out.println(Integer.parseInt(nbs[0]) - result);
                counter += Integer.parseInt(nbs[0]) - result;

            }
            System.out.println(counter);

            bf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

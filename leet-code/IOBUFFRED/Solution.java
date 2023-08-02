package IOBUFFRED;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    static void arrSimplQuiries(List<Integer> nums, List<List<Integer>> qureis) {

        LinkedList<Integer> ls = new LinkedList<>();

        for (List<Integer> q : qureis) {
            int start = q.get(1) - 1;
            int end = q.get(2);
            List<Integer> result = new ArrayList<>();
            List<Integer> temp = nums.subList(0, start);
            result.addAll(0, nums.subList(start, end));
            result.addAll(temp);
            result.addAll(nums.subList(end, nums.size()));

            System.out.println(result);
            nums = result;

        }

        // calculate the prefix array
        System.out.println(nums.toString());

    }

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {

            // READ DATA FROM INPUT
            String sizes = bf.readLine();
            int arrLength = Integer.parseInt(sizes.split(" ")[0]);
            int quriesCount = Integer.parseInt(sizes.split(" ")[1]);

            String nums = bf.readLine();
            List<Integer> arr = new ArrayList<>();

            for (String num : nums.split(" ")) {
                arr.add(Integer.parseInt(num));
            }

            List<List<Integer>> queries = new ArrayList<>();
            for (int i = 1; i <= quriesCount; i++) {
                String[] qStr = bf.readLine().split(" ");
                List<Integer> query = new ArrayList<>();
                query.add(Integer.parseInt(qStr[0]));
                query.add(Integer.parseInt(qStr[1]));
                query.add(Integer.parseInt(qStr[2]));
                queries.add(query);
            }

            arrSimplQuiries(arr, queries);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}

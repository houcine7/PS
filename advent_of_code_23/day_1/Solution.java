package day_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// 
public class Solution {

  public static int numberInLine(String str) {
    String left = "";
    String right = "";

    Map<String, Integer> st = Map.of("one", 1, "two", 2, "three", 3, "four",
        4, "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9);

    for (int i = 0; i < str.length(); i++) {// o t f s e n
      char temp = str.charAt(i);

      if (temp >= '0' && temp <= '9') {
        left += temp;
        break;
      }
      if ((temp == 'o' || temp == 't' || temp == 's') && str.length() > i + 3) {
        String substr = str.substring(i, i + 3);
        if (st.containsKey(substr)) {
          left += st.get(substr);
          break;
        }

      }
      if ((temp == 't' || temp == 's' || temp == 'e') && str.length() > i + 5) {
        String subString = str.substring(i, i + 5);
        if (st.containsKey(subString)) {
          left += st.get(subString);
          break;
        }
      }
      if ((temp == 'f' || temp == 'n') && str.length() > i + 4) {
        String subString = str.substring(i, i + 4);
        if (st.containsKey(subString)) {
          left += st.get(subString);
          break;
        }
      }
    }

    for (int i = str.length() - 1; i >= 0; i--) { // e 3 5 4 o r x n t
      char temp = str.charAt(i);
      if (temp >= '0' && temp <= '9') {
        right += temp;
        break;
      }
      if ((temp == 'e' || temp == 'o' || temp == 'x') && i - 2 >= 0) {
        String subString = str.substring(i - 2, i + 1);
        // System.out.println(subString);
        if (st.containsKey(subString)) {
          right += st.get(subString);
          break;
        }
      }
      if ((temp == 'r' || temp == 'e') && i - 3 >= 0) {
        String subString = str.substring(i - 3, i + 1);
        // System.out.println(subString);
        if (st.containsKey(subString)) {
          right += st.get(subString);
          break;
        }
      }
      if ((temp == 'e' || temp == 'n' || temp == 't') && i - 4 >= 0) {
        String substString = str.substring(i - 4, i + 1);
        if (st.containsKey(substString)) {
          right += st.get(substString);
          break;
        }
      }
    }
    System.out.println(left + " " + right);
    if (right == "") {
      return 0;
    } else {
      return Integer.parseInt(left + right);
    }
  }

  public static void main(String[] args) throws IOException {

    try {
      BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
      AtomicInteger totalCounter = new AtomicInteger();

      br.lines().forEach((line) -> {
        var num = numberInLine(line);
        totalCounter.addAndGet(num);
      });
      br.close();
      System.out.println(totalCounter.get());
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  /*
   * TEST GET NUMBER IN LINE METHOD
   * 
   */

  // List<String> ls = List.of("two1nine", "eightwothree", "abcone2threexyz",
  // "xtwone3four", "4nineeightseven2", "zoneight234", "7pqrstsixteen");
  // for (String string : ls) {
  // numberInLine(string);
  // }

}

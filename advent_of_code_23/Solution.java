import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

  public static int numberInLine(String str) {
    // boolean left = false, right = false;
    // int i = 0, j = str.length() - 1;
    // String res_left = "";
    // String res_right = "";
    // while (i <= j && (!left || !right)) {
    // if (!left && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
    // left = true;
    // res_left += str.charAt(i);
    // }
    // if (!right && str.charAt(j) >= '0' && str.charAt(j) <= '9') {
    // right = true;
    // res_right += str.charAt(j);
    // }
    // i++;
    // j--;
    // }

    // if (res_left == "" && res_right == "") {
    // return 0;
    // } else if (res_left == "" && res_right != "") {
    // return Integer.parseInt(res_right + res_right);
    // } else if (res_left != "" && res_right == "") {
    // return Integer.parseInt(res_left + res_left);
    // } else {
    // return Integer.parseInt(res_left + res_right);
    // }

    String left = "";
    String right = "";

    for (int i = 0; i < str.length(); i++) {
      char temp = str.charAt(i);
      if (temp >= '0' && temp <= '9') {
        left += temp;
        break;
      }
    }

    for (int i = str.length() - 1; i >= 0; i--) {
      char temp = str.charAt(i);
      if (temp >= '0' && temp <= '9') {
        right += temp;
        break;
      }
    }

    System.out.println(left + "  " + right);

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
      System.out.println(numberInLine("fivesckjvndbf1eightfivejqzcsn"));

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}

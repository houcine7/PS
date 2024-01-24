import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTimDiff {

    public static int findMinDifference(List<String> timePoints) {
        int[] nums = new int[timePoints.size()];

        int j = 0;
        for (String time : timePoints) {
            int hours = Integer.parseInt(time.split(":")[0]);
            int minutes = Integer.parseInt(time.split(":")[1]);
            nums[j++] = hours * 60 + minutes;
        }

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i - 1]);
        }

        return min;

    }

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("00:00");
        timePoints.add("23:59");
        timePoints.add("00:00");
        int min = findMinDifference(timePoints);
        System.out.println(min);
    }
}

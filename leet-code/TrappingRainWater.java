public class TrappingRainWater {

    public int trap(int[] height) {

        //
        int counter = 0;

        for (int i = 1; i < height.length - 1; i++) {
            //
            int heighest_left = height[i];
            int heighest_right = height[i];
            int index_left = -1;
            int index_right = -1;
            int left = i - 1, right = i + 1;

            while (left >= 0) {
                //
                if (height[left] >= heighest_left) {
                    heighest_left = height[left];
                    index_left = left;
                }
                left--;
            }

            while (right < height.length) {
                if (height[right] >= heighest_right)
                    heighest_right = height[right];
                index_right = right;
                right++;
            }

            if (index_left != -1 && index_right != -1) {
                if (heighest_left < heighest_right) {
                    counter += heighest_left - height[i];
                } else {
                    counter += heighest_right - height[i];
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {

        TrappingRainWater tw = new TrappingRainWater();
        System.out.println(tw.trap(new int[] { 3, 0, 2, 0, 4 }));

    }
}
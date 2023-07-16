public class TrappingRainWater {

    // not optimized O(n)
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

    // optimizing by precalculate the heighest on the left and on the right:
    public int trap2(int[] height) {

        int counter = 0;
        int[] h_left = new int[height.length];
        int[] h_right = new int[height.length];

        h_left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            h_left[i] = Math.max(h_left[i - 1], height[i]);
        }

        h_right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            h_right[i] = Math.max(h_right[i + 1], height[i]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int holder = Math.min(h_left[i - 1], h_right[i + 1]);
            if (holder - height[i] > 0) {
                counter += holder - height[i];
            }
        }

        return counter;
    }

    public static void main(String[] args) {

        TrappingRainWater tw = new TrappingRainWater();
        System.out.println(tw.trap2(new int[] { 3, 0, 2, 0, 4 }));

    }
}
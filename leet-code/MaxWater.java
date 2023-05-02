public class MaxWater {

    public static int getMaxWater(int[] height) {

        int maxWater = -1;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > height[i]) {
                    maxWater = Math.max(maxWater, height[i] * (j - i));
                } else {
                    maxWater = Math.max(maxWater, height[j] * (j - i));
                }
            }
        }

        System.out.println(maxWater);
        return maxWater;
    }

    public static int getMaxWater2(int[] heigth) {
        int maxWater = -1;
        int i = 0, j = heigth.length - 1;

        while (i != j) {
            // System.out.println(i + "--" + j);
            if (heigth[i] < heigth[j]) {
                maxWater = Math.max(maxWater, heigth[i] * (j - i));
                i++;
            } else {
                maxWater = Math.max(maxWater, heigth[j] * (j - i));
                j--;
            }

        }

        System.out.println(maxWater);
        return maxWater;
    }

    public static void main(String[] args) {
        MaxWater.getMaxWater2(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
    }

}
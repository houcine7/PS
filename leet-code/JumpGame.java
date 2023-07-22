public class JumpGame {

    public int jump(int[] nums) {

        int target = nums.length - 1;
        int jumpsNumber = 0;
        int j = 0;
        while (j < nums.length && jumpsNumber < target) {
            int k = 1;
            int max_possible_jump = nums[j + 1];
            int index = j;

            if (nums[j] + j >= target) {
                jumpsNumber++;
                return jumpsNumber;
            }

            while (k <= nums[j] && k + j < nums.length) {
                System.out.println(nums[j + k]);
                if (nums[j + k] >= max_possible_jump) {
                    max_possible_jump = nums[j + k];
                    System.out.println("-----" + k);
                    index = k;
                }
                k++;
            }

            System.out.println("INDEX: " + index);
            if (nums[index] < nums[j])
                j += nums[j];
            else
                j += index;
            System.out.println(j);
            System.out.println("------------J-----------");
            if (j < nums.length) {
                jumpsNumber++;
            }
        }

        return jumpsNumber;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame(); //
        System.out.println(jg.jump(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0 }));
        // }));
        // System.out.println(jg.jump(new int[] { 4, 1, 1, 3, 1, 1, 1 }));
    }

}

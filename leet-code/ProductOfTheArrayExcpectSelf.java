import java.util.Arrays;

public class ProductOfTheArrayExcpectSelf {

    public int[] productExceptSelf(int[] nums) {
        int prefix = 1;
        int suffix = 1;

        int[] result = new int[nums.length];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefix *= nums[i - 1];
            System.out.println(nums[i - 1]);
            result[i] = prefix;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            suffix *= nums[i + 1];
            result[i] *= suffix;
        }

        return result;

    }

    public static void main(String[] args) {
        ProductOfTheArrayExcpectSelf pd = new ProductOfTheArrayExcpectSelf();
        System.out.println(Arrays.toString(pd.productExceptSelf(new int[] { 1, 2, 0, 4 })));
    }

}

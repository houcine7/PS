public class FindMinRotatedArr {
  public static int findMinRotatedArray(int[] nums) {
    int start = 0, end =nums.length -1;
    
    while (start < end) {
      int mid = start+(end-start)/2;
      if(mid+1< nums.length && nums[mid+1]<nums[mid])
          return nums[mid+1];
      else if( mid-1>=0 && nums[mid] < nums[mid-1])
          return nums[mid];
      else if(nums[start] > nums[mid])
        end = mid-1;
      else
        start = mid+1;
    }

    return nums[0];
  }


  public static void main(String[] args) {
    int[] test = new int[]{4,5,6,7,0,1,2};
    System.out.println(findMinRotatedArray(test));
  }
}

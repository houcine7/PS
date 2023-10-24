import java.util.Arrays;

public class LongestSubsequenceWSumEasy {
   // n * m complexity 
   public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);  // nlog(n)
        int[] ans = new int[queries.length];
        int j=0;   
        while(j<queries.length){ // O(m)
            int curr= queries[j];
            int counter =0 ;
            for(int i=0;i<nums.length ;i++){ // O(n)
                if(curr - nums[i] >= 0){
                    curr = curr-nums[i];
                    counter++;
                }else{
                    break;
                }
            }
            ans[j]=counter;
            j++;
        }

        return ans;
    }


  public static int[] answerQueries2(int[] nums, int[] queries) {
    
    /*
     * let's see that n is the length of nums
     *  and m is length of queries 
     *  the complexity is O(nlogn) + O(n) +O(m*log(n)) ==>O(nlogn) if n>m
     */
    Arrays.sort(nums); // O(nlogn)  
    int len = nums.length -1;
    int acc=0;
    System.out.println(Arrays.toString(nums));
    
    for (int i = 0; i <= len; i++) {  // O(n)
      acc += nums[i];
      nums[i] = acc;
    }
    
    System.out.println(Arrays.toString(nums));
    
    for (int i = 0; i < queries.length; i++) { //O(m)
      int temp =  queries[i];

      if (temp < nums[0]) {
        queries[i] = 0 ;
        continue;
      }

      if(temp > nums[len]){
        queries[i] = len+1;
        continue;
      }


      int start=0, end= len , mid=0;
      while (start<=end) {    // log(n)
        mid = start + (end - start)/2;
        if(nums[mid]==temp)
            break;
        else if(nums[mid] < temp && nums[mid + 1]> temp)
          break;
        else if(nums[mid]<temp)
          start = mid + 1;
        else if(nums[mid]>temp)
          end = mid - 1; 
      }
      queries[i] = mid + 1;
    }
  
    return queries;
  }

  
  public static void main(String[] args) {
    int[] ans = new int[]{4,5,2,1};
    int[] queries = new int[]{3,10,21};

    int[] result = answerQueries2(ans, queries);
  
    System.out.println(result);
  }

}


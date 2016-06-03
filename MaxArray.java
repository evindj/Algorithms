/*
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
*/
import java.util.*;
public class MaxArray {
    public int maxSubArrayLenSlow(int[] nums, int k) {
        int res =0;
        for(int i = 0; i< nums.length; i++){
            int sum =0;
            int lastIndex =-1;
            for(int j = i; j< nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    lastIndex = j;
                }
            }
            if(res<lastIndex -i+1) res = lastIndex- i+1;
    }
    return res;
    }

    public int maxSubArrayLenFast(int[] nums, int k) {
  if(nums.length == 0) return 0;
  int res =0;
  int[] sum = new int[nums.length];
  sum[0] = nums[0];
  for(int i =1; i < nums.length; i++){
      sum[i] = sum[i-1] +nums[i];
  }
  // find two indexes so that their difference is equal to k
  HashMap<Integer, ArrayList<Integer>> valuesIndex = new HashMap<>();
  for(int i = 0; i < sum.length; i++){
      if(valuesIndex.get(sum[i])==null)
          valuesIndex.put(sum[i], new ArrayList());
      valuesIndex.get(sum[i]).add(i);
  }

  for(int i =0; i < sum.length; i++){
      int diff = sum[i] +k;
       if(diff== 2*k){
              if(res< i+1)res = i+1;
          }
      ArrayList<Integer> secondIndex = valuesIndex.get(diff);
      if(secondIndex != null ){
              int max = Math.max(Math.abs(i-secondIndex.get(0)),Math.abs(i-secondIndex.get(secondIndex.size() - 1)));
              if(res<max) res = max;
      }
      valuesIndex.remove(sum[i]);
  }

return res;
}

public int maxSubArrayLenFastest(int[] nums, int k) {
      if(nums.length == 0) return 0;
      int res =0;
      int[] sum = new int[nums.length];
      sum[0] = nums[0];
      for(int i =1; i < nums.length; i++){
          sum[i] = sum[i-1] +nums[i];
      }
      // find two indexes so that their difference is equal to k
      HashMap<Integer,Integer> valuesIndex = new HashMap<>();
      for(int i = 0; i < sum.length; i++){
          valuesIndex.put(sum[i], i);
      }

      for(int i =0; i < sum.length; i++){
          int diff = sum[i] +k;
           if(diff== 2*k){
                  if(res< i+1)res = i+1;
              }
          Integer secondIndex = valuesIndex.get(diff);
         if(secondIndex != null && secondIndex.intValue() > i && secondIndex.intValue() - i > res)
              res = secondIndex.intValue() - i;
      }

  return res;
  }

public static void main(String[] args){
  MaxArray ar = new MaxArray();
  int[] tab ={-5,8,2,-1,6,-3,7,1,8,-2,7};
  int res = ar.maxSubArrayLenFast(tab,-4);
  System.out.println(res);
}

}

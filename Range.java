import java.util.*;
public class Range {
    public List<String> summaryRanges(int[] nums) {
        int i =0;
        ArrayList<String> res = new ArrayList<>();
        while(i< nums.length){
            int start = i;
            while(i<nums.length-1 && nums[i]==nums[i+1]-1){
                i++;
            }
            StringBuilder b = new StringBuilder();
            b.append(nums[start]);
            if(start!=i){
                b.append("->");
                b.append(nums[i]);
            }
            res.add(b.toString());
            i++;
        }
        return res;
    }
}

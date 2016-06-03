public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
       TreeSet<Integer> temp = new TreeSet<>();
       ArrayList<Integer> dup = new ArrayList<>();
       int count =0;
       for(int i =0; i < nums.length; i++){
            if(foundDistance(temp,nums[i],t)) return true;
            temp.add(nums[i]);
            dup.add(nums[i]);
            count++;
            if(count % k == 0 && temp.size() > 0){
                temp.remove(dup.remove(0));
            }
       }
       return false;
    }
    public boolean foundDistance(TreeSet<Integer> queue, int k, int t){
    int left =0; int right = queue.size()-1;
    while(left < right){
        int mid = (right +left)/2;
        if(Math.abs(queue.get(mid)-k) <= t) return true;
        else{
            if(queue.get(mid) > k) right = mid -1;
            else{
                right = mid +1;
            }
        }
    }
    return false;
}
}

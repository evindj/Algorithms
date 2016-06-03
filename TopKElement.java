public class TopKElement {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        for(int i =0; i < nums.length; i++){
            Integer temp= count.get(nums[i]);
            if(temp == null) temp =0;
            count.put(nums[i], temp + 1);
        }
        TreeMap<Integer, ArrayList<Integer>> mapping = new TreeMap<>(Collections.reverseOrder());
        for(int key : count.keySet()){
            ArrayList<Integer> val = mapping.get(count.get(key));
           if(val== null){
               val =new ArrayList<>();
               mapping.put(count.get(key), val);
           }
           val.add(key);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(res.size()<k){
            for(Map.Entry<Integer,ArrayList<Integer>> entry: mapping.entrySet()){
                for(int v : entry.getValue()){
                    res.add(v);
                    if(res.size()==k) return res;
                }
            }
        }
        return res;
}
}

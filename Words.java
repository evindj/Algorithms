
/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] vals = new boolean[s.length()+1];
        vals[0] = true;
        for (int i = 1; i <= s.length() ; i++){
            int window = Math.min(i+getMaxLength(wordDict)-1 , s.length());
            for(int j = i; j<= window; j++){
                if (vals[i-1] == true && wordDict.contains(s.substring(i-1,j))){
                    vals[j] = true;
                }
            }
        }
        return vals[s.length()];
    }
    private int getMaxLength(Set<String> wordDict){
        int max =0;
        for (String s:wordDict) {
            max = Math.max(max,s.length());
        }
        return max;
    }
}

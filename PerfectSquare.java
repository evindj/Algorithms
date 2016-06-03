import java.util.*;

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/
public class PerfectSquare {

  public int numSquares(int n) {
    public int numSquares(int n) {
       int[] record = new int[n+1];
        for(int i=1;i<=n;++i){
            record[i] = i;
            for(int j=(int)Math.sqrt(i);j*j*record[i]>i;--j){
                record[i] = Math.min(record[i-j*j]+1,record[i]);
            }
        }
        return record[n];

      }
   }


   public int numSquaresSlow(int n) {
        ArrayList<Integer> squares = getSquareLessThan(n);
        int[][] res = new int[n+1][squares.size()];
        for(int i =0; i < squares.size(); i++){
            res[0][i] = 0;
        }
        for(int i =0; i <= n; i++){
            res[i][0] = i;
        }
        for(int i =1; i <= n; i++){
            for(int j= 1; j< squares.size(); j++){
                int temp = i - squares.get(j);
                if(temp >=0 )
                    res[i][j]= Math.min(getNumber(squares,i,squares.size()-1), 1+res[temp][j]);
                else
                    res[i][j] = getNumber(squares,i,squares.size());
            }
        }
       int result = res[n][squares.size() -1];
       for(int i =0; i< squares.size(); i++){
         if(result > res[n][i])
              result = res[n][i];
       }
      return result;

    }

   public int numSquaresReCursive(int n) {
       ArrayList<Integer> squares = getSquareLessThan(n);
       int res = Integer.MAX_VALUE;
       if(squares.size() < 2) return n;
       for(int i =squares.size()-1; i>0; i-- ){
           int tempRes = Math.min(getNumber(squares,n,i), 1+numSquaresReCursive(n-squares.get(i)));
           if(tempRes< res) res = tempRes;
       }

      return res;

   }
   private int handle(ArrayList<Integer> squares, int sum, int position){
        while( position>=0 && sum < squares.get(position)) position--;
        if(position <= 0) return sum;
        return 1 + handle(squares, sum - squares.get(position),position);
   }
   private int getNumber(ArrayList<Integer> squares, int sum, int position){
       int res = 0;
       while(sum > 0){
           while(sum < squares.get(position)&& position>=0) position--;
           sum = sum - squares.get(position);
           res++;
       }
       return res;
   }
   private ArrayList<Integer> getSquareLessThan(int n){
       ArrayList<Integer> res = new ArrayList<>();
       for(int i =1; i*i<= n; i++){
           res.add(i*i);
       }
       return res;
   }

    public static void main(String args[]){
      PerfectSquare p = new PerfectSquare();
      System.out.println(p.numSquares(43));
      System.out.println(p.numSquaresReCursive(43));
    }
}

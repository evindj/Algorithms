import java.util.*;
public class PlusOne{
  public int[] plusOne(int[] digits){
    int i = digits.length -1;
    while(i>=0 && digits[i]==9){
      digits[i]= 0;
      i--;
    }
    if(i>=0){
      digits[i]=digits[i]+1;
      return digits;
    }
    else{
      int[] res =  new int[digits.length +1];
      res[0]= 1;
      for(int j =1; j<res.length; j++){
        res[j]=0;
      }
      return res;
    }
  }
  public static void main(String ...){

  }
}

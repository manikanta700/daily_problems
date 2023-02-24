import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        ArrayList<Integer> res = new ArrayList<>();

        subsum(0,num.length,0,res,num);
        Collections.sort(res);
        return res;
        
        
    }
    public static void subsum(int i,int n,int sum,ArrayList<Integer> res,int num[]){
        if(i==n){
            res.add(sum);
            return;
        }
        
        //subsum(i+1,n,sum+num[i],res,num);
        subsum(i+1,n,sum,res,num);
         subsum(i+1,n,sum+num[i],res,num);
        

    }

}

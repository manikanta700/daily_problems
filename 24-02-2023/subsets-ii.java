class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> slis = new ArrayList<>();

        Arrays.sort(nums);

        subsum(0,nums.length,slis,res,nums);
        
        return res;
        
    }
    public static void subsum(int i,int n,ArrayList<Integer> lis,List<List<Integer>> res,int num[]){

        res.add(new ArrayList(lis));

        for(int j=i;j<n;j++){
            if(i!=j && num[j]==num[j-1]) continue;
            lis.add(num[j]);
            subsum(j+1,n,lis,res,num);
            lis.remove(lis.size()-1);

        }
    
        

    }
}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> set = new HashSet<>();
        set.add(0);

        DFS(0,set,rooms);
        if(set.size()==rooms.size())return true;
        return false;
        
    }
    public void DFS(int src,Set set,List<List<Integer>> rooms){

        for(int i:rooms.get(src)){
            if(!set.contains(i)){
                set.add(i);
                DFS(i,set,rooms);
            }
        }
    }
}

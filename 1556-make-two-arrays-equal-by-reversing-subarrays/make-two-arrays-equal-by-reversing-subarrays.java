class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> map= new HashMap<>();

        //Adding arr elements
        for (int ele: arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        //Removing target elements
        for (int ele: target){
            if (!map.containsKey(ele))
                return false;
            
            if (map.get(ele)==1)
                map.remove(ele);
            else 
                map.put(ele,map.get(ele)-1);
        }
        
        return map.isEmpty();
    }
}
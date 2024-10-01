class Solution {
    public boolean canArrange(int[] arr, int k) {
        //BRUTE FORCE METHOD
        /*
        boolean[] store= new boolean[arr.length];
        for (int i=0; i<arr.length; i++){
            if (!store[i]){
                boolean found= false;
                for (int j=i+1; j<arr.length; j++){
                    if (!store[j] && (arr[i]+arr[j])%k==0){
                        found= true;
                        store[j]= true;
                        break; //a pair is found
                    }
                }
                if (!found)
                    return false;
            }
            store[i]= true;
        }
        return true;
        //TC is O(n^2) and SC is O(n)
        //TLE
         */

        //OPTIMAL METHOD:- USING HASHMAP
        //Logic:Find remainders in an array and perform two sum

        HashMap<Integer,Integer> map= new HashMap<>();
        //Perform 2 sum
        for (int ele: arr){
            int rem= (ele%k + k) % k; //handle negative numbers also
            int comp= (k-rem) % k;
            if (map.containsKey(comp)){
                if (map.get(comp)>1) //Occur more than 1 time
                    map.put(comp, map.get(comp)-1); //Remove 1 occurrence
                else //Occur only once
                    map.remove(comp); //Remove that element
            }
            else
                map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return map.isEmpty();
        //TC is O(n) and SC is O(k)
    }
}
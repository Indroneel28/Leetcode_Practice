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
            ele= (ele%k + k) % k; //handle negative numbers also
            if (map.containsKey((k-ele)%k)){ 
                if (map.get((k-ele)%k)>1) //Occur more than 1 time
                    map.put((k-ele)%k, map.get((k-ele)%k)-1); //Remove 1 occurrence
                else //Occur only once
                    map.remove((k-ele)%k); //Remove that element
            }
            else
                map.put(ele,map.getOrDefault(ele,0)+1);
        }
        System.out.println(map);
        if (map.containsKey(0)) { //For 5,10,15,20 if k= 5
            if (map.get(0)%2==0)
                map.remove(0);
            else
                return false;
        }
        return map.isEmpty();
        //TC is O(n) and SC is O(n)
    }
}
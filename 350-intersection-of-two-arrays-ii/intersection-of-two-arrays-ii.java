class Solution {


    //BEST CODE
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap= new HashMap<>(); //key and value

        //We will store common elements in Arraylist
        ArrayList<Integer> list= new ArrayList<>();

        //Extracting elements from the nums1 and put in  hashmap
        for (int ele: nums1){
            hashMap.put(ele,hashMap.getOrDefault(ele,0)+1);
        }

        //Common elements will added in the list and value is reduced
        for (int ele: nums2){
            if (hashMap.containsKey(ele)){
                if (hashMap.get(ele)==1) //it will become 0 after removal, therefore we have to remove the key
                    hashMap.remove(ele);
                else
                    hashMap.put(ele,hashMap.get(ele)-1); //value is reduced by 1
                list.add(ele); //the element ele is common and so added in the list
            }
        }

        //converting arraylist to integer array
        int[] answer= new int[list.size()];
        for (int i=0; i<list.size(); i++){
            answer[i]= list.get(i);
        }
        return answer;
    }




    //BAD CODE BUT DONE IN ONE GO

    // public int[] intersect(int[] nums1, int[] nums2) {
    //     HashMap<Integer,Integer> hashMap1= new HashMap<>(); //key and value
    //     HashMap<Integer,Integer> hashMap2= new HashMap<>();

    //     //Extracting elements from the arrays and putting it to it's respective hashmaps
    //     for (int ele: nums1){
    //         hashMap1.put(ele,hashMap1.getOrDefault(ele,0)+1);
    //     }

    //     for (int ele: nums2){
    //         hashMap2.put(ele,hashMap2.getOrDefault(ele,0)+1);
    //     }

    //     //As for constraints
    //     //0 <= nums1[i], nums2[i] <= 1000
    //     //This means from 0 to 1000 values is there inside the both arrays

    //     //We will store common elements in Arraylist
    //     ArrayList<Integer> list= new ArrayList<>();

    //     //From 0 to 1000
    //     for (Integer i=0; i<=1000; i++){
    //         //If i is present in both hashmaps
    //         Integer a= hashMap1.get(i), b= hashMap2.get(i);
    //         if (a!=null && b!=null){ //a=null & b=null if i is not present in both the array
    //             //common values i
    //             int common= Math.min(a,b);
    //             //So, we will add 'i' in the list for 'common' times
    //             for (int m=1; m<=common; m++)
    //                 list.add(i);
    //         }
    //     }
        
    //     int[] answer= new int[list.size()];
    //     for (int i=0; i<list.size(); i++){
    //         answer[i]= list.get(i);
    //     }
    //     return answer;
    // }
}
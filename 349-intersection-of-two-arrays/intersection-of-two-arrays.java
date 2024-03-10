class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //METHOD 1:- USING HASHSET AND ARRAYLIST
        /*
        HashSet<Integer> set1= new HashSet<>();
        ArrayList<Integer> store= new ArrayList<>();
        for (int j : nums1)
            set1.add(j);
        for (int j : nums2) {
            if (set1.contains(j) && !store.contains(j))
                store.add(j);
        }
        int[] arr= new int[store.size()];
        for (int i=0; i<arr.length; i++)
            arr[i]= store.get(i);
        return arr;
         */

        //METHOD 2:- USING HASHSET'S .retainAll Method
        //Note:- Duplicate values are ignored
        HashSet<Integer> set1= new HashSet<>();
        HashSet<Integer> set2= new HashSet<>();
        for (int element: nums1)
            set1.add(element);
        for (int element: nums2)
            set2.add(element);

        set1.retainAll(set2); //All common elements are stored in set1
        int[] arr= new int[set1.size()];
        int index= 0;
        for (int element: set1)
            arr[index++]= element;
        return arr;
    }
}
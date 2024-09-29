class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //BRUTE FORCE METHOD
        /*
        int[] arr= new int[nums1.length];
        for (int i=0; i<nums1.length; i++){
            int ele= nums1[i], nge= -1;
            boolean found= false;
            for (int j=0; j<nums2.length; j++){
                if (ele==nums2[j]){
                    found= true;
                if (found && nums2[j]>ele){
                    nge= nums2[j];
                    break;
                }
            }
            arr[i]= nge;
        }
        return arr;
         */
        //TC is O(m*n) and SC is O(n)

        //OPTIMAL METHOD
        HashMap<Integer,Integer> map= new HashMap<>();
        Stack<Integer> stack= new Stack<>();
        int[] ans= new int[nums1.length];

        //Move from right to left in nums2 array
        for (int i= nums2.length-1; i>=0; i--){
            int ele= nums2[i], nge= -1;
            while (!stack.isEmpty() && stack.peek()<=ele){
                stack.pop();
            }
            if (!stack.isEmpty())
                nge= stack.peek();
            stack.push(ele);
            map.put(ele,nge); //Will store ele and it's NGE
        }

        for (int i=0; i<nums1.length; i++){
            ans[i]= map.get(nums1[i]);
        }
        return ans;
        //TC is O(m+m+n) and SC is O(2m+m+n)
    }
}
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        //METHOD 1:- USING ARRAYLIST
        ArrayList<Integer> list1= new ArrayList<>();
        ArrayList<Integer> list2= new ArrayList<>();
        for (int num: nums){
            if (num<pivot)
                list1.add(num);
            else if (num==pivot)
                list2.add(0,num);
            else 
                list2.add(num);;
        }
        int k=0;
        for (int ele: list1)
            nums[k++]= ele;
        for (int ele: list2)
            nums[k++]= ele;
        return nums;
        //TC is O(2n) and SC is O(n)
    }
}
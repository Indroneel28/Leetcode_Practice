class Solution {
    public boolean canSortArray(int[] nums) {
        for (int i=0; i<nums.length-1; i++){
            for (int j=0; j<nums.length-1-i; j++){
                if (nums[j+1]<nums[j]){
                    if (countBits(nums[j+1])==countBits(nums[j])){
                        int temp= nums[j];
                        nums[j]= nums[j+1];
                        nums[j+1]=temp;
                    }
                    else {
                        System.out.println(i+" "+j);
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private int countBits(int num){
        int count= 0;
        while (num!=0){
            int rem= num%2;
            count+=rem;
            num/=2;
        }
        return count;
    }
}
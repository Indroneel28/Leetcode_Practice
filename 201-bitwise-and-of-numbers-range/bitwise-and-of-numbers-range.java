class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count= 0;
        while (left!=0 && right!=0){
            if (left==right)
                return left<<count;
            else {
                count++;
                left >>>= 1;
                right >>>= 1;
            }
        }
        return 0;
    }
}
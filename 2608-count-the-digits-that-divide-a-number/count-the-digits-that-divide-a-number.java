class Solution {
    public int countDigits(int num) {
        int count=0, dup= num;
        while (dup!=0){
            int rem= dup%10;
            if (num%rem==0)
                count++;
            dup/=10;
        }
        return count;
    }
}
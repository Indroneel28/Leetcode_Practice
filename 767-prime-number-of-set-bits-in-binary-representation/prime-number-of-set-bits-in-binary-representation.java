class Solution {
    public static boolean prime(int num){
        if (num<=1)
            return false;
        for (int i=2; i<num; i++){
            if (num%i==0)
                return false;
        }
        return true;
    }

    public int countPrimeSetBits(int left, int right) {
        int answer= 0;
        for (int i=left; i<=right; i++){
            int count1=0;
            int store= i;
            while (store!=0){
                count1+=(store&1);
                store>>>=1;
            }
            if (prime(count1))
                answer++;
        }
        return answer;
    }
}
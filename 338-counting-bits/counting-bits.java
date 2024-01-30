class Solution {
    public static int count1(int num){
        int count=0;
        while (num!=0){
            if (num%2==1)
                count++;
            num/=2;
        }
        return count;
    }
    public int[] countBits(int n) {
        int[] arr= new int[n+1];
        for (int i=0; i<=n; i++){
            arr[i]= count1(i);
        }
        return arr;
    }
}
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hashMap= new HashMap<>();
        for (int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }
//        System.out.println(hashMap);
        int countOdd=0, sum=0;
        for (int ele: hashMap.values()){
            if (ele%2==1) {
                countOdd++;
                sum+= ele-1;
            }
            else
                sum+=ele;
        }
        if(countOdd>0) //We can put one odd element at centre
            sum++;
        return sum;
    }
}
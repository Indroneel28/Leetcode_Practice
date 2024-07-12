class Solution {
    // public int maxSum= 0;
    // public int maximumGain(String s, int x, int y) {
    //     //USING GREEDY APPROACH
    //     if (x>y){
    //         while (s.contains("ab"))
    //             s= removeABforX(s,x);
    //         while (s.contains("ba"))
    //             s= removeBAforY(s,y);
    //     }
    //     else{
    //         while (s.contains("ba"))
    //             s= removeBAforY(s,y);
    //         while (s.contains("ab"))
    //             s= removeABforX(s,x);
    //     }
    //     return this.maxSum;
    // }

    // private String removeABforX(String s, int x){
    //     StringBuilder result= new StringBuilder();
    //     int i=0;
    //     for (i=0; i<s.length()-1; i++){
    //         if (s.charAt(i)=='a'&& s.charAt(i+1)=='b') {
    //             maxSum+= x;
    //             i++; //Two times i++ to skip "ab"
    //         }
    //         else
    //             result.append(s.charAt(i));
    //     }
    //     if (i==s.length()-1)
    //         result.append(s.charAt(i));
    //     return result.toString();
    // }

    // private String removeBAforY(String s, int y){
    //     StringBuilder result= new StringBuilder();
    //     int i=0;
    //     for (i=0; i<s.length()-1; i++){
    //         if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'a') {
    //             maxSum+=y;
    //             i++;
    //         }
    //         else
    //             result.append(s.charAt(i));
    //     }
    //     if (i==s.length()-1)
    //         result.append(s.charAt(i));
    //     return result.toString();
    // }
    public int maximumGain(String s, int x, int y) {
    int aCount = 0;
        int bCount = 0;
        int lesser = Math.min(x, y);
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 'b') {
                result += Math.min(aCount, bCount) * lesser;
                aCount = 0;
                bCount = 0;
            } else if (c == 'a') {
                if (x < y && bCount > 0) {
                    bCount--;
                    result += y;
                } else {
                    aCount++;
                }
            } else {
                if (x > y && aCount > 0) {
                    aCount--;
                    result += x;
                } else {
                    bCount++;
                };
            }
        }
        
        result += Math.min(aCount, bCount) * lesser;
        
        return result;
}
}
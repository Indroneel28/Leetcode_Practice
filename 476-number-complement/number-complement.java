class Solution {
    public int findComplement(int num) {
        StringBuilder num1= new StringBuilder(Integer.toBinaryString(num));
        //System.out.println(num1);
        for (int i=0; i<num1.length(); i++){
            if (num1.charAt(i)=='0'){
                num1.setCharAt(i,'1');
            }
            else{
                num1.setCharAt(i,'0');
            }
        }
        //System.out.println(num1);
        int ans= Integer.valueOf(num1.toString(),2);
        return ans;
    }
}
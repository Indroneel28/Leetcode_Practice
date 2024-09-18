class Solution {
    public String largestNumber(int[] nums) {
        //USING SORTING
        ArrayList<String> list= new ArrayList<>();
        for (int num: nums){
            list.add(Integer.toString(num));
        }

        list.sort((a,b) -> {
            StringBuilder sb1= new StringBuilder();
            sb1.append(a); sb1.append(b);
            StringBuilder sb2= new StringBuilder();
            sb2.append(b); sb2.append(a);
            int i= 0, j= 0;
            while(i<sb1.length() && j<sb2.length()){
                if (sb1.charAt(i)==sb2.charAt(i)){
                    i++; j++;
                }
                else if (sb1.charAt(i)>sb2.charAt(j))
                    return -1;
                else
                    return 1;
            }
            return 0; //sb1 is same as sb2 => a and b are same
        });

        StringBuilder sb= new StringBuilder();
        for (String s: list)
            sb.append(s);

        for (int i=0; i< sb.length(); i++){
            if (sb.charAt(i)!='0')
                return sb.toString(); //If any char is not 0 means sb.toString() is our answer
        }
        return "0"; //For "00" , "000" , ... edge cases
        //TC is O(n + nlogn + n) and SC is O(n)
    }
}
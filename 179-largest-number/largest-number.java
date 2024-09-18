class Solution {
    public String largestNumber(int[] nums) {
        //USING SORTING
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(Integer.toString(num));
        }

        //Explanation for Comparator
        /*
        list.sort((a, b) -> {
            StringBuilder sb1 = new StringBuilder();
            sb1.append(a);
            sb1.append(b);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b);
            sb2.append(a);
            int i = 0, j = 0;
            while (i < sb1.length() && j < sb2.length()) {
                if (sb1.charAt(i) == sb2.charAt(i)) {
                    i++;
                    j++;
                } else if (sb1.charAt(i) > sb2.charAt(j))
                    return -1;
                else
                    return 1;
            }
            return 0; //sb1 is same as sb2 => a and b are same
        });
         */

        //One liner Comparator using Lambda function
        list.sort((a,b)-> (b+a).compareTo(a+b));

        StringBuilder sb = new StringBuilder();
        for (String s : list)
            sb.append(s);

        if (sb.charAt(0) == '0')//For "00" , "000" , ... edge cases
            return "0";
        return sb.toString(); //If any char is not 0 means sb.toString() is our answer
        // TC is O(n + k*nlogn + n) and SC is O(n)
        //The comparison function takes O(k) time, where k is the maximum number of digits in the numbers
    }
}
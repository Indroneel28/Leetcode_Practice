class Solution {
    public String kthDistinct(String[] arr, int k) {
        //METHOD 1:- BRUTE FORCE APPROACH
        int count= 0;
        for (int i=0; i<arr.length; i++){
            int occurence= 0; //will count occurrence of arr[1
            for (int j=0; j<arr.length; j++){
                if (arr[i].equals(arr[j])){
                    occurence++;
                }
            }
            if (occurence==1){ //means arr[i] is distinct and unique in the array
                count++;
                if (count==k)
                    return arr[i];
            }
        }
        return "";
        //TC is O(n^2) and SC is O(1)
    }
}
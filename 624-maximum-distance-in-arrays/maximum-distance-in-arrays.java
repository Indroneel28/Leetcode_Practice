class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        //Let's find maximum first and then  minimum
        int max1= Integer.MIN_VALUE, max1Index= -1, min1= Integer.MAX_VALUE, min1Index= -1;
        for (int i=0; i<arrays.size(); i++){
            int len= arrays.get(i).size();
            if (arrays.get(i).get(len-1)>max1){
                max1= arrays.get(i).get(len-1);
                max1Index= i;
            }
            if (arrays.get(i).get(0)<min1){
                min1= arrays.get(i).get(0);
                min1Index= i;
            }
        }
        if (max1Index!=min1Index) //It means the arrays are not same
            return Math.abs(max1-min1);

        //If single array contain both maximum and minimum i.e maxIndex == minIndex
        //Then we will find relative max and min
        int max2= Integer.MIN_VALUE, min2= Integer.MAX_VALUE;
        for (int i=0; i<arrays.size(); i++){
            int len= arrays.get(i).size();
            if (arrays.get(i).get(0)<min2 && i!=max1Index){
                min2= arrays.get(i).get(0);
            }
            if (arrays.get(i).get(len-1)>max2 && i!=min1Index){
                max2= arrays.get(i).get(len-1);
            }
        }
        
        int diff1= Math.abs(max1-min2), diff2= Math.abs(max2-min1);
        return Math.max(diff1, diff2);
        
        //TC is O(2n) and SC is O(1)
    }
}
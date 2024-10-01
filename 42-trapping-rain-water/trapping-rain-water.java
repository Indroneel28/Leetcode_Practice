class Solution {
    public int trap(int[] height) {
        //BY USING PREFIX MAX AND SUFFIX MAX ARRAY
        int[] prefixMax= new int[height.length];
        int[] suffixMax= new int[height.length];
        
        //Calculate prefix max
        prefixMax[0]= height[0];
        for (int i=1; i<height.length; i++){
            prefixMax[i]= Math.max(prefixMax[i-1],height[i]);
        }
        
        //Calculate suffix max
        suffixMax[height.length-1]= height[height.length-1];
        for (int i=height.length-2; i>=0; i--){
            suffixMax[i]= Math.max(suffixMax[i+1],height[i]);
        }

        int blocksOfWater= 0;
        for (int i=0; i<height.length; i++){
            blocksOfWater += Math.min(prefixMax[i],suffixMax[i])-height[i];
        }
        return blocksOfWater;
        
        //TC is O(3n) and SC is O(2n)
    }
}
class Solution {
    public boolean checkIfExist(int[] arr) {
        //BRUTE FORCE METHOD
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if (i!=j && arr[i]==2*arr[j])
                    return true;
            }
        }
        return false;
        //TC is O(n^2) and SC is O(1)
    }
}
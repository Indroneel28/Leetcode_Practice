class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int total= 0;
        int t= -1;
        int storeM=0, storeP=0, storeG=0;
        for (String str: garbage){
            if (t>=0 && t<travel.length) {
                storeM+=travel[t];
                storeP+=travel[t];
                storeG+=travel[t];
                if (str.contains("M")) {
                    total += storeM;
                    storeM= 0;
                }
                if (str.contains("P")) {
                    total += storeP;
                    storeP= 0;
                }
                if (str.contains("G")) {
                    total += storeG;
                    storeG= 0;
                }
            }
            total+=str.length();
            t++;
        }
        return total;
    }
}
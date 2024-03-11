class Solution {
    public String customSortString(String order, String s) {
        int[] orderSTore= new int[order.length()];
        String store="";
        for (int i=0; i<s.length(); i++){
            int index= order.indexOf(s.charAt(i));
            if (index!=-1)
                orderSTore[index]++;
            else 
                store+=s.charAt(i);
        }
        String answer= "";
        for (int i=0; i<orderSTore.length; i++){
            if (orderSTore[i]>0){
                answer+=order.charAt(i);
                orderSTore[i]--;
                i--;
            }
        }
        return answer+store;
    }
}
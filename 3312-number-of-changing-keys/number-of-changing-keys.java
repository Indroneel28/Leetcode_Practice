class Solution {
    public int countKeyChanges(String s) {
        int count= 0;
        for (int i=0; i<s.length()-1; i++){
            char a= s.charAt(i);
            char b= s.charAt(i+1);
            if (Character.toUpperCase(a)!=Character.toUpperCase(b))
                count++;
        }
        return count;
    }
}
class Solution {
    public int minOperations(String[] logs) {
        int count=0;
        for (String file: logs){
            if (file.startsWith("../")){
                if(count>=1)
                    count--;
            }
            else if (!file.startsWith("./")) //does not start with ./ means it ends like x/
                count++;
        }
        return count;
    }
}
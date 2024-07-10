class Solution {
    public int nextBeautifulNumber(int n) {
        int value= n+1;
        while (!checkBalanceNumber(value)){ //loop will run until n is not balance number
            value++;
        }
        return value;
    }
    
    private boolean checkBalanceNumber(int num){
        HashMap<Integer,Integer> map= new HashMap<>();
        while (num!=0){
            int rem= num%10;
            map.put(rem,map.getOrDefault(rem,0)+1);
            num/=10;
        }
        //Accessing elements of HashMap using Map.Entry and entrySet()
        for (Map.Entry<Integer,Integer> item: map.entrySet()){
            if (!item.getKey().equals(item.getValue())) //key and value are not equal means not balance
                return false;
        }
        return true;
    }
}
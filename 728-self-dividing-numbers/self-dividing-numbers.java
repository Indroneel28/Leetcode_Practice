class Solution {
    public static boolean selfDivNum(int num){
        int dup= num;
        while (num!=0){
            int rem= num%10;
            if (rem==0 || dup%rem!=0)
                return false;
            num/=10;
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list= new ArrayList<>();
        for (int i=left; i<=right; i++){
            if (selfDivNum(i))
                list.add(i);
        }
        return list;
    }
}
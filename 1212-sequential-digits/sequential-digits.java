class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list= new ArrayList<>();
        String str= "123456789";
        for (int i=0; i<str.length(); i++){
            for (int j=i+1; j<=str.length(); j++){ // <= so that last element can be included as substring stops at stop-1
                int num= Integer.parseInt(str.substring(i,j));
                if (num>=low && num<=high)
                    list.add(num);
            }
        }
        list.sort(null);
        return list;
    }
}
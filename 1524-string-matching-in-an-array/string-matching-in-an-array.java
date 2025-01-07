class Solution {
    public List<String> stringMatching(String[] words) {
        //OPTIMAL METHOD
        String str= String.join(" ",words);
        List<String> list= new ArrayList<>();
        for (int i=0; i<words.length; i++){
            if (str.indexOf(words[i])!=str.lastIndexOf(words[i]))
                list.add(words[i]);
        }
        return list;
        //TC is O(n^2) and SC is O(2n)
        //indexOf() will traverse again
    }
}
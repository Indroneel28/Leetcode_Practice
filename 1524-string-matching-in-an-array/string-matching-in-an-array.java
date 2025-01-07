class Solution {
    public List<String> stringMatching(String[] words) {
        //METHOD 1:- BRUTE FORCE METHOD
        List<String> list= new ArrayList<>();
        for (int i=0; i< words.length; i++){
            for (int j=0; j<words.length; j++){
                if (i!=j)
                    if (words[j].contains(words[i])) {
                        list.add(words[i]);
                        break;
                    }
            }
        }
        return list;
        //TC is O(n^3) and SC is O(n)
    }
}
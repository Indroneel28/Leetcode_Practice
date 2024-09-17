class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        //METHOD 1:- USING HASHSET
        /*
        String[] list1= s1.split(" ");
        String[] list2= s2.split(" ");

        HashSet<String> common= new HashSet<>(); //To store common elements
        HashSet<String> uncommon= new HashSet<>(); //To store uncommon elements

        //Insert all the words from list1 into the set
        for (String item: list1){
            if (uncommon.contains(item) || common.contains(item)) { //Duplicate found =>remove it
                uncommon.remove(item);
                common.add(item);
            }
            else
                uncommon.add(item); //Unique word, so add it into the set
        }
        //Insert all the words from list2 into the set
        for (String item: list2){
            if (uncommon.contains(item) || common.contains(item)) { //Duplicate found =>remove it
                uncommon.remove(item);
                common.add(item);
            }
            else
                uncommon.add(item); //Unique word, so add it into the set
        }

        String[] answer= new String[uncommon.size()];
        int i=0;
        for (String uniqueWord: uncommon){
            answer[i++]= uniqueWord;
        }
        return answer;
        //TC is O(2(m+n)) and SC is O(m+n+(m+n)+(m+n))
        //WE COULD DIRECTLY SOLVE USING HASHMAP BUT I TRIED TO DO IT WITH HASHSET TO LEARN AND PRACTICE MORE!!
        //BEAT 100%
         */

        //METHOD 2:- USING HASHMAP
        //Count all the occurrences of the words
        HashMap<String,Integer> map= new HashMap<>();

        String[] list1= s1.split(" ");
        String[] list2= s2.split(" ");

        //Put all the words from both arrays into HashMap
        for (String word: list1){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for (String word: list2){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        ArrayList<String> list= new ArrayList<>();
        for (String word: map.keySet()){
            if (map.get(word)==1)
                list.add(word);
        }
        return list.toArray(new String[0]);
        //TC is O(2(m+n)) and SC is O(m+n+(m+n)+(m+n))
    }
}
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        //USING HASHSET
        String[] list1= s1.split(" ");
        String[] list2= s2.split(" ");

        HashSet<String> common= new HashSet<>();
        HashSet<String> uncommon= new HashSet<>();

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
    }
}
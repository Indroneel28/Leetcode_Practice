class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> map= new HashMap<>();
        for (int i=0; i<word.length(); i++){
            map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0)+1);
        }

        ArrayList<Character> list= new ArrayList<>();

        //System.out.println(map);

        //Map can contain atmost 26 keys
        while (!map.isEmpty()) {
            Character c= null;
            int val= 0;
            for (Map.Entry<Character, Integer> ele : map.entrySet()) {
                if (ele.getValue()>val) {
                    c = ele.getKey();
                    val= ele.getValue();
                }
            }
            map.remove(c);
            list.add(c);
        }

        //System.out.println(list);
        

        //ArrayList contain the most occurring element
        //& keys are there in mobile in which we can keep characters
        int sum= 0;
        for (int i=0; i<word.length(); i++){
            char c= word.charAt(i);
            int value= list.indexOf(c)/8;
            sum += (value+1);
        }
        return sum;
    }
}
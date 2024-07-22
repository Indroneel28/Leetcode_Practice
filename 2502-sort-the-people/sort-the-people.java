

//METHOD 2:- BY USING HASHMAP
public class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int len= names.length;
        HashMap<Integer,String> map= new HashMap<>();
        for (int i=0; i<len; i++){
            map.put(heights[i],names[i]);
        }
        Arrays.sort(heights);

        String[] answer= new String[len];
        for (int i=0; i<len; i++){
            answer[i]= map.get(heights[len-1-i]);
        }
        return answer;
    }
}

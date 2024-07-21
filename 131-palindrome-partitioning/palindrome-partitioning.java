class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer= new ArrayList<>();
        List<String> list= new ArrayList<>();
        helper(answer,list,0,s);
        return answer;
    }

    //Method to iterate all the substring O(2^n)
    private void helper(List<List<String>> answer, List<String> list, int index, String s){
        if (index==s.length()){
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i=index; i<s.length(); i++){
            if (isPallindrome(s,index,i)){
                list.add(s.substring(index,i+1));
                helper(answer,list,i+1,s);
                list.remove(list.size()-1); //Remove last inserted element- BackTrack
            }
        }
    }

    //Method to check whether a String is pallindrome or not
    private boolean isPallindrome(String s, int i, int j){
        while (i<=j){
            if (s.charAt(i)!=s.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
}
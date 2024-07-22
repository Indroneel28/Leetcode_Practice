class Solution {
    //Method 1:- Brute Force Method:- TLE
    /*
    public String getPermutation(int n, int k) {
        ArrayList<String> answer= new ArrayList<>();
        recursion(answer,"",0,n);

        answer.sort((a, b) -> (int) (Long.parseLong(a) - Long.parseLong(b)));

        //System.out.println(answer); //Testing
        return answer.get(k-1); //0-based indexing
    }

    private void recursion(ArrayList<String> answer,String s, int index, int n){
        if (index==n){
            //System.out.println(s); //Testing
            answer.add(s);
            return;
        }
        for (int i=1; i<=n;i++){
            if (!s.contains(i+""))
                recursion(answer,s+i,index+1,n);
        }
    }
     */

    //Method 2:- Optimized Method
    public String getPermutation(int n, int k) {
        int fact= 1;
        ArrayList<Integer> numbers= new ArrayList<>();
        for (int i=1; i<n; i++){
            fact*=i;
            numbers.add(i);
        }
        numbers.add(n);

        String ans="";
        k= k-1; //because of 0-based indexing

        while (true){
            ans+= numbers.get(k/fact);
            numbers.remove(k/fact);
            if (numbers.size()==0)
                break;
            k= k%fact;
            fact= fact/numbers.size();
        }
        return ans;
    }
}
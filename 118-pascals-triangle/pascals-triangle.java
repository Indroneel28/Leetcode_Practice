class Solution {
    public List<List<Integer>> generate(int numRows) {
        //METHOD 1:- BRUTE FORCE APPROACH
        /*
        List<List<Integer>> list= new ArrayList<>(numRows);
        for (int i=0; i<numRows; i++){
            List<Integer> store= new ArrayList<>();
            for (int j=0 ;j<=i; j++){
                if (j==i || j==0)
                    store.add(1);
                else {
                    store.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(store);
        }
        return list;
         */
        //TC is O(n^2) and SC is O(n^2)

        //METHOD 2:- OPTIMAL APPROACH
        List<List<Integer>> answer= new ArrayList<>();

        //store the entire pascal's triangle
        for (int row=1; row<=numRows; row++){
            answer.add(generateRow(row));
        }
        return answer;
        //TC is O(n^2) and SC is O(1)
    }

    //Helper Method
    private List<Integer> generateRow(int row){
        long ans= 1;
        List<Integer> ansRow= new ArrayList<>();
        ansRow.add(1); //Inserting the 1st element

        //calculate the rest of the elements:
        for (int col=1 ;col<row; col++){
            ans= ans*(row-col);
            ans/=col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
}
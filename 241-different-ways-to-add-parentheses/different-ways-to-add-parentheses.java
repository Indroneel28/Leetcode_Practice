class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        //RECURSION METHOD

        //Data structure to store different answers
        List<Integer> result= new ArrayList<>();

        for (int i=0; i< expression.length(); i++){
            if (expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*'){
                //Solve left substring
                List<Integer> left= diffWaysToCompute(expression.substring(0,i));
                //Solve right substring
                List<Integer> right= diffWaysToCompute(expression.substring(i+1));

                for (int a: left){
                    for (int b: right){
                        if (expression.charAt(i)=='+')
                            result.add(a+b);
                        else if (expression.charAt(i)=='-')
                            result.add(a-b);
                        else if (expression.charAt(i)=='*')
                            result.add(a*b);
                    }
                }
            }
        }
        //System.out.println(result);
        if (result.isEmpty())
            result.add(Integer.parseInt(expression));
        return result;
        //TC is O(n*(2^n)) and SC is O(n)
    }
}
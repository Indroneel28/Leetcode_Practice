class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Element> queue= new PriorityQueue<>();

        //Brute Force Approach as asked in the question
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j< arr.length; j++){
                Element ele= new Element(arr[i],arr[j]);
                queue.add(ele);
            }
        }

        //Returning the answer array
        int[] ans= new int[2];
        Element e=null;
        for (int i=1; i<=k; i++)
            e= queue.poll();
        ans[0]= e.numerator; //0th index is numerator
        ans[1]= e.denominator; //1st index is denominator
        return ans;
    }
}

class Element implements Comparable<Element>{
    int numerator;
    int denominator;

    //Constructor
    public Element(int numerator,int denominator){
        this.numerator= numerator;
        this.denominator= denominator;
    }

    @Override
    public int compareTo(Element e){
        double d1= this.numerator, d2= this.denominator;
        double e1= e.numerator, e2= e.denominator;
        return Double.compare((d1/d2),(e1/e2));
    }
}
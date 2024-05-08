class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Element> store= new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=0; i<score.length; i++){
            store.add(new Element(score[i],i));
        }

        Integer x= 1;
        String[] answer= new String[score.length];
        while (!store.isEmpty()){
            Element ele= store.poll();
            if (x==1)
                answer[ele.index]= "Gold Medal";
            else if (x==2)
                answer[ele.index]="Silver Medal";
            else if (x==3)
                answer[ele.index]= "Bronze Medal";
            else
                answer[ele.index]= x.toString();
            x++;
        }
        return answer;
    }
}

class Element implements Comparable<Element>{
    int value;
    int index;

    public Element(int value, int index){
        this.value= value;
        this.index= index;
    }

    @Override
    public int compareTo(Element o) {
        return Integer.compare(this.value,o.value);
    }
}

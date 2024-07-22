class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        ArrayList<Name> list= new ArrayList<>();
        for (int i=0; i<names.length; i++){
            Name<String,Integer> name= new Name<>(names[i],heights[i]);
            list.add(name);
        }
        Collections.sort(list);
        String[] answer= new String[names.length];
        for (int i=0; i<names.length; i++){
            answer[i]= (String) list.get(i).name;
        }
        return answer;
    }
}

class Name<String,Integer> implements Comparable<Name<String,Integer>>{
    String name;
    int height;

    public Name(String n, int h){
        this.name= n;
        this.height= h;
    }

    @Override
    public int compareTo(Name o) {
        return o.height-this.height;
    }
}
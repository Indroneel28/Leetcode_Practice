class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue= new LinkedList<>(); //will store students
        for (int ele: students)
            queue.add(ele);
        
        int count= 0; //count counts number of students eaten sandwiches
        int c= 0; //counter
        int i= 0;
        while (!queue.isEmpty()){
            if (queue.peek()==sandwiches[i]){
                count++; i++;
                c= 0;
                queue.poll(); 
            }
            else{
                int ele= queue.poll();
                queue.offer(ele);
                c++; //Shifting
            }
            if (c>=students.length)
                break;
        }
        return students.length-count;
    }
}
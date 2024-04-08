class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>(); //will store sandwiches
        Queue<Integer> queue= new LinkedList<>(); //will store students
        for (int ele: students)
            queue.add(ele);
        for (int i=sandwiches.length-1; i>=0; i--){
            stack.add(sandwiches[i]);
        }

        int count= 0; //count counts number of students eaten sandwiches
        int c= 0; //counter
        while (!queue.isEmpty()){
            if (queue.peek()==stack.peek()){
                count++;
                c= 0; 
                queue.poll(); stack.pop();
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
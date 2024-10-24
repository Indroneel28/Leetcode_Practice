class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        //OPTIMAL METHOD:- USING STACK
        Stack<Integer> stack= new Stack<>();
        for (int i=0; i<asteroids.length; i++){
            int asteroid= asteroids[i];
            if (stack.isEmpty() || asteroid>0 || stack.peek()<0)
                stack.push(asteroid);
            else{ //asteroid is -ve and stack peek() maybe positive
                while (true){
                    if (stack.isEmpty()) {
                        stack.push(asteroid); //Negative asteroid destroyed all the asteroids of the stack
                        break;
                    }
                    if (stack.peek()<0) { //If -ve asteroid is there
                        stack.push(asteroid);
                        break;
                    }
                    int previousAsteroid= stack.pop();
                    if (Math.abs(previousAsteroid)==Math.abs(asteroid))
                        break; //Both asteroids will be destroyed
                    else if (Math.abs(previousAsteroid)>Math.abs(asteroid)){
                        stack.push(previousAsteroid);
                        break;
                    }
                }
            }
        }
        int[] ans= new int[stack.size()];
        for (int i=stack.size()-1; i>=0; i--)
            ans[i]= stack.pop();
        return ans;
        //TC is O(2n) and SC is O(2n)
    }
}
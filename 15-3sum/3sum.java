class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //STRIVER'S A TO Z COURSE

        //METHOD 1:- BRUTE FORCE APPROACH
        //Notice that the solution set must not contain duplicate triplets.
        /*
        HashSet<List<Integer>> set= new HashSet<>();
        for (int i=0;i<nums.length; i++){
            for (int j= i+1; j<nums.length; j++){
                for (int k= j+1; k<nums.length; k++){
                    if (i!=j && j!=k && i!=k){
                        if(nums[i]+nums[j]+nums[k]==0){
                            List<Integer> triplet= new ArrayList<>();
                            triplet.add(nums[i]);
                            triplet.add(nums[j]);
                            triplet.add(nums[k]);
                            //OR //List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]); //SHORT-CUT
                            Collections.sort(triplet);
                            set.add(new ArrayList<>(triplet));
                        }
                    }
                }
            }
        }
        List<List<Integer>> answer= new ArrayList<>(set);
        return answer;
         */
        //TC is O(n^3 * nlogn) and SC is O(2 * no. of the unique triplets)

        //METHOD 2:- BETTER SOLUTION USING HASHING
        /*
        HashSet<List<Integer>> answer= new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);
                if (set.contains(third)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(third);
                    Collections.sort(list);
                    answer.add(list);
                }
                set.add(nums[j]); //add arr[j] in hashset //MOST IMP
            }
        }
        return new ArrayList<>(answer);
         */
        //TC is O(n^2 * nlogn) and SC is O(n)

        //METHOD 3:- OPTIMAL SOLUTION

        List<List<Integer>> answer= new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++){
            //Remove duplicates
            if (i!=0 && nums[i]==nums[i-1])
                continue;

            //Moving 2 pointers
            int j= i+1, k= nums.length-1;
            while (j<k){
                int sum= nums[i]+nums[j]+nums[k];
                if (sum<0)
                    j++;
                else if (sum>0)
                    k--;
                else{
                    List<Integer> temp= Arrays.asList(nums[i],nums[j],nums[k]);
                    answer.add(temp);
                    j++; k--;
                    while (j<k && nums[j]==nums[j-1])
                        j++;
                    while (j<k && nums[k]==nums[k+1])
                        k--;
                }
            }
        }
        return answer;
        //TC is O(nlogn + n^2) and SC is O(no. of quadruplets)
    }
}
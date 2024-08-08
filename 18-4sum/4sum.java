class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //METHOD 1:- BRUTE FORCE APPROACH
        /*
        HashSet<List<Integer>> set= new HashSet<>();
        int n= nums.length;
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                for (int k=j+1; k<n; k++){
                    for (int l=k+1; l<n; l++){
                        if (nums[i]+nums[j]+nums[k]+nums[l]==target){
                            List<Integer> list= Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                            Collections.sort(list);
                            set.add(list);
                        }
                    }
                }
            }
        }
        List<List<Integer>> answer= new ArrayList<>(set);
        return answer;
         */
        //TC is O(n^4 * nlogn) and SC is O(1)
        //TLE


        //METHOD 2:- BETTER APPROACH
        /*
        int n= nums.length;
        Set<List<Integer>> set= new HashSet<>();
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                Set<Long> hashset= new HashSet<>();
                for (int k= j+1; k<n; k++){
                    long sum= nums[i] + nums[j];
                    sum += nums[k];
                    long fourth= target-sum;
                    if (hashset.contains(fourth)){
                        List<Integer> list= new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add((int)fourth);
                        Collections.sort(list);
                        set.add(list);
                    }
                    hashset.add((long)nums[k]);
                }
            }
        }
        return new ArrayList<>(set);
         */
        //TC is O(n^3 * nlogn) and SC is O(2 * no. of the quadruplets)+O(N)


        //METHOD 3:- USING 3 POINTERS
        List<List<Integer>> answer= new ArrayList<>();
        Arrays.sort(nums);
        int n= nums.length;

        for (int i=0; i<n; i++){
            //avoid the duplicates while moving i
            if (i>0 && nums[i]==nums[i-1])
                continue;
            for (int j=i+1; j<n; j++){
                //avoid the duplicates while moving j
                if (j>i+1 && nums[j]==nums[j-1])
                    continue;

                int k= j+1, l=n-1;
                while (k<l){
                    //Using "long" to avoid Overflow because of constraints
                    long sum= nums[i];
                    sum+= nums[j];
                    sum+= nums[k];
                    sum+= nums[l];

                    if (sum==target){
                        List<Integer> list= new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);

                        answer.add(list);

                        k++; l--;

                        //skip the duplicates
                        while (k<l && nums[k-1]==nums[k])
                            k++;
                        while (k<l && nums[l]==nums[l+1])
                            l--;
                    }
                    else if (sum<target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return answer;
        //TC is O(n^3) and SC is O(no. of the quadruplets)
    }
}
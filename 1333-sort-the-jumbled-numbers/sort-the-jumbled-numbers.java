class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        //Converting int[] nums to Integer[] arr
        Integer[] arr= Arrays.stream(nums).boxed().toArray(Integer[]::new);

        HashMap<Integer,Long> mappedNums= new HashMap<>();
        for (int i=0; i<nums.length; i++){
            StringBuilder sum1= new StringBuilder();
            int o1= nums[i];
            if(o1==0)
                sum1.insert(0, mapping[o1 % 10]);
            while (o1!=0){
                sum1.insert(0, mapping[o1 % 10]);
                o1= o1/10;
            }
            long a1= 0;
            if (!sum1.isEmpty())
                a1= Long.parseLong(sum1.toString());
            mappedNums.put(nums[i],a1);
        }

        //Comparator can take only Integer not int that's why we converted the array
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Long.compare(mappedNums.get(o1),mappedNums.get(o2));
            }
        });
        for (int i=0; i<nums.length; i++)
            nums[i]= arr[i];
        return nums;
    }
}
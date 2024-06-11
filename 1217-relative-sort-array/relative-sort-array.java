class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        ArrayList<Integer> store= new ArrayList<>();
        for (int ele: arr1)
            store.add(ele);
        int[] ans= new int[arr1.length];
        int k= 0;
        for (int element : arr2) {
            int j = 0;
            for (int ele : arr1) {
                if (ele == element) {
                    ans[k++] = ele;
                    store.set(j, -1);
                }
                j++;
            }

        }

        ArrayList<Integer> queue= new ArrayList<>();
        for (int ele: store) {
            if (ele>=0)
                queue.add(ele);
        }
        Collections.sort(queue);
        for (int ele: queue){
            ans[k]= ele;
            k++;
        }
        return ans;
    }
}
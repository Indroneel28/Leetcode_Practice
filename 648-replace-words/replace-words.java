class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        //Using Lambda Expression comparator to sort the list
        dictionary.sort((a,b)->a.length()-b.length());

        String[] arr= sentence.split(" ");
        for (int i=0; i<arr.length; i++){
            for (String ele: dictionary){
                if (arr[i].startsWith(ele)) {
                    arr[i] = ele;
                    break;
                }
            }
        }

        String store="";
        for (String ele: arr)
            store+=ele+" ";
        return store.trim();
    }
}
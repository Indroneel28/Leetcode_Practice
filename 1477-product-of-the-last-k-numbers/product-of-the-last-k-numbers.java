//NOTE:- WE NEED TO TAKE SPECIAL CARE OF 0
//USING HASHMAP
class ProductOfNumbers {
    int index; //current index
    HashMap<Integer,Integer> map; // Index, Product
    int lastZero; //Index at which last 0 occurs

    public ProductOfNumbers() {
        this.index= 0;
        this.map= new HashMap<>();
        this.lastZero= -1;
    }

    public void add(int num) {
        if (num==0){
            lastZero= index;
            map.put(index,1);
            this.index++;
        }
        else {
            map.put(index, num*map.getOrDefault(index-1,1));
            this.index++;
        }
    } //O(1) TC

    public int getProduct(int k) {
        if (index-lastZero>k)
            return map.get(index-1)/map.getOrDefault(index-1-k,1);
        else
            return 0;
    } //O(1) TC
}
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
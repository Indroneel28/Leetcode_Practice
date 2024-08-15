class Solution {
    public boolean lemonadeChange(int[] bills) {
        //METHOD -1
        //USING HASHMAP TO COUNT THE FREQUENCY OF EACH NOTE
        /*
        HashMap<Integer,Integer> map= new HashMap<>();
        //Initially all notes are 0
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);

        for(int pay: bills){
            if (pay==5){
                map.put(5,map.get(5)+1);
            }
            else if (pay==10){
                if (map.get(5)>=1){ //Atleast one 5Rs note required
                    map.put(10,map.get(10)+1); //Add 10 Rs
                    map.put(5,map.get(5)-1); //Remove 5 Rs
                }
                else
                    return false;
            }
            else if (pay==20){
                //We will try to use 10Rs and 5Rs first (Greedy Approach)
                //because 10 Rs can only be used for Rs 20 change
                if (map.get(10)>=1 && map.get(5)>=1){
                    map.put(20,map.get(20)+1); //Add 20 Rs
                    map.put(10,map.get(10)-1); //Remove 10 Rs
                    map.put(5,map.get(5)-1); //Remove 5 Rs
                }
                else if (map.get(5)>=3){
                    map.put(20,map.get(20)+1); //Add 20 Rs
                    map.put(5,map.get(5)-3); //Give three 5 Rs notes
                }
                else
                    return false;
            }
        }
        return true;
        //The Queue is empty now and all transactions are successful.
         */

        //METHOD 2:- USING COUNTING
        int count5= 0, count10= 0;
        for (int num: bills){
            if (num==5)
                count5++;
            else if (num==10){
                if (count5>=1){
                    count5--;
                    count10++;
                }
                else
                    return false;
            }
            else{ //num==20
                if (count5>=1 && count10>=1){
                    count5--;
                    count10--;
                }
                else if (count5>=3){
                    count5-=3;
                }
                else 
                    return false;
            }
        }
        return true;
    }
}
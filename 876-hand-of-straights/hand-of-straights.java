class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        TreeMap<Integer, Integer> cardCountMap = new TreeMap<>();
        for (int card : hand) {
            cardCountMap.put(card, cardCountMap.getOrDefault(card, 0) + 1);
        }
        
        while (!cardCountMap.isEmpty()) {
            int firstCard = cardCountMap.firstKey();
            for (int card = firstCard; card < firstCard + groupSize; card++) {
                if (!cardCountMap.containsKey(card)) {
                    return false;
                }
                
                int count = cardCountMap.get(card);
                if (count == 1) {
                    cardCountMap.remove(card);
                } else {
                    cardCountMap.put(card, count - 1);
                }
            }
        }
        
        return true;
    }
}
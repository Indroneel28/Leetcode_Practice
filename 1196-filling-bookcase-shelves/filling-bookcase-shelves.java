class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return arrangeBooks(books, shelfWidth);
    }

    private int arrangeBooks(int[][] books, int maxShelfWidth) {
        int[] minHeights = new int[books.length + 1];
        
        for (int bookIndex = 1; bookIndex <= books.length; bookIndex++) {
            minHeights[bookIndex] = Integer.MAX_VALUE;
            int currentShelfHeight = 0;
            int currentShelfWidth = 0;
            
            for (int lastBook = bookIndex - 1; lastBook >= 0; lastBook--) {
                int currentBookThickness = books[lastBook][0];
                int currentBookHeight = books[lastBook][1];
                
                if (currentShelfWidth + currentBookThickness > maxShelfWidth) {
                    break;
                }
                
                currentShelfWidth += currentBookThickness;
                currentShelfHeight = Math.max(currentShelfHeight, currentBookHeight);
                
                int currentArrangementHeight = minHeights[lastBook] + currentShelfHeight;
                minHeights[bookIndex] = Math.min(minHeights[bookIndex], currentArrangementHeight);
            }
        }
        
        return minHeights[books.length];
    }
}
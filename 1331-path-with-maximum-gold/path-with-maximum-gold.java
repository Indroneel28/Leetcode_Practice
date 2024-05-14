class Solution {
    int maxGold = 0;
    int[] roww = {1, -1, 0, 0};
    int[] coll = {0, 0, -1, 1};

    public int checkIfAllNonZeros(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) count += grid[i][j];
                else return 0;
            }
        }
        return count;
    }

    public void backtrack(int[][] grid, int x, int y, int count) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;

        if (grid[x][y] != 0) {
            int curr = grid[x][y];
            grid[x][y] = 0;
            count += curr;
            maxGold = Math.max(maxGold, count);

            for (int i = 0; i < 4; i++) {
                int newX = x + roww[i];
                int newY = y + coll[i];
                backtrack(grid, newX, newY, count);
            }

            grid[x][y] = curr;
        }
    }

    public int getMaximumGold(int[][] grid) {
        int count = checkIfAllNonZeros(grid);
        if (count != 0) return count;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    backtrack(grid, i, j, 0);
                }
            }
        }

        return maxGold;
    }
}
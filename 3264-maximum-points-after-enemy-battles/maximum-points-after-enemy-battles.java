class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);

        int i=0, j= enemyEnergies.length-1;
        if(enemyEnergies[0] > currentEnergy) 
            return 0;
        long points= 0;
        while (i<=j){
            if (enemyEnergies[0]<=currentEnergy) {
                int fact = (int)currentEnergy/enemyEnergies[i];
                points+= fact;
                currentEnergy-= fact*enemyEnergies[i];
            }
            else if(points>=1){
                currentEnergy+=enemyEnergies[j];
                j--;
            }
            else
                break;
        }
        return points;
    }
}
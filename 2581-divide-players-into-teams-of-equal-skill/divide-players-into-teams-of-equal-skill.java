class Solution {
    public long dividePlayers(int[] skill) {
        //USING SORTING AND TWO_POINTERS
        Arrays.sort(skill);
        int i=0, j=skill.length-1;
        long sumSkill=0;
        long teamSkill= skill[i]+skill[j];
        while (i<j){
            long teamSkillIJ= skill[i]+skill[j];
            if (teamSkillIJ!=teamSkill)
                return -1;
            sumSkill += (skill[i]*skill[j]);
            i++; j--;
        }
        return sumSkill;
        //TC is O(nlogn) and SC is O(1)
    }
}
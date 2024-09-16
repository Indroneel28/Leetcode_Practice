class Solution {
    public int findMinDifference(List<String> timePoints) {
        //METHOD 2:- USING GREEDY APPROACH
        //Sorting the ArrayList in ascending time
        timePoints.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                //Store the minutes and hours in variables for convenience
                int minA = (a.charAt(3)-'0')*10 + (a.charAt(4)-'0');
                int hourA = (a.charAt(0)-'0')*10 + (a.charAt(1)-'0');
                int minB = (b.charAt(3)-'0')*10 + (b.charAt(4)-'0');
                int hourB = (b.charAt(0)-'0')*10 + (b.charAt(1)-'0');

                if (hourA > hourB)
                    return 1;
                else if (hourA < hourB)
                    return -1;
                else //hourA == hourB
                    return Integer.compare(minA, minB);
            }
        });
        int minMinutesDifference= findMinutesDifference(timePoints.get(0),timePoints.get(timePoints.size()-1)); //First and last time of the list
        for (int i=0;i<timePoints.size()-1; i++){
            String a= timePoints.get(i);
            String b= timePoints.get(i+1);
            if (findMinutesDifference(a,b)<minMinutesDifference)
                minMinutesDifference= findMinutesDifference(a,b);
        }
        return minMinutesDifference;
        
        //TC is O(nlogn) and SC is O(1)
    }
    
    //Method to find the difference
    private int findMinutesDifference(String a, String b){
        //Store the minutes and hours in variables for convenience
        int minA = (a.charAt(3)-'0')*10 + (a.charAt(4)-'0');
        int hourA = (a.charAt(0)-'0')*10 + (a.charAt(1)-'0');
        int minB = (b.charAt(3)-'0')*10 + (b.charAt(4)-'0');
        int hourB = (b.charAt(0)-'0')*10 + (b.charAt(1)-'0');

        //AntiClockwise from A to B
        int nHourDiffAToB= hourB-hourA;
        int nMinDiffAToB= minB-minA;
        int nTotalMinutesDiff= Math.abs(nHourDiffAToB*60 + nMinDiffAToB);

        //Clockwise from A to B
        //    CloseWise + AntiClockwise= 24 hours
        // => Clockwise = 24 hours - AntiClockwise
        //So, no need to calculate individually for Clockwise
        int cTotalMinuteDiff= 24*60 - nTotalMinutesDiff;

        //we need minimum minute difference whether it is clockwise or anti-clockwise
        return Math.min(cTotalMinuteDiff,nTotalMinutesDiff);
    }
}
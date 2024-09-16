class Solution {
    public int findMinDifference(List<String> timePoints) {
        //METHOD 1:- BRUTE FORCE METHOD
        //Explore all the pairs and compare the minutes
        /*
        int minMinutesDifference= 60*12; // 60 minutes X 12 hours
        for (int i=0; i<timePoints.size(); i++){
            for (int j= i+1; j<timePoints.size(); j++){
                String a= timePoints.get(i);
                String b= timePoints.get(j);

                //Store the minutes and hours in variables for convenience
                int minA= Integer.parseInt(a.substring(a.indexOf(':')+1));
                int hourA= Integer.parseInt(a.substring(0,a.indexOf(':')));
                int minB= Integer.parseInt(b.substring(b.indexOf(':')+1));
                int hourB= Integer.parseInt(b.substring(0,b.indexOf(':')));

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
                if (Math.min(cTotalMinuteDiff,nTotalMinutesDiff) < minMinutesDifference) //compare diff and minMinutesDifference
                    minMinutesDifference= Math.min(cTotalMinuteDiff,nTotalMinutesDiff);
            }
        }
        return minMinutesDifference;
        //TC is O(n^2) and SC is O(1)
        //TLE
         */

        //METHOD 2:- USING GREEDY APPROACH
        //Sorting the ArrayList in ascending time
        timePoints.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                //Store the minutes and hours in variables for convenience
                int minA = Integer.parseInt(a.substring(a.indexOf(':') + 1));
                int hourA = Integer.parseInt(a.substring(0, a.indexOf(':')));
                int minB = Integer.parseInt(b.substring(b.indexOf(':') + 1));
                int hourB = Integer.parseInt(b.substring(0, b.indexOf(':')));

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
        int minA= Integer.parseInt(a.substring(a.indexOf(':')+1));
        int hourA= Integer.parseInt(a.substring(0,a.indexOf(':')));
        int minB= Integer.parseInt(b.substring(b.indexOf(':')+1));
        int hourB= Integer.parseInt(b.substring(0,b.indexOf(':')));

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
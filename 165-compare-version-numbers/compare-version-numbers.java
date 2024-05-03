class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1= version1.split("[.]");
        String[] arr2= version2.split("[.]");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int len1= arr1.length; int len2= arr2.length;
        int min= Math.min(len1,len2);
        int i=0;
        for (; i<min; i++){
            int x= Integer.parseInt(arr1[i]);
            int y= Integer.parseInt(arr2[i]);
            System.out.println(x+" "+y);
            if (y>x)
                return -1;
            if (x>y)
                return 1;
        }
        
        for (int j=min; j<len1; j++){
            int x= Integer.parseInt(arr1[j]);
            if (x>0)
                return 1;
        }
        for (int j=min; j<len2; j++){
            int y= Integer.parseInt(arr2[j]);
            if (y>0) 
                return -1;
        }
        return 0; //equal
    }
}
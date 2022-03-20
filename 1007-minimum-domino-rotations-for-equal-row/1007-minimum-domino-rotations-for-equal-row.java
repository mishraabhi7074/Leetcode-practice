class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        //  converting tops array to either tops[0] or bottoms[0]
        int comp1 = Math.min(convert(tops, bottoms, tops[0]), convert(tops, bottoms, bottoms[0]));
        //  converting bottoms array to either tops[0] or bottoms[0]
        int comp2 = Math.min(convert(bottoms, tops, tops[0]), convert(bottoms, tops, bottoms[0]));
        return Math.min(comp1, comp2) == 10_001 ? -1 : Math.min(comp1, comp2);
    }
    
    //  we want to convert all values of arr1 to tar with the help of arr2
    public int convert(int[] arr1, int[] arr2, int tar) {
        int answer = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != tar) {
                if (arr2[i] != tar) {
				    //  at this index tar is not present in wither tops or bottoms so it is not possible to convert tops to tar
                    return 10_001;
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }
}
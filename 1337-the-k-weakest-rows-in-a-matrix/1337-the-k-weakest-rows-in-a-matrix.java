class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Set<Integer> set = new LinkedHashSet<>();
        boolean finished = false;
        for(int j = 0; j < mat[0].length && k > 0; j++) {
            for(int i = 0; i < mat.length && k > 0; i++) {
                if(mat[i][j] == 0 || finished) {
                    if(set.add(i)) k--;
                }
            }
			// This is for handling the last part
            if(j == mat[0].length - 1 && k > 0) {
                j--;
                finished = true;
            }
        }
		// This part is just for converting set to list
        int[] res = new int[set.size()];
        int i = 0;
        for(int s : set) {
            res[i++] = s;
        }
        return res;
    }
}
class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        int actualK = k % total;


        List<List<Integer>> result = new ArrayList<>(m);

        for (int i = 0; i < m ; i++) {

            List<Integer> localResult = new ArrayList<>(n);

            for (int j = 0; j < n; j++) {

                int flatIndex = findIndexInFlatArray(i, j, n, total, actualK);
                localResult.add(grid[flatIndex/n][flatIndex%n]);
            }

            result.add(localResult);
        }

        return result;
    }

    private int findIndexInFlatArray(int i, int j, int col, int total, int k) {
        return ((i * col) + j + total - k) % total;
    }
}
class Solution {
    public int[] countBits(int n) {
        int[] sol = new int[n + 1];
        sol[0] = 0;
        int i, pow = 1;
		
        for(i = 1; i <= n; i++)
        {
            if(i == pow)
            {
                sol[i] = 1;
                pow *= 2;
            }
            else
            {
                sol[i] = sol[i - pow / 2] + 1;
            }
        }
        return sol;
    }
}
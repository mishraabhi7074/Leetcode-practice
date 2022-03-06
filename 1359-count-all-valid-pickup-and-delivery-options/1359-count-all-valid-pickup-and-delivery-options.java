class Solution {
    public int countOrders(int n) {
		// since it is asked to return 10^9+7 mod of result
		long mod = (long) 1e9 + 7;
		// to avoid overflow
		long res = 1;
		// now apply formula of n!*(1*3*5*...*(2n-1))
		// it can be written as (1*2*3*....n)*(1*3*5*...*(2n-1))
		for (int i = 1; i <= n; i++) {
			res *= i; // factorial part
			res *= (2 * i - 1); // second part i.e. 2n-1
			res = res % mod; // mod to make answer in range
		}
		// return answer
		return (int) res;
	}
}
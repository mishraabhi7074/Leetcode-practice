// { Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int mat[][], int n, int m) {
         // Create a temporary array which will be use to store every array of matrix:
        int[] temp = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = mat[0][i];
        }
        // Calculating the max area for the first array of matrix:
        int max = calcMaxArea(temp);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    temp[j] = 0;
                } else {
                    temp[j] += mat[i][j];
                }
            }
            max = Math.max(max, calcMaxArea(temp));
        }
        return max;
    }
   
  // Calculate the Maximum Area for Every Individual Array of the Matrix.
  public int calcMaxArea(int[] arr) {
        int length = arr.length;

        // Create an array for storing left smaller index:
        int[] nearestSmallerLeft = new int[length];
        // Create an array for storing right smaller index:
        int[] nearestSmallerRight = new int[length];

        // Finding the nearest smaller element's index towards Left:
        Stack<Integer> nSL = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (nSL.isEmpty()) nearestSmallerLeft[i] = -1;
            if (!nSL.isEmpty() && arr[nSL.peek()] < arr[i]) nearestSmallerLeft[i] = nSL.peek();
            if (!nSL.isEmpty() && arr[nSL.peek()] >= arr[i]) {
                while (!nSL.isEmpty() && arr[nSL.peek()] >= arr[i]) {
                    nSL.pop();
                }
                if (nSL.isEmpty()) nearestSmallerLeft[i] = -1;
                else nearestSmallerLeft[i] = nSL.peek();
            }
            nSL.push(i);
        }

        // Finding the nearest smaller element's index towards Right:
        Stack<Integer> nSR = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            if (nSR.isEmpty()) nearestSmallerRight[i] = length;
            if (!nSR.isEmpty() && arr[nSR.peek()] < arr[i]) nearestSmallerRight[i] = nSR.peek();
            if (!nSR.isEmpty() && arr[nSR.peek()] >= arr[i]) {
                while (!nSR.isEmpty() && arr[nSR.peek()] >= arr[i]) {
                    nSR.pop();
                }
                if (nSR.isEmpty()) nearestSmallerRight[i] = length;
                else nearestSmallerRight[i] = nSR.peek();
            }
            nSR.push(i);
        }
		
		// Creating the Final Array using Left and Right Indexes:
        int[] width = new int[length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            width[i] = (nearestSmallerRight[i] - nearestSmallerLeft[i] - 1) * arr[i];
            max = Math.max(max, width[i]);
        }
        return max;
    }
}
class Solution {
   public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = Integer.MIN_VALUE;
        while (left < right) {
            int leftHeight = height[left], rightHeight = height[right];
            max = Math.max(max, (right - left) * Math.min(leftHeight, rightHeight));
            if (leftHeight < rightHeight) left++;
            else right--;
        }
        return max;
    }
}
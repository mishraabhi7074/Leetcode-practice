/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// revise again
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;
        int firstBadVer = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(isBadVersion(mid)) {//true
                firstBadVer = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return firstBadVer;
    }
}
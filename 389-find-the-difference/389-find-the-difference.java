class Solution {
   public char findTheDifference(String s, String t) {
    return (char) (s + t).chars().reduce(0, (c, d) -> c ^ d);
}
}
// do it again
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() < p.length() || s.length() == 0) {
            return new ArrayList<>();
        }
        
        HashMap<Character,Integer> needs = new HashMap<Character,Integer>();
        HashMap<Character,Integer> window = new HashMap<Character,Integer>();
        for (char c : p.toCharArray()) needs.put(c, needs.getOrDefault(c,0) + 1);
        
        int left = 0, right = 0;
        // counts elements in the window that meet the needs
        int valid = 0;
        List<Integer> result = new ArrayList<>();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // update the window
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }
            // System.out.println(window);
            // determine if left window needs to shrink
            while (right - left >= p.length()) {
                if (valid == needs.size()) {
                    result.add(left);
                }
                // System.out.println();
                char d = s.charAt(left);
                left++;
                // update the window
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // end of sliding window
        return result;
    }
}
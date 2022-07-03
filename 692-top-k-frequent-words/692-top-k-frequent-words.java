// do it again
class Solution {
     public static List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        ans.addAll(freqMap.keySet());

        Collections.sort(ans, (o1, o2) -> {
            if (freqMap.get(o1) == freqMap.get(o2)) {
                return o1.compareTo(o2);
            }

            return freqMap.get(o2) - freqMap.get(o1);
        });

        return ans.subList(0, k);
    }
}
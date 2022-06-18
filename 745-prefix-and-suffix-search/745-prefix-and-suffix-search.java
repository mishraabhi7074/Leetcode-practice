class WordFilter {

    HashMap<String, Integer> map;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        for(int index=0; index<words.length; index++){
            
            String word = words[index];
            for(int i=0; i<word.length(); i++){ // prefixes
                
                for(int j=word.length()-1; j>=0; j-- ){// suffixes
                    
                    String prefix = word.substring(0, i+1); // prefix
                    String suffix = word.substring(j); // suffix
                    String key = prefix + " " + suffix;
                    map.put(key, index);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        
        String key = prefix+" "+suffix;
        return map.getOrDefault(key, -1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
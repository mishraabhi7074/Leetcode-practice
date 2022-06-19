class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products, (a,b) -> a.compareTo(b));
        List<List<String>> result = new ArrayList();
        for(int i = 1; i <= searchWord.length(); i++){
            List<String> list = getRes(searchWord.substring(0,i), products);
            result.add(list);
        }
        return result;
    }
    
    
    private List<String> getRes(String search, String[] products){
        List<String> list = new ArrayList();
        for(String x : products){
            if(list.size() == 3) break;
            if(x.startsWith(search)) list.add(x);
        }
        return list;
    }
}
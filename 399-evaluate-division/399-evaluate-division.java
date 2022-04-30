class Solution {
    
    private class Pair {
        public String var;
        public double val;
        
        Pair(String var, double val) {
            this.var = var;
            this.val = val;
        }
        
        public String toString() {
            return "(" + this.var + "," + this.val + ")";
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        // CREATE GRAPH
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i=0; i<equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            if (!map.containsKey(var1)) map.put(var1, new ArrayList<>());
            map.get(var1).add(new Pair(var2, values[i]));
            
            if (!map.containsKey(var2)) map.put(var2, new ArrayList<>());
            map.get(var2).add(new Pair(var1, 1 / values[i]));
        }
        
        double[] result = new double[queries.size()];
        Arrays.fill(result, -1);
        HashSet<String> set = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        
        for (int i=0; i<queries.size(); i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            
            // if any var is not in map ans is -1
            if (!map.containsKey(var1) || !map.containsKey(var2)) {
                continue;
            }
            queue.clear();
            set.clear();
            set.add(var1);
            queue.offer(new Pair(var1, 1));
            
            // BFS
            while (!queue.isEmpty()) {
                Pair p = queue.poll();
                if (p.var.equals(var2)) {
                    result[i] = p.val;
                    break;
                }
                for(Pair neighbor: map.get(p.var)) {
                    if (!set.contains(neighbor.var)) {
                        queue.offer(new Pair(neighbor.var, neighbor.val * p.val));
                        set.add(neighbor.var);
                    }
                }
            }
        }
        return result;
    }
}
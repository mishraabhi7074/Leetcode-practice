class Solution {
    public boolean isBipartite(int[][] graph) {
              
        int n = graph.length;
        boolean[] flag = new boolean[]{true};
        int[] nodesColor = new int[n]; 
        
        for(int i = 0; i < n; i++){
            if(nodesColor[i] == 0) dfs(graph, i, nodesColor, 1, flag);
        }    
        return flag[0];
        
    }
    
    static void dfs(int[][] graph, int node, int[] nodesColor, int currColor, boolean[] flag){
        
        if(nodesColor[node] != 0){
            int colorAssigned = nodesColor[node];
            if(colorAssigned != currColor) flag[0] = false;
            return;
        }
        nodesColor[node] = currColor;        
        
        for(int i = 0; i < graph[node].length; i++){
            dfs(graph, graph[node][i], nodesColor, 3 - currColor, flag);
        }
        return;
    }
}
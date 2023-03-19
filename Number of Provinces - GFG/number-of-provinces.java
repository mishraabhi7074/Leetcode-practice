//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i =0; i < V; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        // convert matrix to adjacency list
        for(int i =0; i < V; i++){
            for(int j =0; j < V; j++){
                if(adj.get(i).get(j) == 1 && i != j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        int [] vis = new int[V+1];
        int count =0;
        for(int i =0; i < V; i++){
            if(vis[i] == 0){
                count++;
                DFS(i, adjList, vis);
            }
        }
        return count;
       
    }
    
    private static void DFS(int node, ArrayList<ArrayList<Integer>> adjList, int [] vis){
        vis[node] =1;
        for(int j : adjList.get(node)){
            if(vis[j] == 0){
                DFS(j, adjList, vis);
            }
        }
    }
};
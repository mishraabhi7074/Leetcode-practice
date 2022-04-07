class Solution {
public int lastStoneWeight(int[] stones) {

    Arrays.sort(stones);
    int n=stones.length;
    
    while(n>=2){
        if(stones[n-1]==stones[n-2])
            n=n-2;
        else{
            stones[n-1]=stones[n-1]-stones[n-2];
            stones[n-2]=Integer.MAX_VALUE;
            Arrays.sort(stones);
            n=n-1;
        }
    }
    if(n==0)
        return 0;
    return stones[0];
}
}
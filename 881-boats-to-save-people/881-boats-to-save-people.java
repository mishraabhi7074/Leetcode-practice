class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0,sum = 0,i = 0,j = people.length-1;
        Arrays.sort(people);
        while(i <= j){
            if(people[i] + people[j] <= limit){
                count += 1;
                i++;
                j--;
            }else{
                count += 1;
                j--;
            }
        }
        return count;
    }
}
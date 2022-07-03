// do it again
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] digits = new int[10];
        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)) bulls++;
            else{
                if (digits[secret.charAt(i) - '0'] < 0) 
                        cows++;
                if (digits[guess.charAt(i) - '0'] > 0)
                    cows++;
                digits[secret.charAt(i) - '0']++;
                digits[guess.charAt(i) - '0']--;
            }
        }
        return bulls+"A"+cows+"B";
    }
}
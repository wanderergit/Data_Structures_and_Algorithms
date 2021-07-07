package DynamicProgramming.problems.MCM;

public class EggDropping {
    public static void main(String[] args) {

    }
    public static int twoEggDrop(int n) {
        // given we have only 2 eggs
        int[][] memo = new int[3][n+1];
        for(int i=0; i<3; i++){
            for(int j=0; j<n+1; j++){
                memo[i][j] = -1;
            }
        }
        return solve(2, n, memo);
    }
    public static int solve(int eggsRemaining, int floorsToCheck, int[][] memo){
        if(memo[eggsRemaining][floorsToCheck] != -1) return memo[eggsRemaining][floorsToCheck];
        if(floorsToCheck == 0 || floorsToCheck == 1){
            return floorsToCheck;
        }
        // if only one egg is remaining, we have to travel from bottom and check all floors
        if(eggsRemaining == 1){
            return floorsToCheck;
        }
        int mn = Integer.MAX_VALUE;
        // checking for all intermediate floor combos
        for(int k=1; k<=floorsToCheck; k++){
            int eggBreaks = 0;
            if(memo[eggsRemaining-1][k-1] != -1)
                eggBreaks = memo[eggsRemaining-1][k-1];
            else{
                memo[eggsRemaining-1][k-1] = solve(eggsRemaining-1, k-1, memo);
                eggBreaks = memo[eggsRemaining-1][k-1];
            }
            int eggDoesntBreak = 0;
            if(memo[eggsRemaining][floorsToCheck-k] != -1)
                eggDoesntBreak = memo[eggsRemaining][floorsToCheck-k];
            else{
                memo[eggsRemaining][floorsToCheck-k] = solve(eggsRemaining, floorsToCheck-k, memo);
                eggDoesntBreak = memo[eggsRemaining][floorsToCheck-k];
            }
            int temp = 1 + Math.max(eggBreaks, eggDoesntBreak);
            mn = Math.min(mn, temp);
        }
        return memo[eggsRemaining][floorsToCheck] = mn;
    }
}

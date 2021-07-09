package solution.medium;

import java.util.Arrays;

public class 零钱兑换 {

    int[] mem;

    public int coinChange(int[] coins, int amount) {
        mem = new int[amount + 1];
        Arrays.fill(mem, -666);

        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;

        if(mem[amount] != -666) return mem[amount];

        int min = Integer.MAX_VALUE;
        for(int coin: coins) {
            int result = dp(coins, amount - coin);
            if(result == -1) continue;
            min = Math.min(min, result + 1);
        }

        mem[amount] = (min == Integer.MAX_VALUE) ? -1: min;
        return mem[amount];
    }

    public static void main(String[] args) {
        零钱兑换 o = new 零钱兑换();
        int[] coins = {1, 2, 5};
        System.out.println(o.coinChange(coins, 11));
    }
}

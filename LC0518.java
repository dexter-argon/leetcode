import java.util.*;

public class LC0518 {

	public class Solution {
		public int change(int amount, int[] coins) {
			if (amount == 0) {
				return 0;
			}

			int[] dp = new int[amount + 1];
			Arrays.sort(coins);
			dp[0] = 0;

			// {1}, {(1,1),(2)}, {(1,1,1),(2,1),(1,2)}

			for (var coin : coins) {
				for (var currAmount = coin; currAmount <= amount; currAmount += 1) {
					dp[currAmount] += dp[currAmount - coin];
				}
			}

			return dp[amount];
		}
	}
}

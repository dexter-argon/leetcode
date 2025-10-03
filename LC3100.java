class LC3100 {
	static class Solution {
		public int maxBottlesDrunk(int numBottles, int numExchange) {
			int drunkBottles = numBottles; // Initially, drink all of the bottles.
			int emptyBottles = numBottles; // That's why, empty bottles count is equal to number of bottles.

			while (emptyBottles >= numExchange) {
				emptyBottles -= numExchange;
				++drunkBottles;
				++numExchange;
				++emptyBottles;
			}

			return drunkBottles;
		}
	}
}

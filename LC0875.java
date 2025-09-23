import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LC0875 {
	public static class Solution {
		// koko has h hours to complete all the bananas
		// we have to find minimum speed k with which she should eat her banana to eat all the piles of banana

		/*
		 * @param piles array
		 * @param h hours koko has to finish all the banana 
		 * @return The minimum integer eating speed
		 * 
		 * if k == max(piles[i]) then it would take piles.length(n) for koko to finish her bananas
		 * given h >= piles.length, meaning we have a solution.
		 */

		public static int minEatingSpeed(int[] piles, int h) {
			if (piles == null || piles.length == 0) {
				throw new IllegalArgumentException("Piles array cannot be null or empty");
			}
			int minValidSpeed = 0;
			int minSpeed = 1, maxSpeed = Integer.MIN_VALUE;

			for (var pile: piles) {
				maxSpeed = Math.max(maxSpeed, pile);
			}

			while (minSpeed <= maxSpeed) {
				int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
				if (canKokoFinishBananasAtGivenSpeed(piles, h, midSpeed)) {
					minValidSpeed = midSpeed;
					maxSpeed = midSpeed - 1;
				} else {
					minSpeed = midSpeed + 1;
				}
			}

			return minValidSpeed;
		}

		private static boolean canKokoFinishBananasAtGivenSpeed(final int[] piles, int hours, int speed) {
			long hoursNeeded = 0;

			for (int pile: piles) {
				hoursNeeded += (long) ((pile + speed - 1) / speed);
			}

			return hoursNeeded <= hours;
		}
	}

	public static void main(String[] args) {
		// int[] piles = new int[]{30,11,23,4,20};
		// int[] piles = new int[]{3,6,7,11};
		// int[] piles = new int[]{312884470};
		int[] piles = new int[]{805306368,805306368,805306368};
		int h = 1000000000;	
		System.out.println(Solution.minEatingSpeed(piles, h));

	}

	public static class KokoEatingSpeedTests {
		@Test
		void testExample1() {
			int[] piles = {3, 6, 7, 11};
			int h = 8;
			assertEquals(4, Solution.minEatingSpeed(piles, h));
		}

		@Test
		void testExample2() {
			int[] piles = {30, 11, 23, 4, 20};
			int h = 5;
			assertEquals(30, Solution.minEatingSpeed(piles, h));
		}

		@Test
		void testLargeValues() {
			int[] piles = {805306368, 805306368, 805306368};
			int h = 1000000000;
			assertEquals(3, Solution.minEatingSpeed(piles, h));
		}

		@Test
		void testGuardsComeBackQuickly() {
			// h is equal to piles.length, so Koko must eat at the speed of the largest pile.
			int[] piles = {30, 11, 23, 4, 20};
			int h = 5;
			assertEquals(30, Solution.minEatingSpeed(piles, h));
		}

		@Test
		void testEmptyPilesThrowsException() {
			int[] piles = {};
			int h = 10;
			assertThrows(IllegalArgumentException.class, () -> {
				Solution.minEatingSpeed(piles, h);
			});
		}

		@Test
		void testNullPilesThrowsException() {
			assertThrows(IllegalArgumentException.class, () -> {
				Solution.minEatingSpeed(null, 10);
			});
		}
	}
}
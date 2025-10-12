class LC0374 {
	public static class GuessGame {
		int guess(int n) {
			return 0;
		}
	}

	public class Solution extends GuessGame {
		public int guessNumber(int n) {
			int low = 0, high = n;

			while (low <= high) {
				var mid = low + (high - low) / 2;
				int guess = guess(mid);
				if (guess == 0) {
					return mid;
				} else if (guess == -1) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			return -1;
		}
	}
}

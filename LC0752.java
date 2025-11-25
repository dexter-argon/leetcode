import java.util.*;

public class LC0752 {
	class Solution {
		Set<String> deadends;

		public int openLock(String[] deadends, String target) {
			this.deadends = new HashSet<>();
			for (var deadend : deadends) {
				this.deadends.add(deadend);
			}
			String startingWord = "0000";

			return bfs(startingWord, target);
		}

		private boolean isDeadend(String word) {
			return this.deadends.contains(word);
		}

		private int bfs(String word, String target) {
			if (isDeadend(word)) {
				return -1;
			}
			Queue<String> q = new ArrayDeque<>();
			Set<String> visitedWords = new HashSet<>();
			int numOfTurns = 0;

			visitedWords.add(word);
			q.add(word);

			while (!q.isEmpty()) {
				int levelSize = q.size();

				for (var i = 0; i < levelSize; ++i) {
					var currWord = q.poll();
					if (currWord.equals(target)) {
						return numOfTurns;
					}

					char[] currState = currWord.toCharArray();
					for (var j = 0; j < currWord.length(); ++j) {
						int digit = currState[j] - '0';
						int clockwiseTurnedDigit = (digit + 1) % 10;
						int antiClockwiseTurnedDigit = (digit == 0) ? 9 : (digit - 1);

						currState[j] = (char) (clockwiseTurnedDigit + '0');
						var nextWord = new String(currState);
						// clockwise
						if (!isDeadend(nextWord) && !visitedWords.contains(nextWord)) {
							visitedWords.add(nextWord);
							q.add(nextWord);
						}

						// anti-clockwise
						currState[j] = (char) (antiClockwiseTurnedDigit + '0');
						nextWord = new String(currState);
						if (!isDeadend(nextWord) && !visitedWords.contains(nextWord)) {
							visitedWords.add(nextWord);
							q.add(nextWord);
						}

						currState[j] = (char) (digit + '0');

					}
				}

				numOfTurns += 1;
			}
			return -1;
		}
	}
}

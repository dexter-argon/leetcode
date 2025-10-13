import java.util.*;

class LC0981 {
	class TimeMap {
		static class ValueWithExp {
			String value;
			int timestamp;

			ValueWithExp(String value, int timestamp) {
				this.value = value;
				this.timestamp = timestamp;
			}
		}

		Map<String, List<ValueWithExp>> keyToValues;

		public TimeMap() {
			this.keyToValues = new HashMap<>();
		}

		public void set(String key, String value, int timestamp) {
			keyToValues.putIfAbsent(key, new ArrayList<>());
			var listOfValues = keyToValues.get(key);
			listOfValues.add(new ValueWithExp(value, timestamp));
		}

		public String get(String key, int timestamp) {
			var listOfValues = keyToValues.getOrDefault(key, List.of());
			if (listOfValues.isEmpty()) {
				return "";
			}
			return findValueAtTimestamp(listOfValues, timestamp);
		}

		private String findValueAtTimestamp(final List<ValueWithExp> values, final int timestamp) {
			int low = 0, high = values.size() - 1;

			while (low <= high) {
				var mid = low + (high - low) / 2;
				var valueItem = values.get(mid);

				if (valueItem.timestamp == timestamp) {
					return valueItem.value;
				} else if (valueItem.timestamp > timestamp) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			// lower bound. So, high
			return (high < 0) ? "" : values.get(high).value;

		}
	}

}

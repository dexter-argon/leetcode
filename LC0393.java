class LC0393 {

	static public class Solution {
		// Given an integer array data representing the data,
		// return whether it is a valid UTF-8 encoding
		/**
		 * @param input UTF8 encoding
		 * @return whether it's a valid encoding or not
		 */
		public boolean validUtf8(int[] data) {

			for (int i = 0; i < data.length; ) {
				byte utfByte = (byte) data[i];
				int length = sequenceLength(utfByte);

				if (length == -1 || ((i + length) > data.length)) {
					return false; // invalid first byte
				}
				var j = i + 1;
				while (j < i + length) {
					byte nextByte = (byte) data[j++];
					if (!isContinuationByte(nextByte)) {
						return false;
					}
				}

				i += length; 
			}

			return true;
		}

		private boolean isContinuationByte(byte b) {
			return (b & 0xC0) == 0x80;
		}


		private int sequenceLength(byte b) {
			if ((b & 0x80) == 0) {
				// 0xxx xxxx
				return 1;
			} else if ((b & 0xE0) == 0xC0) {
				// 110x xxxx
				return 2;
			} else if ((b & 0xF0) == 0xE0) {
				// 1110 xxxx
				return 3;
			} else if ((b & 0xF8) == 0xF0) {
				// 1111 0xxx
				return 4;
			}

			return -1;
		}
	}

}
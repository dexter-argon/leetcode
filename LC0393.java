class LC0393 {

	static public class Solution {
		// Given an integer array data representing the data,
		// return whether it is a valid UTF-8 encoding
		/**
		 * @param input UTF8 encoding
		 * @return whether it's a valid encoding or not
		 */
		public boolean validUtf8(int[] data) {

			int bytesToFollow = 0;
			for (int i = 0; i < data.length; i += 1) {
				byte utfByte = (byte) data[i];
				if (bytesToFollow == 0) {
					int length = sequenceLength(utfByte);

					if (length == -1) {
						return false; // invalid first byte
					}
					bytesToFollow = length - 1;
				} else {
					if (!isContinuationByte(utfByte)) {
						return false; // invalid continuation byte
					}
					bytesToFollow--;
				}

			}
			return bytesToFollow == 0;
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
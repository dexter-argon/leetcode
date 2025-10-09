class LC0662 {

	class MyCircularQueue {
		int[] queue;
		int begin = 0;
		int end = 0;
		int numOfElementsInQueue = 0;

		public MyCircularQueue(int k) {
			this.begin = 0;
			this.end = -1;
			this.queue = new int[k];
		}

		public boolean enQueue(int value) {
			if (isFull()) {
				return false;
			}
			++this.numOfElementsInQueue;
			this.end = (this.end + 1) % this.queue.length;
			this.queue[this.end] = value;
			return true;
		}

		public boolean deQueue() {
			if (isEmpty()) {
				return false;
			}
			--this.numOfElementsInQueue;
			this.begin = (this.begin + 1) % this.queue.length;
			return true;
		}

		public int Front() {
			if (isEmpty()) {
				return -1;
			}
			return this.queue[this.begin];
		}

		public int Rear() {
			if (isEmpty()) {
				return -1;
			}
			return this.queue[this.end];
		}

		public boolean isEmpty() {
			return this.numOfElementsInQueue == 0;
		}

		public boolean isFull() {
			return this.numOfElementsInQueue == this.queue.length;
		}
	}
}

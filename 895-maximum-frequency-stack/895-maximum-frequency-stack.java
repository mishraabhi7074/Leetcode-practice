class FreqStack  {
	// Map to hold <item,frequencyOfItem>
	private Map<Integer, Integer> map = new HashMap<>();
	// <frequency,stack containing items of desired frequency>
	private Map<Integer, Deque<Integer>> freqStackMap = new HashMap<>();
	// hold max frequency of total elements
	private int max = 0;

	public FreqStack(){}

	public void push(int val) {
		// get the frequency of element needed to be pushed into stack
		int freq = map.getOrDefault(val, 0) + 1;
		// add the updated frequency to the map
		map.put(val, freq);
		// update max to hold the maximum frequency
		max = Math.max(max, freq);
		// if for current freq, freqStackMap does not contain entry create new stack.
		Deque<Integer> stack = freqStackMap.getOrDefault(freq, new LinkedList<>());
		// add current item to stack
		stack.push(val);
		// update freqStackMap
		freqStackMap.put(freq, stack);
	}

	public int pop() {
		// remove the maximum frequency element from freqStackMap stack/
		int val = freqStackMap.get(max).pop();
		// decrement frequency count of item in frequency Map
		map.put(val, map.get(val) - 1);
		// if freqStackMap is now empty. it means no element is there with max
		// frequency.
		if (freqStackMap.get(max).isEmpty()) {
			// decrement max frequency
			max--;
		}
		// return popped element
		return val;
	}
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
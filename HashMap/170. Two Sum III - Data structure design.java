/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/
//这里的关键是用value-key得到另一个key
//hashmap中存出现的次数！！
public class TwoSum {
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(hm.containsKey(number)) {
	        hm.put(number, hm.get(number) + 1);
	    } else {
	        hm.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(int key:hm.keySet()) {
	        int tmp = value - key;
	        if(tmp == key && hm.get(key) > 1) {
	            return true;
	        } else if(tmp != key && hm.containsKey(tmp)) {
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
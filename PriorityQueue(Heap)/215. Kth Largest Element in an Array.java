/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Comparator<Integer> OrderIsdn =  new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				
			    return -1 * o1.compareTo(o2);
			}
		};
		Queue<Integer> priorityQueue =  new PriorityQueue<Integer>(len, OrderIsdn);
		for(int i = 0; i < len; i++) {
		    priorityQueue.offer(nums[i]);
		}
		int ans = 0;
		for(int i = 0; i < k; i++) {
		    ans = priorityQueue.poll();
		}
		return ans;
    }
}
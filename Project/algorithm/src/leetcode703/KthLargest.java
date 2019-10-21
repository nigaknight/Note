package leetcode703;

import java.util.PriorityQueue;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class KthLargest {
    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        queue=new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size()<k){
            queue.offer(val);
        } else if (queue.peek()<val){
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}

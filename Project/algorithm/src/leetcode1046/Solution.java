package leetcode1046;

import java.util.PriorityQueue;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1, o2) -> {return o2-o1;});
        for (int stone:stones){
            queue.offer(stone);
        }
        while (queue.size()>1){
            int stone1=queue.poll();
            int stone2=queue.poll();
            if (stone1!=stone2){
                queue.offer(stone1-stone2);
            }
        }
        return queue.isEmpty()?0:queue.poll();
    }
}

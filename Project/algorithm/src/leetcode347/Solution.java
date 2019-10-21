package leetcode347;

import java.util.*;

/**
 * @author nigaknight
 * @time 2019/10/2
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        List<Integer> list = new Solution().topKFrequent(nums, 2);
        System.out.println(list);
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num:nums){
            if (!map.containsKey(num)){
                map.put(num,1);
            } else {
                map.put(num,map.get(num)+1);
            }
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1,o2)->{return map.get(o1)-map.get(o2);});
        for (Integer key:map.keySet()){
            if (queue.size()<k){
                queue.offer(key);
            } else if (map.get(key)>map.get(queue.peek())){
                queue.poll();
                queue.offer(key);
            }
        }
        List<Integer> res=new ArrayList<>();
        System.out.println(queue.size());
        System.out.println(queue);
        while (!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }
}

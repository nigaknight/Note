package problem03;

import java.util.ArrayList;

/**
 * @author nigaknight
 * @time 2019/9/4
 * 在m个节点的分布式计算系统中，有一批任务需要执行，每个任务
 * 需要的时间是array[i]，每个节点同一时间只能执行一个任务，每个节点只能执行连续的任务，
 * 例如i,i+1,i+2,但是不能执行i,i+2。请问任务完成的最短时间
 *
 * 输入
 * 输入数据包含两行
 *
 * 第一行，空格分隔的两个整数m和n，分别表示节点个数和任务个数(m>0,n>=0)
 *
 * 第二行，空格分隔的正整数序列，表示每个任务需要的时间
 *
 * 输出
 * 一个整数，表示最短完成时间
 *
 *
 * 样例输入
 * 3 5
 * 1 5 3 4 2
 * 样例输出
 * 6
 *
 * 提示
 * 第一个节点执行：任务1和任务2，耗时=1+5=6
 * 第二个节点执行：任务3，耗时=3
 * 第三个节点执行：任务4和任务5，耗时=4+2=6
 * 所以，总最短耗时=6
 **/
public class Solution {
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    static int schedule(int m,int[] array) {
        return 0;
    }
}

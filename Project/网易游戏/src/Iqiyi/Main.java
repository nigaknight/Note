package Iqiyi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/8
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n
        for (int i = 0; i < )
    }
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void solution(int n, int[] nums){
        for (int i = 1; i <=n ; i++){
            dfs(i,nums,new ArrayList<Integer>(),new  int[n]);
        }
    }
    public static void dfs(int i, int[] nums, ArrayList<Integer> list, int[] isused){
        if (i == nums.length+1){
            res.add(list);
            return;
        }
        boolean isadd = false;
        int x = 0;
        for (int j = 1; j < nums.length+1; j++){
            if (isused[j-1] > 0){
                continue;
            }
            if (nums[i-1] == 0 && i > 1 && j < list.get(list.size()-1)){
                continue;
            }
            if (nums[i-1] == 1 && i > 1 && j > list.get(list.size()-1)){
                continue;
            }
            list.add(j);
            isused[j-1]++;
            isadd = true;
            x =j-1;
            break;
        }
        if (!isadd){
            list.remove(list.size()-1);
            isused[x] --;
            dfs(i,nums,list,isused);
        }
        dfs(i+1,nums,list,isused);
    }

}

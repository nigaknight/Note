package problem02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author nigaknight
 * @time 2019/9/15
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nodes = new int[n - 1][3];
        for (int i = 0; i < n - 1; i++) {
            nodes[i][0] = scanner.nextInt();
            nodes[i][1] = scanner.nextInt();
            nodes[i][2] = scanner.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = n - 2; i >= 0; i--) {
            if (!map.containsKey(nodes[i][0])) {
                if (!map.containsKey(nodes[i][1])) {
                    map.put(nodes[i][0], Math.max(nodes[i][2],0));
                } else {
                    map.put(nodes[i][0], Math.max(map.get(nodes[i][1]) + nodes[i][2],0));
                }
            } else if (!map.containsKey(nodes[i][1])) {
                if (nodes[i][2]>map.get(nodes[i][0])){
                    map.put(nodes[i][0],Math.max(nodes[i][2],0));
                }
            } else if (map.containsKey(nodes[i][1])){
                if (map.get(nodes[i][1]) + nodes[i][2] > map.get(nodes[i][0])){
                    map.put(nodes[i][0], Math.max(map.get(nodes[i][1]) + nodes[i][2],0));
                }
            }
        }
        for (int i=1;i<=n;i++){
            if (!map.containsKey(i)){
                map.put(i,0);
            }
            System.out.print(map.get(i)+" ");
        }
    }
}

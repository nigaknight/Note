package leetcode79;

/**
 * @author nigaknight
 * @time 2019/9/12
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','E','S'],
 *   ['A','D','E','E']
 * ]
 *
 * "ABCESEEEFS"
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution {
    boolean res;
    public static void main(String[] args) {
        char[][] board={ {'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        boolean abceseeefs = new Solution().exist(board, "ABCESEEEFS");
        System.out.println(abceseeefs);
    }
    public boolean exist(char[][] board, String word) {
        if (board.length==0){
            return false;
        }
        char c=word.charAt(0);
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==c){
                    boolean[][] isused=new boolean[board.length][board[0].length];
                    isused[i][j]=true;
                    isIn(board,i,j,word.substring(1),isused);
                }
            }
        }
        return res;
    }
    public void isIn(char[][] board,int i,int j,String word,boolean[][] isused){
        if (word.equals("")){
            res=true;
            return;
        }
        char c=word.charAt(0);
        if (i+1<board.length&&board[i+1][j]==c&&!isused[i+1][j]){
            isused[i+1][j]=true;
            isIn(board,i+1,j,word.substring(1),isused);
            isused[i+1][j]=false;
        }
        if (j+1<board[0].length&&board[i][j+1]==c&&!isused[i][j+1]){
            isused[i][j+1]=true;
            isIn(board,i,j+1,word.substring(1),isused);
            isused[i][j+1]=false;
        }
        if (i-1>=0&&board[i-1][j]==c&&!isused[i-1][j]){
            isused[i-1][j]=true;
            isIn(board,i-1,j,word.substring(1),isused);
            isused[i-1][j]=false;
        }
        if (j-1>=0&&board[i][j-1]==c&&!isused[i][j-1]){
            isused[i][j-1]=true;
            isIn(board,i,j-1,word.substring(1),isused);
            isused[i][j-1]=false;
        }
    }
}

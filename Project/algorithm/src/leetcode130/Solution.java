package leetcode130;

/**
 * @author nigaknight
 * @time 2019/10/11
 **/
public class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) {
            return;
        }
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean isEdge = i == 0 || i == row - 1 || j == 0 || j == col - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(i, j, board, row, col);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board, int row, int col) {
        if (i >= row || j >= col || i < 0 || j < 0 || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        dfs(i + 1, j, board, row, col);
        dfs(i - 1, j, board, row, col);
        dfs(i, j + 1, board, row, col);
        dfs(i, j - 1, board, row, col);
    }
}

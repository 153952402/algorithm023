import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * N 皇后
 */
public class NQueens {
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        dfs(board, 0);
        return result;
    }

    private void dfs(char[][] board, int column) {
        if(column == board.length) {
            putAnswer(board);
            return;
        }
        for(int row = 0; row < board.length; row++) {
            if(isValid(board, row, column)) {
                board[row][column] = 'Q';
                dfs(board, column + 1);
                board[row][column] = '.';
            }
        }
    }

    private void putAnswer(char[][] board) {
        List<String> answer = new ArrayList<>(board.length);
        for (int i = 0; i < board.length; i++) {
            answer.add(new String(board[i]));
        }
        result.add(answer);
    }

    private boolean isValid(char[][] board, int row, int column) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < column; j++) {
                if(board[i][j] == 'Q' && (row + column == i + j || row - column == i - j || i == row)) {
                    return false;
                }
            }
        }
        return true;
    }



}

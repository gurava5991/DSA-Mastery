package backtracking;

import java.util.Set;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    private static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (existPathHelper(i, j, board, word, 0))
                        return true;
                }
            }
        }
        return false;

    }

    private static boolean existPathHelper(int row, int col, char[][] board, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index))
            return false;
        char temp = board[row][col];
        board[row][col] = '!'; // Mark the current cell as visited
        boolean left = existPathHelper(row, col - 1, board, word, index + 1);
        boolean right = existPathHelper(row, col + 1, board, word, index + 1);
        boolean top = existPathHelper(row - 1, col, board, word, index + 1);
        boolean bottom = existPathHelper(row + 1, col, board, word, index + 1);
        board[row][col] = temp; // Restore the original value
        return left || right || top || bottom;
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SnakeLadderGame {


    private static List<List<Integer>> findNextMoves(int row, int col, int[][] board) {
        List<List<Integer>> nextMoves = new ArrayList<>();
        while (true) {
            if ((row < 0) || nextMoves.size() == 6) {
                return nextMoves;
            }
            if ((board.length - row + 1) % 2 == 0) {
                //Left to Right
                col++;
                while (col < board.length && nextMoves.size() < 6) {
                    List<Integer> nextMove = new ArrayList<>();
                    nextMove.add(row);
                    nextMove.add(col);
                    nextMoves.add(nextMove);
                    col++;
                }
                if (col == board.length) {
                    row--;
                }
            } else {
                //Right to Left
                col--;
                while (col >= 0 && nextMoves.size() < 6) {
                    List<Integer> nextMove = new ArrayList<>();
                    nextMove.add(row);
                    nextMove.add(col);
                    nextMoves.add(nextMove);
                    col--;
                }
                if (col < 0) {
                    row--;
                }
            }
        }
    }

    private static Set<List<Integer>> filterMoves(List<List<Integer>> nextMoves, int[][] board, boolean[][] visited) {
        //Return only moves having either ladder, snake or move comes with 6 dice(i.e max move)
        Set<List<Integer>> filteredMoves = new HashSet<>();
        for (int i = 0; i < nextMoves.size(); i++) {
            List<Integer> move = nextMoves.get(i);
            int row = move.get(0);
            int col = move.get(1);
            if (visited[row][col]) {
                continue;
            }
            if (board[row][col] != -1 || (i == nextMoves.size() - 1)) {
                filteredMoves.add(move);
            }
        }
        return filteredMoves;
    }

    private static boolean snakeDFS(int row, int col, int[][] board, int currentMoves, boolean[][] visited, int[][] dp, int endCol) {
        if (row == 0 && col == endCol) {
            System.out.println("Reached with moves: " + currentMoves);
            //minMoves = Math.min(minMoves, currentMoves);
            return true;
        }
        if (dp[row][col] != 0) {
            return true;
        }
        if (visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        List<List<Integer>> nextMoves = findNextMoves(row, col, board);
        boolean success = false;
        if (nextMoves != null) {
            Set<List<Integer>> nextMovesFiltered = filterMoves(nextMoves, board, visited);
            for (List<Integer> nextMove : nextMovesFiltered) {
                int nextRow = nextMove.get(0);
                int nextCol = nextMove.get(1);
                int val = board[nextRow][nextCol];
                if (val == -1) {
                    //Normal square
                    success = snakeDFS(nextRow, nextCol, board, currentMoves + 1, visited, dp, endCol);
                    if (success) {
                        int newValue = dp[nextRow][nextCol] + 1;
                        updateDp(dp, row, col, newValue);
                    }
                } else {
                    //Snake or ladder
                    List<Integer> result = getRowColFromValue(val, board);
                    success = snakeDFS(result.get(0), result.get(1), board, currentMoves + 1, visited, dp, endCol);
                    if (success) {
                        int newValue = dp[result.get(0)][result.get(1)] + 1;
                        updateDp(dp, row, col, newValue);
                    }
                }
            }
        }
        return true;
    }

    private static void updateDp(int[][] dp, int row, int col, int newValue) {
        if (dp[row][col] == 0) {
            dp[row][col] = newValue;
        } else {
            dp[row][col] = Math.min(dp[row][col], newValue);
        }
    }

    private static List<Integer> getRowColFromValue(int val, int[][] board) {
        List<Integer> result = new ArrayList<>();
        int rowRem = val % board.length;
        int row;
        if (rowRem == 0) {
            row = (board.length) - (val / board.length);
        } else {
            row = (board.length - 1) - (val / board.length);
        }

        result.add(row);
        int col;
        int rem = val % board.length;
        if ((board.length - row + 1) % 2 == 0) {
            //L--R
            col = rem != 0 ? rem - 1 : board.length - 1;
            result.add(col);
        } else {
            //R--L
            col = rem != 0 ? board.length - rem : 0;
            result.add(col);
        }
        return result;
    }


    public static int snakesAndLadders(int[][] board) {
        //minMoves = Integer.MAX_VALUE;
        if (board.length == 2) {
            return 1;
        }
        int[][] dp = new int[board.length][board.length];
        boolean[][] visited = new boolean[board.length][board.length];
        int endCol;
        if ((board.length + 1) % 2 == 0) {
            endCol = board.length - 1;
        } else {
            endCol = 0;
        }
        snakeDFS(board.length - 1, 0, board, 0, visited, dp, endCol);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[board.length - 1][0];
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}};

        int[][] board2 = new int[][]{{-1, -1, -1}, {-1, 9, 8}, {-1, 8, 9}};
        int[][] board3 = new int[][]{
                {-1, 1, 2, -1},
                {2, 13, 15, -1},
                {-1, 10, -1, -1},
                {-1, 6, 2, 8}
        };
        System.out.println(snakesAndLadders(board2));
    }
}

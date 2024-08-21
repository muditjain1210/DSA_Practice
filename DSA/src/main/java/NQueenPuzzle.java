import java.util.ArrayList;
import java.util.List;

public class NQueenPuzzle {


    public static void recursive(int n, int row, List<List<String>> results, List<Integer> result) {
        int col = 0;
        while (col < n) {
            if (!isAttacking(col, row, result)) {
                result.set(row, col);
                if (row == n - 1) {
                    addResult(results, result);
                } else {
                    recursive(n, row + 1, results, result);
                }
            }
            col++;
        }
    }

    private static void addResult(List<List<String>> results, List<Integer> result) {
        List<String> str = new ArrayList<>();
        for (Integer val : result) {
            char[] chars = new char[result.size()];
            for (int i = 0; i < chars.length; i++) {
                if (val == i) {
                    chars[i] = 'Q';
                } else {
                    chars[i] = '.';
                }
            }
            str.add(new String(chars));
        }
        results.add(str);
    }

    public static boolean isAttacking(int col, int row, List<Integer> prevPost) {
        if (row == 0) {
            return false;
        }
        int j = 1;
        for (int i = row - 1; i >= 0; i--) {
            if (prevPost.get(i) == col) { // same col
                return true;
            }
            if (prevPost.get(i) - j == col || prevPost.get(i) + j == col) { //diagonal
                return true;
            }
            j++;
        }
        return false;
    }


    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }
        recursive(n, 0, results, result);
        return results;
    }

    public static void main(String[] args) {
        List<List<String>> results =
                solveNQueens(5);
        System.out.println(results);
    }
}

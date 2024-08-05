package Stack;

import java.util.*;

public class Pangram {

    private static int length = 0;

    public static boolean isPangram(String str) {
        Set<Character> alphabetSet = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetSet.add(c);
        }
        for (char ch : str.toCharArray()) {
            ch = Character.toLowerCase(ch);
            alphabetSet.remove(ch);
        }
        //System.out.println(alphabetSet);
        return alphabetSet.isEmpty();
    }

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        //isPangram("TheQuickBrownFoxJumpsOverTheLazyDog");
        // System.out.println(reverseVowels("DesignGUrus"));
        //System.out.println(isPalindrome("A man, a plan, a canal, Panama!"));
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums2 = new int[]{-2, 0, 0, 2, 2};
        // Graph stored in the form of an
        // adjacency Matrix
        int INF = Integer.MAX_VALUE;
        int[][] graph = new int[][]{
                {INF, 1, 2, 5, INF, INF, INF, INF},
                {INF, INF, INF, INF, 4, 11, INF, INF},
                {INF, INF, INF, INF, 9, 5, 16, INF},
                {INF, INF, INF, INF, INF, INF, 2, INF},
                {INF, INF, INF, INF, INF, INF, INF, 18},
                {INF, INF, INF, INF, INF, INF, INF, 13},
                {INF, INF, INF, INF, INF, INF, INF, 2},
                {INF, INF, INF, INF, INF, INF, INF, INF},
        };
        //shortestPathMultiStageGraph(graph);

        // System.out.println(threeSum2(nums2));
        //System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        //System.out.println(minSubArrayLen(7, new int[]{7, 3, 1, 2, 4, 3}));
        //System.out.println(lengthOfLongestSubstring("abcdeeee"));
        //System.out.println(findLength2(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1}));
        //System.out.println(findLength2(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}));
        //System.out.println(findLength2(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        int[] matrix = new int[]{40, 20, 30, 10, 30};
        int arr[] = {1, 2, 3, 4, 3, 3, 4, 6, 7, 2, 3, 6, 7, 8, 9, 10, 20, 30, 40, 50, 90, 100, 200, 300};
        //matrixChainMultiplication(arr);

        //minimumAscendingSequence(List.of(3, 3, 8, 7, 3, 7, 8, 8, 1000000, 9, 1000000));
        int[][] matrix2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix3 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] matrix4 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        int[][] matrix5 = new int[][]{{1, 2, 3}};
        int[][] matrix6 = new int[][]{{1}, {2}, {3}};
        int[][] matrix7 = new int[][]{{1, 2}, {3, 4}};
        //spiralOrder(matrix7);
        char[][] board = new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board2 = new char[][]{{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};

        char[][] board3 = new char[][]{
                {'.', '1', '.', '5', '2', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '6', '4', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '9', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '5', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '3', '.', '.', '.'},
                {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

        //System.out.println(isValidSudoku2(board3));
        //char[][] grid = new char[][]{{'1', '0', '1', '1', '1'}, {'1', '0', '1', '0', '1'}, {'1', '1', '1', '0', '1'}};
        //System.out.println(numIslands(grid));
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        //compress(chars);
        System.out.println(compress(new char[]{'a', 'b'}));
    }

    public static String reverseVowels(String s) {
        char[] result = s.toCharArray();
        for (int i = 0, j = result.length - 1; i < j; ) {
            char ch1 = result[i];
            char ch2 = result[j];
            if (isVowel(ch1) && isVowel(ch2)) {
                result[i] = ch2;
                result[j] = ch1;
                i++;
                j--;
            } else if (isVowel(ch1) && !isVowel(ch2)) {
                j--;
            } else if (!isVowel(ch1) && isVowel(ch2)) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return new String(result);
    }

    public static boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char ch1 = Character.toLowerCase(s.charAt(i));
            char ch2 = Character.toLowerCase(s.charAt(j));
            boolean firstAlphaNumeric = isAlphanumeric(ch1);
            boolean secondAlphaNumeric = isAlphanumeric(ch2);
            if (firstAlphaNumeric && secondAlphaNumeric) {
                if (ch1 != ch2) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            } else if (firstAlphaNumeric) {
                j--;
            } else if (secondAlphaNumeric) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            int target = -(nums[i]);
            int j = i + 1;
            int k = nums.length - 1;

            int innerPrev = Integer.MAX_VALUE;
            while (j < k) {
                if (innerPrev == nums[j]) {
                    innerPrev = nums[j];
                    j++;
                    continue;
                }
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
                innerPrev = nums[j];
            }
            //prevtarget = target;
        }
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (mp.containsKey(i)) {
                mp.put(i, mp.get(i) + 1);
            } else {
                mp.put(i, 1);
                list.add(i);
            }
        }

        if (mp.containsKey(0) && mp.get(0) >= 3) {
            result.add(List.of(0, 0, 0));
        }

        for (int i = 0; i < list.size(); i++) {
            int target = -list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int innerTarget = target - list.get(j);
                if (mp.containsKey(innerTarget)) {
                    result.add(List.of(list.get(i), list.get(j), innerTarget));
                }
            }
        }
        return result;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int windowSum = 0;
        int length = Integer.MAX_VALUE;
        while (j < nums.length) {
            windowSum = windowSum + nums[j];
            while (windowSum >= target) {
                length = Math.min(length, (j - i) + 1);
                windowSum = windowSum - nums[i];
                i++;
            }
            j++;
        }
        return length;
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int j = 0;
        int i = 0;
        int length = 1;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            } else {
                length = Math.max(length, set.size());
                while (s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
            }
        }
        return Math.max(length, set.size());
    }

    public static int findLength(int[] nums1, int[] nums2) {

        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            List<Integer> indices;
            if (!indexMap.containsKey(nums2[i])) {
                indices = new ArrayList<>();
                indices.add(i);
                indexMap.put(nums2[i], indices);
            } else {
                indices = indexMap.get(nums2[i]);
                indices.add(i);
            }
        }
        System.out.println(indexMap);

        int length = 0;
        int i = 0;
        while (i < nums1.length) {
            if (!indexMap.containsKey(nums1[i])) {
                i++;
            } else {
                List<Integer> indices = indexMap.get(nums1[i]);
                for (int index : indices) {
                    length = getMaxSubArrayLength(nums1, nums2, i, index, length);
                }
                i++;
            }
        }
        return length;
    }

    public static int findLength2(int[] nums1, int[] nums2) {
        length = 0;
        findLengthRecursive(nums1, nums2, 0, 0, 0);
        return length;
    }

    public static int findLengthRecursive(int[] nums1, int[] nums2, int prefixLength, int n1, int n2) {

        if (n1 >= nums1.length || n2 >= nums2.length) {
            return prefixLength;
        }
        if (nums1[n1] == nums2[n2]) {
            prefixLength++;
            length = Math.max(length, prefixLength);
            return findLengthRecursive(nums1, nums2, prefixLength, n1 + 1, n2 + 1);
        }
        //length = Math.max(length, prefixLength);
        return Math.max(findLengthRecursive(nums1, nums2, 0, n1 + 1, n2),
                findLengthRecursive(nums1, nums2, 0, n1, n2 + 1));
    }

    public static int getMaxSubArrayLength(int[] nums1, int[] nums2, int n1, int n2, int length) {
        int j1 = n1 + 1;
        int j2 = n2 + 1;
        while (j1 < nums1.length && j2 < nums2.length && nums1[j1] == nums2[j2]) {
            j1++;
            j2++;
        }
        return Math.max(length, j1 - n1);
    }

    public static int shortestPathMultiStageGraph(int[][] graph) {
        int n = graph.length;
        int[] cost = new int[n];
        int[] route = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            cost[i] = Integer.MAX_VALUE;
            int j = i + 1;
            while (j < n) {
                if (graph[i][j] != Integer.MAX_VALUE) {
                    int newCost = graph[i][j] + cost[j];
                    if (cost[i] > newCost) {
                        cost[i] = newCost;
                        route[i] = j;
                    }
                }
                j++;
            }
        }
        for (int j : cost) {
            System.out.print("Cost: " + j);

        }
        System.out.println();
        for (int j : route) {
            System.out.println("Route: " + j);

        }
//        System.out.println(cost[0]);
        return cost[0];
    }

    public static void matrixChainMultiplication(int[] matrix) {
        int noMatrices = matrix.length - 1;
        long st = System.currentTimeMillis();
//        int cost = matrixChainMultiplicationRecursive(matrix, 1, noMatrices);
//        System.out.println("Total Time: 1" + (System.currentTimeMillis() - st));
//        System.out.println(cost);


        st = System.currentTimeMillis();
        int[][] dp = new int[noMatrices + 1][noMatrices + 1];
        int cost = matrixChainMultiplicationRecursiveMemo(matrix, 1, noMatrices, dp);
        System.out.println("Total Time: 2" + (System.currentTimeMillis() - st));
        System.out.println(cost);

        st = System.currentTimeMillis();
        cost = matrixChainMultiplicationDynamic(matrix);
        System.out.println("Total Time: 3" + (System.currentTimeMillis() - st));
        System.out.println(cost);

    }

    public static int matrixChainMultiplicationRecursive(int[] matrix, int n1, int n2) {
        if (n1 == n2) {
            return 0;
        }
        if (n2 - n1 == 1) {
            return matrix[n1 - 1] * matrix[n1] * matrix[n2];
        }
        int cost = Integer.MAX_VALUE;
        for (int j = 0; j < n2 - n1; j++) {
            int leftCost = matrixChainMultiplicationRecursive(matrix, n1, n1 + j);
            int rightCost = matrixChainMultiplicationRecursive(matrix, n1 + j + 1, n2);
            int leftIntoRightCost = matrix[n1 - 1] * matrix[n1 + j] * matrix[n2];
            int totalCost = leftCost + rightCost + leftIntoRightCost;
            cost = Math.min(cost, totalCost);
        }
        return cost;
    }

    public static int matrixChainMultiplicationRecursiveMemo(int[] matrix, int n1, int n2, int[][] dp) {

        if (dp[n1][n2] != 0) {
            return dp[n1][n2];
        }
        if (n1 == n2) {
            return 0;
        }
        if (n2 - n1 == 1) {
            int cost = matrix[n1 - 1] * matrix[n1] * matrix[n2];
            dp[n1][n2] = cost;
            return cost;
        }
        int cost = Integer.MAX_VALUE;
        for (int j = 0; j < n2 - n1; j++) {
            int leftCost = matrixChainMultiplicationRecursiveMemo(matrix, n1, n1 + j, dp);
            int rightCost = matrixChainMultiplicationRecursiveMemo(matrix, n1 + j + 1, n2, dp);
            int leftIntoRightCost = matrix[n1 - 1] * matrix[n1 + j] * matrix[n2];
            int totalCost = leftCost + rightCost + leftIntoRightCost;
            cost = Math.min(cost, totalCost);
        }
        dp[n1][n2] = cost;
        return cost;
    }

    public static int matrixChainMultiplicationDynamic(int[] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        for (int k = 0; k < dp.length - 2; k++) {
            for (int i = 1, j = i + k + 1; j < dp.length; i++, j++) {
                int cost = Integer.MAX_VALUE;
                for (int l = 0; l < j - i; l++) {
                    cost = Math.min(cost, dp[i][i + l] +
                            dp[i + l + 1][j] +
                            (matrix[i - 1] * matrix[i + l] * matrix[j]));
                }
                dp[i][j] = cost;
            }
        }
        return dp[1][dp.length - 1];
    }

    public static List<Integer> minimumAscendingSequence(List<Integer> arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i : arr) {
            if (mp.containsKey(i)) {
                int freq = mp.get(i);
                result.add(i);
                mp.put(i, ++freq);
            } else {
                mp.put(i, 1);
            }
        }
        Collections.sort(result);
        int i = 0;
        int j = 0;
        while (i < arr.size() && j < result.size()) {
            if (Objects.equals(arr.get(i), result.get(j))) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == result.size()) {
            System.out.println(result);
            return result;
        }
        System.out.println(-1);
        return List.of(-1);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        spiral(0, matrix.length - 1, 0, matrix[0].length - 1, result, matrix);
        System.out.println(result);
        return result;
    }

    private static List<Integer> spiral(int stRow, int endRow, int stCol, int endCol,
                                        List<Integer> result, int[][] matrix) {
        if (stRow > endRow || stCol > endCol) {
            return result;
        }

        if (stRow == endRow && stCol == endCol) {
            //Single element
            result.add(matrix[stRow][stCol]);
            return result;
        }
        if (stRow == endRow) {
            //Single Row, only L->R
            int j = stCol;
            while (j <= endCol) {
                result.add(matrix[stRow][j]);
                j++;
            }
            return result;
        }

        if (stCol == endCol) {
            //Single Col, only top->Bottom
            int i = stRow;
            while (i <= endRow) {
                result.add(matrix[i][stCol]);
                i++;
            }
            return result;
        }

        //Top Left to Right
        int j = stCol;
        while (j <= endCol) {
            result.add(matrix[stRow][j]);
            j++;
        }

        //Top Right to Bottom
        int i = stRow + 1;
        while (i <= endRow) {
            result.add(matrix[i][endCol]);
            i++;
        }

        //Bottom Right to Left
        j = endCol - 1;
        while (j >= stCol) {
            result.add(matrix[endRow][j]);
            j--;
        }

        //Bottom left to top
        i = endRow - 1;
        while (i > stRow) {
            result.add(matrix[i][stCol]);
            i--;
        }
        return spiral(++stRow, --endRow, ++stCol, --endCol, result, matrix);
    }

    private static boolean checkValidity(char[][] board, char ch, int row, int col, HashMap<Character, List<Integer>> mp) {

        int squareRow = (int) Math.ceil((row + 1) / 3.0);
        int squareCol = (int) Math.ceil((col + 1) / 3.0);
        if (mp.containsKey(ch)) {
            List<Integer> rowColSq = mp.get(ch);
            int oldRow = rowColSq.get(0);
            int oldCol = rowColSq.get(1);
            int oldSqRow = rowColSq.get(2);
            int oldSqCol = rowColSq.get(3);
            if (oldRow == row || oldCol == col || (oldSqRow == squareRow && oldSqCol == squareCol)) {
                return false;
            } else {
                mp.put(ch, List.of(row, col, squareRow, squareCol));
            }
        } else {
            mp.put(ch, List.of(row, col, squareRow, squareCol));
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> rowMap = new HashMap<>();
        HashMap<Integer, Set<Character>> colMap = new HashMap<>();
        HashMap<Integer, Set<Character>> squareMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int squareRow = (int) Math.ceil((i + 1) / 3.0);
                    int squareCol = (int) Math.ceil((j + 1) / 3.0);
                    int squareNum = 3 * (squareRow - 1) + squareCol;
                    Set<Character> rowCharSet = rowMap.get(i);
                    if (rowCharSet != null && rowCharSet.contains(ch)) {
                        return false;
                    }
                    Set<Character> colCharSet = colMap.get(j);
                    if (colCharSet != null && colCharSet.contains(ch)) {
                        return false;
                    }
                    Set<Character> sqCharSet = squareMap.get(squareNum);
                    if (sqCharSet != null && sqCharSet.contains(ch)) {
                        return false;
                    }
                    rowCharSet = (rowCharSet == null) ? new HashSet<>() : rowCharSet;
                    rowCharSet.add(ch);
                    rowMap.put(i, rowCharSet);

                    colCharSet = (colCharSet == null) ? new HashSet<>() : colCharSet;
                    colCharSet.add(ch);
                    colMap.put(j, colCharSet);

                    sqCharSet = (sqCharSet == null) ? new HashSet<>() : sqCharSet;
                    sqCharSet.add(ch);
                    squareMap.put(squareNum, sqCharSet);
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {
        List<Set<Character>> rowList = new ArrayList<>(9);
        List<Set<Character>> colList = new ArrayList<>(9);
        List<Set<Character>> sqaureList = new ArrayList<>(9);


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int squareRow = (int) Math.ceil((i + 1) / 3.0);
                    int squareCol = (int) Math.ceil((j + 1) / 3.0);
                    int squareNum = 3 * (squareRow - 1) + squareCol;

                    Set<Character> rowCharSet = rowList.get(i);
                    if (rowCharSet != null && rowCharSet.contains(ch)) {
                        return false;
                    }
                    Set<Character> colCharSet = colList.get(j);
                    if (colCharSet != null && colCharSet.contains(ch)) {
                        return false;
                    }
                    Set<Character> sqCharSet = sqaureList.get(squareNum);
                    if (sqCharSet != null && sqCharSet.contains(ch)) {
                        return false;
                    }
                    rowCharSet = (rowCharSet == null) ? new HashSet<>() : rowCharSet;
                    rowCharSet.add(ch);
                    rowList.add(i, rowCharSet);

                    colCharSet = (colCharSet == null) ? new HashSet<>() : colCharSet;
                    colCharSet.add(ch);
                    colList.add(i, colCharSet);

                    sqCharSet = (sqCharSet == null) ? new HashSet<>() : sqCharSet;
                    sqCharSet.add(ch);
                    sqaureList.add(i, sqCharSet);
                }
            }
        }
        return true;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<TreeNode, Integer> mp = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        result.add(List.of(root.val));
        que.add(root);
        mp.put(root, 0);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            int level = mp.get(node) + 1;
            List<Integer> levelNodes;
            if (result.size() <= level) {
                levelNodes = new ArrayList<>();
            } else {
                levelNodes = result.get(level);
            }

            if (node.left != null) {
                levelNodes.add(node.left.val);
                que.add(node.left);
                mp.put(node.left, level);
            }
            if (node.right != null) {
                levelNodes.add(node.right.val);
                que.add(node.right);
                mp.put(node.right, level);
            }
            result.add(level, levelNodes);
        }
        return result;
    }

    private static List<List<Integer>> getAdjacentVertices(int row, int col, char[][] grid) {
        List<List<Integer>> result = new ArrayList<>();
        if (row + 1 < grid.length) {
            result.add(List.of(row + 1, col));
        }
        if (row - 1 >= 0) {
            result.add(List.of(row - 1, col));
        }
        if (col + 1 < grid[0].length) {
            result.add(List.of(row, col + 1));
        }
        if (col - 1 >= 0) {
            result.add(List.of(row, col - 1));
        }
        return result;
    }

    public static int numIslands(char[][] grid) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                boolean island = dfs(i, j, grid, visited);
                if (island) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean dfs(int i, int j, char[][] grid, Set<Integer> visited) {
        int vertexNumber = (grid[0].length * i) + (j + 1);
        if (grid[i][j] == '0' || visited.contains(vertexNumber)) {
            visited.add(vertexNumber);
            return false;
        }
        visited.add(vertexNumber);
        List<List<Integer>> adjVertices = getAdjacentVertices(i, j, grid);
        for (List<Integer> vertex : adjVertices) {
            int row = vertex.get(0);
            int col = vertex.get(1);
            dfs(row, col, grid, visited);
        }
        return true;
    }

    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int i = 0;
        int j = 1;
        int pointer = i + 1;
        int count = 1;

        while (j < chars.length) {
            if (chars[i] == chars[j]) {
                j++;
                count++;
            } else {
                if (count == 1) {
                    i++;
                    j++;
                    pointer++;
                } else {
                    List<Character> digits = getdigits(count);
                    for (int k = digits.size() - 1; k >= 0; k--) {
                        chars[pointer] = digits.get(k);
                        pointer++;
                    }
                    i = j;
                    pointer = i + 1;
                    j++;
                    count = 1;
                }
            }
        }
        if (count > 1) {
            List<Character> digits = getdigits(count);
            for (int k = digits.size() - 1; k >= 0; k--) {
                chars[pointer] = digits.get(k);
                pointer++;
            }
        }
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println(pointer);

        return pointer;
    }

    private static List<Character> getdigits(int num) {
        List<Character> digits = new ArrayList<>();
        while (num > 0) {
            int digit = num % 10;
            num = num / 10;
            digits.add(Character.forDigit(digit, 10));
        }
        return digits;
    }

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> intv = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int[] interval : intervals) {
            List<Integer> ll = new ArrayList<>();
            ll.add(interval[0]);
            ll.add(interval[1]);
            intv.add(ll);
        }
        intv.sort(Comparator.comparingInt(s -> s.get(0)));
        List<Integer> prev = intv.get(0);
        result.add(prev);
        for (int i = 1; i < intv.size(); i++) {
            int x = intv.get(i).get(0);
            int y = intv.get(i).get(1);
            if (x <= prev.get(1)) {
                prev.set(1, y);
            } else {
                result.add(intv.get(i));
            }
        }

        int[][] result2 = new int[result.size()][2];
        for (int i = 0; i < result2.length; i++) {
            result2[i][0] = result.get(i).get(0);
            result2[i][1] = result.get(i).get(1);
        }
        return result2;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            Stack<Integer> st = new Stack<>();
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                st.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            List<Integer> levelNodes = new ArrayList<>(st);
            result.add(levelNodes);
        }
        return result;
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> created = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Queue<Node> que = new LinkedList<>();
        Node clonedRootNode = new Node(node.val);
        created.put(node.val, clonedRootNode);
        que.add(node);

        while (!que.isEmpty()) {
            Node oldNode = que.poll();
            visited.add(oldNode);
            Node clonedNode = null;
            if (created.containsKey(oldNode.val)) {
                clonedNode = created.get(oldNode.val);
            } else {
                clonedNode = new Node(oldNode.val);
                created.put(oldNode.val, clonedNode);
            }
            List<Node> clonedNeighbors = new ArrayList<>();
            for (Node neighbour : oldNode.neighbors) {
                Node clonedNeighbour = null;
                if (created.containsKey(neighbour.val)) {
                    clonedNeighbour = created.get(neighbour.val);
                } else {
                    clonedNeighbour = new Node(neighbour.val);
                    created.put(neighbour.val, clonedNeighbour);
                }
                clonedNeighbors.add(clonedNeighbour);
                if (!visited.contains(neighbour)) {
                    que.add(neighbour);
                }
            }
            clonedNode.neighbors = clonedNeighbors;

        }
        return clonedRootNode;

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> resultInt = new ArrayList<>();
        boolean isAdded = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (!isAdded && interval[0] >= newInterval[0]) {
                resultInt.add(new Interval(newInterval));
                isAdded = true;
            }
            resultInt.add(new Interval(interval));
        }
        if (!isAdded) {
            resultInt.add(new Interval(newInterval));
        }
        return null;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
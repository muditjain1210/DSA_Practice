import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeStyle {
    static int maxSize = 0;
    static int leftCandleIndex = Integer.MAX_VALUE;
    static int rightCandleIndex = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(longestSubstring("aaabb", 3));
//        System.out.println(longestSubstring("ababbc", 2));
//        System.out.println(longestSubstring("aaabbb", 3));
        //       System.out.println(longestSubstring("ababacb", 3));
        String s = "***|**|*****|**||**|*";
        int[][] queries = new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        platesBetweenCandles(s, queries);
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int currentLength = 0;
        Map<Character, Integer> mp = new HashMap<>();
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (!mp.containsKey(ch)) {
                mp.put(ch, j);
                j++;
                currentLength++;
            } else {
                int index = mp.get(ch);
                for (int l = i; l <= index; l++) {
                    mp.remove(s.charAt(l));
                }
                i = index + 1;
                mp.put(ch, j);
                maxLength = Math.max(maxLength, currentLength);
                currentLength = j - i + 1;
                j++;
            }

        }
        maxLength = Math.max(maxLength, currentLength);
        return maxLength;

    }

    private static int recursive(int st, int end, String s, int k) {
        if (end < st) {
            return 0;
        }
        if (end == st) {
            return k == 1 ? 1 : 0;
        }
        Map<Character, Integer> mp = getSubstringFreq(s, st, end);
        int j = st;
        while (j <= end) {
            char ch = s.charAt(j);
            if (mp.get(ch) >= k) {
                j++;
            } else {
                int validSubSizeLeft = recursive(st, j - 1, s, k);
                int validSubSizeRight = recursive(j + 1, end, s, k);
                int max = Math.max(validSubSizeLeft, validSubSizeRight);
                maxSize = Math.max(maxSize, max);
                break;
            }
        }
        maxSize = Math.max(maxSize, j - st);
        return j - st;
    }

    private static Map<Character, Integer> getSubstringFreq(String s, int st, int end) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = st; i <= end; i++) {
            char ch = s.charAt(i);
            if (!mp.containsKey(ch)) {
                mp.put(ch, 1);
            } else {
                int fre = mp.get(ch);
                mp.put(ch, ++fre);
            }
        }
        return mp;
    }

    public static int longestSubstring(String s, int k) {
        maxSize = 0;
        recursive(0, s.length() - 1, s, k);
        return maxSize;
    }

    public static void getLeftMostCandleIndex(int target, int st, int end, List<Integer> indices) {
        if (end < st) {
            return;
        }
        int mid = (st + end) / 2;
        if (indices.get(mid) == target) {
            leftCandleIndex = indices.get(mid);
        }
        if (indices.get(mid) > target) {
            leftCandleIndex = Math.min(leftCandleIndex, indices.get(mid));
            getLeftMostCandleIndex(target, st, mid - 1, indices);
        }
        if (indices.get(mid) < target) {
            getLeftMostCandleIndex(target, mid + 1, end, indices);
        }
    }

    public static void getRightMostCandleIndex(int target, int st, int end, List<Integer> indices) {
        if (end < st) {
            return;
        }
        int mid = (st + end) / 2;

        if (indices.get(mid) == target) {
            rightCandleIndex = indices.get(mid);
        } else if (indices.get(mid) > target) {
            getRightMostCandleIndex(target, st, mid - 1, indices);
        } else if (indices.get(mid) < target) {
            rightCandleIndex = Math.max(rightCandleIndex, indices.get(mid));
            getRightMostCandleIndex(target, mid + 1, end, indices);
        }
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] result = new int[queries.length];
        List<Integer> indices = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                indices.add(i);
                mp.put(i, j);
                j++;
            }
        }
        System.out.println(indices);
        for (int i = 0; i < queries.length; i++) {
            leftCandleIndex = Integer.MAX_VALUE;
            rightCandleIndex = Integer.MIN_VALUE;
            int left = queries[i][0];
            int right = queries[i][1];
            getLeftMostCandleIndex(left, 0, indices.size() - 1, indices);
            if (leftCandleIndex < right) {
                getRightMostCandleIndex(right, 0, indices.size() - 1, indices);
                if (rightCandleIndex > leftCandleIndex) {
                    result[i] = (rightCandleIndex - leftCandleIndex) - (mp.get(rightCandleIndex) - mp.get(leftCandleIndex));
                    System.out.println(result[i]);
                    continue;
                }
            }
            result[i] = 0;
            System.out.println(result[i]);
        }
        return result;
    }

}

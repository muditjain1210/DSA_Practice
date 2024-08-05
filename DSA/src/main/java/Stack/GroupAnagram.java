package Stack;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultSet = new ArrayList<>();
        Set<Integer> groupedStringIndex = new HashSet<>();
        List<String> sortedString = new ArrayList<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            sortedString.add(new String(chars));
        }

        for (int i = 0; i < strs.length; i++) {
            if (groupedStringIndex.contains(i)) {
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(strs[i]);

            for (int j = i + 1; j < strs.length; j++) {
                if (groupedStringIndex.contains(j) || !sortedString.get(i).equals(sortedString.get(j))) {
                    continue;
                }
                group.add(strs[j]);
                groupedStringIndex.add(j);
            }
            resultSet.add(group);
        }
        return resultSet;
    }
}

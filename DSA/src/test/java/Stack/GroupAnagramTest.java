package Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramTest {

    @Test
    void groupAnagrams() {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strings1 = {"a"};
        GroupAnagram groupAnagram = new GroupAnagram();
        System.out.println(groupAnagram.groupAnagrams(strings));
        System.out.println(groupAnagram.groupAnagrams(strings1));
    }
}
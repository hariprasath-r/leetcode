import java.util.LinkedHashMap;
import java.util.Map;

/**
    First Unique Character in a String
    ----------------------------------
    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

    Examples:
        s = "leetcode"
        return 0.

        s = "loveleetcode",
        return 2.
    
    Note: You may assume the string contain only lowercase letters.
 */
class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        if (s.isEmpty())
            return -1;

        if (s.length() == 1)
            return 0;

        Map<Character, Integer> count = new LinkedHashMap<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }

     Character character = count.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(m -> m.getValue() == 1)
                .map(m -> m.getKey())
                .findFirst().orElse('\0');

        return character != '\0' ? s.indexOf(character) : -1;

    }
}
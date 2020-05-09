/**
    Ransom Note
    -----------
    Given an arbitrary ransom note string and another string containing letters from all the magazines, 
    write a function that will return true if the ransom note can be constructed from the magazines ; 
    otherwise, it will return false.

    Each letter in the magazine string can only be used once in your ransom note.

    Example 1:
        Input: ransomNote = "a", magazine = "b"
        Output: false

    Example 2:
        Input: ransomNote = "aa", magazine = "ab"
        Output: false
    
    Example 3:
        Input: ransomNote = "aa", magazine = "aab"
        Output: true

    Constraints:
        You may assume that both strings contain only lowercase letters.
 */
 class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length())
            return false;

        final boolean[] result = {true};
        Map<Character, Integer> ransomCount = new HashMap<>();
        Map<Character, Integer> magazineCount = new HashMap<>();

        char[] chars1 = ransomNote.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (ransomCount.containsKey(chars1[i])) {
                ransomCount.put(chars1[i], ransomCount.get(chars1[i]) + 1);
            } else {
                ransomCount.put(chars1[i], 1);
            }
        }
        char[] chars2 = magazine.toCharArray();
        for (int i = 0; i < chars2.length; i++) {
            if (magazineCount.containsKey(chars2[i])) {
                magazineCount.put(chars2[i], magazineCount.get(chars2[i]) + 1);
            } else {
                magazineCount.put(chars2[i], 1);
            }
        }

        ransomCount.keySet().stream().parallel().forEach(c -> {
            if (magazineCount.getOrDefault(c, 0) < ransomCount.get(c))
                result[0] = false;
        });

        return result[0];
    }
}
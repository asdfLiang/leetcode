package hot100.mediumGroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 *
 * @since 2023/8/12 8:46
 * @author by liangzj
 */
public class GroupAnagramsMain {
    public static void main(String[] args) {}

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;

        HashMap<List<Character>, List<String>> strMap = new HashMap<>();
        for (String str : strs) {
            List<Character> chars = new ArrayList<>();
            for (char c : str.toCharArray()) {
                chars.add(c);
            }
            chars = chars.stream().sorted().collect(Collectors.toList());

            List<String> strList = strMap.getOrDefault(chars, new ArrayList<>());
            strList.add(str);
            strMap.putIfAbsent(chars, strList);
        }

        return new ArrayList<>(strMap.values());
    }
}

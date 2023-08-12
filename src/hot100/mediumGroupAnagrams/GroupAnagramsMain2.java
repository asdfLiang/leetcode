package hot100.mediumGroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 *
 * @since 2023/8/12 8:46
 * @author by liangzj
 */
public class GroupAnagramsMain2 {
    public static void main(String[] args) {}

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;

        HashMap<String, List<String>> strMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = new String(charArray);

            List<String> strList = strMap.getOrDefault(sortStr, new ArrayList<>());
            strList.add(str);
            strMap.putIfAbsent(sortStr, strList);
        }

        return new ArrayList<>(strMap.values());
    }
}

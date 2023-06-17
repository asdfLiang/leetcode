package enterprise.byteDance;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 648. 单词替换（字节跳动 10 日心动计划）
 *
 * @since 2023/6/17 8:15
 * @author by liangzj
 */
public class ReplaceWordsMain {
    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";

        System.out.println(replaceWords(dictionary, sentence));
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        List<String> roots = getRoots(dictionary);
        Map<Character, List<String>> startMap =
                roots.stream().collect(Collectors.groupingBy(r -> r.charAt(0)));

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            List<String> mays = startMap.get(word.charAt(0));
            if (mays == null) continue;

            for (String may : mays) {
                if (!word.startsWith(may)) continue;
                words[i] = may;
                break;
            }
        }

        return String.join(" ", words);
    }

    private static List<String> getRoots(List<String> dictionary) {
        if (dictionary.size() < 2) return dictionary;

        dictionary.sort(String::compareTo);
        List<String> roots = new ArrayList<>();
        roots.add(dictionary.get(0));

        for (int i = 1; i < dictionary.size(); i++) {
            String s = dictionary.get(i);
            if (s.startsWith(roots.get(roots.size() - 1))) {
                continue;
            }

            roots.add(s);
        }

        return roots;
    }
}

package basic;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 2024/7/15 下午2:25
 * @author by liangzj
 */
public class TrieNode {
    private final Character data;

    /** Map<data, TrieNode> */
    private final Map<Character, TrieNode> children = new HashMap<>();

    private boolean isEnd;

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public Character getData() {
        return data;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public TrieNode(Character data) {
        this.data = data;
    }
}

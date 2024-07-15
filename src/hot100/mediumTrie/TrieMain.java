package hot100.mediumTrie;

import utils.Trie;

/**
 * 208. 实现 Trie (前缀树)
 *
 * @since 2024/7/15 下午3:08
 * @author by liangzj
 */
public class TrieMain {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple"); // 返回 True
        trie.search("app"); // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app"); // 返回 True
    }
}

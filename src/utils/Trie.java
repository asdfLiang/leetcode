package utils;

import basic.TrieNode;

/**
 * @since 2024/7/15 下午2:42
 * @author by liangzj
 */
public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode(null);
    }

    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.getChildren().containsKey(c)) {
                p = p.getChildren().get(c);
            } else {
                p.getChildren().put(c, new TrieNode(c));
                p = p.getChildren().get(c);
            }
        }
        p.setEnd(true);
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.getChildren().containsKey(c)) {
                p = p.getChildren().get(c);
            } else {
                return false;
            }
        }

        return p != root && p.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            if (p.getChildren().containsKey(c)) {
                p = p.getChildren().get(c);
            } else {
                return false;
            }
        }

        return true;
    }
}

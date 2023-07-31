package myBinaryTree.model;

import java.util.Map;

public class TreeNode<K, V> implements Map.Entry<K, V>{
     TreeNode<K, V> left;
     TreeNode<K, V> right;
     K key;
     V value;

    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}

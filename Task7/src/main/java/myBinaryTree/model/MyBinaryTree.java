package myBinaryTree.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class MyBinaryTree<K extends Comparable,V> implements Map<K, V>{
    private static final Logger logger = LogManager.getLogger(MyBinaryTree.class);
    private int size = 0;
    private TreeNode<K, V> root;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        logger.info("start method get");
        Comparable<K> k = (Comparable<K>) key;
        TreeNode<K, V> treeNode = root;
        while (treeNode != null){
            int compare = k.compareTo(treeNode.key);
            if (compare == 0){
                logger.info("finish method get with result: " + treeNode.value);
                return treeNode.value;
            }
            if (compare < 0){
                treeNode = treeNode.left;
            }
            else if (compare > 0){
                treeNode = treeNode.right;
            }
        }
        logger.info("finish method get with null result");
        return null;
    }

    @Override
    public V put(K key, V value) {
        logger.info("start method put");
        TreeNode<K, V> parent = null;
        TreeNode<K, V> current = root;
        while (current != null){
            int compare = key.compareTo(current.key);
            if (compare < 0){
                parent = current;
                current = current.left;
            }
            else if (compare > 0){
                parent = current;
                current = current.right;
            }
            else {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
        }
        TreeNode<K, V> newNode = new TreeNode<>(key, value);
        if (parent == null){
            root = newNode;
        }
        else {
            int compare = key.compareTo(parent.key);
            if (compare < 0){
                parent.left = newNode;
            }
            else {
                parent.right = newNode;
            }
        }
        logger.info("finish method put");
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        runTreeKey(root, keys);
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        runTreeValue(root, values);
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        runTreeNode(root, entries);
        return entries;
    }

    private void runTreeKey(TreeNode<K, V> localRoot, Set<K> keys){
        if (localRoot != null){
            runTreeKey(localRoot.left, keys);
            keys.add(localRoot.getKey());
            runTreeKey(localRoot.right, keys);
        }
    }

    private void runTreeValue(TreeNode<K, V> localRoot, Collection<V> values){
        if (localRoot != null){
            runTreeValue(localRoot.left, values);
            values.add(localRoot.getValue());
            runTreeValue(localRoot.right, values);
        }

    }

    private void runTreeNode(TreeNode<K, V> localRoot, Set<Entry<K, V>> entries){
        if (localRoot != null){
            runTreeNode(localRoot.left, entries);
            entries.add(localRoot);
            runTreeNode(localRoot.right, entries);
        }

    }
}

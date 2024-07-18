package dsimplemenatation;


public class TreeNode<K, V> {
    K key;
    V value;
    TreeNode<K, V> left;
    TreeNode<K, V> right;

    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}


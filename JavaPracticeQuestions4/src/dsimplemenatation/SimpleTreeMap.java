package dsimplemenatation;
public class SimpleTreeMap<K extends Comparable<K>, V> {
	
    private TreeNode<K, V> root;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private TreeNode<K, V> put(TreeNode<K, V> node, K key, V value) {
        if (node == null) {
            return new TreeNode<>(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value; 
        }
        return node;
    }
    
    public V get(K key) {
        TreeNode<K, V> node = get(root, key);
        return node == null ? null : node.value;
    }

    
    private TreeNode<K, V> get(TreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

 
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(TreeNode<K, V> node) {
        if (node != null) {
            printTree(node.left);
            System.out.println("{" + node.key + " = " + node.value + "}");
            printTree(node.right);
        }
    }

    public static void main(String[] args) {
        SimpleTreeMap<String, Integer> treeMap = new SimpleTreeMap<>();
        treeMap.put("aniruth", 1);
        treeMap.put("parthiban", 2);
        treeMap.put("bala", 3);

        System.out.println("Get key1: " + treeMap.get("key1")); 
        System.out.println("Contains key2: " + treeMap.containsKey("key2")); 

        treeMap.printTree();

    }
}


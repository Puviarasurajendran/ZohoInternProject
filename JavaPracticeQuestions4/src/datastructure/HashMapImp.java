package datastructure;

public class HashMapImp {

	private int size = 16;
	private Node[] dataMap;

	public HashMapImp() {
		this.dataMap = new Node[size];
	}

	public int hash(String key) {
		int hashVal = 0;
		for (char c : key.toCharArray()) {
			int asciiValue = c;
			hashVal = (hashVal + asciiValue * 23) % dataMap.length;
		}
		return hashVal;
	}

	public void put(String key, int value) {
		int index = hash(key);
		Node newNode = new Node(key, value);

		if (dataMap[index] == null) {
			dataMap[index] = newNode;
		} else {
			Node temp = dataMap[index];
			while (temp != null) {
	            if (temp.getKey().equals(key)) {
	                temp.setValue(value);
	                return;
	            }
	            if (temp.next == null) {
	                temp.next = newNode;
	                return;
	            }
	            temp = temp.next;
	        }
		}
	}

	public int get(String key) {
		int index = hash(key);
		Node temp = dataMap[index];
		while (temp != null) {

			if (temp.getKey().equals(key)) 
				return temp.getValue();

		}
		return -1;

	}
	
	public boolean containsKey(String key) {
		int index = hash(key);
		Node temp = dataMap[index];
		while (temp != null) {

			if (temp.getKey() == key)
				return true;

		}
		return false;

	}
	
	

	public void printtable() {

		for (int i = 0; i < dataMap.length; i++) {
			System.out.println(i + " :");
			Node temp = dataMap[i];

			while (temp != null) {
				System.out.println("  {" + temp.getKey() + "= " + temp.getValue() + "}");
				temp = temp.next;
			}
		}
	}
 
}
